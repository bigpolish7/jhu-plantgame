/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.utils;

/**
 *
 * @author tyler
 */
//Use this enum to configure the items available for purchase at the store
public enum GameItemsEnum {
  //Set the base costs, names, and max number for the items here
  SHOVEL(10, "Shovel", 10), 
  WATERING_CAN(10, "Watering Can", 10), 
  SPADE(10, "Spade", 10), 
  SEED(10, "Seed", 10), 
  WATER(10, "Water", 10), 
  FERTILIZER(10, "Fertilizer", 10);
  
  private final int baseCost;
  private final String name;
  private final int maxNumberOfItem;
  
  GameItemsEnum(int cost, String newName, int maxNumber){
    baseCost = cost;
    name = newName;
    maxNumberOfItem = maxNumber;
  }
  
  public int getBaseCost(){
    return baseCost;
  }
  
  public String getName(){
    return name;
  }
  
  public int getMaxNumber(){
    return maxNumberOfItem;
  }
  
  public int getPrice(int numberOfItem){
    return (maxNumberOfItem-numberOfItem+1)*baseCost;
  }
}
