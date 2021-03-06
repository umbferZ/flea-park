<%@page import="com.fleaPark.application.controls.crudProdotti.BeanIMieiProdotti"%>
<jsp:useBean id="iMieiProdotti" class="com.fleaPark.application.controls.crudProdotti.BeanIMieiProdotti"></jsp:useBean>
<jsp:setProperty property="utenteId" name="iMieiProdotti" value="${utente.idUtente }" />
<%
    iMieiProdotti.prendiProdotti();
%>
<%
    if (iMieiProdotti.getiMieiProdotti().size() > 0) {
%>
<div class="row">
	<%
	    for (BeanIMieiProdotti b : iMieiProdotti.getiMieiProdotti()) {
	%>
	<%
	    if (b.isVenduto()) {
	%>
	<jsp:include page="./cardProdottoVenduto.jsp">
		<jsp:param value="<%=b.getProdottoNome()%>" name="nome" />
		<jsp:param value="<%=b.getProdottoDescrizione()%>" name="descrizione" />
		<jsp:param value="<%=b.getProdottoPrezzo()%>" name="prezzo" />
		<jsp:param value="<%=b.getProdottoValuta()%>" name="valuta" />
		<jsp:param value="<%=b.getProdottoId()%>" name="id" />
		<jsp:param value="srcfotografia" name="foto" />
	</jsp:include>
	<%
	    } else {
	%>
	<jsp:include page="./cardProdottoDiponibile.jsp">
		<jsp:param value="<%=b.getProdottoNome()%>" name="nome" />
		<jsp:param value="<%=b.getProdottoDescrizione()%>" name="descrizione" />
		<jsp:param value="<%=b.getProdottoPrezzo()%>" name="prezzo" />
		<jsp:param value="<%=b.getProdottoValuta()%>" name="valuta" />
		<jsp:param value="<%=b.getProdottoId()%>" name="id" />
		<jsp:param value="srcfotografia" name="foto" />
	</jsp:include>
	<%
	    }
	%>
	<%
	    }
	%>
</div>
inserisci qui javascript e ajax
<%
    } else {
%>
<div class="row ">
	<div class="col s12 m6 offset-m3">
		<div class="card-panel center">
			<div class="card-content">
				<div class="card-title">Non ci sono prodotti nella tua raccolta</div>
				<p>Inizia a vendere i tuoi prodotti.</p>
				<a href="" class="btn">Inserisci nuovo prodotto</a>
			</div>
		</div>
	</div>
</div>
<%
    }
%>
