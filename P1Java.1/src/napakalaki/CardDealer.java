
package napakalaki;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
/**
 *
 * @author JuanPa
 */
public class CardDealer {
    
    private static  CardDealer instance =  new CardDealer();
    
    // atributos-relaciones
    
    private ArrayList <Monster> unusedMonsters = new ArrayList();
    
    private ArrayList <Monster> usedMonsters = new ArrayList();
    
    private ArrayList <Treasure> usedTreasures = new ArrayList();
    
    private ArrayList <Treasure> unusedTreasures = new ArrayList();
    
    private ArrayList <Cultist> unusedCultists = new ArrayList();
    
    
    private CardDealer() {
        
    }
    
    public static CardDealer getInstance(){
        return instance;
    }
    
     public void initCultistCardDeck(){
        
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectrio", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 2));
        unusedCultists.add(new Cultist("Sectario", 1));
        unusedCultists.add(new Cultist("Sectario", 1));
        
    }
    
    private void initTreasuresCardDeck(){
        
        // ¡Sí mi amo!
        
        unusedTreasures.add(new Treasure("Si mi amo",0,4,7,TreasureKind.helmet));
        
        //Botas de investigación
        
        unusedTreasures.add(new Treasure("Botas de investigacion",600,3,4,TreasureKind.shoe));
        
        // Capucha de Cthulhu
        
        unusedTreasures.add(new Treasure("Capucha de Cthulhu",500,3,5,TreasureKind.helmet));
        
        // A prueba de balas
        
        unusedTreasures.add(new Treasure("A prueba de babas",400,2,5,TreasureKind.armor));
        
        // Botas de lluvia ácida
        
        unusedTreasures.add(new Treasure("Botas de lluvia acida",800,1,1,TreasureKind.shoe));
         
        // Casco minero
        
        unusedTreasures.add(new Treasure("Casco minero",400,2,4,TreasureKind.helmet));
        
        // Ametralladora Thompson
        
        unusedTreasures.add(new Treasure("Ametralladora Thompson",600,4,8,TreasureKind.bothHand));
        
        // Camiseta de la UGR
        
        unusedTreasures.add(new Treasure("Camiseta de la UGR",100,1,7,TreasureKind.armor));
        
        // Clavo de rail ferroviario
         
        unusedTreasures.add(new Treasure("Clavo de rail ferroviario",400,3,6,TreasureKind.oneHand));
        
        // Cuchillo de sushi arcano
        
        unusedTreasures.add(new Treasure("Cuchillo de sushi arcano",300,2,3,TreasureKind.oneHand));
        
        // Fez alópodo  
        
        unusedTreasures.add(new Treasure("Fez alopodo",700,3,5,TreasureKind.helmet));
        
        // Hacha prehistótica
        
        unusedTreasures.add(new Treasure("Hacha prehistorica",500,2,5,TreasureKind.oneHand));
        
        // El aparato del Pr. Tesla
        
        unusedTreasures.add(new Treasure("El aparato del Pr. Tesla",900,4,8,TreasureKind.armor));
        
        // Gaita
        
        unusedTreasures.add(new Treasure("Gaita",500,4,5,TreasureKind.bothHand));
        
        // Insectidia
        
        unusedTreasures.add(new Treasure("Insecticida",300,2,3,TreasureKind.oneHand));
        
        // Escopeta de 3 cañones
        
        unusedTreasures.add(new Treasure("Escopeta de 3 canones",700,4,6,TreasureKind.bothHand));
        
        // Garabato místico
        
        unusedTreasures.add(new Treasure("Garabato mistico",300,2,2,TreasureKind.oneHand));
        
        // La fuerza de Mr. T
        
        unusedTreasures.add(new Treasure("La fuerza de Mr.T",1000,3,5,TreasureKind.necklace)); // Bonus Mayor
        
        // la rebeca metálica
        
        unusedTreasures.add(new Treasure("La rebeca metalica",400,2,3,TreasureKind.armor));
        
        // Mazo de los antiguos
        
        unusedTreasures.add(new Treasure("Mazo de los antiguos",200,3,4,TreasureKind.oneHand));
        
        // Necro-playboycón
        
        unusedTreasures.add(new Treasure("Necro-playboycon",300,3,5,TreasureKind.oneHand));
        
        // Lanzallamas
        
        unusedTreasures.add(new Treasure("Lanzallamas",800,4,8,TreasureKind.bothHand));
        
        // Negro-comicón
        
        unusedTreasures.add(new Treasure("Necro-comicon",100,1,1,TreasureKind.oneHand));
        
        // Necronomicón
        
        unusedTreasures.add(new Treasure("Necronomicon",800,5,7, TreasureKind.bothHand));
        
        // Linterna a 2 manos
        
        unusedTreasures.add(new Treasure("Linterna a 2 manos",400,3,6,TreasureKind.bothHand));
        
        // Necro-gnomicón
        
        unusedTreasures.add(new Treasure("Necro-gnomicon",200,2,4,TreasureKind.oneHand));
        
        // Necrotelecom
        
        unusedTreasures.add(new Treasure("Necrotelecom",300,2,3,TreasureKind.helmet));
        
        // Porra preternatural
        
        unusedTreasures.add(new Treasure("Porra preternatural",200,2,3,TreasureKind.oneHand));
        
        // Tentáculo de pega
        
        unusedTreasures.add(new Treasure("Tentaculo de pega",200,0,1,TreasureKind.helmet));
        
        // Zapato deja-amigos
        
        unusedTreasures.add(new Treasure("Zapato deja-amigos",500,0,1,TreasureKind.shoe));
        
        // Shogulador
        
        unusedTreasures.add(new Treasure("Shogulador",600,1,1,TreasureKind.bothHand));
        
        // Varita de atizamiento
        
        unusedTreasures.add(new Treasure("Varita de atizamiento",400,3,4,TreasureKind.oneHand));
    }
    
