<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Flea Park - myCart</title>
<jsp:include page="includes/link.jsp"></jsp:include>
</head>
<body>
	<jsp:include page="/modules/mod_bar/barNav.jsp"></jsp:include>
	<div id="content">
		<div class="row">
			<div class="col s9">
				<div class="container ">
					<div class="row">
						<%
						    // TODO controllo se ci sono elementi nel carrello 
						    for (int i = 0; i < 10; i++) {
						%>
						<jsp:include page="/modules/mod_card/cardItemCart.jsp">
							<jsp:param value="<%=i%>" name="id" />
						</jsp:include>
						<%
						    }
						%>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="/modules/mod_card/cardCartIndicator.jsp"></jsp:include>
	<jsp:include page="modules/mod_footer/footer.jsp" />
	<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>