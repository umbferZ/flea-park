<jsp:useBean id="bpd" class="com.fleaPark.application.controls.ricerca.BeanProdottoDettagli"></jsp:useBean>
<jsp:setProperty property="prodottoId" name="bpd" />
<%
    if (request.getParameter("prodottoId") != null) {
        bpd.getDettagliProdottoById();
%>
<div class="card">
	<div class="card-image">
		<img alt="default-image" src="http://d0od.wpengine.netdna-cdn.com/wp-content/uploads/2014/10/material-wallpaper-full.jpg" class="responsive-image">
	</div>
	<div class="card-content">
		<div class="card-title">
			${bpd.prodottoNome}
			<span class="right"> ${bpd.prodottoPrezzo} ${bpd.prodottoValuta } </span>
		</div>
		<p>${bpd.prodottoDescrizione}</p>
	</div>
	<div class="card-action center">
		<form method="post" name="addCarrello">
			<input type="hidden" name="" value="" />
			<button class="btn" name="" value="">
				<i class="material-icons right">shop</i>aggiungi al carrello
			</button>
		</form>
	</div>
</div>
<%
    }
%>