<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="zh-CN">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta http-equiv="pragma" content="no-cache" />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<meta name="description" content="">
	<meta name="author" content="">
	
	<c:set value="${pageContext.request.contextPath}" var="path" scope="page" />
	
	<link href="${path}/css/bootstrap.min.css" rel="stylesheet">
	<link href="${path}/css/login.css" rel="stylesheet">
	<link href="${path}/css/style.css" rel="stylesheet">
	
	
	<!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	      <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	      <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	    <![endif]-->
	
	<title>用户登录</title>
</head>

<body>
  <%@ include file="/WEB-INF/jsp/header.jsp" %>		
  <div class="container">
    <form class="form-login" role="form" action="<c:url value="/login/doLogin.html" />" method="post">
	  <h4 class="form-login-heading">用户登录</h4>
      <input type="text" class="form-control" name="userName" placeholder="用户名" required="" autofocus=""> 
      <input type="password" class="form-control" name="password" placeholder="密码" required=""> 
      <label class="checkbox"> 
        <input type="checkbox" value="remember-me"> 请记住我 
      </label>
	  <button class="btn btn-lg btn-primary btn-block" type="submit">登录</button>
	</form>
  </div>
</body>
</html>

