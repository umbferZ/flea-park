<%@page import="com.fleaPark.application.beans.BeanCategoria"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<nav>
	<div class="nav-wrapper">
		<div class="col s12">
			<jsp:include page="/modules/mod_form/cercaProdotto/index.jsp"></jsp:include>
		</div>
	</div>
</nav>
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
