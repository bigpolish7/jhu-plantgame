/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;

import java.sql.SQLException;
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
    public int getMktFruitQnty(int fid)
    {
        return pm.getQtyFruitsInMkt(fid);
    }
    
     /*
     * This API will increment the fruits in the
     * market. 
     */
    public void setMktFruitQnty(int fid, String name) 
    {
        try
        {
            pm.incrementFruitsQtyInMkt(fid, name);
        }
        catch(SQLException se)
        {
           //TODO put code 
        }
        
    }
    
     /*
     * This API will take a Fruit object and calulate
     * its worth using market factors as well as the
     * quality of the Fruit. 
     */
    public double getPriceOfFruit(int baseCost, double priceCoaf, int MaketQty)
    {
        System.out.println("baseCost is "+ baseCost + "priceCoaf is "+ priceCoaf + "MaketQty is " + MaketQty);
        double price = 0;
        // do calculation
        int mktQty = MaketQty;
        if (mktQty < 1)
        {
            mktQty = 1;
        }
        
        price = (baseCost * priceCoaf) / mktQty;
        
        // if the price is $2 or less round up to $2
        if (price < 2.00)
        {
            price = 2.00;
        }
        
        return price;
    }
    
    public void removeUserFruit(List<Fruits> f, String[] s, User u)
    {
        List<Fruits> fruits = f;
        User user = u;
        
        // this is expensive and inefficient...we should have used a DB to store fruits....
        for(int i=0; i<fruits.size(); i++)
        {
            for(int j=0; j<s.length; j++)
            {
                if (fruits.get(i).getId() == Integer.parseInt(s[j]) )
                {
                    user.addMoney(fruits.get(i).getPrice()); // add cost of fruit to users money
                    setMktFruitQnty(fruits.get(i).getId(),fruits.get(i).getType().getName()); //increment cont in db
                    fruits.remove(i); // remove fruit from users plot.
                }
            }
        }
    }
    
}
