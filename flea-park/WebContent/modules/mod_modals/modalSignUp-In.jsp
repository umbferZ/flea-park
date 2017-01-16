<%@page import="org.apache.jasper.tagplugins.jstl.core.Redirect"%>
<%@page import="com.fleaPark.tools.debug.Message4Debug"%>
<div id="signUp" class="modal">
	<%
// 	    if (request.getParameter("signUp") != null) {
// 	        signUpBean.signUp();
// 	        response.sendRedirect("index.jsp");    
// 	    }
// 	    if (request.getParameter("signIn") != null) {
// 	        if (signUpBean.signIn()) {
// 	            session.setAttribute("user", signUpBean);
// 	            response.sendRedirect("index.jsp");
// 	        }
// 	    }
	%>
	<div class="modal-content">
		<form method="post" action="index.jsp">
			<div class="row">
				<div class="col s6 input-field">
					<i class="material-icons prefix">person</i>
					<input type="text" class="validate" id="firstName" name="firstName" required="required"></input>
					<label class="active" for="firstName">First name</label>
				</div>
				<div class="col s6 input-field">
					<i class="material-icons prefix">person</i>
					<input type="text" class="validate" id="lastName" name="lastName" required="required"></input>
					<label class="active" for="lastName">Last name</label>
				</div>
				<div class="col s6 input-field">
					<i class="material-icons prefix">email</i>
					<input type="email" class="validate" id="email" name="email" required="required"></input>
					<label class="active" for="email">email</label>
				</div>
				<div class="col s6 input-field">
					<i class="material-icons prefix">lock</i>
					<input type="password" class="validate" id="password" name="password" required="required"></input>
					<label class="active" for="password">password</label>
				</div>
				<div class="col input-field right">
					<button class="btn" type="submit" value="true" name="signUp">Sign up for Flea Park</button>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer modal-fixed-footer container">
		<div class="container center">
			By clicking "Sign up for Flea Park", you agree to our <a href="#!" class="modal-action modal-close">term of service</a> and <a href="#!" class="modal-action modal-close ">privacy police</a>
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
					<label class="active" for="email">email</label>
				</div>
				<div class="col s12 input-field">
					<i class="material-icons prefix">lock</i>
					<input type="password" class="validate" id="password" name="password" required="required"></input>
					<label class="active" for="password">password</label>
				</div>
				<div class="col input-field right">
					<button class="btn" type="submit" value="true" name="signIn">Sign In</button>
				</div>
			</div>
		</form>
	</div>
	<div class="modal-footer modal-fixed-footer">
		<a href="#!" class="modal-action modal-close btn-flat ">Forgot password?</a>
	</div>
</div>