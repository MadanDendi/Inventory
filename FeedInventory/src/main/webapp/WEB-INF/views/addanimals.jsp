<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<script type="text/javascript"></script>
<style type="text/css">
<
style>.error {
	color: red;
}
</style>


</head>
<body style="background-color: #90EE90">



	<h2 align="center" style="color: #CD5C5C">Add Animals</h2>
	<h1 style="color: red">${exception}</h1>

	<form:form method="post" modelAttribute="animaladd" action="animaladd">

		<table style="position: absolute; left: 350px; top: 200px">

			<tr>
				<td><label for="zooname">Zoo Name: </label></td>
				<td><form:input path="zooname" id="zooname" /></td>
				<td><form:errors path="zooname" cssClass="error" /></td>
			</tr>
			<tr>
				<td><label for="animalname">Animal Name: </label></td>
				<td><form:input path="animalname" id="animalname" /></td>
				<td><form:errors path="animalname" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="AddAnimals" /></td>
			</tr>
		</table>
	</form:form>

</body>