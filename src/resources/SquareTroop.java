/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import bin.Enemy;
import bin.Entity;
import bin.Scenery;
import bin.Troop;
import java.io.FileInputStream;
import java.io.InputStream;
import sun.audio.AudioStream;

/**
 *
 * @author Jose
 */
public class SquareTroop extends Entity implements Troop{
    private Enemy e;
    boolean moveup = true;
    
    public SquareTroop(){
        super("/assets/squareenemy.png");
        e = new EnemySquare();
    }
    @Override
    public void interact(Scenery s){
       String dialogue[] = new String[1];
       dialogue[0] = "Eu sou erro";
       s.callDialogue(dialogue);
       
    }
    @Override
    public AudioStream getMusic(){
        try{
            InputStream in = new FileInputStream(SquareTroop.class.getResource("../assets/battle2.wav").getFile());
            AudioStream as = new AudioStream(in); 
            return as;
        }
        catch(Exception e){
            System.err.println("Could not play music");
            return null;
        }
    }
    @Override
    public Enemy getEnemy(){
        return e;
    }
    @Override
    public int move(){
        if(moveup){
            moveup =false;
            return 3;
        }
        else{
            moveup = true;
            return 1;
        }
    }
    
}
