/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;


import bin.Player;
import bin.Savefile;
import bin.Saveutil;
import bin.Scenery;
import bin.Troop;
import java.util.LinkedList;
import javax.swing.JLabel;

/**
 *
 * @author Jose
 */
public class Map extends javax.swing.JFrame {

    /**
     * Creates new form map
     */
   public Player p;
   private Battle b;
   boolean spacepressed = false;
   String dialogues[];
   int dialogueindex;
   public Scenery scenerie;
   public LinkedList<Scenery> sceneries;
    public Map(LinkedList<Scenery> sceneries, Player p) {
        initComponents();
        this.sceneries =sceneries;
        this.p =p;
        this.Dialogpane.setVisible(false);
        this.Entitiespane.setBackground(new java.awt.Color(0,0,0,0));
        this.Menu.setVisible(false);
        this.updateHp();
    }
    public void updateHp(){
        this.hplabel.setText(p.hp+"/100");
    }
    public void endCombat(boolean sucess){
        updateHp();
        b.setVisible(false);
        if(sucess){
            String[] s = {"Voce venceu!"};
            callDialogue(s);
            this.setVisible(true);
        }
        else{
            Gameover g = new Gameover();
            g.setVisible(true);
            this.setVisible(false);
        }
    }
    
    public void startBattle(Troop t){
        b = new Battle(t,this);
        b.setVisible(true);
        this.setVisible(false);
        
    }
    
    public void callDialogue(String[] d){
       this.Dialogpane.setVisible(true);
       dialogues = d;
       dialogueindex =0;
       this.textpanel.setText(dialogues[dialogueindex]);
       
    }
    
    private boolean nextDialogue(){
        dialogueindex++;
        if(dialogueindex>=dialogues.length){
            return false;
        }
        this.textpanel.setText(dialogues[dialogueindex]);
        return true;
    }
    
