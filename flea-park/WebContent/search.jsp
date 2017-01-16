<%
    if (request.getParameter("search") != null) {
%>
<jsp:include page="includes/containerGridStrutture.jsp"></jsp:include>
<%
    }

    else if (request.getParameter("idStrut") != null) {
%>
<div class="container">
	<jsp:include page="includes/containerSingleStruttura.jsp"></jsp:include>
</div>
<%
    }
%>