    private void initMonsterCardDeck(){
        
        //3 Byakhees de bonanza
        
        ArrayList<TreasureKind> tvp = new ArrayList();
        ArrayList<TreasureKind> top = new ArrayList();
        
        Prize prize = new Prize(2, 1);
        tvp.add(TreasureKind.armor);
        top.add(TreasureKind.armor);
        BadStuff bc = new BadStuff("Pierdes tu armadura visible y otra oculta.", 0, tvp, top);
        unusedMonsters.add(new Monster("3 Byakhees de bonanza", 8, bc, prize));
        
        //Chibithulhu
        
        //ArrayList<TreasureKind> tvp2 = new ArrayList();
        //ArrayList<TreasureKind> top2 = new ArrayList();
        tvp.clear();
        top.clear();
        
        prize = new Prize(1,1);
        bc = new BadStuff("Embobados con el lindo primigenio te descartas de tu casco visible.",0,tvp,top);
        tvp.add(TreasureKind.helmet);
        unusedMonsters.add(new Monster("Chibithulhu",2,bc, prize));
        //El sopor de Dunwich
        
        ArrayList<TreasureKind> tvp3 = new ArrayList();
        ArrayList<TreasureKind> top3 = new ArrayList();
        
        
        prize = new Prize(1,1);
        tvp3.add(TreasureKind.shoe);
        bc = new BadStuff("El primordial bostezo contagioso", 0, tvp3, top3 );
        unusedMonsters.add(new Monster("El sopor de Dunwich", 2, bc, prize));
        
        //Ángeles de la noche ibicenca
         
        ArrayList<TreasureKind> tvp4 = new ArrayList();
        ArrayList<TreasureKind> top4 = new ArrayList();
        
        prize = new Prize(4,1);
        tvp4.add(TreasureKind.oneHand);
        top4.add(TreasureKind.oneHand);
        bc = new BadStuff("Te atrapan para llevarte de fiesta y te dejan caer en mitad dael vuelo."
                + " Descarta 1 mano visible y 1 mano oculta", 0, tvp4, top4);
        unusedMonsters.add(new Monster("Angeles de la noche ibicenca", 14, bc , prize));
        
        //El gorrón en el umbral
        
        prize = new Prize(3,1);
        bc = new BadStuff("Pierdes todos tus tesoros visibles",0,6,0);
        unusedMonsters.add(new Monster("El gorron en el umbral", 10, bc , prize));
                
                
        //H. P. Munchcraft
          
        ArrayList<TreasureKind> tvp6 = new ArrayList();
        ArrayList<TreasureKind> top6 = new ArrayList();
        
        prize = new Prize(2,1);
        tvp6.add(TreasureKind.armor);
        bc = new BadStuff("Pierdes la armadura visible", 0, tvp6, top6);
        unusedMonsters.add(new Monster("HP Munchcraft",6, bc , prize));
        
        //Bichgooth
        
        ArrayList<TreasureKind> tvp7 = new ArrayList();
        ArrayList<TreasureKind> top7 = new ArrayList();

        prize = new Prize(1, 1);
        tvp7.add(TreasureKind.armor);
        bc = new BadStuff("Pierdes tu armadura visible.", 0, tvp7, top7);
        unusedMonsters.add(new Monster("Bichgooth", 2, bc, prize));
        
        //El rey de la rosa
        
        prize = new Prize(4, 2);
        
        bc = new BadStuff("Pierdes 5 niveles y 3 tesoros visibles.", 5, 3, 0);
        unusedMonsters.add(new Monster("El rey de la rosa", 13, bc, prize));
        
        
        //La que redacta en las tinieblas
        
        prize = new Prize(1, 1);
        
        bc = new BadStuff("Toses los pulmones y pierdes 2 niveles", 2, 0, 0);
        unusedMonsters.add(new Monster("La que redacta en las tinieblas", 2, bc, prize));
        
        //Los hondos
        
        prize = new Prize(2, 1);
        
        bc = new BadStuff("Estos monstruos resultan bastante superficiales y te aburren mortalmente. Estas muerto.", true);
        unusedMonsters.add(new Monster("Los hondos", 8, bc, prize));
        
        
        //Semillas Cthulhu
        
        prize = new Prize(2, 1);
        
        bc = new BadStuff("Pierdes 2 niveles y 2 tesoros ocultos", 2, 0, 2);
        unusedMonsters.add(new Monster("Semillas Cthulhu", 4, bc, prize));
        
        //Dameargo
        
        prize = new Prize(2, 1);
        
        ArrayList<TreasureKind> tvp12 = new ArrayList();
        ArrayList<TreasureKind> top12 = new ArrayList();
        
        tvp12.add(TreasureKind.oneHand);
        
        bc = new BadStuff("Te intentas escaquear. Pierdes una mano visible", 0, tvp12, top12);
        unusedMonsters.add(new Monster("Dameargo", 1, bc, prize));
        
        
        //Pollipolipo volante
        
        prize = new Prize(1, 1);
        
        bc = new BadStuff("Da mucho asquito. Pierdes 3 niveles", 3, 0, 0);
        unusedMonsters.add(new Monster("Pollipolipo volante", 3, bc, prize));
        
        
        //Yskhtihyssg-Goth
        
        prize = new Prize(3,1);
        bc = new BadStuff("No le hace gracia que pronuncien mal su nombre. Estas muerto", true);
        unusedMonsters.add(new Monster("Yskhtihyssg-Goth", 12, bc, prize));
        
        //Familia feliz
        
        prize = new Prize(4,1);
        bc = new BadStuff("La familia te atrapa. Estas muerto", true);
        unusedMonsters.add(new Monster("Familia feliz", 1, bc, prize));
        
        //Roboggoth
        
        ArrayList<TreasureKind> tvp15 = new ArrayList();
        ArrayList<TreasureKind> top15 = new ArrayList();
      
        prize = new Prize(2,1);
        tvp15.add(TreasureKind.bothHand);
        bc = new BadStuff("La quinta directiva primaria te obliga a perder 2 niveles y un tesoro 2 manos visible", 2, tvp15, top15);
        unusedMonsters.add(new Monster("Roboggoth", 8, bc, prize));
        
        //El Espia
        
        ArrayList<TreasureKind> tvp16 = new ArrayList();
        ArrayList<TreasureKind> top16 = new ArrayList();
        
        prize = new Prize(1,1);
        tvp16.add(TreasureKind.helmet);
        bc = new BadStuff("Te asusta en la noche. Pierdes un casco visible", 0, tvp16, top16);
        unusedMonsters.add(new Monster("El espia", 5, bc, prize));
        
        //El Lenguas
        
        prize = new Prize(1,1);
        bc = new BadStuff("Menudo susto te llevas. Pierdes 2 niveles y 5 tesoros visibles", 2, 5, 0);
        unusedMonsters.add(new Monster("El lenguas", 20, bc, prize));
        
        //Bicéfalo
        
        ArrayList<TreasureKind> tvp18 = new ArrayList();
        ArrayList<TreasureKind> top18 = new ArrayList();
       
        prize = new Prize(1,1);
        tvp18.add(TreasureKind.bothHand);
        bc = new BadStuff("Te faltan manos para tanta cabeza. Pierdes 3 niveles y tus tesoros visibles de las manos", 3, tvp18, top18);
        unusedMonsters.add(new Monster("Bicefalo", 20, bc, prize));
        
        // El mal indecible impronunciable
        
        ArrayList<TreasureKind> tvp19 = new ArrayList();
        ArrayList<TreasureKind> top19 = new ArrayList();
        
        prize = new Prize(3,1);
        tvp19.add(TreasureKind.oneHand);
        bc = new BadStuff("Pierdes 1 mano visible",0,tvp19,top19);
        unusedMonsters.add(new Monster("El mal indecible impronunciable", 10, bc, prize, -2));
        
        //Testigo Oculares
        
        prize = new Prize(2,1);
        bc = new BadStuff("Pierdes tus tesoros visbles. Jajaja",0,6,0);
        unusedMonsters.add(new Monster("Testigos oculares", 6, bc, prize, +2));
        
        //El gran cthulhu
        prize = new Prize(2,5);
        bc = new BadStuff("Hoy no es tu dia de suerte. Mueres", true);
        unusedMonsters.add(new Monster("El gran cthulhu", 20, bc, prize, +4));
        
        //Serpiente Político
        
        prize = new Prize(2,1);
        bc = new BadStuff("Tu gobierno te recorta 2 niveles",2,0,0);
        unusedMonsters.add(new Monster("Serpiente politico", 8, bc, prize, -2));
        
        //Felpuggoth
        
        ArrayList<TreasureKind> tvp20 = new ArrayList();
        ArrayList<TreasureKind> top20 = new ArrayList();
        
        prize = new Prize(1,1);
        tvp20.add(TreasureKind.helmet);
        tvp20.add(TreasureKind.armor);
        top20.add(TreasureKind.bothHand);
        bc = new BadStuff("Pierdes tu casco y tu armadura visible. Pierdes tus manos ocultas.",0,tvp20,top20);
        unusedMonsters.add(new Monster("Felpuggoth", 2, bc, prize, +5));
        
        
        //Shoggoth
        
        prize = new Prize(4,2);
        bc = new BadStuff("Pierdes 2 niveles",2,0,0);
        unusedMonsters.add(new Monster("Shoggoth", 16, bc, prize, -4));
        
        //Lolitagooth
        
        prize = new Prize(1,1);
        bc = new BadStuff("Pintalabios negro. Pierdes 2 niveles",2,0,0);
        unusedMonsters.add(new Monster("Lolitagooth", 2, bc, prize, +3));


    }
    
