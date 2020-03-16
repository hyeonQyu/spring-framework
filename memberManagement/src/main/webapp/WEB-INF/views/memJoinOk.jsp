<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> memJoinOk </h1>
	<!-- 모델이 아닌 커맨드 객체(여기선 Member)를 이용함 -->
	ID : ${member.memId}<br />
	PW : ${member.memPw}<br />
	Mail : ${member.memMail} <br />
	Phone : ${member.memPhone1} - ${member.memPhone2} - ${member.memPhone3} <br />
	
	<a href="/member1/resources/html/memJoin.html"> Go MemberJoin </a>
</body>
</html>
