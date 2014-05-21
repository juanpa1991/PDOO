
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Juan Pablo, Juan Carlos, Miguel Angel
 */
public class Player {
    
    private boolean death = true;
    private String name;
    private int level;
    
    //atributos-relaciones
    
    private ArrayList <Treasure> hiddenTreasures = new ArrayList();
    
    private ArrayList <Treasure> visibleTreasures = new ArrayList();
    
    private BadStuff pendingBadStuff = new BadStuff("", true);
    
    
    public Player (String name){
        this.name = name;
        this.death = true;
        this.level = 1;
    }
    
    public Player(Player p){
        
        this.name=p.name;
        this.death=p.death;
        this.level=p.getLevel();
        this.hiddenTreasures=p.getHiddenTreasures();
        this.visibleTreasures=p.getVisibleTreasures();
        this.pendingBadStuff=p.getPendingBadSutff();
        
    }
    
    public String getName(){
        
        return this.name;
        
    }
    
    public int getLevel(){
        return this.level;
    }
    
    public int getOponentLevel(Monster m){
        
        return m.getBasicValue();
        
    }
    
    public ArrayList<Treasure> getHiddenTreasures(){
        
        return hiddenTreasures;
        
    }
    
    public ArrayList<Treasure> getVisibleTreasures(){
        
        return visibleTreasures;
        
    }
    public BadStuff getPendingBadSutff(){
        
        return pendingBadStuff;
        
    }
    private void setLevel(int l){
        
        this.level=l;
        
    }
    
    public boolean isDead(){
        if(this.death)
            return true;
        else
            return false;
    }
    
    protected int getCombatLevel(){
        int combatLevel = 0, tesoro =0;
        for (Treasure tk:visibleTreasures){
        if(howManyVisibleTreasures(TreasureKind.necklace)== 1)
            tesoro=tesoro+tk.getMaxBonus();          
        else
            tesoro=tesoro+tk.getMinBonus();
        }
        combatLevel = this.getLevel() + tesoro;
        return combatLevel;
    }
    
    public int getCombatLevelPlayer(){
        
        return getCombatLevel();
        
    }
    
    public void makeTreasureVisible(Treasure t){
        
        
        ArrayList<Treasure> temp = new ArrayList();
        boolean canI=this.canMakeTreasureVisible(t);
        if(canI){
            
            visibleTreasures.add(t);
            hiddenTreasures.remove(t);
                         
        }
         
    }
    
    public boolean canMakeTreasureVisible(Treasure t){
        boolean can=false;
        boolean bothhand=false;
        boolean onehand=false;
        int cont=0;
        for(Treasure tre: visibleTreasures){
            if(tre.getType()==t.getType()){
                cont++;   
            }
            if(tre.getType()==TreasureKind.bothHand){
                bothhand=true;
                
            }
            if(tre.getType()==TreasureKind.oneHand){
                onehand=true;
                
            }
            
        }
        if(cont==0)
            can = true;
        if((cont==1) && (t.getType()==TreasureKind.oneHand))
            can = true;
        else if(((t.getType() == TreasureKind.oneHand)&& (bothhand==true)) || (t.getType() == TreasureKind.bothHand && (onehand == true))){
            can = false;
            
        }
        
        return can;
    }
    
    private void bringToLife(){
        this.death = false;
    }
    
    private void incrementLevels(int i){
        
             this.level += i;
             if(this.level>9){
                 
                 this.level=10;
                 
             }
    }
    
    private void decrementLevels(int i){
        
            this.level -= i;
            if(this.level<1){
                
                this.level=1;
                
            }
            
    }
    
    private void discardNecklaceIfVisible(){
        if(howManyVisibleTreasures(TreasureKind.necklace)== 1){
            CardDealer dealer=CardDealer.getInstance();
             ArrayList<Treasure> localTrasures = new ArrayList(this.visibleTreasures);
             for(Treasure tre:localTrasures){
                if(tre.getType()==TreasureKind.necklace){
                    dealer.giveTreasureBack(tre);
                    this.visibleTreasures.remove(tre);
                }
        }
    }
    
    }
    
    private boolean canIBuyLevels(int l){
        if((this.getLevel() + l)>9)
            return false;
        else
            return true;
    }
    
    public boolean buyLevels(ArrayList<Treasure> visible, ArrayList<Treasure> hidden){
        
        int numlevelsT=0, numlevels=0, numlevels2=0;
        boolean canbuy=false;
        
            
            numlevels=this.computeGoldCoinsValue(visible);
            numlevels2=this.computeGoldCoinsValue(hidden);
            numlevelsT=(numlevels2+numlevels)/1000;
        
        if(this.canIBuyLevels(numlevelsT)){
            
            this.incrementLevels(numlevelsT);
            canbuy=true;
            
        }
        
        visibleTreasures.removeAll(visible);
        hiddenTreasures.removeAll(hidden);
        
        CardDealer dealer=CardDealer.getInstance();
        for(Treasure tre: visible){
            
            dealer.giveTreasureBack(tre);
        
        }
        
        for(Treasure tre: hidden){
            
            dealer.giveTreasureBack(tre);
            
        }
        return canbuy;
        
    }
    
    private void dieIfNoTreasures(){
        if(visibleTreasures.isEmpty() && hiddenTreasures.isEmpty())
            this.death = true;
    }
    
