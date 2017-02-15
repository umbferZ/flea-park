<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<footer class="page-footer">
	<div class="container">
		<div class="row">
			<div class="col l3 s12 center">
				<h5 class="">Change language</h5>
				<ul>
					<li>
						<a href="?language=en">English</a>
					</li>
					<li>
						<a href="?language=it">Italiano</a>
					</li>
					<li>
						<a href="?language=es">Español</a>
					</li>
					<li>
						<a href="?language=de">Deutsch</a>
					</li>
				</ul>
			</div>
			<div class="col l6 s12 center">
				<h5>second menu</h5>
			</div>
			<div class="col l3 s12 center">
				<h5>another menù</h5>
			</div>
		</div>
	</div>
	<div>
		<jsp:include page="/includes/cardSession.jsp"></jsp:include>
	</div>
	<div class="footer-copyright">
		<div class="container center">
			based on
			<a class="grey-text text-lighten-4" href="http://materializecss.com/about.html" target="on_blank">materialize CSS</a>
		</div>
	</div>
</footer>