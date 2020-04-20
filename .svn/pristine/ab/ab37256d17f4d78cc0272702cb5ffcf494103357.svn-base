<!DOCTYPE html>
<html lang="en" xmlns:th="http://www.thymeleaf.org">
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">

<link href="https://fonts.googleapis.com/css?family=Roboto:400,700" rel="stylesheet">
<title>Admin</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
	
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

	<div class="container-fluid">
		<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
			<a class="navbar-brand" href="#">Eat.Fit.App</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav mr-auto">
					<li class="nav-item"><a class="nav-link" href="/items">Home </a></li>
					<li class="nav-item"><a class="nav-link" href="/items/item">Add Item </a></li>
					<li class="nav-item"><a class="nav-link" href="/items/display">View Items </a></li>
					<li class="nav-item"><a class="nav-link" href="">Manage delivery person </a></li>
					</ul>
				
			</div>
		</nav>
	</div>
	<div class="tableFixHead"   style="width:90%; height:500px;margin-top: 15px;margin-left: 50px;">
 		<table class="table table-bordered table-striped" >
		    <thead>
		      <tr>
		        <th>Item Name</th>
		        <th>Item Description</th>
		        <th>Price</th>
		        <th>Date Added</th>
		        <th>Item type</th>
		        <th>Update</th>
		        <th>Delete</th>
		      </tr>
		    </thead>
		    <tbody id="tablebody">
		    	<tr th:each="message : ${items}">
		    	
		        <td th:text="${message.itemName}"></td>
		        <td th:text="${message.itemDesc}"></td>
		        <td th:text="${message.price}"></td>
		        <td th:text="${message.dateAdded}"></td>
		        <td th:text="${message.itemType}"></td>
		        <td><a th:href="@{/items/displayitem/__${message.itemId}__}"><img src="/edit.png" width="30px" height="30px"></a>
		        <td><a th:href="@{/items/delete/__${message.itemId}__}"><img src="/delete.png" width="30px" height="30px"></a>
		      
		   		</tr>   
		    </tbody> 
		   </table>
		 </div> 
	</div>
</body>

</html>                            