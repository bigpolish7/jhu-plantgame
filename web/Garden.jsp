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
        <title>Garden</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <%@ include file="/NavPageHeader.jsp" %>
        <label id="gardenHeading" class="pageHeading">Welcome to your garden, <jsp:getProperty name="user" property="userName"/> </label>
        <form action="<%=response.encodeURL(Constants.FRONT_CONTROLLER + "?action="+Constants.GARDEN_SERVLET)%>" method="POST">
        
        <%
        for(GameItemsEnum item : GameItemsEnum.values()) {
            if (item.getName().toLowerCase().contains("SEED".toLowerCase())) {
        %>
            <input type="checkbox" name="seedToPlant" value="<%=item.getName()%>"><%=item.getName()%> <%=(userItems.get(item.getName())).getNumberOfItem()%>
        <%  } 
        }
        %>
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
                    <%=thisPlot.getPlotStatus()%>
                </td>
                <%
                if (thisPlot.getPlotStatus().equalsIgnoreCase(Constants.PLOT_STATUS_NEED_PLOW) || thisPlot.getPlotStatus().equalsIgnoreCase(Constants.PLOT_STATUS_NEED_SEED)) {
                    // Fruit fruit is null
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
                    <%
                        if (!(thisPlot.getPlotStatus().equalsIgnoreCase(Constants.PLOT_STATUS_NEED_PLOW))) {
                        // this plot has been plowed - Plow button should be disable
                    %>
                    <button name="actionPlow" style="background-color:transparent" disabled type="submit" value="<%=(i)%>">Plow</button>
                    <% } else { %>
                    <button name="actionPlow" type="submit" value="<%=(i)%>">Plow</button>
                    <% } %>
                    <button name="actionPlant" type="submit" value="<%=(i)%>">Plant</button>
                    <button name="actionWater" type="submit" value="<%=(i)%>">Water</button>
                    <button name="actionFertilize" type="submit" value="<%=(i)%>">Fertilize</button>
                    <button name="actionHarvest" type="submit" value="<%=(i)%>">Harvest</button>
                </td>
              </tr>
          <%
            }
          %>
        </table>
        </form>
    </body>
</html>
