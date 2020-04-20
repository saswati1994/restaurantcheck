

<!DOCTYPE html>

<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Bootstrap Simple Registration Form</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script> 
<script src='https://kit.fontawesome.com/a076d05399.js'></script>

<style type="text/css"> 

.block {
  display: block;
  width: 15%;
  height: 18%;
  border: none;
  background-color: #4CAF50;
  padding: 14px 28px;
  font-size: 16px;
  cursor: pointer;
  text-align: center;
}
.tableFixHead          { overflow-y: auto; height: 100px; }
.tableFixHead thead th { position: sticky; top: 0; }

/* Just common table stuff. Really. */
table  { border-collapse: collapse; width: 80%; }
th, td { padding: 8px 16px; }
th     { background:#eee; }

</style>
</head>
<body>
<div class="signup-form">
<div style="
    height: 45px;
    background: lightgray;
    padding: 1px;
    display: flex;
">
<h4 style="margin-left: 49px;width: 80px;">Item List</h4>
<input type="text" id='itn' name="name"  style="margin: 8px 0 8px 350px">
<button value="Search" style="height: 27px;margin-top: 8px;" class="addSearch">Search</button>

<label for="cars" style="margin: 11px 0 8px 108px">Choose a Type:</label>

<select id="cars" onChange="location=this.value" style="margin: 8px;height: 28px;">

  <option>Select ItemType</option>
  <option value="VEG">VEG</option>
  <option value="NONVEG">NONVEG</option> 
  <option value="VEGAN">VEGAN</option> 

</select>

 <i class='fas fa-shopping-cart' style='margin: 11px 0 11px 99px;font-size: 22px;'></i> 
 <span style="
    background: orange;
    border-radius: 50%;
    height: 17px;
    padding: 1px 2px;
    margin: 0px -6px;
"  th:text="${countvalue}">title</span>
</div>
 
    
		  
	<div class="tableFixHead"   style="width:80%; height:250px;margin-top: 27px;margin-left: 46px;">
 		<table class="table table-bordered table-striped" >
		    <thead>
		      <tr>
		        <th>Id</th>
		        <th>Item Name</th>
		        <th>Description</th>
		        <th>Date </th>
		        <th>Price</th>
		        <th>Type</th>
		        <th></th>
		      </tr>
		    </thead>
		    
		    
		    <tbody id="tablebody">
		    
		    	
		   		 <tr th:each="message : ${userList}" varStatus="status">
		        <td class='itemId' th:text="${message.itemId}"></td>
		        <td th:text="${message.itemName}"></td>
		       <td th:text="${message.itemDesc}"></td>
		       <td th:text="${message.dateAdded}"></td>
		         <td th:text="${message.price}"></td> 
		         <td th:text="${message.itemType}"></td> 
		        
 <td><button type="button" class="addButton" value="Submit">Add</button></td>
		        
		   		 </tr>
		   		
		      
		    </tbody>
		  </table>
 	</div>
 
   
</div>
</body>
<script type="text/javascript">
$(".addSearch").click(function() {
	//alert()
	var itemName= $('#itn').val();
	/* alert(itemName) */

 $.ajax({
        type : "POST",
        async:false,    
       /*  contentType : "application/json", */
        url :"/items/searchitem",        
        data : {'itemName' : itemName},            
        
        success : function(data) {
           appendTable(data);
            
        },
        error: function(xhr, status, error) {
              var err = eval("(" + xhr.responseText + ")");
        }
    });
	 
 /* $.ajax({
        type : "POST",
        async:false,    
        contentType : "application/json", 
        url :"/items/nameList",        
         data : {itemName}, 
         
        
        success : function(data) {
           console.log(data)
            
        },
        error: function(xhr, status, error) {
              var err = eval("(" + xhr.responseText + ")");
        }
    }); */
   

});
function appendTable(data){
	$("#tablebody").empty();
	console.log(data)
	console.log(data.userList)
	$.each(data.userList, function(i, obj) {
		  //use obj.id and obj.name here, for example:
		 console.log(obj)
		 $("#tablebody").append( "<tr>"
				 +"<td class='itemId'>"+obj.itemId+"</td>"
				 +"<td>"+obj.itemName+"</td>"
				 +"<td>"+obj.itemDesc+"</td>"
				 +"<td>"+obj.dateAdded+"</td>"
				 +"<td>"+obj.price+"</td>"
				 +"<td>"+obj.itemType+"</td>"
				 +"<td><button type='button' class='addButton' value='Submit'>Add</button></td>"
				 +"</tr>" ) 
		});
	
}
$('#tablebody').on('click', '.addButton', function() {
	//alert()
	var itemId=$(this).closest('tr').find('.itemId').html();

 $.ajax({
        type : "POST",
        async:false,    
       /*  contentType : "application/json", */
        url :"/items/addNewCart",        
        data : {'itemId' : itemId},            
        
        success : function(data) {
            if(data==true){                
                alert("Successfully added into Cart!")                
                window.location.href='list';
                
            }else{
                alert(data)
                //$('.error_msg').show();
                //$('.error_msg').html(data);        
                
            }
            
        },
        error: function(xhr, status, error) {
              var err = eval("(" + xhr.responseText + ")");
        }
    });
   

});
</script>
</html>                            