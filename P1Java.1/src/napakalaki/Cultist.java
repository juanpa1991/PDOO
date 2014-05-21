/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

/**
 *
 * @author Juanki1
 */
public class Cultist implements Card{
    
    private String name;
    private int gainedLevels;

    
    Cultist(String name, int gainedLevels){
        
        this.name=name;
        this.gainedLevels=gainedLevels;
        
    }
    @Override
    public int getBasicValue() {
        
        return this.gainedLevels;
        
    }

    @Override
    public int getSpecialValue() {
        
        return this.getBasicValue()*CultistPlayer.getTotalCultistPlayer();
        
    }
    
}
