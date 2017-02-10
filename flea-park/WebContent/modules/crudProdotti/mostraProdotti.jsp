<%@page import="com.fleaPark.application.controls.crudProdotti.BeanIMieiProdotti"%>
<jsp:useBean id="iMieiProdotti" class="com.fleaPark.application.controls.crudProdotti.BeanIMieiProdotti"></jsp:useBean>
<jsp:setProperty property="utenteId" name="iMieiProdotti" value="${utente.idUtente }" />
<%
    iMieiProdotti.prendiProdotti();
%>
<%
    int i = 1;
    if (i != 2) {
%>
<%
    for (BeanIMieiProdotti b : iMieiProdotti.getiMieiProdotti()) {
%>
<div class="col s12 m4">
	<div class="card large">
		<div class="card-image">
			<img alt="" src="https://i.ytimg.com/vi/uFS4TVu8v08/maxresdefault.jpg">
		</div>
		<div class="card-content">
			<div class="card-title lighten">
				<span class="right" ><%=b.getProdottoPrezzo()%>
					<span class="regular"><%=b.getProdottoValuta()%></span>
				</span>
				<%=b.getProdottoNome()%>
			</div>
			<p class="condensed">
				<%=b.getProdottoDescrizione()%>
			</p>
		</div>
		<div class="card-action center">
			<a href="#modal-cancella-<%=b.getProdottoId()%>" class="btn-floating left">
				<i class="material-icons red">delete</i>
			</a>
			<a href="#" class="btn-floating right">
				<i class="material-icons blue">update</i>
			</a>
		</div>
	</div>
</div>
<div class="modal bottom-sheet" id="modal-cancella-<%=b.getProdottoId()%>">
	<div class="modal-content">
		<h6 class="center">
			Sicuro di voler cancellare <b><%=b.getProdottoNome()%></b> dai tuoi prodotti?
		</h6>
	</div>
	<div class="modal-footer">
		<div class="container">
			<form id="cancellaProdotto">
				<input type="hidden" name="prodottoId" value="<%=b.getProdottoId()%>">
				<button class="modal-action modal-close btn-flat red left white-text" name="cancellaProdotto" value="true">
					<i class="material-icons left">delete</i>Cancella
				</button>
			</form>
			<a href="#!" class="modal-action modal-close btn-flat blue right white-text">
				<i class="material-icons left">close</i>Annulla
			</a>
		</div>
	</div>
</div>
<%
    }
%>
inserisci qui javascript e ajax
<%
    } else {
%>
non ci sono prodotti;
<%
    }
%>