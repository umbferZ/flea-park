<%@ page errorPage="/error.jsp"%>
<jsp:include page="/includes/languageCheck.jsp"></jsp:include>
<%
    //         String lng = (String) session.getAttribute("language");
    //         Resources resources = new Resources((String) session.getAttribute("language"));
    if (request.getParameter("accedi") != null) {
        response.sendRedirect("index.jsp");
    }
    if (request.getParameter("registrati") != null) {
        response.sendRedirect("index.jsp");
    }
    if (request.getParameter("logout") != null) {
        session.removeAttribute("utente");
        response.sendRedirect("index.jsp");
    }
%>
<!DOCTYPE html>
<html>
<head>
<title>Flea Park</title>
<jsp:include page="includes/link.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/components/cmp_bar/barNav.jsp"></jsp:include>
	<div id="content">
		<%
		    if (session.getAttribute("utente") != null) {
		%>
		<div class="container">
			<jsp:include page="/modules/mod_form/form_inserisciProdotto.jsp"></jsp:include>
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
		<ul>
		<li>ultimi inserimenti</li>
		<li>prodotti più osservati</li>
		</ul>
	</div>
	<jsp:include page="components/cmp_footer/footer.jsp" />
	<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>