<%-- 
    Document   : NavPageHeader
    Created on : Oct 19, 2013, 2:23:31 PM
    Author     : tyler
--%>

<%@page import="plantgame.utils.Constants"%>
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
  </tr>
  
</table>
