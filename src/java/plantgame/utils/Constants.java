/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.utils;

/**
 *
 * @author Derek
 */
public class Constants {
    
    public static final String LOGIN = "Login";
    public static final String REGISTER = "Register";
    
    // Fruits
    public static final String APPLE = "apple";
    public static final String ORANGE = "orange";
    
    // Fruitb ID
    public static final int APPLE_ID = 1;
    public static final int ORANGE_ID = 2;
   

    public static final String NOT_ENOUGH_MONEY = "NEM";
    public static final String NOT_ENOUGH_ITEMS_IN_STORE = "NEIIS";
    public static final String PURCHASE_COMPLETE = "PC";
    public static final String USER = "user";
    public static final String PURCHASE_RESULT = "PR";
    public static final String APPLICATION = "/PlantGame";
    public static final String STORE_JSP = "/Store.jsp";
    public static final String GARDEN_JSP = "/Garden.jsp";
    public static final String MARKET_JSP = "/Market.jsp";    
    public static final String NAV_PAGE_HEADER = "/NavPageHeader.jsp";
    public static final String STORE_SERVLET = "Store";
    public static final String GARDEN_SERVLET = "Garden";
    public static final String FRONT_CONTROLLER = "FrontController";
    public static final String HOME_PAGE_JSP = "/Homepage.jsp";
    public static final String PLOT_STATUS_USED = "Seed planted";
    public static final String PLOT_STATUS_UNUSED = "Available for gardening";
    //Delay from start of program to when store gets its first 
    //shipment of items in ms
    public static final long STORE_FIRST_DELIVERY_DELAY = 10000; 
    
    //Delay between delivery of items to store
    public static final long STORE_INTER_DELIVERY_DELAY = 5000000;     
    
    //This is the number of items that will be added to the store
    //at each deliver. Right now is just a constant but maybe can
    //be more dynamic in the future
    public static final int NUMBER_OF_ITEM_TO_ADD_TO_STORE = 2;
    
    //This is the number of each item that the store will start with
    public static final int ITEM_NUMBER_STORE_START  = 1;
    
    //This is the maximum number of each item that the store can hold
    public static final int MAX_NUMBER_OF_ITEM_IN_STORE = 100;
    
    public static final int USER_START_NUMBER_OF_ITEMS = 1;
    // Each user can purchase extra plots of land for this amount of money
    public static final int MONEY_FOR_ONE_PLOT_OF_LAND = 10;
    // Each user can own up to a maximum number of plots of land
    public static final int MAX_NUMBER_OF_PLOTS_OF_LAND = 10;
    public static final int USER_START_NUMBER_OF_PLOTS = 5;
    
}
