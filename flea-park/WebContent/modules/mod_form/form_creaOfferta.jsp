<div class="row">
	<div class="col s3">
		<div class="card-panel">Istruzioni</div>
	</div>
	<div class="col s9">
		<div class="card">
			<div class="card-content">
				<div class="card-title">Nuova offerta</div>
			</div>
			<div class="card-action contaier">
				<form method="get">
					<div class="row">
						<div class="col s12 m6 input-field">
							<i class="material-icons prefix">edit</i>
							<input type="text" name="name" id="name" required="required">
							<label class="active" for="name">name</label>
						</div>
						<div class="col s12 m6 input-field">
							<select name="target_id[]" multiple="multiple" required="required">
								<option value="" disabled selected>Scegli target</option>
								<option value="1">target 1</option>
								<option value="2">target 2</option>
							</select> <label>Target</label>
						</div>
						<div class="input-field col s12 m6">
							<i class="material-icons prefix">today</i>
							<input type="date" class="datepicker validate" id="checkin" name="checkin" required="required">
							<label class="active" for="checkin">Checkin</label>
						</div>
						<div class="input-field col s12 m6">
							<i class="material-icons prefix">today</i>
							<input type="date" class="datepicker validate" id="checkout" name="checkout" required="required">
							<label class="active" for="checkin">Checkout</label>
						</div>
						<div class="input-field col s12">
							<select name="struttura_id" required="required" id="slc_struttura">
								<option value="" disabled selected>Scegli Struttura</option>
								<option value="1">struttura1</option>
								<option value="2">struttura2</option>
							</select> <label>Strutture</label>
						</div>
						<div class="input-field col s12 notVisible" id="slc_servizi">
							<select name="servizi_id[]" multiple="multiple" required="required">
								<option value="" disabled selected>Scegli servizi</option>
								<option value="1">servizio 1</option>
								<option value="2">servizio 2</option>
							</select> <label>Servizi</label>
						</div>
						<div class="col s12 m2 center input-field">
							<input type="checkbox" id="cb_visibility" />
							<label for="cb_visibility">Pubblica</label>
						</div>
						<div class="col s12 m8 input-field notVisible" id="range">
							<p class="range-field">
								<input type="range" id="test5" min="0" max="100" />
							</p>
						</div>
						<div class="col s12 center input-field">
							<button class="btn" type="submit" value="true" name="creaOfferta">Crea</button>
						</div>
					</div>
				</form>
				<p>
					<i class="material-icons">home</i>
				</p>
			</div>
		</div>
	</div>
</div>
<script type='text/javascript' src='js/jquery-2.2.0.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#slc_struttura").change(function() {
			$("#slc_servizi").show();
			$("#btn_submit_place").addClass("notVisible");
		});
		$("#cb_visibility").change(function() {
			$("#range").slideToggle();
		});
	});
</script>