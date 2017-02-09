<%@page import="com.fleaPark.application.controls.crudProdotti.BeanIMieiProdotti"%>
<jsp:useBean id="iMieiProdotti" class="com.fleaPark.application.controls.crudProdotti.BeanIMieiProdotti"></jsp:useBean>
<jsp:setProperty property="utenteId" name="iMieiProdotti" value="${utente.idUtente }" />
<%
    iMieiProdotti.prendiProdotti();
%>
<%
    if (true) {
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
				<span class="card-title right "><%=b.getProdottoPrezzo()%>&euro;
				</span>
				<%=b.getProdottoNome()%>
			</div>
			<p class="condensed">
				<%=b.getProdottoDescrizione()%>
			</p>
		</div>
		<div class="card-action center">
			<a href="#" class="btn-floating left">
				<i class="material-icons red">delete</i>
			</a>
			<a href="#" class="btn-floating right">
				<i class="material-icons blue">update</i>
			</a>
		</div>
	</div>
</div>
<%
    }
%>
<%
    } else {
%>
non ci sono prodotti;
<%
    }
%>