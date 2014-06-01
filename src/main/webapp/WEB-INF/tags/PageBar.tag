<%@ tag pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="pageUrl" required="true" rtexprvalue="true"
	description="分页页面对应的URl"%>
<%@ attribute name="pageAttrKey" required="true" rtexprvalue="true"
	description="Page对象在Request域中的键名称"%>

<c:set var="pageUrl" value="${pageUrl}" />
<%
	String separator = pageUrl.indexOf("?") > -1 ? "&" : "?";
	jspContext.setAttribute("pageResult",
			request.getAttribute(pageAttrKey));
	jspContext.setAttribute("pageUrl", pageUrl);
	jspContext.setAttribute("separator", separator);
%>

<div>
	<ul class="pager">
		<li class="previous">
			<c:if test="${pageResult.hasPreviousPage}">
				<a href="<c:url value="${pageUrl}"/>${separator}pageNo=${pageResult.currentPageNo -1 }">&larr; 上一頁</a>
			</c:if>
			<c:if test="${!pageResult.hasPreviousPage}">
				<span>&larr; 上一頁</span>
			</c:if>
		</li>
		<li class="next">
			<c:if test="${pageResult.hasNextPage}">
				<a href="<c:url value="${pageUrl}"/>${separator}pageNo=${pageResult.currentPageNo +1 }">下一頁 &rarr;</a>
			</c:if>
			<c:if test="${!pageResult.hasNextPage}">
				<span>下一頁 &rarr;</span>
			</c:if>
		</li>
	</ul>
</div>