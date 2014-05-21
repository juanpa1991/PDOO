package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author JuanPa
 */
public class Treasure implements Card{

    private String name;
    private int goldCoins;
    private int minBonus;
    private int maxBonus;
    private TreasureKind type;
    
    
    //atributos-relaciones
    
    
    
    

    public Treasure(String name, int goldCoins, int minBonus, int maxBonus, TreasureKind type) {

        this.name = name;
        this.goldCoins = goldCoins;
        this.maxBonus = maxBonus;
        this.minBonus = minBonus;
        this.type = type;

    }
    
    public TreasureKind getType(){
        return type;
    }
    
    public String getName(){
        return name;
    }
    
    public int getMaxBonus(){
        return maxBonus;
    }
    
    public int getMinBonus(){
        return minBonus;
    }
    
    public int getGoldCoins(){
        return goldCoins;
    }

    @Override
    public int getBasicValue() {
        return this.getMinBonus();
    }

    @Override
    public int getSpecialValue() {
        return this.getMaxBonus();
    }
    
}


