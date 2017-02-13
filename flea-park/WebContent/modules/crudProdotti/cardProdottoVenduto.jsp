<div class="col s12 m4" id="prodottoVenduto">
	<div class="card large grey darken-2 white-text">
		<div class="card-image">
			<img alt="" src="https://i.ytimg.com/vi/uFS4TVu8v08/maxresdefault.jpg">
			<div class="card-title red white-text shadow">Venduto</div>
		</div>
		<div class="card-content">
			<div class="card-title lighten">
				<span class="right"><%=request.getParameter("prezzo")%>
					<span class="regular"><%=request.getParameter("valuta")%></span>
				</span>
				<%=request.getParameter("nome")%>
			</div>
			<p class="condensed truncate">
				<%=request.getParameter("descrizione")%>
			</p>
		</div>
	</div>
</div>
