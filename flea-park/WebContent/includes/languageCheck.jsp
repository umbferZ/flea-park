
<%
    if (session.getAttribute("language") == null) {
        session.setAttribute("language", request.getLocale().getLanguage());
    }
    if (request.getParameter("language") != null) {
        session.setAttribute("language", request.getParameter("language"));
    }
%>