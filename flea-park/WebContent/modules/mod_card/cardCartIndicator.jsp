<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="s3 left fixed-action-btn">
	<div class="card" id="card_cartIndicator">
		<div class="card-title"></div>
		<div class="card-content">
			<span class="right">
				<a href="#"><i class="material-icons tiny wave-effect" id="icon_close_card_cartIndicator">close</i></a>
			</span>
			<div class="title">Ciao ${utente.nome} ${utente.cognome}</div>
			Totale
			<span class="card-title">123,89 €</span>
		</div>
		<div class="card-action">
			<form method="post" action="UCPagamento01InserimentoDati.jsp">
				<button class="btn" type="submit" name="action">
					Procedi al pagamento <i class="material-icons right">shop</i>
				</button>
			</form>
		</div>
	</div>
	<a class="btn-floating btn-large waves-effect right notVisible" id="fab_cartIndicator"><i class="material-icons">shop</i></a>
</div>
<script type='text/javascript' src='js/jquery-2.2.0.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#icon_close_card_cartIndicator").click(function() {
			$("#card_cartIndicator").slideToggle(function() {
				$("#fab_cartIndicator").fadeToggle();
			});

		});
		$("#fab_cartIndicator").click(function() {

			$("#fab_cartIndicator").fadeToggle(function() {
				$("#card_cartIndicator").slideToggle();
			});
		});

	});
</script>