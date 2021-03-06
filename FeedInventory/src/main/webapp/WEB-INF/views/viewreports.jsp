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
	<h2 align="center" style="color: #CD5C5C">Daily Reports</h2>

	<c:if test="${not empty avganimalfeed}">

		<table border="1"
			style="border-color: navy; position: absolute; left: 20px; top: 180px">
			<thead>
				<tr>
					<th><h3 style="color: purple" align="center">Animal
							Average Feed</h3></th>
				</tr>

				<tr style="color: purple">
					<th>Animal</th>
					<th>Avg Feed</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="listValue" items="${avganimalfeed}"
					varStatus="status">
					<tr>
						<td><c:out value="${listValue.animalname}" /></td>
						<td><c:out value="${listValue.avgfeed}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>


	<c:if test="${not empty zoowastage}">
		<table border="1"
			style="border-color: navy; position: absolute; left: 300px; top: 180px">

			<thead>
				<tr>
					<th><h3 style="color: purple" align="center">Waste per
							Zoo</h3></th>
				</tr>
				<tr style="color: purple">
					<th>Zoo</th>
					<th>Waste</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="listValue" items="${zoowastage}" varStatus="status">
					<tr>
						<td><c:out value="${listValue.zooname}" /></td>
						<td><c:out value="${listValue.waste}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
	
	<c:if test="${not empty avgfeedtimes}">
		<table border="1"
			style="border-color: navy; position: absolute; left: 500px; top: 180px">

			<thead>
				<tr>
					<th><h3 style="color: purple" align="center">Average Feed Times per a Day
							</h3></th>
				</tr>
				<tr style="color: purple">
					<th>Animal</th>
					<th>Number of Times</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="listValue" items="${avgfeedtimes}" varStatus="status">
					<tr>
						<td><c:out value="${listValue.animalname}" /></td>
						<td><c:out value="${listValue.avgoftimes}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
	
	<c:if test="${not empty zooanimalcompare}">
		<table border="1"
			style="border-color: navy; position: absolute; left: 900px; top: 180px">

			<thead>
				<tr>
					<th><h3 style="color: purple" align="center">Feed Compare
							</h3></th>
				</tr>
				<tr style="color: purple">
					<th>Zoo</th>
					<th>Zoo</th>
					<th>Animal</th>
					<th>Percentage</th>

				</tr>
			</thead>
			<tbody>
				<c:forEach var="listValue" items="${zooanimalcompare}" varStatus="status">
					<tr>
						<td><c:out value="${listValue.azooname}" /></td>
						<td><c:out value="${listValue.bzooname}" /></td>
						<td><c:out value="${listValue.animalname}" /></td>
						<td><c:out value="${listValue.percentage}" /></td>

					</tr>
				</c:forEach>
			</tbody>
		</table>

	</c:if>
	
	
	



</body>