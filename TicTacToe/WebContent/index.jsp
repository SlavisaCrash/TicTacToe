<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">

<title>Tic Tac Toe</title>
</head>
<body>

	<center>	
	<div id="parentBox">
	
			<div id="block">
			
			<c:forEach var="i" begin="0" end="2">
				<c:forEach var="j" begin="0" end="2">
					<c:set var="k" value="${i},${j}"></c:set>
					<div id="cell" onclick="location.href='TicTacToeController?x=${i}&y=${j}'">${board[k]}</div>
				</c:forEach>
				<br>
			</c:forEach>
			
			</div>
			<div id="result">
				<h3>Result</h3>
				<h4>You:${userScore}</h4>
				<h4>Cpu:${cpuScore}</h4>	
			</div>
			<div id="footer">
				<p id="message">${message}</p>
			
				<c:if test="${buttonEnabled eq 'yes'}">
					<p><input type="submit" value="New Game" onclick="location.href='TicTacToeController?action=new'"></p>	
				</c:if>
			</div>
	</div>
	
    </center>

</body>
</html>