/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.utils;

/**
 *
 * @author tyler
 */
public enum FruitsEnum {
  APPLE(1,Constants.APPLE, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT),
  PEAR(1,Constants.PEAR, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT),
  BANANA(1,Constants.BANANA, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT),
  MANGO(1,Constants.MANGO, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT),
  KIWI(1,Constants.KIWI, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT);
  
  
  private final int baseCost;
  private final String name;
  private final long timeToGrow; //in ms
  private final long timeToRot; //in ms
  
  FruitsEnum(int cost, String newName, long newTime, long newRotTime){
  
    baseCost = cost;
    name = newName;
    timeToGrow = newTime;
    timeToRot = newRotTime;
  }
  
  public int getBaseCost(){
    return baseCost;
  }
  
  public String getName(){
    return name;
  }
  
  public long getTimeToGrow(){
    return timeToGrow;
  }
  
  
  public long getTimeToRot(){
    return timeToRot;
  }
}