    public void render(){
        this.Entitiespane.removeAll();
        JLabel j;
        for(int x = 0; x<scenerie.entities.length;x++){
            for(int y=0;y<scenerie.entities[x].length;y++){
                if(scenerie.entities[x][y]!=null){
                   
                    j = new JLabel();
                    j.setIcon(scenerie.entities[x][y].getSprite());
                    Entitiespane.add(j);
                    j.setLocation(x*40,y*30);
                    j.setVisible(true);
                    j.setSize(40,30);
                    j.repaint();
                    
                }
            }
        }
        this.repaint();
        this.paintAll(this.getGraphics());
        this.Entitiespane.repaint();
        
    }
    public void changeMap(int s){
        this.scenerie = sceneries.get(s);
        this.mapbackground.setIcon(scenerie.getImg());
        this.mapbackground.repaint();
        
        render();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Dialogpane = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textpanel = new javax.swing.JTextArea();
        Menu = new javax.swing.JPanel();
        savebtn = new javax.swing.JButton();
        hplabel = new javax.swing.JLabel();
        Entitiespane = new javax.swing.JPanel();
        mapbackground = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(800, 600));
        setMinimumSize(new java.awt.Dimension(800, 600));
        setPreferredSize(new java.awt.Dimension(800, 600));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                formKeyTyped(evt);
            }
        });
        getContentPane().setLayout(null);

        Dialogpane.setBackground(new java.awt.Color(0, 0, 0));
        Dialogpane.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 4));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);

        textpanel.setEditable(false);
        textpanel.setBackground(new java.awt.Color(0, 0, 0));
        textpanel.setColumns(20);
        textpanel.setFont(new java.awt.Font("NSimSun", 0, 18)); // NOI18N
        textpanel.setForeground(new java.awt.Color(255, 255, 255));
        textpanel.setRows(5);
        textpanel.setName(""); // NOI18N
        textpanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                textpanelKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textpanelKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(textpanel);

        javax.swing.GroupLayout DialogpaneLayout = new javax.swing.GroupLayout(Dialogpane);
        Dialogpane.setLayout(DialogpaneLayout);
        DialogpaneLayout.setHorizontalGroup(
            DialogpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 752, Short.MAX_VALUE)
                .addContainerGap())
        );
        DialogpaneLayout.setVerticalGroup(
            DialogpaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DialogpaneLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 130, Short.MAX_VALUE)
                .addContainerGap())
        );

        getContentPane().add(Dialogpane);
        Dialogpane.setBounds(10, 440, 780, 160);

        Menu.setBackground(new java.awt.Color(0, 0, 0));
        Menu.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 255, 255), 6));

        savebtn.setBackground(new java.awt.Color(0, 0, 0));
        savebtn.setFont(new java.awt.Font("Comic Sans MS", 0, 32)); // NOI18N
        savebtn.setForeground(new java.awt.Color(255, 255, 255));
        savebtn.setText("Salvar");
        savebtn.setFocusable(false);
        savebtn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                savebtnMouseClicked(evt);
            }
        });

        hplabel.setBackground(new java.awt.Color(240, 180, 240));
        hplabel.setFont(new java.awt.Font("Segoe UI Historic", 0, 36)); // NOI18N
        hplabel.setForeground(new java.awt.Color(255, 255, 255));
        hplabel.setText("100/100");

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(savebtn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addComponent(hplabel)
                .addContainerGap(25, Short.MAX_VALUE))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(savebtn, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 93, Short.MAX_VALUE)
                .addComponent(hplabel)
                .addGap(221, 221, 221))
        );

        getContentPane().add(Menu);
        Menu.setBounds(0, 0, 190, 441);

        javax.swing.GroupLayout EntitiespaneLayout = new javax.swing.GroupLayout(Entitiespane);
        Entitiespane.setLayout(EntitiespaneLayout);
        EntitiespaneLayout.setHorizontalGroup(
            EntitiespaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 800, Short.MAX_VALUE)
        );
        EntitiespaneLayout.setVerticalGroup(
            EntitiespaneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 600, Short.MAX_VALUE)
        );

        getContentPane().add(Entitiespane);
        Entitiespane.setBounds(0, 0, 800, 600);

        mapbackground.setMaximumSize(new java.awt.Dimension(800, 600));
        mapbackground.setMinimumSize(new java.awt.Dimension(800, 600));
        mapbackground.setPreferredSize(new java.awt.Dimension(800, 600));
        getContentPane().add(mapbackground);
        mapbackground.setBounds(0, 0, 800, 600);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyTyped
        switch(evt.getKeyChar()){
            case 'e':
                if(this.Menu.isVisible()){
                    this.Menu.setVisible(false);
                }
                else{
                    this.Menu.setVisible(true);
                }
                break;
            case ' ':
                if(!nextDialogue()){
                    this.Dialogpane.setVisible(false);
                }
                break;
            case 'a':
                this.scenerie.move(2);
                break;
            case 'w':
                this.scenerie.move(3);
                break;
            case 'd':
                this.scenerie.move(0);
                break;
            case 's':
                this.scenerie.move(1);
                break;
        }
        this.render();
        
    }//GEN-LAST:event_formKeyTyped

    private void textpanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textpanelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_textpanelKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
  
    }//GEN-LAST:event_formKeyPressed

    private void textpanelKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textpanelKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_textpanelKeyReleased

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
       
    }//GEN-LAST:event_formKeyReleased

    private void savebtnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_savebtnMouseClicked
        Savefile s = new Savefile();
        s.playerhp = p.hp;
        s.sceneryindex = scenerie.getIndex();
        
        Saveutil.save(s);
    }//GEN-LAST:event_savebtnMouseClicked

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Dialogpane;
    private javax.swing.JPanel Entitiespane;
    private javax.swing.JPanel Menu;
    private javax.swing.JLabel hplabel;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mapbackground;
    private javax.swing.JButton savebtn;
    private javax.swing.JTextArea textpanel;
    // End of variables declaration//GEN-END:variables
}