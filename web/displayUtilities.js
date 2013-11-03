/* 
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

//This function will take a HTML select and
//add numbers up to maxNumber
function fillInNumericSelect(id, num)
{
  var selectBox= document.getElementById(id);
  var infoLabel = document.getElementById("infoLabel");
  
  
  for (var i = 1; i <= num ; i++)
  {
    var option=document.createElement("option");
 
    option.text = i;
    option.value = i;
    
    try{
      selectBox.add(option, null);    
    }
    catch(e){
      
      try{
        selectBox.add(option);   
      }
      catch(e2){
        try{
          selectBox.options[selectBox.options.length] = new Option(i,i);
        }
        catch(e3){
        }
      }
    }
  }
}



function updateItemSubTotals(subTotalID, itemPrice, selectBoxID){
  var selectBox= document.getElementById(selectBoxID);
  var subTotalLabel = document.getElementById(subTotalID);
  var numberSelected = selectBox.options[selectBox.selectedIndex].text;
  subTotalLabel.innerHTML=itemPrice*numberSelected;
}
