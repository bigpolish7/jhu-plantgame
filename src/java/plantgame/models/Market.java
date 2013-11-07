/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aadu
 */
public class Market {
    
    List<Fruits> mktFruitsList = null;
    
    public Market()
    {
        mktFruitsList =new ArrayList<Fruits>();
    } 
    
    /*
     * This API will retrive all the fruits that can
     * be sold on the market. It will pull this from 
     * the DB
     */
    public List<Fruits> getMarketFruits()
    {
        // TODO pull list from DB
        
        return mktFruitsList;
    }
    
     /*
     * This API will retrive all the fruits own by
     * a particuler user at a given moment that can
     * be sold on the market. It will pull this from 
     * the DB
     */
    public List<Fruits> getUserFruits(int uid)
    {
        List<Fruits> usrFruitsList =new ArrayList<Fruits>();
        // TODO pull list of fruits for user from DB
        
        return usrFruitsList;
    }
    
     /*
     * This API will take a Fruit object and calulate
     * its worth using market factors as well as the
     * quality of the Fruit. 
     */
    public double getPriceOfFruit(Fruits fruit)
    {
        double price = 0;
        
        // do calculation
        
        return price;
    }
    
}
