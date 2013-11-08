<%-- 
    Document   : Garden
    Created on : Nov 4, 2013, 2:41:59 PM
    Author     : minh
--%>


<%@page import="plantgame.utils.Constants"%>
<%@page import="plantgame.models.Fruits"%>
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
        
        <table class="displayTable">
          <tr>
            <th>
              Fruit
            </th>
            <th>
              Status
            </th>
            <th>
              Quality
            </th>     
            <th>
              Actions
            </th>               
          </tr>
          
          <%
            for (Fruits fruit : user.getGarden().getFruits()){
          %>
              <tr>
                <td>
                  <%=fruit.getType().getName()%>
                </td>
                <td>
                  <%=fruit.getStatus()%>
                </td>
                <td>
                  <%=fruit.getQuality().getName()%>
                </td>     
                <td>
                  
                </td>
              </tr>
          <%
            }
          %>
        </table>
    </body>
</html>
