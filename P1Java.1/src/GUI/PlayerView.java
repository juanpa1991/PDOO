/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;
import java.util.ArrayList;
import javax.swing.JPanel;
import napakalaki.CultistPlayer;
import napakalaki.Player;
import napakalaki.Treasure;
import napakalaki.TreasureKind;
/**
 *
 * @author Juanki1
 */
public class PlayerView extends javax.swing.JPanel {

    Player playerModel;
    /**
     * Creates new form PlayerView
     */
    public PlayerView() {
        initComponents();
    }
    
    public void fillTreasurePanel (JPanel aPanel, ArrayList<Treasure> aList) {
        // Se elimina la información antigua
        aPanel.removeAll();
        // Se recorre la lista de tesoros construyendo y añadiendo sus vistas
        // al panel
        for (Treasure t : aList) {
            TreasureView aTreasureView = new TreasureView();
            aTreasureView.setTreasure (t);
            aTreasureView.setVisible (true);
            aPanel.add (aTreasureView);
    
        }
        // Se fuerza la actualización visual del panel
        aPanel.repaint();
        aPanel.revalidate();
    }

    public void setPlayer (Player p) {
        playerModel = p;
        boolean typePlayer;
        typePlayer=p.getClass().getSimpleName().equals("Player");
        if(typePlayer==false){
            
            SectarioBool.setText(Integer.toString(((CultistPlayer)playerModel).getMyCultistCard().getBasicValue()));
            
        }
        
        else{
            
            SectarioBool.setText("");
            
        }
        
        Nombre.setText(playerModel.getName());
        Nivel.setText(Integer.toString(playerModel.getLevel()));
        NiveldeCombate.setText(Integer.toString(playerModel.getCombatLevelPlayer()));
        NumeroVisibles.setText(Integer.toString(playerModel.getPendingBadSutff().getnVisibleTreasures()));
        NumeroOcultos.setText(Integer.toString(playerModel.getPendingBadSutff().getnHiddenTreasures()));
        SpecificHiddenT.setText(playerModel.getPendingBadSutff().toStringH());
        SpecificVisibleT.setText(playerModel.getPendingBadSutff().toStringV());
        
        //Como establecer Sectario=true o contrario
        
        // Incluir instrucciones para actualizar su nombre, nivel, etc.
        // Incluir también la orden para actualizar la vista asociada a su carta
        // de sectario (si es el caso) mediante el método setCultist
        // A continuación se actualizan sus tesoros
        fillTreasurePanel (visibleTreasures, playerModel.getVisibleTreasures());
        fillTreasurePanel (hiddenTreasures, playerModel.getHiddenTreasures());
        repaint();
        revalidate();
        }
    
        public JPanel getHiddenTreasuresPanel(){
            
            return hiddenTreasures;
            
        }
        
        public JPanel getVisibleTreasuresPanel(){
            
            return visibleTreasures;
            
        }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        VisiblesNumber = new javax.swing.JLabel();
        OcultosNumber = new javax.swing.JLabel();
        Name = new javax.swing.JLabel();
        Level = new javax.swing.JLabel();
        Sectario = new javax.swing.JLabel();
        NumeroVisibles = new javax.swing.JLabel();
        NumeroOcultos = new javax.swing.JLabel();
        Nombre = new javax.swing.JLabel();
        Nivel = new javax.swing.JLabel();
        SectarioBool = new javax.swing.JLabel();
        visibleTreasures = new javax.swing.JPanel();
        hiddenTreasures = new javax.swing.JPanel();
        CombatLevel = new javax.swing.JLabel();
        NiveldeCombate = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        SpecificHiddenT = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        SpecificVisibleT = new javax.swing.JLabel();

        VisiblesNumber.setText("VisiblesNumber");

        OcultosNumber.setText("OcultosNumber");

        Name.setText("Name");

        Level.setText("Level");

        Sectario.setText("Sectario");

        NumeroVisibles.setBackground(new java.awt.Color(153, 204, 255));
        NumeroVisibles.setText("             ");

        NumeroOcultos.setBackground(new java.awt.Color(153, 204, 255));
        NumeroOcultos.setText("            ");

        Nombre.setBackground(new java.awt.Color(153, 204, 255));

        Nivel.setBackground(new java.awt.Color(153, 204, 255));

        SectarioBool.setBackground(new java.awt.Color(153, 204, 255));

