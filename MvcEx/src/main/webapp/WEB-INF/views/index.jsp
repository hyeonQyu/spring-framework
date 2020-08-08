<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%
		String context = request.getContextPath();
	%>

	<form action="<%= context %>/studentView" method="get">
		이름 : <input type="text" name="name"><br/>
		나이 : <input type="number" name="age"><br/>
		학년 : <input type="number" name="grade"><br/>
		반 : <input type="number" name="classNum"><br/>
		<input type="submit" value="전송">
	</form>

</body>
</html>