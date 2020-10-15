/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

/**
 *
 * @author Jose
 */
public class Player extends Entity implements java.io.Serializable{
    public int hp = 100;
    public int maxhp = 100;
    public Player(){
            super("../assets/squareprotag.png");
        
    }

    @Override
    public void interact(Scenery s) {
       
    }
    
    public boolean takeDamage(int d){
        hp-=d;
        return hp<=0;
    }
    
    public void heal(int d){
        hp+= d;
        if(hp>100){
            hp = 100;
        }
    }
    
    
}
