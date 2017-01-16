<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="com.fleaPark.tools.debug.Message4Debug"%>
<%
/*     String keyword = "";
			String checkin = "";
			String checkout = "";
			String result = "";
			if (request.getParameter("search") != null) {
				keyword = searchBean.getKeyword();
				checkin = searchBean.getCheckin();
				checkout = searchBean.getCheckout();

			} */
%>
<div id="barSearch" class="barSearch notVisible row">
	<div class="right-align col s12">
		<i class="material-icons waves-effect tiny" id="icon_close_barSearch">close</i>
	</div>
	<div class="row col s12">
		<form method="post" action="">
			<div class="input-field col s12 m7">
				<i class="material-icons prefix">mode_edit</i>
				<input type="text" class="validate" id="keyword" name="keyword" required="required" value="">
				<label class="active" for="keyword">Keyword</label>
			</div>
			<div class="input-field col s12 m2">
				<i class="material-icons prefix">today</i>
				<input type="date" class="datepicker validate" id="checkin" name="checkin" required="required" value="">
				<label class="active" for="checkin">Checkin</label>
			</div>
			<div class="input-field col s12 m2">
				<i class="material-icons prefix">today</i>
				<input type="date" class="datepicker validate" id="checkout" name="checkout" required="required" value="">
				<label class="active" for="checkin">Checkout</label>
			</div>
			<div class="input-field col s12 m1 center">
				<button class="btn" type="submit" name="search" value="ok">
					<i class="material-icons">search</i>
				</button>
			</div>
		</form>
	</div>
</div>
<%-- 	<div><%=result%></div> --%>
<script type='text/javascript' src='js/jquery-2.2.0.js'></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#btn_search").click(function() {
			$("#barSearch").slideToggle();

		});
		$("#icon_close_barSearch").click(function() {
			$("#barSearch").slideToggle();

		});

	});
</script>
