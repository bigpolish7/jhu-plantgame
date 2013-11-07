/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgame.models;

import java.util.ArrayList;

/**
 *
 * @author minh
 */
public class Garden {
  
  private ArrayList<Fruits> fruits;
  
  public Garden(){
    fruits = new ArrayList<Fruits>();
  }
  
  
  //Add a fruit to the garden
  public void addFruit(Fruits newFruit){
    fruits.add(newFruit);
  }
  
  public ArrayList<Fruits> getFruits(){
    return fruits;
  }
  
  
}
