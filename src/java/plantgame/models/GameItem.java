/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;


/**
 *
 * @author tyler
 */
public class GameItem {
  
  private String name;
  
  public void GameItem(){
    name = "";
  }
  
  public void setName(String n){
    name = n;
  }
  
  public String getName(){
    return name;
  }
}
