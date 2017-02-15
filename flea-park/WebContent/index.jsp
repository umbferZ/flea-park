<%@page import="javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter.DEFAULT"%>
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
	<jsp:include page="/components/cmp_bar/barSearch.jsp"></jsp:include>
	<%
	    if (session.getAttribute("utente") == null) {
	%>
	<jsp:include page="/modules/crudUtente/accesso.jsp"></jsp:include>
	<jsp:include page="/modules/crudUtente/registrazione.jsp"></jsp:include>
	<%
	    }
	%>
	<div id="content">
		<%
		    if (session.getAttribute("utente") != null) {
		%>
		<jsp:include page="/modules/crudProdotti/index.jsp"></jsp:include>
		<jsp:include page="/modules/acquisti/index.jsp"></jsp:include>
		<%
		    }
		%>
		<%
		    if (request.getParameter("cercaProdotto") != null) {
		%>
		<jsp:include page="/modules/cercaProdotto/index.jsp"></jsp:include>
		<%
		    } else {
		%>
		<div class="section-not-pad-bot"></div>
		<ul>
			<li>ultimi inserimenti</li>
			<li>prodotti più osservati</li>
		</ul>
		<jsp:include page="/modules/slider.jsp" />
		<%
		    }
		%>
	</div>
	<jsp:include page="components/cmp_footer/footer.jsp" />
	<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>