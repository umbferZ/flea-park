
<jsp:include page="/includes/languageCheck.jsp"></jsp:include>
<%
/*     String lng = (String) session.getAttribute("language");
    Resources resources = new Resources((String) session.getAttribute("language"));
    if (request.getParameter("signUp") != null) {
        response.sendRedirect("index.jsp");
    }
    if (request.getParameter("signIn") != null) {
        response.sendRedirect("index.jsp");
    }
    if (request.getParameter("logout") != null) {
        session.removeAttribute("user");
        response.sendRedirect("index.jsp");
    } */
%>
<!DOCTYPE html>
<html>
<head>
<title>Flea Park</title>
<jsp:include page="includes/link.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/modules/mod_bar/barNav.jsp"></jsp:include>
	<div id="content">
		<p align="center">
			<%
			    // 			    out.println("Language : " + language + "<br />");
			%>
		</p>
		<%
		    if (session.getAttribute("user") != null) {
		%>
		<div class="container">
            <h1 class="lighten">Flea Park</h1>
			
		</div>
		<%
		    } else {
		%>
		<div class="section-not-pad-bot" style="min-height: 700px;">
			<jsp:include page="./modules/slider.jsp" />
		</div>
		<%
		    }
		%>
	</div>
	<jsp:include page="modules/mod_footer/footer.jsp" />
	<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>