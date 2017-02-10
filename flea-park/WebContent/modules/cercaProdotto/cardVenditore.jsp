<jsp:useBean id="bvd" class="com.fleaPark.application.controls.ricerca.BeanVenditoreDettagli"></jsp:useBean>
<jsp:setProperty property="prodottoId" name="bvd" />
<%
    if (request.getParameter("prodottoId") != null) {
        bvd.validate();
%>
<div class="card">
	<div class="card-image">
		<img alt="default-image" src="${bvd.venditoreFoto }" class="responsive-image">
		<span class="card-title">${bvd.venditoreNome} ${bvd.venditoreCognome}</span>
	</div>
	<div class="card-content">
		<p>prodotti di ${bvd.venditoreNome}</p>
	</div>
	<div class="card-action center">
		<a href="" class="btn">
			<i class="material-icons right">email</i>Contatta
		</a>
	</div>
</div>
<%
    }
%>
