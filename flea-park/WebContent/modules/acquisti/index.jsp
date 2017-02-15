
<%
    if (request.getParameter("iMieiAcquisti") != null) {
%>
<div class="container">
	<h5 class="center">I miei Acquisti</h5>
	<jsp:include page="./mostraAcquisti.jsp"></jsp:include>
</div>
<%
    }
%>