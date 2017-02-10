<ul id="slide-out" class="side-nav">
	<li>
		<div class="userView">
			<div class="background">
				<img src="${utente.fotoCopertina }">
			</div>
			<a href="#!user">
				<img class="circle waves-effect waves-circle" src="${utente.fotoProfilo }">
			</a>
			<span class="name">${utente.nome} ${utente.cognome}</span>
			<span class="email">${utente.email}</span>
		</div>
	</li>
	<li>
		<a href="?iMieiProdotti=show">
			<i class="material-icons right">settings</i>I miei prodotti
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="?iMieiAcquisti=show">
			<i class="material-icons right">settings</i>I miei acquisti
		</a>
	</li>
	<li class="divider"></li>
	<li>
		<a href="index.jsp?logout=true">
			<i class="material-icons right">exit_to_app</i>Esci
		</a>
	</li>
</ul>
<script type='text/javascript' src='js/jquery-2.2.0.js'></script>
<script type="text/javascript">
	$(document).ready(
			function() {
				var imageUrl = $('.background').find('img').attr('src');
				$('.background').css(
						{
							'height' : '100%',
							'width' : '100%',

							'background' : 'url("' + imageUrl
									+ '") repeat scroll 50% 50% / cover'
						});
			});
</script>
