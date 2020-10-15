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
public class HealFountain extends Entity{
    public HealFountain(){
        super("../assets/redcross.png");
    }
    @Override
    public void interact(Scenery s){
        s.player.hp = 100;
        s.updateHp();
        String[] d = {"Vocë foi curado"};
        s.callDialogue(d);
    }
}
