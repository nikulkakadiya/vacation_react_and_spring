
<html>
<head>
<%@include file="./base.jsp"%>
</head>
<body>
	<div align="center">
		<h1>Welcome To Product</h1>
		<table>
			<tr>
				<th>S.Id</th>
				<th>first-Name</th>
				<th>last-name</th>
				<th>city</th>
				<th>Action</th>
			</tr>
			<c:forEach items="${user }" var="p">
			<tr>
				<td>${p.id }</td>
				<td>${p.fname }</td>
				<td>${p.lname }</td>
				<td>${p.city }</td>
				<td><a href="delete/${p.id }">Delete</a>&nbsp;&nbsp;<a href="update/${p.id }">Edit</a></td>
				<td></td>
			</tr>
			</c:forEach>
		</table>
		<div align="center">
			<a href="add-product">Add-Product</a>
		</div>
	</div>
</body>
</html>