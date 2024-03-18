<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/nstyle.css" />
</head>
<body>
<h3>content_update.jsp</h3>
<form action="modify" method="post">
<input type="hidden" name="bid" value="${content_view.bid }" />
<table>
	<tr>
		<td class="left">번호</td>
		<td>${content_view.bid }</td>
	</tr>
	<tr>
		<td class="left">히트</td>
		<td>${content_view.bhit }</td>
	</tr>
	<tr>
		<td class="left">이름</td>
		<td>
			<input type="text" name="bname" value="${content_view.bname }" />	
		</td>
	</tr>
	<tr>
		<td class="left">제목</td>
		<td>
			<input type="text" name="btitle" value="${content_view.btitle }" />		
		</td>
	</tr>
	<tr>
		<td class="left">내용</td>
		<td>
			<textarea name="bcontent" cols="35" rows="5">${content_view.bcontent }</textarea>	
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<input type="submit" value="modify" /> &nbsp;&nbsp;
			<a href="list">list</a>		
		</td>		
	</tr>
</table>
</form>

</body>
</html>