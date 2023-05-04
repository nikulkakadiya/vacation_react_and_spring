<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<form action="handle-product" method="post">
		<h1>Add file product</h1>
		<table>
			<tr>
				<td><label for="fname"><b>First Name</b></label></td>
				<td><input type="text" placeholder="Enter Name" id="fname"
					name="fname" required></td>
			</tr>
			<tr>
				<td><label for="lname"><b>last name</b></label></td>
				<td><input type="text" placeholder="Enter Name" id="lname"
						   name="lname" required></td>
				</textarea></td>
			</tr>
			<tr>
				<td><label for="city"><b>city</b></label></td>
				<td><input type="text" placeholder="Enter Product Price"
					id="city" name="city" required></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath }/">Back</a></td>
				<td>
					<button type="submit">Add</button>
				</td>
			</tr>

		</table>
	</form>


</body>
</html>