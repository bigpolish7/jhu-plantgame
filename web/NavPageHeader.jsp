<%-- 
    Document   : NavPageHeader
    Created on : Oct 19, 2013, 2:23:31 PM
    Author     : tyler
--%>

<%@page import="plantgame.utils.Constants"%>
<jsp:useBean id="user" scope="session" class="plantgame.models.User"/>
<table id="NavPageHeaderTable" class="NavPageHeaderTable">
  <tr class="NavPageHeaderTableRow">
    <td class ="NavPageHeaderTableDataItem">
      <a href="<%=response.encodeURL(Constants.APPLICATION+Constants.HOME_PAGE_JSP)%>">Home</a>
    </td>
    <td class ="NavPageHeaderTableDataItem">
      <a href="<%=response.encodeURL(Constants.APPLICATION+Constants.GARDEN_JSP)%>">Garden</a>
    </td>    
    <td class ="NavPageHeaderTableDataItem">
      <a href="<%=response.encodeURL(Constants.APPLICATION+Constants.MARKET_JSP)%>">Market</a>
    </td>      
    <td class ="NavPageHeaderTableDataItem">
      <a href="<%=response.encodeURL(Constants.APPLICATION+Constants.STORE_JSP)%>">Store</a>
    </td>     
    <!-- TODO
  //Set the base costs, names, and max number for the items here
  SHOVEL(10, "Shovel", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  WATERING_CAN(10, "Watering Can", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  SPADE(10, "Spade", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  SEED(10, "Seed", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  WATER(10, "Water", Constants.MAX_NUMBER_OF_ITEM_IN_STORE), 
  FERTILIZER(10, "Fertilizer", Constants.MAX_NUMBER_OF_ITEM_IN_STORE);
    -->
    <td>
      Money <jsp:getProperty name="user" property="money"/>
    </td>
  </tr>
  
</table>
