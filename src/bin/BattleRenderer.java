/*
 * To change b license header, choose License Headers in Project Properties.
 * To change b template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

/**
 *
 * @author Jose
 */
import com.sun.prism.paint.Color;
import gui.Battle;
import java.awt.Component;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class BattleRenderer extends Thread {

    private Battle b;
    private JPanel battlepane;
    
    public BattleRenderer(Battle b,JPanel bp) {
        this.b =b;
        battlepane = bp;
    }

    @Override
    public void run() {
        b.attackhappening = true;
        battlepane.removeAll();
        battlepane.add(b.squary);
        b.squary.setLocation(b.defaultposx, b.defaultposy);

        int collisiontimer = 0;
        Attack[] a = b.enemy.getAttacks();
        int counter = 0;
        int[] r;
        boolean stillattacks = true;
        JLabel[] attacksprites = new JLabel[a.length];
        for (int x = 0; x < a.length; x++) {
            attacksprites[x] = new JLabel();
            attacksprites[x].setIcon(a[x].getSprite());
            
            battlepane.add(attacksprites[x]);
            r = a[x].trajectoryFunction(0);
            attacksprites[x].setLocation(r[0], r[1]);
        }
        while (stillattacks) {
            battlepane.setVisible(true);
            b.paintAll(b.getGraphics());
            if (b.downpressed) {
               
                if (b.squary.getY()+2 < battlepane.getHeight()-22) {
                    b.squary.setLocation(b.squary.getX(), b.squary.getY() + 2);
                }
            }
            if (b.uppressed) {
                if (b.squary.getY()-2 > 0+4) {
                    b.squary.setLocation(b.squary.getX(), b.squary.getY() - 2);
                }
            }
            if (b.leftpressed) {
                if (b.squary.getX()-2 > 0+4) {
                    b.squary.setLocation(b.squary.getX() - 2, b.squary.getY());
                }
            }
            if (b.rightpressed) {
                if (b.squary.getX()+2 < battlepane.getWidth()-22) {
                    b.squary.setLocation(b.squary.getX() + 2, b.squary.getY());
                }
            }
            if (collisiontimer > 0) {
                collisiontimer -= 15;
            }
            stillattacks = false;
             battlepane.removeAll();
             battlepane.add(b.squary);
            for (int x = 0; x < a.length; x++) {
               
                if (a[x].duration > counter) {
                    r = a[x].trajectoryFunction(counter);
                    attacksprites[x].setLocation(r[0], r[1]);
                    battlepane.add(attacksprites[x]);
                  
                    attacksprites[x].setSize(a[x].getSize(),a[x].getSize());
                    
                    attacksprites[x].setVisible(true);
                    
                    attacksprites[x].repaint();
                    attacksprites[x].revalidate();
                    if (b.checkCollisions(b.squary.getX(),b.squary.getY(),r[0],r[1],a[x].getSize()) && (collisiontimer <= 0)) {
                        collisiontimer = 400;
                        b.takeDamage(a[x].getDamage());
                        attacksprites[x].repaint();
                    }
                    stillattacks = true;
                    battlepane.repaint();
                }
               
               

            }
            try {
                Thread.sleep(15);
            } catch (InterruptedException ex) {
                Logger.getLogger(BattleRenderer.class.getName()).log(Level.SEVERE, null, ex);
            }
            counter++;
        }
        battlepane.setVisible(false);
        b.attackbutton.setVisible(true);
        b.attackhappening = false;
    }
}


