<div class="col s12 m4" id="prodottoVenduto">
	<div class="card large grey darken-2 white-text">
		<div class="card-image">
			<img alt="" src="https://i.ytimg.com/vi/uFS4TVu8v08/maxresdefault.jpg">
			<span class="card-title red white-text shadow">
				<span class="strike">
					<%=request.getParameter("prezzo")%>
					<%=request.getParameter("valuta")%>
				</span>
				<sub>Venduto</sub>
			</span>
		</div>
		<div class="card-content">
			<div class="card-title lighten">
				<%=request.getParameter("nome")%>
			</div>
			<p class="condensed truncate">
				<%=request.getParameter("descrizione")%>
			</p>
		</div>
	</div>
</div>
