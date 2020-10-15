/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;

import gui.Map;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

/**
 *
 * @author Jose
 */
public abstract class Scenery implements java.io.Serializable {

    public int[] playerpos = {1, 0};
    public Entity[][] entities;
    protected ImageIcon mapimg;
    protected int ysize;
    protected int xsize;
    protected Map map;
    private int sceneryindex;
    public Player player;

    public Scenery(int xsize, int ysize, String mapurl, Map m, Player p, int s) {
        if (xsize < 2 || ysize < 2) {
            System.err.println("Invalid map size");
            m.dispose();
        }

        player = p;
        
        entities = new Entity[xsize][ysize];
        entities[1][0] = p;
        this.ysize = ysize;
        this.xsize = xsize;
        try {
            mapimg = new ImageIcon(Scenery.class.getResource(mapurl));

        } catch (Exception e) {
            System.err.println(e);
            m.dispose();
        }
        this.map = m;
        sceneryindex = s;
    }

    public void updateHp() {
        map.updateHp();
    }

    public ImageIcon getImg() {
        return mapimg;
    }

    public void changeScenery(int i) {
      
        map.changeMap(i);
        entities[playerpos[0]][playerpos[1]] = null;
        entities[1][0] = null;
        entities[1][0] = player;
        playerpos[0] = 1;
        playerpos[1] = 0;
    }

    public int getIndex() {
        return this.sceneryindex;
    }

    public void callDialogue(String[] dialogue) {
        map.callDialogue(dialogue);
    }

    public int getPlayerX() {
        return playerpos[0];
    }

    public int getPlayerY() {
        return playerpos[1];
    }

    public void callBattle(Troop t) {
        this.map.startBattle(t);

    }

    public void insertEntity(int x, int y, Entity e) throws Exception {
        if (x == playerpos[0] && y == playerpos[1]) {
            throw new Exception("");
        }
    }

    protected void playMoveClip() {
        InputStream in;
        AudioStream a;
        try {
            in = new FileInputStream(Scenery.class.getResource("../assets/4A.wav").getFile());
            a = new AudioStream(in);
            AudioPlayer ap = AudioPlayer.player;
            ap.start(a);
        } catch (IOException ex) {
            Logger.getLogger(Scenery.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    protected void moveTroops() {
        int m;
        Troop t;
        for (int x = 0; x < xsize; x++) {
            for (int y = 0; y < ysize; y++) {
                if (entities[x][y] instanceof Troop) {
                    t = (Troop) entities[x][y];
                    m = t.move();

                    switch (m) {
                        case 0:
                            if (x + 1 > xsize) {
                                break;
                            } else if (entities[x + 1][y] == null) {

                                entities[x + 1][y] = (Entity) t;
                                entities[x][y] = null;
                                playMoveClip();
                                break;
                            } else {
                                entities[x][y] = null;
                                this.callBattle(t);
                                break;
                            }
                        case 1:
                            if (y + 1 > ysize) {
                                break;
                            } else if (entities[x][y + 1] == null) {
                                entities[x][y + 1] = (Entity) t;
                                entities[x][y] = null;
                                playMoveClip();
                                break;
                            } else {
                                entities[x][y] = null;
                                this.callBattle(t);
                                break;
                            }
                        case 2:
                            if (x - 1 < 0) {
                                break;
                            } else if (entities[x - 1][y] == null) {
                                entities[x - 1][y] = (Entity) t;
                                entities[x][y] = null;
                                playMoveClip();
                                break;
                            } else {
                                entities[x][y] = null;
                                this.callBattle(t);
                                break;
                            }
                        case 3:
                            if (y - 1 < 0) {
                                break;
                            } else if (entities[x][y - 1] == null) {
                                entities[x][y - 1] = (Entity) t;
                                entities[x][y] = null;
                                playMoveClip();
                                break;
                            } else {
                                entities[x][y] = null;
                                this.callBattle(t);
                                break;
                            }
                        default:

                    }
                }
            }
        }
    }

    public boolean move(int d) {
        try {
            switch (d) {
                case 0:
                    if (playerpos[0] + 1 > xsize) {

                        moveTroops();
                        return false;
                    }
                    if (entities[playerpos[0] + 1][playerpos[1]] != null) {

                        entities[playerpos[0] + 1][playerpos[1]].interact(this);
                        moveTroops();
                        return true;
                    } else {

                        Player temp = (Player) entities[playerpos[0]][playerpos[1]];
                        entities[playerpos[0]][playerpos[1]] = null;
                        playerpos[0]++;

                        entities[playerpos[0]][playerpos[1]] = temp;
                        moveTroops();
                        return true;
                    }

                case 1:
                    if (playerpos[1] + 1 > ysize) {
                        moveTroops();
                        return false;
                    }
                    if (entities[playerpos[0]][playerpos[1] + 1] != null) {
                        entities[playerpos[0]][playerpos[1] + 1].interact(this);
                        moveTroops();
                        return true;
                    } else {
                        Player temp = (Player) entities[playerpos[0]][playerpos[1]];
                        entities[playerpos[0]][playerpos[1]] = null;
                        playerpos[1]++;

                        entities[playerpos[0]][playerpos[1]] = temp;
                        moveTroops();
                        return true;
                    }

                case 2:
                    if (playerpos[0] - 1 < 0) {
                        moveTroops();
                        return false;
                    }
                    if (entities[playerpos[0] - 1][playerpos[1]] != null) {
                        entities[playerpos[0] - 1][playerpos[1]].interact(this);
                        moveTroops();
                        return true;
                    } else {
                        Player temp = (Player) entities[playerpos[0]][playerpos[1]];
                        entities[playerpos[0]][playerpos[1]] = null;
                        playerpos[0]--;

                        entities[playerpos[0]][playerpos[1]] = temp;
                        moveTroops();
                        return true;
                    }
                case 3:
                    if (playerpos[1] - 1 < 0) {
                        moveTroops();
                        return false;
                    }
                    if (entities[playerpos[0]][playerpos[1] - 1] != null) {
                        entities[playerpos[0]][playerpos[1] - 1].interact(this);
                        moveTroops();
                        return true;
                    } else {
                        Player temp = (Player) entities[playerpos[0]][playerpos[1]];
                        entities[playerpos[0]][playerpos[1]] = null;
                        playerpos[1]--;

                        entities[playerpos[0]][playerpos[1]] = temp;
                        moveTroops();
                        return true;
                    }
                default:
                    return false;
            }
        } catch (Exception e) {
            return false;
        }

    }

}
