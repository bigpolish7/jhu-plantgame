<%-- 
    Document   : Error
    Created on : Nov 15, 2013, 11:31:52 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <%@ include file="/NavPageHeader.jsp" %>
        <label id="gardenHeading" class="pageHeading">Oops, some errors occurred, <jsp:getProperty name="user" property="userName"/> </label>
        <form action="<%=response.encodeURL(Constants.FRONT_CONTROLLER + "?action="+Constants.GARDEN_JSP)%>" method="POST">
            <%
                String message = (String) request.getAttribute(Constants.ERROR_MESSAGE);
            %>
            <p><b><%= message %></b></p>
        </form>        
    </body>
</html>
