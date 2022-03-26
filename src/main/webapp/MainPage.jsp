<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<style>
	.container {
	border-radius: 5px;
	background-color: #f2f2f2;
	padding: 20px;
}
input[type=submit] {
	background-color: #1E90FF;
	color: white;
	padding: 12px 20px;
	border: none;
	border-radius: 4px;
	cursor: pointer;
}
input[type=submit]:hover {
  background-color: #4169E1;
}
</style>
<meta charset="ISO-8859-1">
<title>Search</title>
</head>
<body>
	<header>
			<div>
				<table width = "100%">
					<tr>
						<td>
							<h2>Welcome ${ username } ! You can search your T-shirts here.</h2>
						</td>
						<td align = "right">
							<form action="SignOut">
							<input type = "submit" value = "SignOut"/>
							</form>
						</td>
					</tr>
				</table>
			</div>
		</header>
	<div align="center" class="container">
	<form action="find">
	<table>
	<tr><td>Color:</td>
	<td><input type="text" name="color"/></td>
	</tr>
	<tr><td>Size:</td>
	<td><input type="text" name="size"/></td>
	</tr>
	<tr><td>Gender:</td>
	<td><select name="gender">
  			<option value="M">Male</option>
 			<option value="F">Female</option>
 			<option value="U">Unisex</option>
		</select></td>
	</tr>
	<tr><td>Output Preference:</td>
	<td><select name="preference">
  			<option value="1">Price</option>
  			<option value="2">Rating</option>
  			<option value="3">Both</option>
		</select></td>
	</tr>
	<tr><td><input type="submit" value="search"></td></tr>
	</table>
	</form>
	</div>
</body>
</html>