
<%
    if (request.getParameter("cercaProdotto") != null) {
%>
<div class="row">
	<div class="col s12 m3">
		<div class="side-scrollable">
			<div class="side-scrollable-content">
				<jsp:include page="/modules/cercaProdotto/collectionProdotti.jsp"></jsp:include>
			</div>
		</div>
	</div>
	<div class="col s12 m6">
		<div class="container" id="dettagliProdotto">
			<jsp:include page="/modules/cercaProdotto/cardProdotto.jsp"></jsp:include>
			<p class="center">Seleziona un elemento per vedere i dettagli</p>
		</div>
	</div>
	<div class="col s12 m3 ">
		<div class="container" id="dettagliVenditore">
			<jsp:include page="/modules/cercaProdotto/cardVenditore.jsp"></jsp:include>
		</div>
	</div>
</div>
<%
    }
%>