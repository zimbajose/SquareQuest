/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Jose
 */
public class MusicPlayer extends Thread{
    
    private AudioPlayer p;
    public boolean keepPlaying;
    private AudioStream as;
    
    public MusicPlayer(AudioStream a){
      as = a;
      keepPlaying = true;
    }
    
    @Override
    public void run(){
        
        while(keepPlaying){
            p.player.start(as);
        }
        p.player.stop(as);
    }
    
}
