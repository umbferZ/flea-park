<div class="navbar">
	<nav class="">
		<%
		    if (session.getAttribute("user") != null) {
		%>
		<!-- dropDown account -->
		<ul id="account" class="dropdown-content">
			<li><a href="#!"><i class="material-icons tiny right">dashboard</i>Profile</a></li>
			<li><a href="#!"><i class="material-icons tiny right">settings</i>Setting</a></li>
			<li><a href="index.jsp?logout=true"><i class="material-icons tiny right">exit_to_app</i>Logout</a></li>
		</ul>
		<!-- dropDown cart -->
		<ul id="cart" class="dropdown-content">
			<li><a href="cart.jsp">Cart<span class="badge"></span></a></li>
			<li><a href="#!"><i class="material-icons tiny right">settings</i>Setting</a></li>
		</ul>
		<%
		    }
		%>
		<!-- navigation men� -->
		<div class="nav-wrapper" style="padding: 0px 20px">
			<%
			    if (session.getAttribute("user") != null) {
			%>
			<a href="#" data-activates="slide-out" class="button-collapse show-on-large"><i class="mdi-navigation-menu"></i></a>
			<%
			    }
			%>
			<a href="index.jsp" class="brand-logo center">Flea Park</a>
			<ul id="nav-mobile" class="right hide-on-med-and-down">
				<li><a href="#" id="btn_search"><i class="material-icons tiny left">search</i>Search</a></li>
				<%
				    if (session.getAttribute("user") != null) {
				%>
				<li><a href="#!" class="dropdown-button" data-activates="cart"><i class="material-icons tiny left">shopping_cart </i>Cart<i class="material-icons tiny right">arrow_drop_down</i></a></li>
				<li><a href="#!" class="dropdown-button" data-activates="account"><i class="material-icons tiny left">perm_identity</i>${user.firstName} ${user.lastName}<i class="material-icons tiny right">arrow_drop_down</i></a></li>
				<%
				    } else {
				%>
				<li><a class="modal-trigger" href="#signIn"><i class="material-icons tiny left">input</i>Sing in</a></li>
				<li><a class="modal-trigger" href="#signUp"><i class="material-icons tiny left">mode_edit</i>Sing out</a></li>
				<%
				    }
				%>
			</ul>
		</div>
	</nav>
</div>
<%
    if (session.getAttribute("user") != null) {
%>
<jsp:include page="/modules/mod_sideBar/sidebar_locatorePremium.jsp"></jsp:include>\
<%
    } else {
%>
<jsp:include page="/modules/mod_modals/modalSignUp-In.jsp"></jsp:include>
<%
    }
%>
<jsp:include page="barSearch.jsp"></jsp:include>