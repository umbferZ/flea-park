
<%@page import="com.fleaPark.application.controls.ricerca.BeanRicercaProdotto"%>
<jsp:useBean id="beanRicerca" class="com.fleaPark.application.controls.ricerca.BeanRicerca"></jsp:useBean>
<%
    beanRicerca.cerca(request.getParameter("cercaProdotto"));
			if (beanRicerca.getProdotti().size() != 0) {
%>
<div class="card-panel">
	<a href="" class="center">ricerca avanzata</a>
	<p class="center">
		Trovati
		<%=beanRicerca.getProdotti().size()%>
		prodotti
	</p>
</div>
<!-- <div class="button-group sort-by-button-group"> -->
<!-- 	<button class="button is-checked" data-sort-value="original-order">original order</button> -->
<!-- 	<button class="button" data-sort-value="titolo">nome</button> -->
<!-- 	<button class="button" data-sort-value="prezzo">prezzo</button> -->
<!-- 	<button class="button" data-sort-value="categoria">categoria</button> -->
<!-- </div> -->
<div class="side-scrollable">
	<div class="side-scrollable-content">
		<ul class="collection">
			<%
			    for (BeanRicercaProdotto bp : beanRicerca.getProdotti()) {
			%>
			<li class="collection-item avatar activator" data-category="<%=bp.getCategoriaNome().replace(" ", "-")%>">
				<img src="<%=bp.getProdottoFoto()%>" alt="" class="circle">
				<span class="title truncate" id="titolo"><%=bp.getProdottoNome()%></span>
				<p>
					in
					<a href="?categoria=<%=bp.getCategoriaNome()%>"><%=bp.getCategoriaNome()%></a>
				</p>
				<p class="accentColor right-align">
					<span id="prezzo"><%=bp.getProdottoPrezzo()%></span>
					<%=bp.getPrdottoValuta()%>
				</p>
				<form>
					<input type="hidden" name="prodottoId" value="<%=bp.getProdottoId()%>">
				</form>
			</li>
			<%
			    }
			%>
		</ul>
	</div>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
<script type="text/javascript">
	$j = jQuery.noConflict();
	$j(document).ready(function() {
		$j('.collection-item').click(function() {
			$j('.collection').find('.active').removeClass('active');
			$j(this).toggleClass('active');
			var form = $j(this).find('form');
			$j.ajax({
				type : 'POST',
				url : 'modules/cercaProdotto/cardProdotto.jsp',
				data : form.serialize(),
				dataType : 'html',
				success : function(data) {
					$j('#dettagliProdotto').html(data);

				},
				error : function() {
					$j('#dettagliProdotto').html("<p>errore imprevisto</p>");
				},
				timeout : 2000
			});
			$j.ajax({
				type : 'POST',
				url : 'modules/cercaProdotto/cardVenditore.jsp',
				data : form.serialize(),
				dataType : 'html',
				success : function(data) {
					$j('#dettagliVenditore').html(data);
					$('.card').show();
				},
				error : function() {
					$j('#dettagliVenditore').html("<p>errore imprevisto</p>");
				},
				timeout : 2000
			});

		});
		// 		var $grid = $j('.collection');
		// 		$grid.isotope({
		// 			itemSelector : '.collection-item',
		// 			layoutMode : 'masonry',
		// 			getSortData : {
		// 				titolo : '#titolo',
		// 				categoria : '[data-category]',
		// 				prezzo : function(itemElem) {
		// 					var weight = $j(itemElem).find('#prezzo').text();
		// 					return parseFloat(weight.replace(/[\(\)]/g, ''));
		// 				}
		// 			}
		// 		});
		// 		$j('.sort-by-button-group').on('click', 'button', function() {
		// 			var sortValue = $j(this).attr('data-sort-value');
		// 			$grid.isotope({
		// 				sortBy : sortValue
		// 			});
		// 		});

		// 		$j('.button-group').each(function(i, buttonGroup) {
		// 			var $buttonGroup = $j(buttonGroup);
		// 			$buttonGroup.on('click', 'button', function() {
		// 				$buttonGroup.find('.is-checked').removeClass('is-checked');
		// 				$j(this).addClass('is-checked');
		// 			});
		// 		});
		// 		$grid.isotope('layout');
	});
</script>
<%
    } else {
%>
<p>La ricerca non ha prodotto alcun risultato</p>
<%
    }
%>
