<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="en">

<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Home Page</title>
</head>

<body>
	<jsp:include page="header.jsp"></jsp:include>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>


	<div class="container mt-5 mb-2" style="heigh: 80%">
		<div class="row">
			<div class="col" style="text-align: center;">
				<h2>Book Listing</h2>
			</div>
			<div class="col-sm-2">
				<form method="POST" action="addBook">
					<input type="submit" id="add" value="Add Book">
				</form>
			</div>
		</div>
	</div>
	<div class="container">
		<table class="table table-bordered">
			<thead>
				<tr>
					<th scope="col">Book Code</th>
					<th scope="col">Book Name</th>
					<th scope="col">Author</th>
					<th scope="col">Date added</th>
					<th scope="col">Actions</th>
				</tr>
			</thead>


			<c:if test="${books!=null}">
			
			<c:forEach var="b" items="${books}">


					<tr>
						<td>${b.getCode()}</td>
						<td>${b.getName()}</td>
						<td>${b.getAuthor().getName()}</td>
						<td>${b.getDate()}</td>
						<td>
							<a href="editBook?Id=${b.getCode()}" id="edit" style="margin-right: 5px;"> Edit</a> 
							<a href="delete?Id=${b.getCode()}" id="delete"> Delete</a></td>
					</tr>

				</c:forEach>
			</c:if>

		</table>





	</div>



</body>

<Style>
#add {
	background-color: #476fe8;
	color: white;
	border-radius: 5px;
	border-style: none;
	padding-inline: 20px;
	font-size: larger;
}

#edit {
	padding-inline: 5px;
	text-align: center;
	border-radius: 5px;
	border-style: solid;
	border-color: grey;
	color: grey;
	text-decoration: none;
}

#delete {
	padding-inline: 5px;
	text-align: center;
	border-radius: 5px;
	border-style: solid;
	border-color: #bf1515;
	color: #bf1515;
	text-decoration: none;
}
</Style>

</html>