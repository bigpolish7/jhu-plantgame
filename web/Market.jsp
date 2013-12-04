<%-- 
    Document   : Market
    Created on : Oct 17, 2013, 5:38:58 PM
    Author     : aadu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="market" class="plantgame.models.Market" scope="session" />
<%@page import="plantgame.models.User"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="plantgame.models.Fruits"%>
<%@page import="plantgame.models.Plot"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlantGame Market</title>
        <link rel="stylesheet" type="text/css" href="style.css" media = "all">
    </head>
    <body>
     <%@ include file="/NavPageHeader.jsp" %>   
        <div id="maincontainer">
       <!--
            
                // TODO: Reenable all cpmmented out code.
                
        -->
            <%
                User user = (User) session.getAttribute("user"); 
                ArrayList<Plot> plots = user.getGarden().getPlots();
                

            %>
            <div style="margin-top: 5em"></div>
            <div id="topsection"><div class="innertube"> <center><h1><p class="t1">Welcome to the Market</p></h1>
                            <p> <%--<%= user.getFirstName() %> +" "+<%= user.getLastName() %>--%></p></center></div></div>
                <div id="container3">
                    <div id="container2">
                        <div id="col2">
                            <p id="tab"><b>Your Information</b></p>
                            <p id="tab">Cash</p>
                        
                        </div>
                        <div id="col3">
                        <div class="innertube">
                        <%-- main content goes in this window --%>
                        <form action="" method="get">
                         <table class ="tableMkt" width="600" border="1">
                            <tr bgcolor="#99CCFF">
                                <td><div align="center"><b>Fruit</b></div></td>
                                <td><div align="center"><b>Quality</b></div></td>
                                <td><div align="center"><b>Current Market Price</b></div></td>
                                <td><div align="center"><b>Select</b></div></td>
                            </tr>
                            <tr>
                                <%
                                int qty; 
                                for(int i = 0; i<plots.size(); i++)
                                {
                                    qty = market.getMktFruitQnty(plots.get(i).getFruit().getType().getId()); 
                                    double tmpPrice =  market.getPriceOfFruit(plots.get(i).getFruit().getType().getBaseCost(),
                                            plots.get(i).getFruit().getQuality().getPriceCoefficient(),
                                            qty);
                                    %>
                                    <td align="center"><%= plots.get(i).getFruit().getType().getName() %></td>
                                    <td align="center"><%= plots.get(i).getFruit().getQuality().getName() %></td>
                                    <td align="center"><%= tmpPrice %></td>
                                    <td align="center"><input type="radio" name="<%=plots.get(i).getFruit().getType().getName() %>"</td>
                                    <%
                                }
                                %>
                            </tr>
                        </table>
                            <input style="width: 10em; font-weight: bold" type="submit" value="Sell">
                      </form>
                        </div>        
                        </div>
                    </div>
                </div>                    
               
        </div>
    </body>
</html>
