<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>View Cart After Placing Order</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>
<body>

<script>
function cancelData(){
	
	//call to put
	var myHeaders = new Headers();
	  myHeaders.append("Content-Type","application/json");
	  
	  var requestOptions={
			  method:'GET',
			  headers:myHeaders,	  
	  };
	  
	  var responseObject;
	  fetch("http://localhost:8082/order/cancel/${orderid}",requestOptions)
	  
	  .then(response=>{
		   
		   response.text()
		   window.location.href = 'http://localhost:8082/order/cancel';
		   
	   })
	   .catch(error=>console.log('error',error));
}

</script>

<div class = "container">

<div class="row">
<h2> Order has been placed: ${orderid} </h2>
</div>

<div class="row">
<h2> Below is the Order Details: </h2>
</div>

<table class="table table-bordered table-hover">
        <thead class= "thead-dark">
          <tr>
              <th scope="col"><h3>Cart Id</h3></th>
              <!-- <th scope="col"><h3>Item Name</h3></th>
              <th scope="col"><h3>Price</h3></th> -->
              <th scope="col"><h3>User Id</h3></th>
              <th scope="col"><h3>Placed Date</h3></th>
            </tr>
         </thead>

            
                <tr>
                  <td><h5>${cart.getCartId()}</h5></td>
                  <%-- <td> <h5>${item.getItemName()}</h5></td>
                  <td><h5>${item.getPrice()}</h5></td> --%>
                  <td><h5>${userid}</h5></td>
                  <td><h5>${placeddate}</h5></td>
                </tr>
            

        </table>
        
        <button type="submit" onclick="cancelData()" class="btn btn-primary btn-lg">Cancel Order</button>
</div>
</body>
</html>