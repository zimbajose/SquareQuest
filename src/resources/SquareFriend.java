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
public class SquareFriend extends Entity{
    
    public SquareFriend(){
        super("../assets/squarefriend.png");
    }
    
    @Override
    public void interact(Scenery s){
        String dialogue[] = {"Bom dia","Eu sou o amigo quadrado"};
        s.callDialogue(dialogue);
        
    }
    
}
