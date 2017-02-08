<div class="navbar-fixed">
	<nav class="">
		<%
		    if (session.getAttribute("utente") != null) {
		%>
		<!-- dropDown cart -->
		<ul id="cart" class="dropdown-content">
			<li>
				<a href="cart.jsp">
					Cart
					<span class="badge"></span>
				</a>
			</li>
			<li>
				<a href="#!">
					<i class="material-icons tiny right">settings</i>Setting
				</a>
			</li>
		</ul>
		<%
		    }
		%>
		<div class="nav-wrapper" style="padding: 0px 20px">
			<%
			    if (session.getAttribute("utente") != null) {
			%>
			<a href="#" data-activates="slide-out" class="button-collapse show-on-large">
				<i class="material-icons">menu</i>
			</a>
			<jsp:include page="/components/cmp_sideBar/sidebar.jsp"></jsp:include>
			<%
			    }
			%>
			<a href="index.jsp" class="brand-logo center">Flea Park</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<%
				    if (session.getAttribute("utente") != null) {
				%>
				<li>
					<a href="#!" class="dropdown-button" data-activates="cart">
						<i class="material-icons tiny left">shopping_cart </i>Cart<i class="material-icons tiny right">arrow_drop_down</i>
					</a>
				</li>
				<%
				    } else {
				%>
				<li>
					<a class="modal-trigger" href="#signIn">
						<i class="material-icons tiny left">input</i>Accedi
					</a>
				</li>
				<li>
					<a class="modal-trigger" href="#signUp">
						<i class="material-icons tiny left">mode_edit</i>Registrati
					</a>
				</li>
				<%
				    }
				%>
			</ul>
		</div>
	</nav>
</div>
<jsp:include page="./barSearch.jsp"></jsp:include>
<%
    if (session.getAttribute("utente") == null) {
%>
<jsp:include page="/modules/mod_modals/modalSignUp-In.jsp"></jsp:include>
<%
    } else {
%>
<%
    }
%>
