<%-- 
    Document   : Market
    Created on : Oct 17, 2013, 5:38:58 PM
    Author     : aadu
--%>

<%@page import="plantgame.utils.FruitsEnum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="market" class="plantgame.models.Market" scope="session" />

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="plantgame.models.Fruits"%>
<%@page import="plantgame.models.Plot"%>
<%@page import="plantgame.models.Garden"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlantGame Market</title>
        <link rel="stylesheet" type="text/css" href="style.css" media = "all">
    </head>
    <body>
     <%@ include file="/NavPageHeader.jsp" %>   
        <div id="maincontainer">
    
            <%
                List<Fruits> fruits = null;
                if(user != null)
                {
                    fruits = user.getHarvestedFruitsList();   
                } 

                String bt = request.getParameter("mktBt");  //check if submit button was pressed
                String[] selectedFruits;
                if (bt != null)
                {
                    if (bt.equals("Sell")) // Fruit sell action was made
                    {
                        selectedFruits = request.getParameterValues("selectedFrts");
                        market.removeUserFruit(fruits, selectedFruits, user);
                    }
                }
                
            %>
            <div style="margin-top: 5em"></div>
            <div id="topsection"><div class="innertube"> <center><h1><p class="t1">Welcome to the Market</p></h1>
                        <p style="color: black"> <%= user.getFirstName() %><%=  " "%><%= user.getLastName() %></p></center></div></div>
                <div id="container3">
                    <div id="container2">
                        <div id="col2">
                            <p id="tab"><b>Market Information</b></p>
                            <div class="innertube">
                                <center>  
                                    <table class ="tableMkt" width="250" border="1">
                                        <tr bgcolor="#99CCFF">
                                            <td><div align="center"><b>Fruit</b></div></td>
                                            <td><div align="center"><b>Quantity</b></div></td>
                                        </tr>
                                        <tr>
                                            <td><div align="center"><b><%=Constants.APPLE%></b></div></td>
                                            <td><div align="center"><b><%= market.getMktFruitQnty(Constants.APPLE_ID) %></b></div></td>
                                        </tr>
                                        <tr>
                                            <td><div align="center"><b><%=Constants.ORANGE%></b></div></td>
                                            <td><div align="center"><b><%= market.getMktFruitQnty(Constants.ORANGE_ID) %></b></div></td>
                                        </tr>
                                        <tr>
                                            <td><div align="center"><b><%=Constants.PEAR%></b></div></td>
                                            <td><div align="center"><b><%= market.getMktFruitQnty(Constants.PEAR_ID) %></b></div></td>
                                        </tr>
                                        <tr>
                                            <td><div align="center"><b><%=Constants.BANANA%></b></div></td>
                                            <td><div align="center"><b><%= market.getMktFruitQnty(Constants.BANANA_ID) %></b></div></td>
                                        </tr>
                                        <tr>
                                            <td><div align="center"><b><%=Constants.MANGO%></b></div></td>
                                            <td><div align="center"><b><%= market.getMktFruitQnty(Constants.MANGO_ID) %></b></div></td>
                                        </tr>
                                        <tr>
                                            <td><div align="center"><b><%=Constants.KIWI%></b></div></td>
                                            <td><div align="center"><b><%= market.getMktFruitQnty(Constants.KIWI_ID) %></b></div></td>
                                        </tr>

                                    </table>
                              </center>        
                            </div>
                        </div>
                        <div id="col3">
                        <div class="innertube">
                        <%-- main content goes in this window --%>
                        <form action="<%=response.encodeURL(Constants.FRONT_CONTROLLER + "?action="+Constants.MARKET_CONTROLLER)%>" method="POST">
                         <table class ="tableMkt" width="600" border="1">
                            <tr bgcolor="#99CCFF">
                                <td><div align="center"><b>Fruit</b></div></td>
                                <td><div align="center"><b>Quality</b></div></td>
                                <td><div align="center"><b>Current Market Price $</b></div></td>
                                <td><div align="center"><b>Select</b></div></td>
                            </tr>
                            
                                <%
                                int qty; 
                                if (fruits != null)
                                {
                                    for(int i = 0; i<fruits.size(); i++)
                                    {
                                        //Fruits fruits = plots.get(i).getFruit();
                                        if(fruits != null)
                                        {      
                                                FruitsEnum type = fruits.get(i).getType();
                                                if(type != null)
                                                {
                                                    qty = market.getMktFruitQnty(type.getId()); 
                                                    double tmpPrice =  market.getPriceOfFruit(type.getBaseCost(),
                                                            fruits.get(i).getQuality().getPriceCoefficient(),
                                                            qty);
                                                    fruits.get(i).setPrice(tmpPrice);
                                                    %>
                                                    <tr>
                                                    <td align="center" ><%= type.getName() %></td>
                                                    <td align="center"><%= fruits.get(i).getQuality().getName() %></td>
                                                    <td align="center"><%= tmpPrice %></td>
                                                    <td align="center"><select multiple name="selectedFrts"> <option value="<%=fruits.get(i).getId() %>"></option></select></td>
                                                    </tr>                                                                 
                                                    <%
                                                }
                                           
                                        }
                                    }
                                }
                                
                                %>

                        </table>
                            <input style="width: 10em; font-weight: bold" type="submit" name="mktBt" value="Sell">
                      </form>
                        </div>        
                        </div>
                    </div>
                </div>                    
               
        </div>
    </body>
</html>
