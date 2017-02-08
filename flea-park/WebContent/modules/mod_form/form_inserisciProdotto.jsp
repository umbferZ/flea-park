<%@page import="com.fleaPark.application.controls.ricerca.BeanCategoria"%>
<jsp:useBean id="beanCat" class="com.fleaPark.application.controls.ricerca.BeanCategoria"></jsp:useBean>
<div class="row">
	<div class="col s12 m3">
		<div class="card-panel">Istruzioni</div>
	</div>
	<div class="col s12 m6">
		<form method="get">
			<div class="card">
				<div class="card-image">
					<img alt="default-image" src="https://maxcdn.icons8.com/app/uploads/2016/02/material-icons-1.png" class="responsive-image">
				</div>
				<div class="card-action contaier">
					<div class="row">
						<div class="col s12 input-field">
							<i class="material-icons prefix">edit</i>
							<input type="text" name="nome" id="nome" required="required">
							<label class="active" for="nome">Nome</label>
						</div>
						<div class="col s12 input-field">
							<i class="material-icons prefix">attach_money</i>
							<input type="text" name="prezzo" id="prezzo" required="required">
							<label class="active" for="prezzo">prezzo</label>
						</div>
						<div class="file-field input-field col s12">
							<div class="btn">
								<span>Foto</span>
								<input type="file" multiple name="foto[]">
							</div>
							<div class="file-path-wrapper">
								<input class="file-path validate" type="text" placeholder="Upload one or more files">
							</div>
						</div>
						<div class="col s12 input-field">
							<select name="categoria" required="required">
								<option value="" disabled selected>Scegli una categoria</option>
								<%
								    for (BeanCategoria b : beanCat.getCategorie()) {
								%>
								<option value="<%=b.getIdCategoria()%>"><%=b.getNome()%></option>
								<%
								    }
								%>
							</select>
						</div>
						<div class="input-field col s12">
							<textarea id="textarea" class="materialize-textarea" data-length="120"></textarea>
							<label for="textarea">Descrizione</label>
						</div>
						<div class="col s12 center input-field">
							<button class="btn" type="submit" value="true" name="inserisciProdotto">Inserisci prodotto</button>
						</div>
					</div>
					<p>
						<i class="material-icons">home</i>
					</p>
				</div>
			</div>
		</form>
	</div>
</div>