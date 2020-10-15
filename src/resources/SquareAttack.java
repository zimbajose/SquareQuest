/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package resources;

import bin.Attack;

/**
 *
 * @author Jose
 */
public class SquareAttack extends Attack {
    
    public SquareAttack(){
        super(30,"../assets/squareattack.png",300);
    }
    @Override
    public int[] trajectoryFunction(int x){
        int a[] = {x,x};
        return a;
    }
    
}
