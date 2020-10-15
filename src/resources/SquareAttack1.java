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
public class SquareAttack1 extends Attack {
    private boolean sin;
    public SquareAttack1(boolean sin){
        super(30,"../assets/squareattack.png",300);
        this.sin = sin;
    }
    @Override
    public int[] trajectoryFunction(int x){
        double b =x;
        double h =(Math.sin(b/15)*70);
        double t =(Math.cos(b/15)*70);
        b = sin ?  h:t ;
        int y = (int) b;
        int a[] = {x,y+90};
        return a;
    }
    
}
