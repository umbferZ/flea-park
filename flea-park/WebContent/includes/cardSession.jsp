<%@page import="java.util.List"%>
<%@page import="com.fleaPark.tools.debug.Message4Debug"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    if (Message4Debug.isDebug()) {
%>
<%
    Enumeration<String> chiavi = session.getAttributeNames();
        String ses = "";
        while (chiavi.hasMoreElements()) {
            String chiave = (String) chiavi.nextElement();
            ses += "<div class='card col s9 red darken-1 white-text'>";
            ses += "<div class='card-content'>";
            ses += "session.getAttribute('" + chiave + "'): ";
            ses += session.getAttribute(chiave) + "";
            ses += "</div>";
            ses += "</div>";

        }
        chiavi = request.getAttributeNames();
        String req = "<br />";
        while (chiavi.hasMoreElements()) {
            String chiave = (String) chiavi.nextElement();
            req += "<div class='card-content col s9 green darken-3 white-text'>";
            req += "request.getAttribute('" + chiave + "'): " + request.getAttribute(chiave) + "";
            req += "</div>";

        }
        chiavi = request.getParameterNames();
        String reqp = "";
        while (chiavi.hasMoreElements()) {
            String chiave = (String) chiavi.nextElement();
            reqp += "<div class='card col s9 blue darken-3 white-text'>";
            reqp += "<div class='card-content'>";
            reqp += "request.getParameter('" + chiave + "'): ";
            reqp += request.getParameter(chiave) + "";
            reqp += "</div>";
            reqp += "</div>";

        }
%>
<div class="row container">
	<div class="col s6">
		<span class="light">SESSION</span>
		<div class="row">
			<%=ses%>
		</div>
	</div>
	<div class="col s6">
		<span class="light">REQUEST</span>
		<div class="row">
			<%=reqp%>
		</div>
	</div>
</div>
<pre class="container">
    stackTrace:
	<%
    }
    List<String> ss = Message4Debug.getStack();
    for (String s : ss)
        out.write("\n" + s);
%>
	</pre>
