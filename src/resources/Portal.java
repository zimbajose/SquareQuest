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
public class Portal extends Entity{
    private int portalindex;
    public Portal(int portalindex) {
        super("../assets/portal.png");
        this.portalindex = portalindex;
    }

    @Override
    public void interact(Scenery s) {
        s.changeScenery(portalindex);
        
    }
    
}
