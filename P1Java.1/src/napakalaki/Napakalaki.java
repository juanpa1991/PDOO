package napakalaki;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;
import java.util.Random;


public class Napakalaki {

    private static final Napakalaki instance =  new Napakalaki();
    
    //atributos-relaciones
    
    private ArrayList <Player> jugadores = new ArrayList();
    
    private Player currentPlayer = null;
    
    private Monster currentMonster; 
    
    private CardDealer dealer = CardDealer.getInstance();
    
    private Napakalaki() {
        
    }
    
    public static Napakalaki getInstance(){
        return instance;
    }
    
    
    private void initPlayers (ArrayList<String> names){
        for (String s:names){
            Player nuevoJugador = new Player(s);
            jugadores.add(nuevoJugador);
        }     
    }
    
    private Player nextPlayer(){
        int indice;
        if (currentPlayer==null){
            Random r  = new Random();
            indice = r.nextInt(3); 
            
        }
        else{
            indice = jugadores.indexOf(currentPlayer);
        }
        indice=((indice %3)+1)%3;
       
        
    return jugadores.get(indice);
    }
    
    public Player getCurrentPlayer(){
        return currentPlayer;
    }
    
    public ArrayList<Player> getJugadores(){
        return jugadores;
    }
    
    public Monster getCurrentMonster(){
        return currentMonster;
    }
    
    public boolean endOfGame(CombatResult result){
        if(CombatResult.winAndWinGame==result)
            return true;
        else
            return false;                    
    }
    
    

        
        /*System.out.println("\n\nCONSULTAS:\n");
        
        // 1 consulta
         System.out.println("\n1ª Consulta:\n");
         
        for (Monster monster:monsters){
            if(monster.getCombatLevel()>10)
                System.out.println(monster.toString()) ;          
        }
        System.out.println();
            
            
        //2 consulta
        System.out.println("\n2ª Consulta:\n");
            
        for (Monster monster:monsters){
            if(monster.getBadStuff().getLevels()>0 && monster.getBadStuff().getnVisibleTreasures()==0 && monster.getBadStuff().getnHiddenTreasures()==0 && monster.getBadStuff().getSpecificVisibleTreasures().isEmpty() && monster.getBadStuff().getSpecificHiddenTreasures().isEmpty())
            System.out.println(monster.toString());
        }
        
        //3 consulta
        System.out.println("\n3ª Consulta:\n");
        
            for (Monster monster:monsters){
            if(monster.getPrize().getLevel()>1)
                System.out.println(monster.toString()) ;          
        }
        System.out.println();
            
        // 4 consulta
        System.out.println("\n4ª Consulta:\n");    
        
            for (Monster monster:monsters){
            if((monster.getBadStuff().getnVisibleTreasures()>0) || ( monster.getBadStuff().getnHiddenTreasures()>0) || monster.getBadStuff().getSpecificVisibleTreasures().size() > 0 || monster.getBadStuff().getSpecificHiddenTreasures().size() > 0)
                System.out.println(monster.toString()) ;          
        }*/
        
    
    public void makeTreasuresVisible(ArrayList <Treasure> treasures){
        //Hacer en jugador este codigo y repasar el diagrama
        for(Treasure tr:treasures){
            
            currentPlayer.makeTreasureVisible(tr);
            
        }
            
    }
    
    public void initGame(ArrayList<String> players){
        
        initPlayers(players);
        CardDealer dealer = CardDealer.getInstance();
        dealer.initCards();
        this.nextTurn();
        
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        
        return currentPlayer.buyLevels(visible,hidden);
          
    }
    
    public boolean nextTurn(){
        
        boolean estadook=false;
       
        estadook=this.nextTurnAllowed();
        
        if(estadook){
            currentMonster=dealer.nextMonster();
            this.currentPlayer=nextPlayer();
            if(currentPlayer.isDead()){
                currentPlayer.initTreasures();
            }
            
        }
        
        return estadook;
    }
    
    public void discardVisibleTreasures(ArrayList<Treasure> treasures){
            ArrayList<Treasure> localTreasures = new ArrayList(treasures);
            for(Treasure tre: localTreasures){
            currentPlayer.discardVisibleTreasure(tre);
            dealer.giveTreasureBack(tre);
            }   
    }
    
    public void discardHiddenTreasures(ArrayList<Treasure> treasures){
        
        ArrayList<Treasure> localTreasures = new ArrayList(treasures);
        for(Treasure tre: localTreasures){
            currentPlayer.discardHiddenTreasure(tre);
            dealer.giveTreasureBack(tre);
        }   
    }
    
    public CombatResult developCombat(){
     
        CombatResult combat_rel=currentPlayer.combat(currentMonster);
        if(combat_rel==CombatResult.loseAndConvert){
            
            CultistPlayer sectario=new CultistPlayer(currentPlayer,dealer.nextCultist());
            int pos=jugadores.indexOf(currentPlayer);
            jugadores.remove(pos);
            currentPlayer=sectario;
            jugadores.add(pos,sectario);
        }
        dealer.giveMonsterBack(currentMonster);
        return combat_rel;
    }
    
    public boolean nextTurnAllowed(){
    
        if(currentPlayer==null){
            return true;
        }
        else{
            
            return currentPlayer.validState();
        }
    }
    
}
