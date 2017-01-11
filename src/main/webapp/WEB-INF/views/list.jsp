<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Lista Produktow</title>
	</head>
	<body>
	    Counter: ${counter} <br />
	    SessionCounter: ${SessionCounter} <br />
		<a href="<c:url value="new" />">Dodaj pordukt</a><br />
		<table border="1">
			<thead>
				<tr>
					<th>PK</th>
					<th>Nazwa</th>
					<th>Cena</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product" varStatus="status">
				<tr>
					<td>${product.PK}</td>
					<td><a href="edit?pk=${product.PK}">${product.name}</a></td>
					<td>${product.price}</td>
					<td><a href="delete?pk=${product.PK}" onclick="return confirm('Jestes pewien?')">Delete </a></td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<br />
		<form action="logout" method="POST">
                      <input type="submit" value="Wyloguj " onclick="return confirm('Jestes pewien?')" />
                      </form>
        		      <br />
        		<hr />
		<hr />
	</body>
</html>