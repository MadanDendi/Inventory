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
<body style="background-color: blue;">



	<h2 align="center" style="color: #CD5C5C">Add Feed Entry Details</h2>
	<h1 style="color: red">${exception}</h1>

	<form:form method="post" modelAttribute="feedentry" action="feedentry">


		<table style="position: absolute; left: 350px; top: 200px">

			<tr>
				<td><label for="zooname">Zoo Name </label></td>
				<td><form:select path="zooname" id="zooname">
						<c:forEach var="listValue" items="${animallist}"
							varStatus="status">
							<form:option value="${listValue.zooname} ">${listValue.zooname}</form:option>
						</c:forEach>
					</form:select></td>

			</tr>

			<tr>
				<td><label for="animal">Animal </label></td>
				<td><form:select path="animal" id="animal">
						<c:forEach var="listValue" items="${animallist}"
							varStatus="status">
							<form:option value="${listValue.animalname} ">${listValue.animalname}</form:option>
						</c:forEach>
					</form:select></td>

			</tr>
			<tr>
				<td><label for="feedtime">FeedTime </label></td>
				<td><input type="datetime-local" name="feedtime" /></td>


			</tr>
			<tr>
				<td><label for="quantity">Feed Quantity : </label></td>
				<td><form:input path="quantity" id="quantity" /></td>
				<td><form:errors path="quantity" cssClass="error" /></td>
			</tr>

			<tr>
				<td colspan="3"><input type="submit" value="FeedEntry" /></td>
			</tr>
		</table>
	</form:form>


</body>