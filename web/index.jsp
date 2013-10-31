
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
 <%
   
       // Get any error messages
       String errorMessage = (String)request.getAttribute("errorMessage");
        
        // Set to empty string if there was no error message.
        if (errorMessage == null ) {
            errorMessage = "";
        }
    %>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Plant-astrophe</title>
         <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <div class="center" style="background-color: lightgreen;">
        <h2><%= errorMessage %></h2>
        <div id="signIn">
            <form action="FrontController" method="POST">
                <input type="hidden" name="action" value="Login"/>
                <fieldset>
                    <legend>Welcome Back!</legend>
                    <table>
                        <Tr>
                            <td>Username:</td>
                            <td><input type="text" name="username"/></td>
                        </Tr>
                        <tr>
                            <td>Password:</td>
                            <td><input type="password" name="password"/></td>
                        </tr>
                    </table>
                    <input type="submit" value="Play!"/>
                </fieldset>
            </form>
            <hr>
            <br>
            <a href="Register.jsp">Not a user? I'm sorry, sign up now and play!</a>
        </div>
        </div>
    </body>
</html>
