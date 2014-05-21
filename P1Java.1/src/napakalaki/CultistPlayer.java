/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author Juanki1
 */
public class CultistPlayer extends Player{

    private static int totalCultistPlayers =0;
    private Cultist myCultistCard;
    
    CultistPlayer(Player p, Cultist c){
        
        super(p);
        this.myCultistCard=c;
        totalCultistPlayers=totalCultistPlayers+1;
        
    }
    
    public static int getTotalCultistPlayer(){
        
        return totalCultistPlayers;
        
    }
    
    @Override
    public int getOponentLevel(Monster m){
        
        return m.getSpecialValue();
        
    }

    @Override
    protected int getCombatLevel() {
        return super.getCombatLevel()+myCultistCard.getSpecialValue();
    }
    
    @Override
    public int computeGoldCoinsValue(ArrayList<Treasure> t){
        
        int niveles=super.computeGoldCoinsValue(t)*2;
        
         return niveles;  
        
    }
    
    @Override
    public boolean shouldConvert(){
        
        return false;
        
    }
    
    public Cultist getMyCultistCard(){
        
        return myCultistCard;
        
    }
    
}
