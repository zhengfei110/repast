<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core"prefix="c"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/hall.js"></script>
<link rel="stylesheet" type="text/css" href="../css/hall.css">
<link rel="stylesheet" href="../css/bootstrap.min.css" type="text/css"></link>
<script type="text/javascript" src="../css/jquery-3.1.1.min.js"></script>
<script type="text/javascript" src="../css/bootstrap.min.js"></script>
</head>
</head>

<body>
	<c:forEach items="${ld}" var="d">
		<div class="a2">
			<img src="${d.src}" height="110" width="141"/>${d.seatid}号桌<br/>
			<button type="button" class="btn btn-primary">${d.staticName}</button>
		</div>
		</c:forEach>
</body>
</html>