    protected int computeGoldCoinsValue(ArrayList<Treasure> t){
        int oro=0;
        
         for(Treasure tre: t){
                
             oro=oro+tre.getGoldCoins();
                
        }
         
        return oro;

    }
    
    public boolean validState(){
        if((pendingBadStuff.isEmpty()==true) && (hiddenTreasures.size() < 5)){
            return true;
        } 
        else{
            
            return false;
        }
    }
    
    public boolean hasVisibleTreasures(){
        if(visibleTreasures.isEmpty())
            return true;
        else
            return false;
    }
    
    private void pendingBadStuff(BadStuff b){
        this.pendingBadStuff = b;
    }
     
    private int howManyVisibleTreasures(TreasureKind tKind){
        int numeroTesorosVisibles = 0;
        for(Treasure tk:visibleTreasures){
            if(tk.getType() == tKind)
                numeroTesorosVisibles++;
        }              
        return numeroTesorosVisibles;               
    }
    
    private void applyPrize(Monster currentMonster){
        
        Treasure treasure;
        int nLevels=currentMonster.getPrize().getLevel();
        this.incrementLevels(nLevels);
        int nTreasures=currentMonster.getPrize().getTreasures();
        if(nTreasures>0){
            CardDealer dealer=CardDealer.getInstance();
            for(int i=0;i<nTreasures;i++){
                treasure=dealer.nextTreasure();
                this.hiddenTreasures.add(treasure);
            }
        }
    }
    
    private void applyBadStuff(BadStuff b){
        
        this.decrementLevels(b.getLevels());
        this.setPendingBadStuff(b.adjustToFitTreasureLists(visibleTreasures,hiddenTreasures));
        
    }
   
    private void die(){
        
        this.setLevel(1);
        CardDealer dealer=CardDealer.getInstance();
        for(Treasure tre: visibleTreasures)
            dealer.giveTreasureBack(tre);
        visibleTreasures.clear();
        for(Treasure tre: hiddenTreasures)
            dealer.giveTreasureBack(tre);
        hiddenTreasures.clear();
        this.dieIfNoTreasures();
     
    }
    
    public void discardVisibleTreasure(Treasure t){
        
        visibleTreasures.remove(t);
        if((pendingBadStuff!=null)&&(!pendingBadStuff.isEmpty())){
            
            pendingBadStuff.substractVisibleTreasure(t);
            
        }
        
        this.dieIfNoTreasures();
            
    }
    
    public void discardHiddenTreasure(Treasure t){
        
        hiddenTreasures.remove(t);
        if((pendingBadStuff!=null)&&(!pendingBadStuff.isEmpty())){
            
            pendingBadStuff.substractHiddenTreasure(t);
            
        }
        
        this.dieIfNoTreasures();
            
    }
    
    public CombatResult combat(Monster m){
        
        CombatResult combat_rel=null;
        int mylevel=this.getCombatLevel();
        int monsterLevel=this.getOponentLevel(m);
        if(mylevel>monsterLevel){
            this.applyPrize(m);
            
            if(this.level>=10){
                
                combat_rel= CombatResult.winAndWinGame;
                
            }
            
            else{
                
                combat_rel=CombatResult.win;
                
            }
            
        }
        else{
            
            Dice dice=Dice.getInstance();
            int escape=dice.nextNumber();
            if(escape<5){
                
                boolean amIDead=m.kills();
                if(amIDead==true){
                    
                    this.die();
                    combat_rel=CombatResult.loseAndDie;
                    
                }
                else{
                    
                    combat_rel=CombatResult.lose;
                    int numaux=dice.nextNumber();
                    if(numaux==6 && !shouldConvert()){
                        
                        combat_rel=CombatResult.loseAndConvert;
                        
                    }
                    
                    else{
                        
                        this.applyBadStuff(m.getBadStuff());
                        
                    }
                    
                }
                
            }
            else{
            combat_rel=CombatResult.loseAndEscape;
            }
        }
       this.discardNecklaceIfVisible();
       return combat_rel;
    } 
     
    public void initTreasures(){
        
        CardDealer dealer=CardDealer.getInstance();
        Dice dice=Dice.getInstance();
        this.bringToLife();
        Treasure treasure=dealer.nextTreasure();
        this.hiddenTreasures.add(treasure);
        int number=dice.nextNumber();
        if(number>1){
            
            treasure=dealer.nextTreasure();
            this.hiddenTreasures.add(treasure);
            
        }
        
        if(number==6){
            
            treasure=dealer.nextTreasure();
            this.hiddenTreasures.add(treasure);
            
        }
        
    }
    
    void setPendingBadStuff(BadStuff b){
        
        this.pendingBadStuff=b;
        
    }

    public boolean shouldConvert(){
        
        Dice dice=Dice.getInstance();
        if(dice.nextNumber()==6){
            
            return true;
            
        }
        
        else{
            
            return false;
            
        }
        
    }

@Override
    public String toString(){
        String salida ="";
        salida = " name: " + name + " level: " + Integer.toString(level) + " death: " + Boolean.toString(death) + " tesoros visibles: ";
        for(Treasure v: visibleTreasures){
            salida +="name: " + v.getName() + "(" + v.getType().toString() + ")";
        }
        salida += "tesoros ocultos: ";
        for(Treasure h: hiddenTreasures){
            salida +="name: " + h.getName() + "(" + h.getType().toString() + ")";
        }
        return salida;
}
    
}