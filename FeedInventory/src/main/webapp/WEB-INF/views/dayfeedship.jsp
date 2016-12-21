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
 

 
    <h2 align="center" style="color: #CD5C5C">Add Feed Shipment Arrival</h2>
    <h1 style="color: red">${exception}</h1>
  
    <form:form method="post" modelAttribute="addfeedship" action="addfeedship">

		<form:hidden path="currentdate" id="currentdate"  />
        <table style="position: absolute; left: 500px;top: 200px">
        
            <tr>
                <td><label for="zooname">Zoo Name </label> </td>
                <td><form:select path="zooname" id="zooname">
                    <c:forEach var="listValue" items="${zoolist}" varStatus="status">
   					<form:option value="${listValue.zooname} ">${listValue.zooname}</form:option>
   					</c:forEach>
   					</form:select></td>
   					
            </tr>
        	<tr>
                <td><label for="feedquantity">Feed Quantity Arrived : </label> </td>
                <td><form:input path="feedquantity" id="feedquantity"/></td>
                <td><form:errors path="feedquantity" cssClass="error"  /></td>
            </tr>
            
            <tr>
                <td colspan="3">            
                            <input type="submit" value="AddFeedShipQuantity"/>

                </td>
            </tr>
        </table>
    </form:form>
   
</body>