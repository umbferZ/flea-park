
<%
    if (request.getParameter("iMieiProdotti") != null) {
%>
<div class="container">
	<h5 class="center">I miei prodotti</h5>
	<jsp:include page="./mostraProdotti.jsp"></jsp:include>
</div>
<div class="fixed-action-btn click-to-toggle">
	<a class="btn-floating btn-large red">
		<i class="large material-icons">more_vert</i>
	</a>
	<ul>
		<li>
			<a class="btn-floating red">
				<i class="material-icons">add</i>
			</a>
		</li>
		<li>
			<a class="btn-floating yellow darken-1">
				<i class="material-icons">format_quote</i>
			</a>
		</li>
		<li>
			<a class="btn-floating green">
				<i class="material-icons">publish</i>
			</a>
		</li>
		<li>
			<a class="btn-floating blue">
				<i class="material-icons">attach_file</i>
			</a>
		</li>
	</ul>
</div>
<%
    }
%>