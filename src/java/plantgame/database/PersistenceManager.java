/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import plantgame.models.User;
/**
 *
 * @author Derek
 */
public class PersistenceManager {
    
        private static PersistenceManager instance = null;
        
        private Connection connection;
        
        protected PersistenceManager() {
        
            connection = getConnection();
            String temp;
        }
        
        public static PersistenceManager getInstance() {
            if (instance == null) {
                instance = new PersistenceManager();
            }
            return instance;
        }
    
        private Connection getConnection() {
        
                Connection connection = null;
                try {
                    try {
                       Class.forName("com.mysql.jdbc.Driver");
                    } catch (ClassNotFoundException ex) {
                        System.out.println("Could not get the JDBC bridge class name" + ex.getMessage());
                    }  

                    String url = "jdbc:mysql://localhost:3306/plantgame?zeroDateTimeBehavior=convertToNull";
                    connection = DriverManager.getConnection(url, "root", "password");
                } catch (SQLException ex) {
                    System.out.println("Error with sql" + ex.getMessage());
                }

                return connection;
        }
        
        public User authenticateUser(String userName, String password) {
            
            String query ="SELECT * FROM USER where userName=? AND password=?";
            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(query);


                statement.setString(1, userName);
                statement.setString(2, password);
                ResultSet resultSetSelect =  statement.executeQuery();

                if (resultSetSelect.next()) {
                       
                    System.out.println("we got stuff...");
                    User user = new User();
                  //  String s1 = resultSetSelect.getString(1);
                    
                    user.setId(resultSetSelect.getInt(1));
                     user.setFirstName(resultSetSelect.getString(2));
                     user.setLastName(resultSetSelect.getString(3));
                     user.setDob(resultSetSelect.getString(4));
                     user.setEmail(resultSetSelect.getString(5));
                     user.setPhone(resultSetSelect.getString(6));
                     user.setPassword(resultSetSelect.getString(7));
                     user.setUserName(resultSetSelect.getString(8));
                

                      
                      return user;
                  }
                else {
                    System.out.println("got nothing....");
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersistenceManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             return null;
        }
        
         public User registerUser(User user) {
            
            String query ="INSERT INTO PlantGame.User (FirstName, LastName, dob, email, phone, `password`, username) VALUES (?,?,?,?,?,?,?)";
            PreparedStatement statement;
            try {
                statement = connection.prepareStatement(query);


                statement.setString(1, user.getFirstName());
                statement.setString(2, user.getLastName());
                statement.setString(3, user.getDob());
                statement.setString(4, user.getEmail());
                statement.setString(5, user.getPhone());
                statement.setString(6, user.getPassword());
                statement.setString(7, user.getUserName());
                int result =  statement.executeUpdate();
       
                      
              if ( result > 0) {
               
                  System.out.println("sucessful registration!");
                  
                  // This should add the ID the db generates.
                  return user;
                 
              }
              else {
                    System.out.println("got nothing....");
                     
                }
            } catch (SQLException ex) {
                Logger.getLogger(PersistenceManager.class.getName()).log(Level.SEVERE, null, ex);
            }
            
             return null;
        }
        
        
        
        
     
}
