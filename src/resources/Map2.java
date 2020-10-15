/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import bin.Player;
import bin.Scenery;
import gui.Map;

/**
 *
 * @author Jose
 */
public class Map2 extends Scenery implements java.io.Serializable{
    
    public Map2(Map m,Player p){
        super(20,20,"../assets/background.png",m,p,1);
        startup();
    }
    
    private void startup(){
        entities[5][5] = new SquareTroop();
        entities[7][5] = new SquareTroop();
        entities[7][10] = new Tree();
        entities[4][4] = new Portal(0);
        entities[7][7] = new HealFountain();
        entities[9][4] = new Tree();
        entities[5][12] = new Tree();
    }
    
}
