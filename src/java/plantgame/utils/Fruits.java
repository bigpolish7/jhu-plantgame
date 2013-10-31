/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.utils;

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
    
    
}
