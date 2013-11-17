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
  APPLE(1,"Apple", 100000, 100000),
  PEAR(1,"Pear", 100000, 100000),
  BANANA(1,"Banana", 100000, 100000),
  MANGO(1,"Mango", 100000, 100000),
  KIWI(1,"Kiwi", 100000, 100000);
  
  
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
