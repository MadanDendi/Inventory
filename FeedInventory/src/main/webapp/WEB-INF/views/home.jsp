<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>


<html>
<head>
 <link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
 
 <style type="text/css">


div #container {
	
	overflow: hidden;
}

.outer {
	width: 17%;
	height: 500 px; 
	color: navy;
	background-color: pink;
	border: 2px solid darkblue;
	padding: 5px;
	float: left;
}


 .error {
        color: #ff0000;
    }
    
    .left{
    width:20%;
    height:200px;
    border:1px solid #ccc;
    float: left;
    background-color:#FFF0F5;
    
}

</style>

<script type="text/javascript">

	

	
	
	function GetXmlHttpObjectWithOutHandler() {
	       var objXmlHttp = null;
	       if (navigator.userAgent.indexOf("MSIE") >= 0) {
	           var strName = "Msxml2.XMLHTTP";
	           if (navigator.appVersion.indexOf("MSIE 5.5") >= 0) {
	               strName = "Microsoft.XMLHTTP";
	           }
	           try {
	               objXmlHttp = new ActiveXObject(strName);
	               return objXmlHttp;
	           } catch (e) {
	               //showWSalert("Error. Scripting for ActiveX might be disabled");
	               return;
	           }
	       }

	       if (navigator.userAgent.indexOf("Mozilla") >= 0) {
	           objXmlHttp = new XMLHttpRequest();
	           return objXmlHttp;
	       }
	   }
	   
	   function showRegform(url) {
	       var currObj = this;
	       this.pxmlContentLoaderHttp = GetXmlHttpObjectWithOutHandler();
	       this.loadAreaContentStatusChanged = function () {
	           if (currObj.pxmlContentLoaderHttp.readyState == 4 || currObj.pxmlContentLoaderHttp.readyState == "complete") {
	        	   console.log("Entered into "+currObj.pxmlContentLoaderHttp.responseText);
	               document.getElementById("container").innerHTML = currObj.pxmlContentLoaderHttp.responseText;
	           }
	       }
	       this.pxmlContentLoaderHttp.onreadystatechange = function () {
	           currObj.loadAreaContentStatusChanged();
	       };
	       this.pxmlContentLoaderHttp.open("POST", url, true);
	       this.pxmlContentLoaderHttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	       this.pxmlContentLoaderHttp.send("");
	   }
	   
	   javascript:window.history.forward(1);
</script>
</head>
<body >
<div>
	<div style="width: 100%;background-color:#F0F8FF; padding: 10px" ><table>
			<tr>
				
				<td><a href="home"
					style=" padding-right: 40px;"><font
						style="font-size: 30px; ">Home </font></a></td>
						
				<td><a href="#"
					style=" padding-right: 40px;"
					onclick="showRegform('addanimal')"><font
						style="font-size: 30px; ">AddAnimals </font></a></td>
				<td><a href="#"
					style="padding-right: 40px;"
					onclick="showRegform('feedentries')"><font
						style="font-size: 30px; ">FeedEntry</font></a></td>
				<td><a href="#"
					style="padding-right: 40px;"
					onclick="showRegform('feedshipment')"><font
						style="font-size: 30px; ">FeedShipment</font></a></td>
				<td><a href="#"
					style="padding-right: 40px;"
					onclick="showRegform('viewreports')"><font
						style="font-size: 30px; ">ViewReports</font></a></td>
				
			</tr>
		</table> </div>
		<h1>${msg }</h1>
	<div id="container"  >
	 		
	</div>
</div>
		
	

</body>
</html>