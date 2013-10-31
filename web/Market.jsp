<%-- 
    Document   : Market
    Created on : Oct 17, 2013, 5:38:58 PM
    Author     : aadu
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<jsp:useBean id="market" class="plantgame.models.Market" scope="session" />
<%@page import="plantgame.models.User"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>PlantGame Market</title>
        <link rel="stylesheet" type="text/css" href="style.css" media = "all">
    </head>
    <body>
        <center>
            <%
                //User user = (User) session.getAttribute("user");  
            %>
            <p class="t1">Welcome to the Market <%--<%= user.getFirstName() %> +" "+<%= user.getLastName() %>--%></p>
        </center>
    </body>
</html>
