<%@page import="java.io.PrintWriter"%>
<%@page import="java.io.StringWriter"%>
<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Flea Park - Error</title>
<jsp:include page="includes/link.jsp"></jsp:include>
</head>
<body class="grey lighten-4">
	<jsp:include page="/components/cmp_bar/barNav.jsp"></jsp:include>
	<div class="container" id="content">
		<p>
			Error:
			<%=exception.toString()%>
		</p>
		<p>
			Message:
			<%=exception.getMessage()%>
		</p>
		<p>
			Cause:
			<%=exception.getCause()%>
		</p>
		<code>
			StackTrace:
			<%
		    StringWriter stringWriter = new StringWriter();
		    PrintWriter printWriter = new PrintWriter(stringWriter);
		    exception.printStackTrace(printWriter);
		    out.println(stringWriter);
		    printWriter.close();
		    stringWriter.close();
		%>
		</code>
	</div>
	<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>