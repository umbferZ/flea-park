
<%
    if (request.getParameter("iMieiProdotti") != null) {
%>
<div class="container">
	<div class="row">
		<div class="row">
			<div class="col s12">
				<ul class="tabs">
					<li class="tab col s6">
						<a class="active" href="#tuttiProdotti">Tutti i prodotti</a>
					</li>
					<li class="tab col s6">
						<a href="#nuovoProdotto">Nuovo prodotto</a>
					</li>
				</ul>
			</div>
			<div id="tuttiProdotti" class="col s12">
				<jsp:include page="/modules/crudProdotti/inserisciNuovoProdotto.jsp"></jsp:include>
			</div>
			<div id="nuovoProdotto" class="col s12">
				<jsp:include page="/modules/crudProdotti/inserisciNuovoProdotto.jsp"></jsp:include>
			</div>
		</div>
	</div>
</div>
<%
    }
%>