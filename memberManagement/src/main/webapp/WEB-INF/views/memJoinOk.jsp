<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1> memJoinOk </h1>
	<!-- 모델이 아닌 커맨드 객체(여기선 Member)를 이용함, @ModelAttribute를 이용하여 member의 이름을 mem으로 변경하여 사용 -->
	ID : ${mem.memId}<br />
	PW : ${mem.memPw}<br />
	Mail : ${mem.memMail} <br />
	Phone : ${mem.memPhone1} - ${mem.memPhone2} - ${mem.memPhone3} <br />
	
	<!-- @ModelAttribute를 이용하여 getServerTime 메소드를 호출 -->
	<p> The time on the server is ${serverTime}. </p>
	
	<a href="/member1/resources/html/memJoin.html"> Go MemberJoin </a>
</body>
</html>
