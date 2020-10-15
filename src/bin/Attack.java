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
public abstract class Attack {
    
    protected int size;
    protected ImageIcon icon;
    protected int damage;
    public int duration;
    public Attack(int d, String s,int du){
        icon = new ImageIcon(Attack.class.getResource(s).getFile());
        damage =d;
        size = icon.getIconWidth();
        duration =du;
        
    }  
    
    public int getDamage(){
        return damage;
    }
    public ImageIcon getSprite(){
        return icon;
    }
    public int getSize(){
        return size;    
    }
    
    public abstract int[] trajectoryFunction(int x);
        
    
    
    
}
