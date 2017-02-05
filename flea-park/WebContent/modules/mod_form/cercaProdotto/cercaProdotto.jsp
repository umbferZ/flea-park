
<form method="post" id="cerca" name="cerca">
	<div class="row">
		<div class="input-field">
			<input id="search" type="search" name="prodotto" required>
			<label class="label-icon" for="search"> <i class="material-icons">search</i></label> <i class="material-icons">close</i>
		</div>
	</div>
</form>
<script type='text/javascript' src='js/jquery-2.2.0.js'></script>
<script type="text/javascript">
	$(document).ready(function() {

		var form = $('#cerca');
		form.on('submit', function(e) {
			e.preventDefault();
			$.ajax({
				type : 'POST',
				url : 'modules/mod_form/cercaProdotto/controller.jsp',
				data : form.serialize(),
				dataType : 'html',
				success : function(data) {
					$('#content').html(data);
				}
			});

		});
	});
</script>
