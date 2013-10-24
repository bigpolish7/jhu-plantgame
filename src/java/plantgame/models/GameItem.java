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
  private int baseCost;

  public GameItem(String n, int c){
    name = n;
    baseCost = c;
    
  }
  
  public void GameItem(){
    name = "";
    baseCost = 0;
  }
  
  public void setName(String n){
    name = n;
  }
  
  public String getName(){
    return name;
  }
  
  public void setBaseCost(int n){
    baseCost = n;
  }
  
  public int getBaseCost(){
    return baseCost;
  }
  
}