        visibleTreasures.setBackground(new java.awt.Color(153, 204, 255));

        hiddenTreasures.setBackground(new java.awt.Color(153, 204, 255));

        CombatLevel.setText("CombatLevel");

        NiveldeCombate.setBackground(new java.awt.Color(153, 204, 255));
        NiveldeCombate.setText("             ");

        jLabel1.setText("Visible");

        jLabel2.setText("Hidden");

        jLabel3.setText("Pending BadStuff:");

        jLabel4.setText("SpecificHiddenT");

        SpecificHiddenT.setBackground(new java.awt.Color(153, 204, 255));

        jLabel5.setText("SpecificVisibleT");

        SpecificVisibleT.setBackground(new java.awt.Color(153, 204, 255));

        org.jdesktop.layout.GroupLayout layout = new org.jdesktop.layout.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .addContainerGap()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(Name, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Nombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 204, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(Sectario, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                                .add(18, 18, 18)
                                .add(SectarioBool, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 55, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))
                            .add(layout.createSequentialGroup()
                                .add(CombatLevel)
                                .add(18, 18, 18)
                                .add(NiveldeCombate)))
                        .add(132, 132, 132)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(VisiblesNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(OcultosNumber, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel3, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(NumeroVisibles, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 30, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(NumeroOcultos, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 1, Short.MAX_VALUE))
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(jLabel4, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(jLabel5, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.UNRELATED)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING, false)
                            .add(SpecificHiddenT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .add(SpecificVisibleT, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)))
                    .add(layout.createSequentialGroup()
                        .add(Level, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 54, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(Nivel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 46, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(104, 104, 104)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(jLabel1)
                            .add(visibleTreasures, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 790, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                    .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                        .add(jLabel2)
                        .add(hiddenTreasures, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 790, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(382, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
            .add(layout.createSequentialGroup()
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING, false)
                    .add(layout.createSequentialGroup()
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(layout.createSequentialGroup()
                                .add(52, 52, 52)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                    .add(Name)
                                    .add(Nombre, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                            .add(org.jdesktop.layout.GroupLayout.TRAILING, layout.createSequentialGroup()
                                .add(10, 10, 10)
                                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, Sectario)
                                    .add(org.jdesktop.layout.GroupLayout.TRAILING, SectarioBool, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                        .add(4, 4, 4))
                    .add(layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(jLabel3)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                            .add(NumeroVisibles)
                            .add(VisiblesNumber)
                            .add(jLabel4)
                            .add(SpecificHiddenT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE))))
                .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                    .add(layout.createSequentialGroup()
                        .add(14, 14, 14)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.LEADING)
                            .add(CombatLevel)
                            .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.BASELINE)
                                .add(OcultosNumber)
                                .add(NumeroOcultos)
                                .add(NiveldeCombate)
                                .add(jLabel5)
                                .add(SpecificVisibleT, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)))
                        .add(48, 48, 48)
                        .add(jLabel1)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(visibleTreasures, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED, 337, Short.MAX_VALUE)
                        .add(jLabel2)
                        .addPreferredGap(org.jdesktop.layout.LayoutStyle.RELATED)
                        .add(hiddenTreasures, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 198, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                        .add(66, 66, 66))
                    .add(layout.createSequentialGroup()
                        .add(18, 18, 18)
                        .add(layout.createParallelGroup(org.jdesktop.layout.GroupLayout.TRAILING)
                            .add(Nivel, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE, 16, org.jdesktop.layout.GroupLayout.PREFERRED_SIZE)
                            .add(Level))
                        .addContainerGap(org.jdesktop.layout.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel CombatLevel;
    private javax.swing.JLabel Level;
    private javax.swing.JLabel Name;
    private javax.swing.JLabel Nivel;
    private javax.swing.JLabel NiveldeCombate;
    private javax.swing.JLabel Nombre;
    private javax.swing.JLabel NumeroOcultos;
    private javax.swing.JLabel NumeroVisibles;
    private javax.swing.JLabel OcultosNumber;
    private javax.swing.JLabel Sectario;
    private javax.swing.JLabel SectarioBool;
    private javax.swing.JLabel SpecificHiddenT;
    private javax.swing.JLabel SpecificVisibleT;
    private javax.swing.JLabel VisiblesNumber;
    private javax.swing.JPanel hiddenTreasures;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel visibleTreasures;
    // End of variables declaration//GEN-END:variables
}