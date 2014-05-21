/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package napakalaki;

import GUI.NapakalakiView;
import GUI.PlayerNamesCapture;
import java.util.ArrayList;

/**
 *
 * @author Juanki1
 */
public class main {
        
    
    public static void main(String[] args) {
        
        Napakalaki napakalakiModel = Napakalaki.getInstance();
        
        NapakalakiView napakalakiView = new NapakalakiView();
        
        Dice.createInstance(napakalakiView);
        
        ArrayList<String> names = new ArrayList();
        
        PlayerNamesCapture namesCapture = new PlayerNamesCapture(napakalakiView, true);
        
        names = namesCapture.getNames();
        
        napakalakiModel.initGame(names);
        
        napakalakiView.setNapakalaki(napakalakiModel);
        
        napakalakiView.showView();
        
        
        
//        Napakalaki napakalaki = Napakalaki.getInstance();
//        String[] names = new String[3]; 
//        names[0]="j1";
//        names[1]="j2";
//        names[2]="j3";
//        
//        napakalaki.initGame(names);
//        
//        //Mostrar jugadores
//        for(Player p: napakalaki.getJugadores()){
//            System.out.println("Jugador: " + p.toString());
//        }
//        
//        //Mostrar jugador actual
//        System.out.println("Jugador actual: " + napakalaki.getCurrentPlayer().toString());
//        
//        
//        //Mostrar monstruo
//        System.out.println("Monstruo actual: " + napakalaki.getCurrentMonster().toString());
//        
//        
//        //Puedo comprar niveles?
//        //System.out.println("Comprar niveles: " + napakalaki.buyLevels(napakalaki.getCurrentPlayer().getVisibleTreasures(), napakalaki.getCurrentPlayer().getHiddenTreasures()));
//        //System.out.println(napakalaki.getCurrentPlayer().getLevel());
//        
//        //hacer visible/Equipar
//        //ArrayList<Treasure> tre = new ArrayList();
//        //tre.add(new Treasure("La fuerza de Mr. T",1000,3,5,TreasureKind.necklace));
//        //napakalaki.makeTreasuresVisible(tre);
//        napakalaki.makeTreasuresVisible(napakalaki.getCurrentPlayer().getHiddenTreasures());
//        
//        //Mostrar jugador actual equipado
//        System.out.println("Jugador actual equipado: " + napakalaki.getCurrentPlayer().toString());
//        
//        
//        //Descartar un tesoro oculto
//        //napakalaki.getCurrentPlayer().discardHiddenTreasure(napakalaki.getCurrentPlayer().getHiddenTreasures().get(0));
//        //System.out.println("Jugador actual descartardo de 1 tesoro oculto: " + napakalaki.getCurrentPlayer().toString());
//        
//        //Descartar un tesoro visible
//        //napakalaki.getCurrentPlayer().discardVisibleTreasure(napakalaki.getCurrentPlayer().getVisibleTreasures().get(0));
//        //System.out.println("Jugador actual descartardo de 1 tesoro visible: " + napakalaki.getCurrentPlayer().toString());
//        
//        
//        //Mostrar el pendingBadSutff
//        //System.out.println("Badstuff" + napakalaki.getCurrentPlayer().getPendingBadSutff());
//        
//
//        //descartar todos los tesoros ocultos
//        //napakalaki.discardHiddenTreasures(napakalaki.getCurrentPlayer().getHiddenTreasures());
//        //System.out.println("Jugador actual descartardo de todos los tesoros ocultos: " + napakalaki.getCurrentPlayer().toString());
//        
//
//        //descartar todos los tesoros visibles
//        //napakalaki.discardVisibleTreasures(napakalaki.getCurrentPlayer().getVisibleTreasures());
//        //System.out.println("Jugador actual descartardo de todos los tesoros visibles: " + napakalaki.getCurrentPlayer().toString());
//        
//        
//        //nivel de combate
//        //System.out.println("Nivel de combate: " + napakalaki.getCurrentPlayer().getCombatLevel());
//        
//        //Combate
//        System.out.println(napakalaki.developCombat());
//        
//        //Mostrar el pendingBadSutff
//        System.out.println("Badstuff" + napakalaki.getCurrentPlayer().getPendingBadSutff());
//        
//        
//        //Mostrar jugador actual equipado despues del combate
//        System.out.println("Jugador actual equipado despues del combate: " + napakalaki.getCurrentPlayer().toString());
    }
}