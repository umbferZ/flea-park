
<%@page import="com.fleaPark.application.beans.BeanProdotto"%>
<jsp:useBean id="beanRicerca" class="com.fleaPark.application.beans.BeanRicerca"></jsp:useBean>
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
	    for (BeanProdotto bp : beanRicerca.getProdotti()) {
	%>
	<li class="collection-item avatar activator"><i class="material-icons circle">folder</i> <span class="title"><%=bp.getProdottoNome()%></span>
		<p>
			<%=bp.getProdottoPrezzo()%>
			&euro; <br>
			<%=bp.getCategoriaNome()%>
		</p></li>
	<%
	    }
	%>
</ul>
<%
    } else {
%>
<p>La ricerca non ha prodotto alcun risultato</p>
<%
    }
%>