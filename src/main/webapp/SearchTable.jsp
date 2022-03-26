<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>RESULTS!!!</title>
<style>
        table, th, td{
            border: 1px solid black;
            border-collapse: collapse;
        }
        th{
            height: 30px;
        }
        table{
            width: 90%;
            margin-left: 50px;
        }
        .table-div{
        	margin-top: 40px;
        }
        form{
        margin-top:10px;
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
</head>
<body>
	<c:if test="${result.size()!=0}">
	<h2 align="center">
		<c:out value="${result.size()}"></c:out> matching Tshirts found!
	</h2>
	<div class="table-div">
	<table>
	<tr>
		<th> ID </th>
		<th> NAME </th>
		<th> COLOR </th>
		<th> GENDER </th>
		<th> SIZE</th>
		<th> PRICE</th>
		<th> RATING</th>
		<th>AVAILABILITY </th>
	</tr>
		<c:forEach items = "${result}" var = "t">
				<tr >
  					<td>${t.getID()}</td>
  					<td>${t.getName()}</td>
  					<td>${t.getColor()}</td>
  					<td>${t.getGender()}</td>
  					<td>${t.getSize()}</td>
  					<td>${t.getPrice()}</td>
  					<td>${t.getRating()}</td>
  					<td>${t.getAvailability()}</td>
				</tr>
  		</c:forEach>
	</table>
	</div>
	</c:if>
	<c:if test="${result.size() == 0}">
		<div class="container-fluid">
			<div class="row mb-5">
				<div class="col-10">
					<h1 align="center" style="color:red;">
						Sorry! No matching flights found!
					</h1>
				</div>
				<div class="col-2">
					<form action="SignOut">
					<input type = "submit" value = "SignOut"/>
					</form>
				</div>
			</div>
		</div>
	</c:if>
</body>
</html>