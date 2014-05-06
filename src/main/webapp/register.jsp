<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>user register</title>
    <script>
    	function mycheck() {
    		if(document.all("user.password").value != document.all("again").value) {
    			alert("Enter password error");
    			return false;
    		} else {
    			return true;
    		}
    	}
    </script>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
  User register info:
  <form action="<c:url value="/register.html" />" method="post" obsubmit="return mycheck()">
  <c:if test="${!empty errorMsg }">
  	<div style="color=red">${errorMsg}</div>
  </c:if>
  <table border="1px" width="60%">
  	<tr>
  		<td width="20%">UserName</td>
  		<td width="80%"><input type="text" name="userName" /></td>
  	</tr>
  	<tr>
  		<td width="20%">Password</td>
  		<td width="80%"><input type="password" name="password" /></td>
  	</tr>
  	<tr>
  		<td width="20%">Password comfirm</td>
  		<td width="80%"><input type="password" name="again" /></td>
  	</tr>
  	<tr>
  		<td colspan="2">
  			<input type="submit" value="save">
  			<input type="reset" value="reset">
  		</td>
  	</tr>
  </table>
  </body>
</html>
