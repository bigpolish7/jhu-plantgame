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
    private int quality;
    
    public Fruits(String type, int id)
    {
        fruitId = id;
        fruitType = type;
    }
    
    public Fruits()
    {
    }
    
    public String getFruitType()
    {
        return fruitType;
    }
   
    public int getFruitId()
    {
        return fruitId;
    }
    
    public void setFruitType(String type)
    {
        fruitType = type;
    }
   
    public void setFruitId(int id)
    {
        fruitId = id;
    }
    /*
    public int getNumberOfTimesWater()
    {
        return NumberOfTimesWater;
    }
    */
    public void setNumberOfTimesWater(int num)
    {
        NumberOfTimesWater = num;
    }
    /*
    public int getNumberOfTimesFertilize()
    {
        return NumberOfTimesFertilize;
    }
    */
    
    public void setNumberOfTimesFertilize(int num)
    {
        NumberOfTimesFertilize = num;
    }
    
    public int getFruitQuality()
    {
        //TODO: calculation of quality from NumberOfTimesFertilize and  NumberOfTimesWater    
        return quality;
    }
    
}
