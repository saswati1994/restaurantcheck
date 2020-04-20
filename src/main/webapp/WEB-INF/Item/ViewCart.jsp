<!DOCTYPE html>
<html>

<head>
<meta charset="ISO-8859-1">
<title>List of Cart Items</title>
<meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
  
</head>


  <body>
  <script>
  function sendData(){
	  
	  var myHeaders = new Headers();
	  var cartid = $cartitems.getCartId();
	  myHeaders.append("Content-Type","application/json");
	  var data = JSON.stringify({"placedDate":"2020-04-16","cart":{"cartId":cartid}});
	  
	  var requestOptions={
			  method:'POST',
			  headers:myHeaders,
			  body:data,
			  
	  };
	 var responseObject;
	  fetch("http://localhost:8082/order",requestOptions)
	  
	  .then(response=>{
		  response.text()
		  .then(data=>{
			  window.location.href = response.url+"?orderId="+data;
			  console.log("data",data)
			 
		  })
	  })
	  .catch(error=>console.log('error',error));
  }
  
  
  
  </script>
  <nav class="navbar navbar-dark bg-primary">
    <span class="navbar-brand mb-0 h1">Checkout</span>
    </nav>

    <div class = "container">
    <div class="row">
    <div class= "col">
    <h2 id="cartId"> Cart ID: ${cartitems.getCartId()} </h2>
    </div>
    <div class= "col">
    <h2> User ID: ${cartitems.getUserId()}</h2>
    </div>
    </div>
        <table class="table table-bordered table-hover">
        <thead class= "thead-dark">
          <tr>
              <th scope="col"><h3>Item</h3></th>
              <th scope="col"><h3>Item Description</h3></th>
              <th scope="col"><h3>Price</h3></th>
            </tr>
         </thead>

            <c:forEach var="item" items="${items}">
                <tr>
                  <td>${item.getItemName()}</td>
                  <td><h5>${item.getItemDesc()}</h5></td>
                  <td><h5>"${item.getPrice()}"</h5></td>
                </tr>
             </c:forEach>

        </table>
        <div class= "col">
         <h2>Total Price: ${totalPrice} </h2>
         </div>
        <button type="submit" onclick="sendData()" class="btn btn-primary btn-lg">Place Order</button>
         
        </div>

      </body>
      
</html>