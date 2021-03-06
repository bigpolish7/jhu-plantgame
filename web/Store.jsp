<%-- 
    Document   : Store
    Created on : Oct 12, 2013, 4:18:38 PM
    Author     : tyler
--%>

<%@page import="plantgame.models.Store"%>
<%@page import="plantgame.utils.Constants"%>
<%@page import="plantgame.utils.GameItemsEnum"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
  Store store = Store.getInstance();
%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>PlantGame Store</title>
    <link rel="stylesheet" type="text/css" href="style.css"/>
    <script src="displayUtilities.js"></script>
    
    <!--When the page loads this will fill in the quantity -->
    <script>
      window.onload=function() {
        <%
          for (GameItemsEnum item : GameItemsEnum.values() ){
            //DEBUG
            System.out.println("Store.jsp there are "+store.getNumberOfItemInStock(item.getName())+" "+item.getName());
        %>          
            fillInNumericSelect('<%=item.getName() + "Select"%>', <%=store.getNumberOfItemInStock(item.getName())%>)
        <%
          }
        
          //DEBUG
          System.out.println(Constants.getVerbosePurchaseResult((String)session.getAttribute(Constants.PURCHASE_RESULT)));
        %>   
      
        var pr = "<%=Constants.getVerbosePurchaseResult((String)session.getAttribute(Constants.PURCHASE_RESULT))%>";
        
        <%
          session.setAttribute(Constants.PURCHASE_RESULT, null);
        %>
            
        if (pr!="NULL"){
          window.alert(pr);
        }   
        
      };
    </script>

    <script>
      function updateTotals(subTotalLabelID, itemPrice, selectBoxID){
        updateItemSubTotals(subTotalLabelID, itemPrice, selectBoxID);
        document.getElementById("totalPriceLabel").innerHTML="Updating";
        var total = 0;
        var subTotal = 0;
        <%
          for (GameItemsEnum item : GameItemsEnum.values() ){
        %>  
            var selectBox= document.getElementById("<%=item.getName() %>"+ "Select");
            var numberSelected = selectBox.options[selectBox.selectedIndex].text;
            subTotal = itemPrice*numberSelected;   
            total = total + subTotal;
        <%
          }
        %>      
        
        document.getElementById("totalPriceLabel").innerHTML=total;
      }
    </script>
    
    
  </head>
  <body>
    <!--Page Header -->
    <%@ include file="/NavPageHeader.jsp" %>
    <center>  
        <label id="storeHeading" class="pageHeading" style="color: white">Welcome to the Store, <jsp:getProperty name="user" property="userName"/> </label>  
     
    
    <!-- This will display the different items a user can purchase -->
    <form action="<%=response.encodeURL(Constants.FRONT_CONTROLLER + "?action="+Constants.STORE_SERVLET)%>" method="POST">
      <table class="displayTable" style="background-color:lightgreen">
        <tr>
          <th>Item</th>
          <th>Number In Stock</th>
          <th>Price</th>
          <th>Number to Purchase</th>
          <th>Sub Total</th>
        </tr>
        
        <!--This builds up the rows in the table for the items available for purchase -->
        <%
          for (GameItemsEnum item : GameItemsEnum.values() ){
        %>
            <tr>
              <td style="border:1px solid black;"><%=item.getName()%> </td>
              <td style="border:1px solid black;"><%=store.getNumberOfItemInStock(item.getName()) %></td>
              <td style="border:1px solid black;"><%=store.getItemPrice(item.getName()) %> </td>
              <td style="border:1px solid black;">
                <!--The number will be dynamically added-->
                <select id='<%=item.getName() + "Select"%>' name='<%=item.getName() + "Select"%>' onchange='updateTotals("<%=item.getName()%>"+ "SubTotal",<%=store.getItemPrice(item.getName()) %>,"<%=item.getName() %>"+ "Select")'>
                  <option value="0">0</option>
                </select>
              </td>
              <td style="border:1px solid black;">
                <label id='<%=item.getName() + "SubTotal"%>' name='<%=item.getName() + "SubTotal"%>'></label>
              </td>
            </tr>  
        <%
          }
        %>
        <tr>
          <td colspan="4">       
          </td>
          <td>
            Total: <label id="totalPriceLabel" name="totalPriceLabel"></label>
          </td>          
        </tr>        
        <tr>
          <td colspan="4">            
          </td>          
          <td>
            <input type="submit" value="Purchase">
          </td>
        </tr>
      </table>
      
    </form>
   </center>
  </body>
</html>
