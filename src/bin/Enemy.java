/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import javax.swing.ImageIcon;

/**
 *
 * @author Jose
 */
public abstract class Enemy {
    protected int hp;
    protected ImageIcon sprite;
    
    public Enemy(int h, String s){
        hp =h;
        try{
            sprite = new ImageIcon(Enemy.class.getResource(s).getFile());
        }
        catch(Exception e){
            System.err.println("Could not load enemy sprite");
        }
    }
    
    public boolean takeDamage(){
        hp = hp-1;
        return (hp<=0);
    }
    
    public abstract Attack[] getAttacks();
    
    public ImageIcon getSprite(){
        return sprite;
    }
    
    
    
    
}
