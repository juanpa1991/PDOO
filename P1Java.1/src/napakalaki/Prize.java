package napakalaki;

// clase Prize

public class Prize {
    
    private int treasures; // atributo treasures
    private int level;    // atributo level
    
    public Prize(int treasures, int level){ // constructor Prize con parametros treasures y level
        this.treasures = treasures;         
        this.level = level;
    }
    
    public int getTreasures(){ // consultor getTreasures
        return treasures;     // devuelve treasures
    }
    
    public int getLevel(){  // consultor getLevel
        return level;      // devuelve level
    }
            
    @Override
   public String toString(){
        return " Treasures = " + Integer.toString(treasures) + " Levels = " + Integer.toString(level);
}         
}
