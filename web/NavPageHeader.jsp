<%-- 
    Document   : NavPageHeader
    Created on : Oct 19, 2013, 2:23:31 PM
    Author     : tyler
--%>

<%@page import="plantgame.utils.GameItemsEnum"%>
<%@page import="plantgame.utils.Constants"%>
<%@page import="plantgame.models.UserItem"%>
<%@page import="java.util.HashMap"%>

<jsp:useBean id="user" scope="session" class="plantgame.models.User"/>
<table id="NavPageHeaderTable" class="NavPageHeaderTable" style="background-color: lightgreen">
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
    <td class ="NavPageHeaderTableLogout">
      <a href="<%=response.encodeURL(Constants.FRONT_CONTROLLER+"?action="+Constants.LOGOUT_SERVLET) %>">Logout</a>
    </td>
  </tr>
</table>
<table id="NavPageHeaderTable2" class="NavPageHeaderTable" style="background-color: lightgreen">  
  <tr class="NavPageHeaderTableRow">
    <td>
      Money <jsp:getProperty name="user" property="money"/>
    </td>
 </tr>
  <tr class="NavPageHeaderTableRow">
    <td>
        <h2 style="color: blue">Store Item Info: </h2>
    </td>
    <%
      HashMap<String, UserItem> userItems = user.getItems();
      
      for(GameItemsEnum item : GameItemsEnum.values()){
        
        %>
        <td class ="NavPageHeaderTableDataItem">
          <%= item.getName() %> <%= (userItems.get(item.getName())).getNumberOfItem() %>
        </td>
        <%
      }
    %>
  </tr>
  
</table>
