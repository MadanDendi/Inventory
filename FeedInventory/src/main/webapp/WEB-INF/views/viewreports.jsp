<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
<html>
<head>
<script type="text/javascript"></script>
<style type="text/css">
<style>
 
    .error {
        color: red;
    }
</style>


</head>
<body style="background-color:#90EE90">

  <c:if test="${not empty avganimalfeed}">

		<table border="1" style="border-color: navy; position: absolute;left: 50px;top: 180px">
		<thead>
		<tr ><th ><h3 style="color: purple" align="center" >  Animal Average Feed</h3> </th></tr>
		
		<tr style="color: purple">
				<th>Animal</th>
				<th>Avg Feed</th>
				
		</tr>
		</thead>
		<tbody>
			<c:forEach var="listValue" items="${avganimalfeed}" varStatus="status">
				 <tr>
      				 <td><c:out value="${listValue.animalname}" /></td>
       				<td><c:out value="${listValue.avgfeed}" /></td>  				
       				
     			</tr>
			</c:forEach>
			 </tbody>
		</table>

	</c:if>
	
	
	 <c:if test="${not empty zoowastage}">
		<table border="1" style="border-color: navy; position: absolute;left: 400px;top: 180px">
		
		<thead>
		<tr ><th ><h3 style="color: purple" align="center" > Waste per Zoo</h3> </th></tr>
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

 
   
</body>