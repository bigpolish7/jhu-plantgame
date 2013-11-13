<%-- 
    Document   : Garden
    Created on : Nov 4, 2013, 2:41:59 PM
    Author     : minh
--%>


<%@page import="plantgame.utils.Constants"%>
<%@page import="plantgame.models.Fruits"%>
<%@page import="plantgame.models.Plot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plant Game Garden</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <%@ include file="/NavPageHeader.jsp" %>
        <label id="gardenHeading" class="pageHeading">Welcome to your garden, <jsp:getProperty name="user" property="userName"/> </label>
        <form action="<%=response.encodeURL(Constants.FRONT_CONTROLLER + "?action="+Constants.GARDEN_SERVLET)%>" method="POST">
        <table class="displayTable">
          <tr>
            <th>
              Plot#
            </th>
            <th>
              Plot status
            </th>
            <th>
              Fruit
            </th>
            <th>
              Fruit status
            </th>
            <th>
              Quality
            </th>     
            <th>
              Actions
            </th>               
          </tr>
          
          <%
            for (int i = 0; i < user.getGarden().getPlots().size(); i++){
                Plot thisPlot = user.getGarden().getPlots().get(i);
          %>
              <tr>
                <td>
                    <%=(i+1)%>
                </td>  
                <td>
                    <%=thisPlot.getPlotUsage()%>
                </td>
                <%
                if (thisPlot.getPlotUsage().equalsIgnoreCase(Constants.PLOT_STATUS_UNUSED) || thisPlot.getPlotUsage().equalsIgnoreCase("is plowed")) {
                    // there is no seed being planted in this plot; Fruit fruit is null
                %>
                <td>
                </td>     
                <td>
                </td>
                <td>
                </td>
                
                <%
                }
                else { //get the name and quality of the fruit being planted in this plot
                %>
                <td>
                    <%=thisPlot.getFruit().getType().getName()%>
                </td>     
                <td>
                    <%=thisPlot.getFruit().getStatus()%>
                </td>
                <td>
                    <%=thisPlot.getFruit().getQuality().getName()%>
                </td>
                <%
                }
                %>
                <td>
                    <input type="submit" name="gardeningAction" value="Plow">
                    <input type="submit" name="gardeningAction" value="Plant">
                    <input type="submit" name="gardeningAction" value="Water">
                    <input type="submit" name="gardeningAction" value="Fertilize">
                    <input type="submit" name="gardeningAction" value="Harvest">
                    <input type="hidden" name="plotNumber" value="<%=(i)%>">
                </td>
                
              </tr>
          <%
            }
          %>
        </table>
        </form>
    </body>
</html>
