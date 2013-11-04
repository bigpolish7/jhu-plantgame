/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.helperBeans;

import javax.servlet.http.HttpServletRequest;
import plantgame.models.Store;
import plantgame.models.User;
import plantgame.utils.Constants;
import plantgame.utils.GameItemsEnum;

/**
 *
 * @author tyler
 */
public class StoreHelper {
  
  
  
  public void StoreHelper(){
    
  }
  
  //This method will take a user object and a request object. It will extract
  //the items that the user selected to purchase from the request. It will then 
  //check to make sure the user has enough money. If the user does not have enough money
  //then Constants.NOT_ENOUGH_MONEY will be returned. 
  //Then the database will be checked to make sure there are still enough 
  //items in the store. In not then Constants.NOT_ENOUGH_ITEMS_IN_STORE will be 
  //returned.
  //If the user has enough money and there are enough items in the store then 
  //the user's money will be updated, the database for the store will be updated
  //and the user's items will be updated.
  public static String doPurchase(User user, HttpServletRequest request){
    
    int selectedValue[] = new int[GameItemsEnum.values().length];
    int total = 0;
    int price;
    int index = 0;
    
    //DEBUG
    System.out.println("StoreHelper User's name is "+user.getUserName());
    
    //First determine how many of each item the user selected to buy
    //from the request and determine the total price
    for (GameItemsEnum item : GameItemsEnum.values()){
      //Get the value selected for each item
      selectedValue[index] = Integer.parseInt(request.getParameter(item.getName()+"Select"));
      
      //Get the price per item
      price = Store.getItemPriceStatic(item.getName());
      
      //DEBUG
      System.out.println("StoreHelper parameter "+item.getName()+"Select is "+selectedValue[index]);
      
      //Calculate the cost of the items selected by the user
      total = total + price*selectedValue[index];
      
      //DEBUG
      System.out.println("StoreHelper price for "+item.getName()+" is "+price);
      
      index++;
    }
    
    //DEBUG
    System.out.println("StoreHelper User has $"+ user.getMoney());
    
    //Check to make sure the user has enough money
    if (total > user.getMoney()){
      //DEBUG
      System.out.println("StoreHelper Not Enough Money");
      
      return Constants.NOT_ENOUGH_MONEY;
    }
    
    Store store = Store.getInstance();
    
    //The store object actually does the removing items from the store and
    //adding them to the user's stock in a synchronized method
    return store.purchaseItems(selectedValue, user);
    
  }
  
  
}

