/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;

import java.util.ArrayList;
import java.util.List;
import plantgame.database.PersistenceManager;
import plantgame.models.Fruits;

/**
 *
 * @author aadu
 */
public class Market {
    
    List<Fruits> mktFruitsList = null;
    PersistenceManager pm = null;
    
    public Market()
    {
        mktFruitsList =new ArrayList<Fruits>();
        pm = PersistenceManager.getInstance();
    } 
    
    
     /*
     * This API will retrive all the fruits owned by
     * a particuler user at a given moment that can
     * be sold on the market. It will pull this from 
     * the DB
     */
    public int getMktFruitQnty(int uid)
    {
        return pm.getQtyFruitsInMkt(uid);
    }
    
     /*
     * This API will take a Fruit object and calulate
     * its worth using market factors as well as the
     * quality of the Fruit. 
     */
    public double getPriceOfFruit(int baseCost, double priceCoaf, int MaketQty)
    {
        double price = 0;
        // do calculation
        int mktQty = MaketQty;
        if (mktQty < 1)
        {
            mktQty = mktQty++;
        }
        
        price = (baseCost * priceCoaf) / mktQty;
        
        // if the price is $2 or less round up to $2
        if (price < 2.00)
        {
            price = 2.00;
        }
        
        return price;
    }
    
}
