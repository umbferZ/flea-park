
<%
String[] h3 = new String[] { "Flea Park", "Tutto quello che vuoi" };
String[] h5 = new String[] { "Dai nuova vita alle tue cose" };
String[] caption = new String[] { "right", "left", "center" };
%>
<div class="slider">
	<ul class="slides">
		<%
		    for (int i = 0; i < 4; i++) {
		%>
		<li>
			<img src="images/slider/slide_<%=i%>.jpg">
			<div class="caption <%=caption[i % caption.length]%>-align">
				<h2><%=h3[i % h3.length]%></h2>
				<h4 class="light grey-text text-lighten-3"><%=h5[i % h5.length]%></h4>
			</div>
		</li>
		<%
		    }
		%>
	</ul>
</div>