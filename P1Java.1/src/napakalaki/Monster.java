package napakalaki;

/**
 *
 * @author JuanPa
 */
public class Monster implements Card{
    
    private String name;
    private int combatLevel;
    private Prize price;
    private BadStuff bc;
    private int levelChangeAgainstCultistPlayer;
    
    
    public Monster(String name, int level, BadStuff bc, Prize price){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.price = price;
        this.levelChangeAgainstCultistPlayer=0;
    }
    
    public Monster(String name, int level, BadStuff bc, Prize price, int levelChangeAgainstCultistPlayer){
        this.name = name;
        this.combatLevel = level;
        this.bc = bc;
        this.price = price;
        this.levelChangeAgainstCultistPlayer=levelChangeAgainstCultistPlayer;
    }
    public int getBasicValue(){
        
        return this.getCombatLevel();
        
    }
    public boolean kills(){
        
        if(this.getBadStuff().myBadStuffIsDead()==true){
            
            return true;
        }
        else
            
            return false;
    }
    
    public String getName(){
        return name;
    }
    
    public int getCombatLevel(){
        return combatLevel;
    }
    
    
    public BadStuff getBadStuff(){
        return bc;
    }
    public Prize getPrize(){
        return price;
    }
    
    @Override
    public String toString(){
        return " name= " + name + " Combat level = " + Integer.toString(combatLevel) 
                  + bc.toString()  + price.toString();
}

    @Override
    public int getSpecialValue() {
        return this.getBasicValue()+this.levelChangeAgainstCultistPlayer;
    }
    
    
    
}
