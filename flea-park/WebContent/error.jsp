<%@ page isErrorPage="true" import="java.io.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<jsp:include page="includes/header.jsp"></jsp:include>
<jsp:include page="/modules/mod_card/cardCartIndicator.jsp"></jsp:include>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Flea Park -Error</title>
<jsp:include page="includes/link.jsp"></jsp:include>
</head>
<body class="grey lighten-4">
	<jsp:include page="/modules/mod_bar/barNav.jsp"></jsp:include>
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
		<pre>
StackTrace:
<%
		    StringWriter stringWriter = new StringWriter();
		    PrintWriter printWriter = new PrintWriter(stringWriter);
		    exception.printStackTrace(printWriter);
		    out.println(stringWriter);
		    printWriter.close();
		    stringWriter.close();
		%>

</pre>
	</div>
	<jsp:include page="modules/mod_footer/footer.jsp" />
	<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>