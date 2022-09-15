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
<title>Add Book</title>
</head>

<body>

	<jsp:include page="header.jsp"></jsp:include>

	<%
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
	%>
	<div style="text-align: center; margin-top: 2%; margin-bottom: 2%;">
		<h2>Edit Book Details</h2>
		
	</div>
	<div>
		<form action="update" method="post" modelAttribute="book" style="width: 60%;"
			class="container">
			<div class="row pb-3">
				<div class="col-sm-3">
					<label for="title">Book Code</label>
				</div>
				<div class="col">
					<input type="text" name="code" id="code" size="50" value="${book.getCode()}" 
					readonly="readonly" style="color: #535151; border-style: none;" />
				</div>
			</div>
			<div class="row pb-3">
				<div class="col-sm-3">
					<label for="quantity">Book Name</label>
				</div>
				<div class="col">
					<input type="text" name="name" id="name" size="50" value="${book.getName()}" required />
				</div>
			</div>
			<div class="row pb-3">
				<div class="col-sm-3">
					<label for="size">Author</label>
				</div>
				<div class="col">
					<select name="author" id="autor" style="width:48%;" required>
						<option value="${book.getAuthor().getName()}" style="color: #535151; background-color: #efe9de;">${book.getAuthor().getName()}</option>
						
						<c:if test="${authors!=null}">
			
							<c:forEach var="a" items="${authors}">
					
								<option value="${a.getName()}">${a.getName()}</option>
					
							</c:forEach>
						</c:if>
						
						
					</select>
				</div>
			</div>
			<div class="row pb-3">
				<div class="col-sm-3">
					<label for="image">Added On</label>
				</div>
				<div class="col">
					<input type="text" name="date" id="date" size="50" value="${book.getDate()}"  
					readonly="readonly" style="color: #535151; border-style: none;"/>
				</div>
			</div>



			<div class="row mt-5">

				<div class="col-sm-3">

					<input type="submit" value="Submit" class="col"
						style="margin-right: 20px; color: white; background-color: blue; border-radius: 8px; border-style: none;">
		</form>

	</div>
	<div class="col-sm-3">
		<form method="POST" action="cancel">
			<input type="submit" value="Cancel"
				style="margin-right: 20px; color: white; background-color: red; border-radius: 8px; border-style: none;">
		</form>
	</div>

	</div>


	</div>

</body>

</html>