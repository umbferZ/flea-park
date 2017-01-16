<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (request.getParameter("signUp") != null) {
        response.sendRedirect("index.jsp");
    }
    if (request.getParameter("signIn") != null) {
        response.sendRedirect("index.jsp");
    }
    if (request.getParameter("logout") != null) {
        session.removeAttribute("user");
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<title>Offerte</title>
<jsp:include page="includes/link.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/modules/mod_bar/barNav.jsp"></jsp:include>
	<div id="content">
		<div class="container">
			<%
			    if (request.getParameter("showOfferte") != null) {
			%>
			<jsp:include page="/modules/mod_collapsable/collapsable_listaOfferte.jsp"></jsp:include>
			<%
			    } else if (request.getParameter("creaOfferta") != null) {
			%>
			<jsp:include page="/modules/mod_form/form_creaOfferta.jsp"></jsp:include>
			<%
			    }
			%>
		</div>
	</div>
	<jsp:include page="modules/mod_footer/footer.jsp" />
	<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>