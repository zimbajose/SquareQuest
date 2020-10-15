/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import bin.Attack;
import bin.Enemy;
import javax.swing.ImageIcon;

/**
 *
 * @author Jose
 */

public class EnemySquare extends Enemy {
    private boolean attackedonce = false;
    private boolean attackedtwice = false;
    public EnemySquare(){
        super(4,"../assets/enemysquare.jpeg");
      
    }
    
    @Override
    public Attack[] getAttacks(){
        
        if(!attackedonce){
            Attack[] f = {new SquareAttack()};
            attackedonce = true;
            return f;
        }
        else if(!attackedtwice){
            Attack[] f = {new SquareAttack1(true)};
            attackedtwice = true;
            return f;
        }
        else{
            Attack[] f = {new SquareAttack1(false),new SquareAttack1(true)};
            return f;
        }
        
    }
    
}
