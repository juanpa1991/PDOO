package napakalaki;

import java.util.ArrayList;

/**
 *
 * @author JuanPa
 */
public class BadStuff {
    
    private String text;
    private int levels;
    private int nVisibleTreasures=0;
    private int nHiddenTreasures=0;
    private boolean death=false;
    private ArrayList<TreasureKind> specificHiddenTreasures = new ArrayList();
    private ArrayList<TreasureKind> specificVisibleTreasures = new ArrayList();
    
    public BadStuff(String text, int levels, int nVisible, int nHidden){
        this.text = text;
        this.levels = levels;
        this.nVisibleTreasures = nVisible;
        this.nHiddenTreasures = nHidden;
    }
    
    public BadStuff(String text, int levels, ArrayList<TreasureKind> tVisible,
    ArrayList<TreasureKind> tHidden){
        this.text = text;
        this.levels = levels;
        this.specificHiddenTreasures = tHidden;
        this.specificVisibleTreasures = tVisible;
    }
    
    
    public BadStuff(String text, boolean death){
        this.text = text;
        this.death = death;
    }
    
    public boolean isEmpty(){
        
        if((nVisibleTreasures==0) && (nHiddenTreasures==0) && (specificHiddenTreasures.isEmpty())
                && (specificVisibleTreasures.isEmpty())){
            return true;
        }
        
        else
            
            return false;
        
    }
    
    public void substractVisibleTreasure(Treasure t){
        
        specificVisibleTreasures.remove(t.getType());
        if(this.getnVisibleTreasures()!=0){
            nVisibleTreasures--;
            
        }
             
    }
    
    public void substractHiddenTreasure(Treasure t){
        specificHiddenTreasures.remove(t.getType());
        if(this.getnHiddenTreasures()!=0){
            
            nHiddenTreasures--;
            
        }
        
    }
    
    public boolean myBadStuffIsDead(){
        
        if(this.death==true)
            return true;
        else
            return false;
    }
    
    public String getText(){
        return text;
    }
    
    public int getLevels(){
        return levels;
    }
    
    public int getnVisibleTreasures(){
        return nVisibleTreasures;
    }
    
    public int getnHiddenTreasures(){
        return nHiddenTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificVisibleTreasures(){
        return specificVisibleTreasures;
    }
    
    public ArrayList<TreasureKind> getSpecificHiddenTreasures(){
        return specificHiddenTreasures;
    }
    
    
    public boolean getDeath(){
        return death;
    }
    
    public BadStuff adjustToFitTreasureLists(ArrayList<Treasure> v, ArrayList<Treasure> h){
        //Construir variables nuevas porque no se puede modificar el badStuff del monstruo, variables intermedias
        if(this.nHiddenTreasures>0 || this.nVisibleTreasures>0){
            
            int tVisibles=0, tOcultos=0;
            tVisibles=Math.min(this.nVisibleTreasures,v.size());
            tOcultos=Math.min(this.nHiddenTreasures,h.size());
            this.nVisibleTreasures=tVisibles;
            this.nHiddenTreasures=tOcultos;
            
        }
        
        else{
            
            ArrayList<TreasureKind> tipovisiblejugador=new ArrayList();
            for(Treasure tre: v){
                
                tipovisiblejugador.add(tre.getType());
                
            }
            
            ArrayList<TreasureKind> tipovisibleaplicar=new ArrayList();
            for(TreasureKind t: specificVisibleTreasures){
                
                for(Treasure vi: v){
                    
                    if(t.equals(vi.getType())){
                        
                        if(tipovisiblejugador.contains(t)){
                            
                            tipovisiblejugador.remove(t);
                            tipovisibleaplicar.add(t);
                            
                        }
                        
                    }
                    
                }
                
            }
            
            ArrayList<TreasureKind> tipoocultojugador=new ArrayList();
            for(Treasure tre: h){
                
                tipoocultojugador.add(tre.getType());
                
            }
            
            ArrayList<TreasureKind> tipoocultoaplicar=new ArrayList();
            for(TreasureKind t: specificHiddenTreasures){
                
                for(Treasure oc: h){
                    
                    if(t.equals(oc.getType())){
                        
                        if(tipoocultojugador.contains(t)){
                            
                            tipoocultojugador.remove(t);
                            tipoocultoaplicar.add(t);
                            
                        }
                        
                    }
                    
                }
                
            }
            specificHiddenTreasures.clear();
            for(TreasureKind tre: tipoocultoaplicar){
            
                specificHiddenTreasures.add(tre);
            }
            
            specificVisibleTreasures.clear();
            for(TreasureKind tre: tipovisibleaplicar){
            
                specificVisibleTreasures.add(tre);
            }
        }
        
        return this;
        
    }
    
    public String toStringH(){
        String salida="";
        
        for(TreasureKind tk:specificHiddenTreasures){
            salida = salida +" "+ tk.toString();
        }
         
        return salida;
    }
    
    public String toStringV(){
        String salida="";
        
        for(TreasureKind tk:specificVisibleTreasures){
            salida = salida +" "+ tk.toString();
        }
         
        return salida;
    }
    
}
