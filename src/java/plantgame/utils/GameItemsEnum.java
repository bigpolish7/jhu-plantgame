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
  SHOVEL(10, "Shovel", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  WATERING_CAN(10, "Watering Can", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  SPADE(10, "Spade", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  SEED(10, "Seed", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  WATER(10, "Water", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  FERTILIZER(10, "Fertilizer", Constants.MAX_NUMBER_OF_ITEM_IN_STORE);
  
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
    // numberOfItem: the number of items available for sale at store
    return (maxNumberOfItem-numberOfItem+1)*baseCost;
  }
}
