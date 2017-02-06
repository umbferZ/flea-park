
<%
    if (request.getParameter("prodotto") != null) {
%>
<div class="row">
	<div class="col s12 m3">
		<jsp:include page="/modules/mod_form/cercaProdotto/searchResult.jsp"></jsp:include>
	</div>
	<div class="col s12 m6">
		<div class="container" id="dettagliProdotto">
			<jsp:include page="/modules/mod_form/cercaProdotto/cardProdotto.jsp"></jsp:include>
		</div>
	</div>
	<div class="col s12 m3 ">
		<div class="container" id="dettagliProdotto">
			<jsp:include page="/modules/mod_form/cercaProdotto/cardVenditore.jsp"></jsp:include>
		</div>
	</div>
</div>
<script type="text/javascript" src="js/jquery-2.2.0.js"></script>
<script type="text/javascript">
	$('.collection-item').click(function() {
		$('.collection').find('.active').removeClass('active');
		$(this).toggleClass('active');
	})
</script>
<%
    }
%>