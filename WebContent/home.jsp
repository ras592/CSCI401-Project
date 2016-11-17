<jsp:include page="/views/includes/header.jsp" />
<%@ page import="store.business.User" %>
<% 
   	User current_user = (User)request.getSession().getAttribute("current_user");
	Boolean authenticated = false;
	String first_name = "Stranger";
	
	if (current_user != null) {
   		first_name = current_user.getFirstName();
   		authenticated = true;
	}
    	
%>
        <h1><%= "Welcome, " + first_name %>!</h1>
<jsp:include page="/views/includes/footer.jsp" />