/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bin;


import java.io.*;

/**
 *
 * @author Jose
 */
public class Saveutil {
    
    public static void save(Savefile e){
       
        try {
         FileOutputStream fileOut =
         new FileOutputStream("savedata.square");
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
         out.writeObject(e);
         out.close();
         fileOut.close();
         
      } catch (IOException i) {
         i.printStackTrace();
      }
    }
    
    public static Savefile load(){
        Savefile e;
        try {
         FileInputStream fileIn = new FileInputStream("savedata.square");
         ObjectInputStream in = new ObjectInputStream(fileIn);
         e = (Savefile) in.readObject();
         in.close();
         fileIn.close();
      } catch (IOException i) {
         i.printStackTrace();
         return null;
      } catch (ClassNotFoundException c) {
         
         c.printStackTrace();
         return null;
      }
        return e;
    }
    
}
