<%-- 
    Document   : Homepage
    Created on : Oct 7, 2013, 10:30:52 AM
    Author     : Derek
--%>

<%@page contentType="text/html" import="java.util.*,plantgame.models.User" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <% //User user = (User) session.getAttribute("user");%>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Homepage</title>
         <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <%@ include file="/NavPageHeader.jsp" %>
        <h1>Welcome to your dashboard, <%= user.getUserName() %> </h1>

    </body>
</html>
