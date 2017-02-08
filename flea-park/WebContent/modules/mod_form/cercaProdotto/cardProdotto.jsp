<jsp:useBean id="bpd" class="com.fleaPark.application.controls.ricerca.BeanProdottoDettagli"></jsp:useBean>
<jsp:setProperty property="prodottoId" name="bpd" />
<%
    if (request.getParameter("prodottoId") != null) {
        bpd.getDettagliProdottoById();
%>
<div class="card">
	<div class="card-image">
		<img alt="default-image" src="https://maxcdn.icons8.com/app/uploads/2016/02/material-icons-1.png" class="responsive-image">
		<span class="card-title black-text"> predisporre carosello nella card</span>
	</div>
	<div class="card-content">
		<div class="card-title">
			${bpd.prodottoNome}
			<span class="right"> ${bpd.prodottoPrezzo} &euro; </span>
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