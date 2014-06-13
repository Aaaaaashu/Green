<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="green" tagdir="/WEB-INF/tags" %>

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

  <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
    <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
  <![endif]-->

  <title>Green|社區版塊</title>
</head>
<body>
  <%@ include file="header.jsp"%>
  <div class="container content">
    <div class="topics-header"></div>
 	<div class="tips">
   	  <div class="tips-header"></div>
      <div class="tips-content-1">
        <a class="btn btn-success" href="<c:url value="/board/addTopicPage-${board.boardId}.html"/>">發佈新帖</a>
      </div>
      <div class="tips-content-2">
        <h2>${board.boardName}</h2>
        <div>${board.boardDesc}</div>
      </div>
    </div> 
    <c:forEach var="topic" items="${pagedTopic.result}">
	  <div class="topic">
	    <img class="avatar" src="${path}/images/avatar.png" >
		<div class="title">
		  <a href="<c:url value="/board/listTopicPosts-${topic.topicId}.html"/>">
			<c:if test="${topic.digest > 0}">
			  <span class="glyphicon glyphicon-fire"></span>
			</c:if>
			${topic.topicTitle} 
		  </a>
		</div>
		<div class="info">
	      <a href="#">${topic.user.userName}</a>
		  <small>|</small>
		  <small>創建：<fmt:formatDate pattern="yyyy-MM-dd" value="${topic.createTime}"/></small>
		  <small>最後回覆：<fmt:formatDate pattern="yyyy-MM-dd" value="${topic.lastPost}" /></small>
		</div>
		<div class="reply">
		  <span class="badge">${topic.replies}</span>
		</div>
	  </div>
    </c:forEach>
	<div class="clearfix"></div>
	<div class="pagebar">
	  <green:PageBar
		pageUrl="/board/listBoardTopics-${board.boardId}.html"
		pageAttrKey="pagedTopic"/>
	</div>
  </div>
  <%@ include file="footer.jsp"%>
  
  <script src="http://cdn.staticfile.org/jquery/2.1.1-rc2/jquery.min.js"></script>
  <script src="http://cdn.staticfile.org/twitter-bootstrap/3.1.1/js/bootstrap.min.js"></script>
</body>	
</html>

