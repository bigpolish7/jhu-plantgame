/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.helperBeans;

import javax.servlet.http.HttpServletRequest;
import plantgame.models.User;
import plantgame.utils.Constants;

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
    
    //TODO: make this method
    return Constants.NOT_ENOUGH_MONEY;
  }
  
  
}

