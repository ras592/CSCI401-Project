<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Java Error</title>
</head>
<body>
	<h1>Java Error</h1>
	<p>Sorry, Java has thrown an exception.</p>
	<p>To continue, click the Back button.</p>
	
	<h2>Details</h2>
	<p>Type: {pageContext.exception["class"]}</p>
	<p>Message: {pageContext.exception.message}</p>
</body>
</html>