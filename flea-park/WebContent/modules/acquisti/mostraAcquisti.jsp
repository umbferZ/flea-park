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
</div>
<%
    } else {
%>
<div class="row ">
	<div class="col s12 m6 offset-m3">
		<div class="card-panel center">
			<div class="card-content">
				<div class="card-title">Non hai ancora effettuato acquisti</div>
				<p>Cerca quello di cui hai bisogno.</p>
				<div class="input-field">
					<form id="cerca" method="get">
						<div class="row">
							<div class="input-field">
								<input type="search" name="cercaProdotto" id="search" required="required" placeholder="Cosa stai cercado?">
								<label class="label-icon" for="search">
									<i class="material-icons ">search</i>
								</label>
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</div>
<%
    }
%>
