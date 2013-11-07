/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.utils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import plantgame.models.User;

/**
 *
 * @author tyler
 */
public class Utils {
 
  //This method will get the user object stored in the session and return it
  public static User getUserFromSession(HttpServletRequest request){
        //First get the user object from the session
    HttpSession session = request.getSession();
    
    User user = null;
    
    //TODO: forward to some error page or something
    if (session == null){
      System.out.println("Utils getUserFromSession processRequest session was null");
    }
    else{
      //Get the user object from the session
      user = (User)session.getAttribute(Constants.USER);
    }
    
    
    if (user == null){
      System.out.println("Utils getUserFromSession processRequest user was null");
    }
    
    return user;
  }
}
