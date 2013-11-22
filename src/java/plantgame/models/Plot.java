/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgame.models;

/**
 *
 * @author minh
 */
public class Plot {
    private String plotStatus;
    private Fruits fruit;
    
    public Plot(String thisPlotStatus) {
        plotStatus = thisPlotStatus;
        fruit = new Fruits();
    }
    public Plot() {
    }
    public String getPlotStatus() {
        return plotStatus;
    }
    public void setPlotStatus(String thisPlotStatus) {
        plotStatus = thisPlotStatus;
    }
    public Fruits getFruit() {
        return fruit;
    }
    public void setFruit(Fruits thisFruit) {
        fruit = thisFruit;
    }
    
    public void startGrowing(){
      if (fruit != null){
        fruit.startGrowing();
      }
    }
}

