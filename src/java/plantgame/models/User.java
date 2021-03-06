/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import plantgame.utils.Constants;
import plantgame.utils.FruitsEnum;
import plantgame.utils.GameItemsEnum;
import plantgame.utils.QualitiesEnum;

/**
 *
 * @author Derek
 */
public class User {
    
    private String firstName;
    private String lastName;
    private String password;
    private String dob;
    private String email;
    private String phone;
    private Integer id;
    private String userName;
    private double money;
    private HashMap <String, UserItem> items;
    private Garden garden;
    // <fruit name, <quality type, quantity>>
    Hashtable<String, Hashtable<String, Integer>> harvestedFruits;
    List<Fruits> harvestedFruitsList = null;
    
    public User(){
      items = new HashMap<String, UserItem>();
      UserItem userItem;
      harvestedFruitsList = new ArrayList<Fruits>();
      
      //DEBUG
      System.out.println("User adding items");
      
      //This initializes the user's stock of items
      for(GameItemsEnum item:GameItemsEnum.values()){
        userItem = new UserItem();
        userItem.setType(item);
        userItem.setNumberOfItem(Constants.USER_START_NUMBER_OF_ITEMS);
        items.put(item.getName(), userItem);
        //DEBUG
        System.out.println("User added "+item.getName());        
      }
      garden = new Garden();
      for (int i = 0; i < Constants.USER_START_NUMBER_OF_PLOTS; i++){
          Plot thisPlot = new Plot(Constants.PLOT_STATUS_NEED_PLOW);
          garden.addOnePlot(thisPlot);
      }
      harvestedFruits = new Hashtable<String, Hashtable<String, Integer>>();
      for (FruitsEnum fruitItem:FruitsEnum.values()){
          Hashtable<String, Integer> qualityQuantity = new Hashtable<String, Integer>();
          for (QualitiesEnum qualityItem:QualitiesEnum.values()) {
              qualityQuantity.put(qualityItem.getName(), 0);
          }
          harvestedFruits.put(fruitItem.getName(), qualityQuantity);
      }
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setMoney(double m){
      money = m;
    }
    
    public void addMoney(double m){
      money = money + m;
    }
    
    public double getMoney(){
      return money;
    }
    
    public Garden getGarden(){
      return garden;
    }
    
    public void setGarden(Garden g){
      garden = g;
    }
    
    public void setItems(HashMap<String, UserItem> m){
      items = m;
    }
    
    public HashMap<String, UserItem> getItems(){
      return items;
    }
    public Hashtable<String, Hashtable<String, Integer>> getHarvestedFruits(){
        return harvestedFruits;
    }
    
    public void addToHarvestedFruits(Fruits hf)
    {
        harvestedFruitsList.add(hf);
    }
    
    public List<Fruits> getHarvestedFruitsList()
    {
        return harvestedFruitsList;
    }
    
}
