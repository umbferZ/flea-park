
<%
    
%>
<!-- form for to choose Regione -->
<div class="row">
	<div class="col s12 m4">
		<div class="card-panel center">
			<span class="card-title lighten">Please choose your place</span>
		</div>
	</div>
	<div class="col s12 m8">
		<div class="card ">
			<div class="card-content">
				<div class="card-title">Select your place</div>
			</div>
			<div class="card-action center">
				<div>
					<div class="input-field col s12">
						<form method="get" name="regioni">
							<input type="hidden" name="chooseRegione" value="true" />
							<select name="regioni_id" required="required" id="slc_regioni">
								<option value="" disabled selected>Choose regione</option>
								<option value="1">Regione1</option>
								<option value="2">Regione1dfg</option>
							</select> <label>Regioni</label>
						</form>
					</div>
					<div class="input-field col s12 notVisible" id="slc_province">
						<form method="get" name="province">
							<input type="hidden" name="chooseProvince" value="true" />
							<select name="province_id" required="required">
								<option value="" disabled selected>Choose provincia</option>
								<option value="1">Provincia1</option>
								<option value="2">Provincia1dfg</option>
							</select> <label>Province</label>
						</form>
					</div>
					<div class="input-field col s12 notVisible" id="slc_comuni">
						<form method="get" name="comuni">
							<input type="hidden" name="chooseComune" value="true" />
							<select name="comune_id" required="required">
								<option value="" disabled selected>Choose comune</option>
								<option value="1">Comune1</option>
								<option value="3">Comune1dfgd</option>
							</select> <label>Comuni</label>
						</form>
					</div>
				</div>
				<div class="input-field col s12 notVisible" id="btn_submit_place">
					<form method="get" name="comuni">
						<button class="btn" type="submit" name="btn_submit_place" value="true">
							<i class="material-icons">send</i>
						</button>
					</form>
				</div>
				<p class="right-align">
					<i class="material-icons">place</i>
				</p>
			</div>
		</div>
	</div>
</div>
<script type='text/javascript' src='js/jquery-2.2.0.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#slc_regioni").change(function() {
			$("#slc_province").removeClass("notVisible");
			$("#slc_comuni").addClass("notVisible");
			$("#btn_submit_place").addClass("notVisible");
		});
		$("#slc_province").change(function() {
			$("#slc_comuni").removeClass("notVisible");
			$("#btn_submit_place").addClass("notVisible");
		});
		$("#slc_comuni").change(function() {
			$("#btn_submit_place").removeClass("notVisible");
		});
	});
</script>