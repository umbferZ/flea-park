<%@page import="org.umbZfer.debug.Message4Debug"%>
<jsp:useBean id="beanDiAccesso" class="com.fleaPark.application.controls.accesso.BeanDiAccesso"></jsp:useBean>
<jsp:setProperty property="nome" name="beanDiAccesso" />
<jsp:setProperty property="cognome" name="beanDiAccesso" />
<jsp:setProperty property="email" name="beanDiAccesso" />
<jsp:setProperty property="password" name="beanDiAccesso" />
<%
    if (request.getParameter("accedi") != null) {
        if (beanDiAccesso.accedi()) {
            session.setAttribute("utente", beanDiAccesso);
            response.sendRedirect("index.jsp");
        }
    }
%>
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