    private void ShuffleTreasures(){
        
        Collections.shuffle(unusedTreasures);
        
    }
    
    private void ShuffleMonsters(){
        
        Collections.shuffle(unusedMonsters);
        
    }
    
    public Treasure nextTreasure(){
        
        if(unusedTreasures.isEmpty()){
            
            for(Treasure tre: usedTreasures){
                
                unusedTreasures.add(tre);
                
            }
            Collections.shuffle(unusedTreasures);
            usedTreasures.clear();
        }
            
        return unusedTreasures.remove(0);
              
    }
    
    public Monster nextMonster(){
        
        if(unusedMonsters.isEmpty()){
            
            for(Monster mon: usedMonsters){
                
                unusedMonsters.add(mon);
                
            }
            Collections.shuffle(unusedMonsters);
            usedMonsters.clear();
       
        }
        
        return unusedMonsters.remove(0);
             
    }

    public void giveTreasureBack(Treasure t){
        
        this.usedTreasures.add(t);
          
    }
    
    public void giveMonsterBack(Monster m){
        
        this.usedMonsters.add(m);
        
    } 
    
    public void initCards(){
        
        this.initMonsterCardDeck();
        this.initTreasuresCardDeck();
        this.ShuffleMonsters();
        this.ShuffleTreasures();
        this.initCultistCardDeck();
        
    }
    
    private void shuffleCultists(){
        
        
        Collections.shuffle(unusedCultists);
        
    }
    
    public Cultist nextCultist(){
        
        return unusedCultists.remove(0);
        
    }
    
    
}
