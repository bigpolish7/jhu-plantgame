/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;

import java.util.HashMap;
import plantgame.utils.GameItemsEnum;

/**
 *
 * @author tyler
 */
public class Store {

  //StoreItem will be an internal class to Store that holds an item type
  //and the number of that item which the store contains
  private class StoreItem{
    public int numberOfItem;
    public GameItemsEnum itemType;
    
    public StoreItem(GameItemsEnum e, int num){
      numberOfItem = num;
      itemType = e;
    }
    
    
  }
  
  private Store store = null;
  private HashMap<String, StoreItem> storeItems;
  
  //The constructor creates the storeItems hashmap which can be used to
  //look up a StoreItem object by its name
  private Store(){
    
    storeItems = new HashMap<String, StoreItem>();
    
    for (GameItemsEnum item : GameItemsEnum.values()){
      StoreItem newStoreItem = new StoreItem(item, 10);
      storeItems.put(item.getName(), newStoreItem);
    }
  }
  
  //Store will be a singleton since it will be shared among all players in the 
  //game
  public Store getInstance (){
    if (store == null){
      store = new Store();
    }
    
    return store;
  }
  
  //TODO method for adding items to store. Should be synchronized
  
  //TODO method for removing items from store. Should be synchronized
  
  //TODO method for getting price of an item
}
