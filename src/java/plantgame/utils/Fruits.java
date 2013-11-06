/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.utils;

import java.util.Timer;

/**
 *
 * @author aadu
 */
public class Fruits {
    
    private String fruitType = null;
    private int fruitId;
    
    private int NumberOfTimesWater;
    private int NumberOfTimesFertilize;
    
    Fruits(String type, int id)
    {
        fruitId = id;
        fruitType = type;
    }
    
    public int getNumberOfTimesWater()
    {
        return NumberOfTimesWater;
    }
    
    public void setNumberOfTimesWater(int num)
    {
        NumberOfTimesWater = num;
    }
    
    public int getNumberOfTimesFertilize()
    {
        return NumberOfTimesFertilize;
    }
    
    public void setNumberOfTimesFertilize(int num)
    {
        NumberOfTimesFertilize = num;
    }
    

    public void run(){
      //DEBUG
      System.out.println("Fruits creating thread");
      
      Timer plantGrowingTimer = new Timer();
      
      //Schedule the plant to reach fruition at a given delay
      plantGrowingTimer.schedule(null, fruitId);
    }
}
