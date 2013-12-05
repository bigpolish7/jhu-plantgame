<%-- 
    Document   : Garden
    Created on : Nov 4, 2013, 2:41:59 PM
    Author     : minh
--%>


<%@page import="java.util.Hashtable"%>
<%@page import="plantgame.utils.QualitiesEnum"%>
<%@page import="plantgame.utils.FruitsEnum"%>
<%@page import="plantgame.utils.Constants"%>
<%@page import="plantgame.models.Fruits"%>
<%@page import="plantgame.models.Plot"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Garden</title>
        <%
        String currentUrl = (request.getRequestURL()).toString();
        %>
        <!-- setting time to refresh the page in seconds so that the Fruit status update can be seen-->
        
        <link rel="stylesheet" type="text/css" href="style.css"/>
        
    </head>
    <body>
        
        <%@ include file="/NavPageHeader.jsp" %>
        <center>  <h1 style="color: ghostwhite">Welcome to your garden, <%= user.getUserName() %> </h1></center>  
        <form action="<%=response.encodeURL(Constants.FRONT_CONTROLLER + "?action="+Constants.GARDEN_SERVLET)%>" method="POST" style="background-color:lightgreen">
        
        <%
        int counter = 0;
        for(GameItemsEnum item : GameItemsEnum.values()) {
            if (item.getName().toLowerCase().contains("SEED".toLowerCase())) {
                if (counter == 0) {
        %>
                    <input type="radio" name="seedToPlant" checked value="<%=item.getName()%>"><%=item.getName()%> <%=(userItems.get(item.getName())).getNumberOfItem()%>
        <%
                }
                else {
        %>
                    <input type="radio" name="seedToPlant" value="<%=item.getName()%>"><%=item.getName()%> <%=(userItems.get(item.getName())).getNumberOfItem()%>
        <%  
                }
                counter = counter + 1;
            }
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
              Water
            </th>
            <th>
              Fertilizer
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
            <th>
              Time to grow
            </th>
            <th>
              Time to rot
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
                    <%=thisPlot.getFruit().getNumberOfTimesWater()%>
                </td>
                <td>
                    <%=thisPlot.getFruit().getNumberOfTimesFertilize()%>
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
                    <% if (!(thisPlot.getPlotStatus().equalsIgnoreCase(Constants.PLOT_STATUS_NEED_PLOW))) {
                        // this plot has been plowed - Plow button should be disable
                    %>
                    <button name="actionPlow" style="background-color:transparent" disabled type="submit" value="<%=(i)%>">Plow</button>
                    <% } else { %>
                    <button name="actionPlow" type="submit" value="<%=(i)%>">Plow</button>
                    <% } %>
                    
                    <% if (!(thisPlot.getPlotStatus().equalsIgnoreCase(Constants.PLOT_STATUS_NEED_SEED)) && !(thisPlot.getPlotStatus().equalsIgnoreCase(Constants.PLOT_STATUS_NEED_PLOW))) {
                        // this plot has been plowed and planted - both buttons should be disable
                    %>
                    <button name="actionPlant" style="background-color:transparent" disabled type="submit" value="<%=(i)%>">Plant</button>
                    <% } else { %>
                    <button name="actionPlant" type="submit" value="<%=(i)%>">Plant</button>
                    <% } %>
                    <button name="actionWater" type="submit" value="<%=(i)%>">Water</button>
                    <button name="actionFertilize" type="submit" value="<%=(i)%>">Fertilize</button>
                    <button name="actionHarvest" type="submit" value="<%=(i)%>">Harvest</button>
                </td>
                <td>
                    <% if ((thisPlot.getPlotStatus().equalsIgnoreCase(Constants.PLOT_STATUS_HAS_SEED)) && 
                            (thisPlot.getFruit().getStatus().equalsIgnoreCase("Growing"))) {
                        // adding a time to grow timer if a fruit is growing in this plot
                            String growTimerId = "growTimer" + i;
                            String growTimerName = "growCountDown" + i + "()";
                            String growSec = "growSec" + i;
                            String growMin = "growMin" + i;
                            long remainingTimeToGrow = Constants.FRUIT_TIME_TO_GROW - (System.currentTimeMillis() - thisPlot.getFruit().getStartingTimeToGrow());
                    %>
                        <script type="text/javascript">

                            var <%=growSec%> = <%=(remainingTimeToGrow/1000)%60%>;   // set the seconds
                            var <%=growMin%> = <%=(remainingTimeToGrow/1000)/60%>;   // set the minutes

                            function <%=growTimerName%> {
                                <%=growSec%>--;
                                if (<%=growSec%> < 0) {
                                  <%=growSec%> = 59;
                                  <%=growMin%> = <%=growMin%> - 1;
                                } else {
                                  <%=growMin%> = <%=growMin%>;
                                }
                                
                                if (<%=growMin%> < 0 || (<%=growMin%> == 0 && <%=growSec%> == 0)) {
                                    <%=growTimerId%>.innerHTML = "done";
                                    return;
                                }
                                time = (<%=growMin%> <= 9 ? "0" : "") + <%=growMin%> + " minute(s) and " + (<%=growSec%> <= 9 ? "0" : "") + <%=growSec%> + " second(s)";
                                if (document.getElementById("<%=growTimerId%>")) { <%=growTimerId%>.innerHTML = time; }
                                window.setTimeout("<%=growTimerName%>;", 1000);
                            }

                            function addLoadEvent(func) {
                                var oldonload = window.onload;
                                if (typeof window.onload != 'function') {
                                    window.onload = func;
                                } else {
                                    window.onload = function() {
                                        if (oldonload) {
                                            oldonload();
                                        }
                                        func();
                                    }
                                }
                            }
                            addLoadEvent(function() {
                                <%=growTimerName%>;
                            });
                        </script>
                        <span id="<%=growTimerId%>" class="timeClass"></span>
                    <%  
                        } // add a growTimer if this plot has a fruit
                    %>
                </td>
                <td>
                    <% if ((thisPlot.getPlotStatus().equalsIgnoreCase(Constants.PLOT_STATUS_HAS_SEED)) && 
                            (thisPlot.getFruit().getStatus().equalsIgnoreCase("Growing") || thisPlot.getFruit().getStatus().equalsIgnoreCase("Grown"))) {
                        // adding a time to rot timer if this fruit is grown
                        String rotTimerId = "rotTimer" + i;
                        String rotTimerName = "rotCountDown" + i + "()";
                        String rotSec = "rotSec" + i;
                        String rotMin = "rotMin" + i;
                        long remainingTimeToRot = (Constants.FRUIT_TIME_TO_GROW+Constants.FRUIT_TIME_TO_ROT) - (System.currentTimeMillis() - thisPlot.getFruit().getStartingTimeToGrow());
                    %>
                    <script type="text/javascript">
                        var <%=rotSec%> = <%=(remainingTimeToRot/1000)%60%>;   // set the seconds
                        var <%=rotMin%> = <%=(remainingTimeToRot/1000)/60%>;   // set the minutes
                        function <%=rotTimerName%> {
                            <%=rotSec%>--;
                            if (<%=rotSec%> < 0) {
                              <%=rotSec%> = 59;
                              <%=rotMin%> = <%=rotMin%> - 1;
                            } else {
                              <%=rotMin%> = <%=rotMin%>;
                            }
                                if (<%=rotMin%> < 0 || (<%=rotMin%> == 0 && <%=rotSec%> == 0)) {
                                    <%=rotTimerId%>.innerHTML = "done";
                                    return;
                                }
                                time = (<%=rotMin%> <= 9 ? "0" : "") + <%=rotMin%> + " minute(s) and " + (<%=rotSec%> <= 9 ? "0" : "") + <%=rotSec%> + " second(s)";
                                if (document.getElementById("<%=rotTimerId%>")) { <%=rotTimerId%>.innerHTML = time; }
                                window.setTimeout("<%=rotTimerName%>;", 1000);
                            
                            
                        }

                        function addLoadEvent(func) {
                            var oldonload = window.onload;
                            if (typeof window.onload != 'function') {
                                window.onload = func;
                            } else {
                                window.onload = function() {
                                    if (oldonload) {
                                        oldonload();
                                    }
                                    func();
                                }
                            }
                        }
                        addLoadEvent(function() {
                            <%=rotTimerName%>;
                        });
                    </script>
                    <span id="<%=rotTimerId%>" class="timeClass"></span>
                    <% }
                    %>
                </td>
              </tr>
          <%
            }//for each plot
          %>
        </table>

        <button name="actionAddOnePlot" type="submit">Add one plot</button>
        <p>Harvested Fruits</p>
        <table class="displayTable">
          <tr>
            <% 
            // <fruit name, <quality type, quantity>>
            Hashtable<String, Hashtable<String, Integer>> harvestedFruits = user.getHarvestedFruits();
            for (FruitsEnum fruitItem : FruitsEnum.values()) {
            %>
            <th>
                  <%=fruitItem.getName()%>
            </th>
            <%
              }
             %>
          </tr>
          <% 
          for (QualitiesEnum qualityItem : QualitiesEnum.values()) {
            if (!(qualityItem.getName().equalsIgnoreCase(Constants.FRUIT_QUALITY_GROWING))) {
          %>
          <tr>
            <% for (FruitsEnum fruitsItem : FruitsEnum.values()) {
                Hashtable<String, Integer> qualityQuantity = harvestedFruits.get(fruitsItem.getName());
            %>
            <td>
                <%=qualityQuantity.get(qualityItem.getName())%> <%=qualityItem.getName()%>        
            </td>
            <% }
            %>
          </tr>
          <%
            }
          }
          %>
        </table>
        </form>
    </body>
</html>
