<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="./base.jsp"%>
</head>
<body>
	<form action="${pageContext.request.contextPath }/editsave"
		method="post">
		<h1>Update product</h1>
		<table>
			<tr>
				<td><input type="hidden" value="${user.id }" name="id"></td>
			</tr>
			<tr>
				<td><label for="fname"><b>Name</b></label></td>
				<td><input type="text" placeholder="Enter Name" id="fname"
					name="fname" value="${user.fname }" required></td>
			</tr>
			<tr>
				<td><label for="lname"><b>product description</b></label></td>
				<td><input type="text" placeholder="Enter Name" id="lname"
						   name="lname" value="${user.lname }" required></td></td>
			</tr>
			<tr>
				<td><label for="city"><b>Product Price</b></label></td>
				<td><input type="text" placeholder="Enter Product Price"
					id="city" name="city" value="${user.city }" required></td>
			</tr>
			<tr>
				<td><a href="${pageContext.request.contextPath }/">Back</a></td>
				<td>
					<button type="submit">Update</button>
				</td>
			</tr>

		</table>
	</form>


</body>
</html>