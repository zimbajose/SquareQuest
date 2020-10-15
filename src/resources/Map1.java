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
public class Map1 extends Scenery implements java.io.Serializable{
    
    public Map1(Map m,Player p){
        super(20,20,"../assets/background.png",m,p,0);
        startup();
    }
    
    private void startup(){
        entities[5][5] = new SquareTroop();
        entities[10][10] = new SquareFriend();
        entities[12][18] = new Portal(1);
        
    }
    
}
