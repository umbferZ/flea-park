
<%
    if (request.getParameter("prodotto") != null) {
%>
<div class="row">
	<div class="col s12 m3">
		<jsp:include page="/modules/mod_form/cercaProdotto/collectionProdotti.jsp"></jsp:include>
	</div>
	<div class="col s12 m6">
		<div class="container" id="dettagliProdotto">
			<jsp:include page="/modules/mod_form/cercaProdotto/cardProdotto.jsp"></jsp:include>
		</div>
	</div>
	<div class="col s12 m3 ">
		<div class="container" id="dettagliVenditore" >
			<jsp:include page="/modules/mod_form/cercaProdotto/cardVenditore.jsp"></jsp:include>
		</div>
	</div>
</div>

<%
    }
%>