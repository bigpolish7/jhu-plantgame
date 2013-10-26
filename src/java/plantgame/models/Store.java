/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;

import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import plantgame.utils.Constants;
import plantgame.utils.GameItemsEnum;

/**
 *
 * @author tyler
 */
public class Store implements Runnable{

  //StoreItem will be an internal class to Store that holds an item type
  //and the number of that item which the store contains
  private class StoreItem{
    public int numberOfItem;
    public GameItemsEnum itemType;
    public int maxNumberOfItem;
    
    public StoreItem(GameItemsEnum e, int num){
      numberOfItem = num;
      itemType = e;
      maxNumberOfItem = e.getMaxNumber();
    }
    
    
  }
  
  //Private class extending TimerTask. This will be used by the addItemsToStoreTimer
  //object to add items to the store.
  private class StoreDeliver extends TimerTask{
    

    public StoreDeliver(){
      super();
    }
    
    @Override
    public void run(){
      for(GameItemsEnum item : GameItemsEnum.values()){
        addItemToStore(item.getName(), Constants.NUMBER_OF_ITEM_TO_ADD_TO_STORE);
        
        //DEBUG
        System.out.println("Store:StoreDeliver adding "+item.getName());
      }
    }
  }
  
  
  private static Store store = null;
  private HashMap<String, StoreItem> storeItems;
  
  //The constructor creates the storeItems hashmap which can be used to
  //look up a StoreItem object by its name
  private Store(){
    
    storeItems = new HashMap<String, StoreItem>();
    
    for (GameItemsEnum item : GameItemsEnum.values()){
      StoreItem newStoreItem = new StoreItem(item, Constants.ITEM_NUMBER_STORE_START);
      storeItems.put(item.getName(), newStoreItem);
    }
    

  }
  
  @Override
  public void run(){
    //DEBUG
    System.out.println("Store creating thread for deliveries.");
    
    //Create a timer object which will execute 
    Timer addItemsToStoreTimer = new Timer();
    addItemsToStoreTimer.scheduleAtFixedRate(new StoreDeliver(), Constants.STORE_FIRST_DELIVERY_DELAY, Constants.STORE_INTER_DELIVERY_DELAY);    
  }
  
  
  //Store will be a singleton since it will be shared among all players in the 
  //game
  //This will also start the store thread
  public static Store getInstance (){
    //DEBUG
    System.out.println("Store returning an instance of the store.");
    
    if (store == null){
      store = new Store();
      
      //DEBUG
      System.out.println("Store starting thread.");
      
      //Start the thread
      (new Thread(store)).start();
    }
    return store;
  }
  
  //method for adding items to store. Should be synchronized
  public synchronized void addItemToStore(String itemName, int numberToAdd){
    
    //DEBUG
    System.out.println("Store adding "+numberToAdd+" "+itemName+" to the store.");
    
    
    //First get the StoreItem
    StoreItem item = storeItems.get(itemName);
    
    //Add the numberToAdd items to the store's inventory
    item.numberOfItem = item.numberOfItem+numberToAdd;
    
    //Then determine if the store hold too many of that item
    //and if so decrease the number to the max number that the store
    //can hold
    if (item.numberOfItem > item.maxNumberOfItem){
      item.numberOfItem = item.maxNumberOfItem;
    }
    
    //DEBUG
    System.out.println("Store now has "+item.numberOfItem+" of "+item.itemType.getName());
    
  }
  
  //Method for getting the number of items in stock for a particular item
  public int getNumberOfItemInStock(String itemName){
    return storeItems.get(itemName).numberOfItem;
  }
  
  //TODO method for removing items from store. Should be synchronized
  
  //TODO method for getting price of an item
}
