/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package plantgame.controllers;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import plantgame.models.Fruits;
import plantgame.models.User;
import plantgame.models.Plot;
import plantgame.models.UserItem;
import plantgame.utils.Constants;
import plantgame.utils.GameItemsEnum;
import plantgame.utils.FruitsEnum;
import plantgame.utils.Utils;

/**
 *
 * @author minh
 */
public class GardenServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
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
            System.out.println("Garden Servlet processRequest session was null");
            log("Garden Servlet processRequest session was null");
        }
        else{
            //Get the user object from the session
            user = (User)session.getAttribute(Constants.USER);
            if (user == null){
                System.out.println("Garden Servlet processRequest user was null");
                log("Garden Servlet processRequest user was null");
            }
            else {
                System.out.println(user.getFirstName());

                Enumeration paramNames = request.getParameterNames();
                while(paramNames.hasMoreElements()) {
                    String paramName = (String)paramNames.nextElement();
                    System.out.println(
                    paramName + " = " + request.getParameter(paramName));
                    
                    if (paramName.equalsIgnoreCase("actionPlow")) {
                        int plotNumber = 
                            Integer.parseInt(request.getParameter(paramName));
                        // Allow users to dig
                        user.getGarden().getPlots().get(plotNumber).setIsPlowed(true);
                        user.getGarden().getPlots().get(plotNumber).setPlotStatus(Constants.PLOT_STATUS_NEED_SEED);
                    }
                    
                    // Allow users to plant
                    if (paramName.equalsIgnoreCase("actionPlant")) {
                        int plotNumber = 
                            Integer.parseInt(request.getParameter(paramName));
                        String seedToPlant =
                            request.getParameter("seedToPlant");
                        
                        //userItems has 
                        System.out.println("seedToPlant: " + seedToPlant);
                        for(GameItemsEnum item:GameItemsEnum.values()){
                            if (item.getName().equalsIgnoreCase(seedToPlant)) {
                                // update the number of this seed
                                HashMap<String, UserItem> userItems = user.getItems();
                                UserItem userItem = userItems.get(item.getName());

                                //DEBUG
                                System.out.println("GardenServlet user has "+userItem.getNumberOfItem()+" of " +userItem.getType().getName());
                                                                  
                                //Check to make sure the user has enough of this item
                                if (userItem.getNumberOfItem() > 0){
                                  userItem.setNumberOfItem(userItem.getNumberOfItem()-1);
                                  user.getGarden().getPlots().get(plotNumber).setPlotStatus(Constants.PLOT_STATUS_HAS_SEED);
                                  // update the fruit in this plot
                                  String fruitType = seedToPlant.replace(" Seed", "");
                                  for (FruitsEnum fruitsEnumItem:FruitsEnum.values()){
                                      if (fruitsEnumItem.getName().equalsIgnoreCase(fruitType)) {
                                          // Fruits.java: Fruits() constructor: what id is for?
                                          // set id = 1 for all fruits for now
                                          Fruits fruit = new Fruits(fruitsEnumItem, 1);
                                          user.getGarden().getPlots().get(plotNumber).setFruit(fruit);
                                      }
                                  }  
                                }
                                
                                userItems.put(item.getName(), userItem);
                                user.setItems(userItems);
                            }  
                        }   
                    }//if (paramName.equalsIgnoreCase("actionPlant"))
                }//while(paramNames.hasMoreElements())

                //Add user to the request
                request.setAttribute(Constants.USER, user);

                //DEBUG
                System.out.println("Garden Servlet forwarding request to " + Constants.GARDEN_JSP);
                log("Garden Servlet forwarding request to " + Constants.GARDEN_JSP);

                //Forward the request to the Store.jsp 
                RequestDispatcher rDispatcher = getServletContext().getRequestDispatcher(Constants.GARDEN_JSP);
                rDispatcher.forward(request, response);
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
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
     * Handles the HTTP <code>POST</code> method.
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
