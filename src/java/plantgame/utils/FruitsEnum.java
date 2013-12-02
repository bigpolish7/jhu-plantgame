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
  APPLE(Constants.APPLE_ID,1,Constants.APPLE, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT),
  PEAR(Constants.PEAR_ID,1,Constants.PEAR, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT),
  BANANA(Constants.BANANA_ID,1,Constants.BANANA, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT),
  MANGO(Constants.MANGO_ID,1,Constants.MANGO, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT),
  KIWI(Constants.KIWI_ID,1,Constants.KIWI, Constants.FRUIT_TIME_TO_GROW, Constants.FRUIT_TIME_TO_ROT);
  
  private final int id;
  private final int baseCost;
  private final String name;
  private final long timeToGrow; //in ms
  private final long timeToRot; //in ms
  
  FruitsEnum(int fId, int cost, String newName, long newTime, long newRotTime){
      
    id = fId;  
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
  
  public int getId(){
    return id;
  }
}
