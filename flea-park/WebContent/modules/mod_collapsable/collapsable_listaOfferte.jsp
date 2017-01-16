<div class="row">
	<div class="col s3">
		<div class="card-panel">Istruzioni</div>
	</div>
	<div class="col s9">
		<ul class="collapsible popout" data-collapsible="accordion">
			<%
			    for (int i = 0; i < 10; i++) {
			%>
			<li>
				<div class="collapsible-header">
					<div class="row">
						<div class="col s12 m2">
							<i class="material-icons">filter_drama</i>nome
						</div>
						<div class="col s12 m2">prezzo</div>
						<div class="col s12 m2">pubblica/privata</div>
						<div class="col s12 m2">attiva/scaduta</div>
						<div class="col s12 m2">target</div>
						<div class="col s12 m1">#v</div>
						<div class="col s12 m1">#p</div>
					</div>
				</div>
				<div class="collapsible-body container">
					<div class="row">
						<div class="col s12 m3">Struttura</div>
						<div class="col s12 m3">servizi + prezzo</div>
						<div class="col s12 m3">prezzo</div>
						<div class="col s12 m3">qualcosa</div>
					</div>
					<div class="row">
						<div class="col s12 m3">Struttura</div>
						<div class="col s12 m3">servizi + prezzo</div>
						<div class="col s12 m3">prezzo</div>
						<div class="col s12 m3">qualcosa</div>
					</div>
				</div>
			</li>
			<%
			    }
			%>
		</ul>
	</div>
</div>