/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;


import sun.audio.AudioStream;

/**
 *
 * @author Jose
 */
public interface Troop{
    
    public Enemy getEnemy();
    public AudioStream getMusic();
    public int move();
    
    
    
}
