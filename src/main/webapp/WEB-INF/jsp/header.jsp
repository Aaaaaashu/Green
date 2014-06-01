<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<div class="header" role="navigation" >
	<div class="container">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span> 
				<span class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="<c:url value="/index.jsp"/>">Green</a>
		</div>
		<div class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href="<c:url value="/index.jsp"/>">社區</a></li>
				<li><a href="#about">市集</a></li>
				<li><a href="#contact">關於</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle" data-toggle="dropdown">更多 <b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Action</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul>
				</li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
     			<c:if test="${!empty USER_CONTEXT.userName}">
					<li><a href="#">${USER_CONTEXT.userName} <span class="badge">${USER_CONTEXT.credit}</span></a></li>
					<li><a href="<c:url value="/login/doLogout.html"/>">註銷</a></li>
				</c:if>
				<c:if test="${empty USER_CONTEXT.userName}">
					<li><a href="<c:url value="/login.jsp"/>">登錄</a></li>
  					<li><a href="<c:url value="/register.jsp"/>">註冊</a></li>
				</c:if>
    		</ul>
   			<form class="navbar-form navbar-right search">
     			 <input type="text" class="form-control" placeholder="Search...">
    		</form>	
		</div>
	</div>
</div>