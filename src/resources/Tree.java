/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import bin.Entity;
import bin.Scenery;

/**
 *
 * @author Jose
 */
public class Tree extends Entity{
    
    public Tree(){
        super("../assets/tree.png");
    }

    @Override
    public void interact(Scenery s) {
        
    }
    
}
