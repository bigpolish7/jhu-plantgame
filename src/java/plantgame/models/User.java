/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.models;

import java.util.HashMap;
import plantgame.utils.Constants;
import plantgame.utils.GameItemsEnum;

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
    private int money;
    private HashMap <String, UserItem> items;
    
    public User(){
      items = new HashMap<String, UserItem>();
      UserItem userItem;
      
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
    
    public void setMoney(int m){
      money = m;
    }
    
    public int getMoney(){
      return money;
    }
    
    public void setItems(HashMap<String, UserItem> m){
      items = m;
    }
    
    public HashMap<String, UserItem> getItems(){
      return items;
    }
}
