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
    private boolean isPlowed;
    private String plotUsage;
    private Fruits fruit;
    
    public Plot(boolean thisIsPlowed, String thisPlotUsage) {
        isPlowed = thisIsPlowed;
        plotUsage = thisPlotUsage;
    }
    public Plot() {
    }
    public boolean getIsPlowed() {
        return isPlowed;
    }
    public void setIsPlowed(boolean thisIsPlowed) {
        isPlowed = thisIsPlowed;
    }
    public String getPlotUsage() {
        return plotUsage;
    }
    public void setPlotUsage(String thisPlotUsage) {
        plotUsage = thisPlotUsage;
    }
    public Fruits getFruit() {
        return fruit;
    }
    public void setFruit(Fruits thisFruit) {
        fruit = thisFruit;
    }
}

