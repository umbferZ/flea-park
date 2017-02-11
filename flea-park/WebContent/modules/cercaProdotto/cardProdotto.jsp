<jsp:useBean id="bpd" class="com.fleaPark.application.controls.ricerca.BeanProdottoDettagli"></jsp:useBean>
<jsp:setProperty property="prodottoId" name="bpd" />
<%
    if (request.getParameter("prodottoId") != null) {
				bpd.getDettagliProdottoById();
%>
<div class="card">
	<div class="card-image ">
		<div class="slider ">
			<ul class="slides ">
				<%
				    for (String src : bpd.getProdottoGallery()) {
				%>
				<li>
					<img alt="default-image" src="<%=src%>" class="responsive-image">
				</li>
				<%
				    }
				%>
			</ul>
		</div>
	</div>
	<div class="card-content">
		<span class="card-title activator grey-text text-darken-4">
			<i class="material-icons right">more_vert</i> ${bpd.prodottoNome}
		</span>
		<p class="truncate activator">${bpd.prodottoDescrizione}</p>
	</div>
	<div class="card-reveal">
		<span class="card-title grey-text text-darken-4">
			<i class="material-icons right">close</i> ${bpd.prodottoNome}
		</span>
		<p>${bpd.prodottoDescrizione}</p>
		<div class="center">
			<form method="post" name="addCarrello">
				<input type="hidden" name="" value="" />
				<button class="btn" name="" value="">
					<i class="material-icons left">shop</i>${bpd.prodottoPrezzo} ${bpd.prodottoValuta }
				</button>
			</form>
		</div>
	</div>
	<div class="card-action center">
		<div class="card-title ">${bpd.prodottoPrezzo}${bpd.prodottoValuta }</div>
		<form method="post" name="addCarrello">
			<input type="hidden" name="" value="" />
			<button class="btn" name="" value="">
				<i class="material-icons right">shop</i>aggiungi al carrello
			</button>
		</form>
	</div>
</div>
<script type="text/javascript">
	$(document).ready(function() {
		$('.slider').slider({
			indicators : true,
			transition : 500,
			interval : 4000
		});
	});
</script>
<%
    }
%>