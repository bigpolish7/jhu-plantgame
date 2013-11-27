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
        <form action="<%=response.encodeURL(Constants.FRONT_CONTROLLER + "?action="+Constants.GARDEN_JSP)%>" method="POST">
            
            <table class="NavPageHeaderTable" style="background-color: lightgreen">
                <tr>
                    <td>
                        Oops, some errors occurred, <jsp:getProperty name="user" property="userName"/>
                    </td>    
                </tr>
            
            </table>
            
            <table class="NavPageHeaderTable" style="background-color: lightgreen">
                <tr>
                    <td>
                <%
                    String message = (String) request.getAttribute(Constants.ERROR_MESSAGE);
                %>
                <%= message %>
                    </td>    
                </tr>
            
            </table>
        </form>        
    </body>
</html>
