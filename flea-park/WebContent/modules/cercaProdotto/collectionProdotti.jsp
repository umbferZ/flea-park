
<%@page import="com.fleaPark.application.controls.ricerca.BeanRicercaProdotto"%>
<jsp:useBean id="beanRicerca" class="com.fleaPark.application.controls.ricerca.BeanRicerca"></jsp:useBean>
<%
    beanRicerca.cerca(request.getParameter("cercaProdotto"));
			if (beanRicerca.getProdotti().size() != 0) {
%>
<div class="side-scrollable">
	<div class="side-scrollable-content">
		<div class="card-panel">
			<a href="" class="center">ricerca avanzata</a>
			<p class="center">
				Trovati
				<%=beanRicerca.getProdotti().size()%>
				prodotti
			</p>
		</div>
		<div class="button-group sort-by-button-group center">
			<button class="is-checked btn-flat" data-sort-value="original-order">
				<i class="material-icons">sort</i>
			</button>
			<button class="btn-flat" data-sort-value="titolo">
				<i class="material-icons">sort_by_alpha</i>
			</button>
			<button class="btn-flat" data-sort-value="prezzo">
				<i class="material-icons">attach_money</i>
			</button>
			<button class="btn-flat active" data-sort-value="categoria">
				<i class="material-icons">book</i>
			</button>
		</div>
		<ul class="collection">
			<%
			    for (BeanRicercaProdotto bp : beanRicerca.getProdotti()) {
			%>
			<li class="collection-item avatar activator" data-category="<%=bp.getCategoriaNome().replace(" ", "-")%>">
				<img src="<%=bp.getProdottoFoto()%>" alt="" class="circle">
				<span class="title truncate" id="titolo"><%=bp.getProdottoNome()%></span>
				<p class="truncate">
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
<!-- <script type="text/javascript" src="/js/jquery-2.2.0.js"></script> -->
<script type="text/javascript">
	// 	$j = jQuery.noConflict();
	$(document).ready(function() {
		$('.collection-item').click(function() {
			$('.collection').find('.active').removeClass('active');
			$(this).toggleClass('active');
			var form = $(this).find('form');
			$.ajax({
				type : 'POST',
				url : 'modules/cercaProdotto/cardProdotto.jsp',
				data : form.serialize(),
				dataType : 'html',
				success : function(data) {
					$('#dettagliProdotto').html(data);

				},
				error : function() {
					$('#dettagliProdotto').html("<p>errore imprevisto</p>");
				},
				timeout : 2000
			});
			$.ajax({
				type : 'POST',
				url : 'modules/cercaProdotto/cardVenditore.jsp',
				data : form.serialize(),
				dataType : 'html',
				success : function(data) {
					$('#dettagliVenditore').html(data);
					$('.card').show();
				},
				error : function() {
					$('#dettagliVenditore').html("<p>errore imprevisto</p>");
				},
				timeout : 2000
			});

		});
		console.log("pronto");
		var $grid = $('.collection');
		$grid.isotope({
			itemSelector : '.collection-item',
			layoutMode : 'masonry',
			getSortData : {
				titolo : '#titolo',
				categoria : '[data-category]',
				prezzo : function(itemElem) {
					var weight = $(itemElem).find('#prezzo').text();
					return parseFloat(weight.replace(/[\(\)]/g, ''));
				}
			}
		});
		$('.sort-by-button-group').on('click', 'button', function() {
			console.log("chick group");
			var sortValue = $(this).attr('data-sort-value');
			$grid.isotope({
				sortBy : sortValue
			});
		});
		$('.button-group').each(function(i, buttonGroup) {
			console.log("chick tasto");
			var $buttonGroup = $(buttonGroup);
			$buttonGroup.on('click', 'button', function() {
				$buttonGroup.find('.is-checked').removeClass('is-checked');
				$(this).addClass('is-checked');
			});
		});
		$grid.isotope('layout');
	});
</script>
<%
    } else {
%>
<p>La ricerca non ha prodotto alcun risultato</p>
<%
    }
%>
