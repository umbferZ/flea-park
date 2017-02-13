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
inserisci qui javascript e ajax
<%
    } else {
%>
non ci sono prodotti;
<%
    }
%>