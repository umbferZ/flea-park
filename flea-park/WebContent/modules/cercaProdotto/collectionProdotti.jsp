
<%@page import="com.fleaPark.application.controls.ricerca.BeanRicercaProdotto"%>
<jsp:useBean id="beanRicerca" class="com.fleaPark.application.controls.ricerca.BeanRicerca"></jsp:useBean>
<a href="">ricerca avanzata</a>
<%
    beanRicerca.cerca(request.getParameter("prodotto"));
			if (beanRicerca.getProdotti().size() != 0) {
%>
<p>
	Trovati
	<%=beanRicerca.getProdotti().size()%>
	prodotti
</p>
<ul class="collection">
	<%
	    for (BeanRicercaProdotto bp : beanRicerca.getProdotti()) {
	%>
	<li class="collection-item avatar activator ">
		<i class="material-icons circle">folder</i>
		<span class="title"><%=bp.getProdottoNome()%></span>
		<p>
			<%=bp.getCategoriaNome()%>
		</p>
		<span class="secondary-content">
			<%=bp.getProdottoPrezzo()%>
			&euro;
		</span>
		<form name="p" id="p">
			<input type="hidden" name="prodottoId" value="<%=bp.getProdottoId()%>">
		</form>
	</li>
	<%
	    }
	%>
</ul>
<script type="text/javascript" src="js/jquery-2.2.0.js"></script>
<script type="text/javascript">
	$('.collection-item').click(function() {
		$('.collection').find('.active').removeClass('active');
		$(this).toggleClass('active');
		var form = $(this).find('form');
		console.log(form.serialize());
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
			},
			error : function() {
				$('#dettagliVenditore').html("<p>errore imprevisto</p>");
			},
			timeout : 2000
		});
	})
</script>
<%
    } else {
%>
<p>La ricerca non ha prodotto alcun risultato</p>
<%
    }
%>
