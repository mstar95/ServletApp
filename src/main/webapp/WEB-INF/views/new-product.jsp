<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Dodaj Produkt</title>
	</head>
	<body>
		<a href="list">Powrót</a><br />
		<form action="new" method="POST">
               Name: <input type="text" name="Name" required>
              <br />
              Cena: <input type="number" name="Price" required>
              <input type="submit" value="Dodaj" />
              </form>
		      <br />
		<hr />
	</body>
</html>