<%@page import="org.apache.jasper.tagplugins.jstl.core.Redirect"%>
<%@page import="com.fleaPark.tools.debug.Message4Debug"%>
<div id="signUp" class="modal">
	<jsp:useBean id="beanDiAccesso" class="com.fleaPark.application.beans.BeanDiAccesso"></jsp:useBean>
	<jsp:setProperty property="nome" name="beanDiAccesso" />
	<jsp:setProperty property="cognome" name="beanDiAccesso" />
	<jsp:setProperty property="email" name="beanDiAccesso" />
	<jsp:setProperty property="password" name="beanDiAccesso" />
	<%
	    if (request.getParameter("registrati") != null) {
	        beanDiAccesso.registrati();
	        response.sendRedirect("index.jsp");
	    }
	    if (request.getParameter("accedi") != null) {
	        if (beanDiAccesso.accedi()) {
	            session.setAttribute("utente", beanDiAccesso);
	            response.sendRedirect("index.jsp");
	        }
	    }
	%>
	<div class="modal-content">
		<form method="post" action="index.jsp">
			<div class="row">
				<div class="col s6 input-field">
					<i class="material-icons prefix">person</i>
					<input type="text" class="validate" id="nome" name="nome" required="required"></input>
					<label class="active" for="nome">Nome</label>
				</div>
				<div class="col s6 input-field">
					<i class="material-icons prefix">person</i>
					<input type="text" class="validate" id="cognome" name="cognome" required="required"></input>
					<label class="active" for="cognome">Cognome</label>
				</div>
				<div class="col s6 input-field">
					<i class="material-icons prefix">email</i>
					<input type="email" class="validate" id="email" name="email" required="required"></input>
					<label class="active" for="email">Email</label>
				</div>
				<div class="col s6 input-field">
					<i class="material-icons prefix">lock</i>
					<input type="password" class="validate" id="password" name="password" required="required"></input>
					<label class="active" for="password">Password</label>
				</div>
				<div class="col input-field right">
					<button class="btn" type="submit" value="true" name="registrati">Registrami su Flea Park</button>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer modal-fixed-footer container">
		<div class="container center">
			Cliccando "Registrami su Flea Park" accetti i nostri <a href="#!" class="modal-action modal-close">terminini di servizio</a> e la nostra <a href="#!" class="modal-action modal-close ">politica di privacy</a>
		</div>
	</div>
</div>
<div id="signIn" class="modal">
	<div class="modal-content">
		<form method="post" action="index.jsp">
			<div class="row">
				<div class="col s12 input-field">
					<i class="material-icons prefix">email</i>
					<input type="email" class="validate" id="email" name="email" required="required"></input>
					<label class="active" for="email">Email</label>
				</div>
				<div class="col s12 input-field">
					<i class="material-icons prefix">lock</i>
					<input type="password" class="validate" id="password" name="password" required="required"></input>
					<label class="active" for="password">Password</label>
				</div>
				<div class="col input-field right">
					<button class="btn" type="submit" value="true" name="accedi">Accedi</button>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer modal-fixed-footer">
		<a href="#!" class="modal-action modal-close btn-flat ">Password dimenticata?</a>
	</div>
</div>