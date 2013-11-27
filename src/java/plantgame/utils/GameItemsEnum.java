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
  BUCKET(10, Constants.BUCKET, Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  SPADE(10, Constants.SPADE, Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  APPLE_SEED(10, Constants.SEED_APPLE, Constants.MAX_NUMBER_OF_ITEM_IN_STORE),
  PEAR_SEED(10, Constants.SEED_PEAR, Constants.MAX_NUMBER_OF_ITEM_IN_STORE),
  BANANA_SEED(10, Constants.SEED_BANANA, Constants.MAX_NUMBER_OF_ITEM_IN_STORE),
  MANGO_SEED(10, Constants.SEED_MANGO, Constants.MAX_NUMBER_OF_ITEM_IN_STORE),
  KIWI_SEED(10, Constants.SEED_KIWI, Constants.MAX_NUMBER_OF_ITEM_IN_STORE),
  WATER(10, Constants.ITEM_WATER, Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  FERTILIZER(10, Constants.ITEM_FERTILIZER, Constants.MAX_NUMBER_OF_ITEM_IN_STORE);
   
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
