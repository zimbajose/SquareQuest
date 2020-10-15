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
public abstract class Entity {
    
    
    protected ImageIcon sprite;
    public Entity(String imageurl){
        try{
            sprite = new ImageIcon(Entity.class.getResource(imageurl).getFile());
        }
        catch(Exception e){
            System.err.println("Could not generate image url");
        }
    }
    
    
    public ImageIcon getSprite(){
        return sprite;
    }
    
    public abstract void interact(Scenery s);
    
    
    
}
