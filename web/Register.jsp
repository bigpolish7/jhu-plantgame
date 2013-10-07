<%-- 
    Document   : Register
    Created on : Oct 7, 2013, 8:40:56 AM
    Author     : Derek
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Sign Up and Play</title>
         <link rel="stylesheet" type="text/css" href="style.css"/>
    </head>
    <body>
        <h1>You are only a few minutes away from playing the hottest game on the market!</h1>
        <br>
        <form method="POST" action="FrontController">
            <input type="hidden" name="action" value="Register"/>
            <fieldset>
                <legend>Account Information</legend>
                <table>
                    <TR>
                        <td>Gamer name:</td>
                        <td><input type="text" name="gameName"/></td>
                    </TR>
                    <TR>
                        <td>Password:</td>
                        <td><input type="password" name="password"/></td>
                        
                    </TR>
                </table>
            </fieldset>
            <br>
            <fieldset>
                <legend>Personal Information</legend>
                <table>
                    <TR>
                        <td>First Name:</td>
                        <td><input type="text" name="firstName"/></td>
                    </TR>
                    <TR>
                        <td>Last Name:</td>
                        <td><input type="text" name="lastName"/></td>
                    </TR>
                    <TR>
                        <td>Date of Birth:</td>
                        <td><input type="text" name="dob"/></td>
                    </TR>
                </table>
            </fieldset>
            <br>
            <fieldset>
                <legend>Contact Information</legend>
                <table>
                    <TR>
                        <td>Email Address:</td>
                        <td><input type="text" name="email"/></td>
                    </TR>
                    <TR>
                        <td>Phone Number:</td>
                        <td><input type="text" name="phone"/></td>
                    </TR>
                </table>
            </fieldset> 
            <br>
            <input type="submit" value="Join Us"/>
        </form>
    </body>
</html>
