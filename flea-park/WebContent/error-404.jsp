<%@ page language="java" isErrorPage="true" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Flea Park - Page not found</title>
<jsp:include page="includes/link.jsp"></jsp:include>
</head>
<body class="grey lighten-4">
	<jsp:include page="/modules/mod_bar/barNav.jsp"></jsp:include>
	<div class="container">
		<div class="row">
			<div class="col s12 l6 offset-l3">
				<div class="card">
					<div class="card-image">
						<img alt="page not founf" src="http://cliparts.co/cliparts/qcB/or5/qcBor5jpi.png">
					</div>
					<div class="card-content">
						<span class="card-title">Page not found - error 404</span>
						<p>
							<b>Error code:</b> ${pageContext.errorData.statusCode}
						</p>
						<p>
							<b>Request URI:</b> ${pageContext.request.scheme}://${header.host}${pageContext.errorData.requestURI}
						</p>
					</div>
				</div>
			</div>
		</div>
	</div>
	<jsp:include page="includes/script.jsp"></jsp:include>
</body>
</html>
