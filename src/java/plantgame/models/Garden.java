/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgame.models;

import java.util.ArrayList;
import plantgame.utils.Constants;

/**
 *
 * @author minh
 */
public class Garden {
  
  //private ArrayList<Fruits> fruits;
  private ArrayList<Plot> plots;
    
  public Garden(){
    //fruits = new ArrayList<Fruits>();
    plots = new ArrayList<Plot>(Constants.USER_START_NUMBER_OF_PLOTS);
  }
  
  /*
  //Add a fruit to the garden
  public void addFruit(Fruits newFruit){
    fruits.add(newFruit);
  }
  
  public ArrayList<Fruits> getFruits(){
    return fruits;
  }
  */
  //Add plots to the garden
  public void addPlot(Plot newPlot){
    plots.add(newPlot);
  }
  
  public ArrayList<Plot> getPlots(){
    return plots;
  }
}
