<div class="col s12 m4" id="prodottoDisponibile">
	<div class="card large">
		<div class="card-image">
			<img alt="" src="https://i.ytimg.com/vi/uFS4TVu8v08/maxresdefault.jpg">
			<span class="card-title green white-text shadow right">
				<%=request.getParameter("prezzo")%>
				<%=request.getParameter("valuta")%>
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
		<div class="card-action center">
			<a href="#modal-cancella-<%=request.getParameter("id")%>" class="btn-floating left">
				<i class="material-icons red">delete</i>
			</a>
			<a href="#" class="btn-floating right">
				<i class="material-icons blue">update</i>
			</a>
		</div>
	</div>
</div>
<div class="modal bottom-sheet" id="modal-cancella-<%=request.getParameter("id")%>">
	<div class="modal-content">
		<h6 class="center">
			Sicuro di voler cancellare <b><%=request.getParameter("nome")%></b> dai tuoi prodotti?
		</h6>
	</div>
	<div class="modal-footer">
		<div class="container">
			<form id="cancellaProdotto">
				<input type="hidden" name="prodottoId" value="<%=request.getParameter("id")%>">
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
