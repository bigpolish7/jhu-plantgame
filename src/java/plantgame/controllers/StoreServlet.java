/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package plantgame.controllers;

import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import plantgame.helperBeans.StoreHelper;
import plantgame.models.Store;
import plantgame.models.User;
import plantgame.utils.Constants;

/**
 *
 * @author tyler
 * 
 * This servlet will control the store portion of the web application
 */
public class StoreServlet extends HttpServlet {

  
  public void init(){
    //When the servlet starts create a store object
    //This will also start the store delivery timer
    Store store = Store.getInstance();    
  }
  
  /**
   * Processes requests for both HTTP
   * <code>GET</code> and
   * <code>POST</code> methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    
    //First get the user object from the session
    HttpSession session = request.getSession();
    
    User user = null;
    
    //TODO: forward to some error page or something
    if (session == null){
      System.out.println("Store Servlet processRequest session was null");
      log("Store Servlet processRequest session was null");
    }
    else{
      //Get the user object from the session
      user = (User)session.getAttribute(Constants.USER);
    }
    
    
    if (user == null){
      System.out.println("Store Servlet processRequest user was null");
      log("Store Servlet processRequest user was null");
    }
    
            
    //have the StoreHelper class process the user's purchase request
    String purchaseResult = StoreHelper.doPurchase(user, request);
    
    //Add the purchase results to the request
    request.setAttribute(Constants.PURCHASE_RESULT, purchaseResult);
    

    
    //DEBUG
    System.out.println("Store Servlet forwarding request to "+Constants.STORE_JSP);
    log("Store Servlet forwarding request to "+Constants.STORE_JSP);
    
    //Forward the request to the Store.jsp 
    RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(Constants.STORE_JSP);
    rDispatcher.forward(request, response);    
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP
   * <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP
   * <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>
}
