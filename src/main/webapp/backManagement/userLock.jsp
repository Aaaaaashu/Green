<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <meta name="description" content="Green">
  <meta name="author" content="orangehat">

  <c:set value="${pageContext.request.contextPath}" var="path" scope="page" />

  <link href="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/css/bootstrap.min.css" rel="stylesheet">
  <link href="${path}/css/style.css" rel="stylesheet">
  <link href="${path}/css/back-management.css" rel="stylesheet">

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

<title>Green|後台管理</title>
</head>
<body>
  <%@ include file="../header.jsp"%>
  
  <div class="container">
  
     <div class="user-lock">
      <h4>小黑屋</h4>
      <table class="table table-hover table-bordered">
	    <thead>
	      <tr>
	        <th class="lock-th-1">用戶名</th>
	        <th class="lock-th-2">鎖定/解鎖</th>
	      </tr>
	     </thead>
	     <tbody>
           <c:forEach var="user" items="${users}">
           <form action="<c:url value="/forum/userLockManage.html" />" method="post" >
      	     <tr>
      	       <td class="lock-td-1"><input type="hidden" name="userName" value="${user.userName}">${user.userName}</td>
      	       <td class="lock-td-2">
      	         <input type="radio" name="locked" value="1" />锁定 
		         <input type="radio" name="locked" value="0" />解锁
			     <input class="btn btn-primary save-manager" type="submit" value="保存">
      	       </td>
      	     </tr>
      	   </form>  
           </c:forEach>
         </tbody>
       </table>
    </div>
  
  </div>
    
  <script src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
  <script src="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>
</html>

