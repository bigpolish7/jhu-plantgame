/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;

import plantgame.utils.GameItemsEnum;

/**
 *
 * @author tyler
 */
public class UserItem {
  private GameItemsEnum type;
  private int numberOfItem;
  
  public UserItem(){
    
  }
  
  public void setType(GameItemsEnum e){
    type = e;
  }
  
  public GameItemsEnum getType(){
    return type;
  }
  
  public void setNumberOfItem(int e){
    numberOfItem = e;
  }
  
  public int getNumberOfItem(){
    return numberOfItem;
  }
  
}
