
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin</title>
<link href="/webjars/bootstrap/4.3.1/css/bootstrap.min.css"
	rel="stylesheet">
</head>
<body>

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
  
 	<div class="container" style="width:400px; margin:0 auto; margin-top: 50px;">
 	
	<h1>Add New Item</h1> 
	 <br/>
	<form action="/items/add" method="post">  
		<table>  
			<tr><td>Item Name:</td><td><input type="text" name="itemName" pattern="[a-zA-Z ]{4,}" maxlength="15" required title="4 or more letters and no special characters allowed"/></td></tr>  
			<tr><td>Item Description:</td><td><input type="text" name="itemDesc" pattern="[a-zA-Z ]{4,}" maxlength="30" required title="4 or more letters and no special characters allowed"/></td></tr>  
			<tr><td>Price:</td><td><input type="number" name="price" required /></td></tr>  
			<tr><td>Item Type:</td>
			<td>  
			<input type="radio" name="itemType" value="VEG" checked="checked"/>VEG   
			<input type="radio" name="itemType" value="NONVEG"/>NONVEG 
			<input type="radio" name="itemType" value="VEGAN"/>VEGAN
			</td></tr>  
		 	<tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr><tr><td></td></tr>
			<tr><td></td><td colspan="2"><input type="submit" value="Add Item"/></td></tr>  
		</table>  
	</form>  
	</div>
	
</body>
</html>