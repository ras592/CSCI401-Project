<jsp:include page="/views/includes/header.jsp" />
<%@ page import="store.business.User" %>
<%@ page import="store.business.Category" %>
<%@ page import="store.business.Product" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="store.utility.MysqlCon" %>
<%@ page import="store.utility.RoutingUtility" %>
<% 
	User current_user = (User)request.getSession().getAttribute("current_user");
	Boolean authenticated = false;
	int role_id = 1;
	String first_name = "Stranger";
	
	if (current_user != null) {
		first_name = current_user.getFirstName();
		authenticated = true;
		role_id = current_user.getRole_id();
	}
	ArrayList<ArrayList<Product>> frontPageList = new ArrayList<ArrayList<Product>>();
	ArrayList<Category> categories = MysqlCon.getAllCategories();
	for(int i = 0; i < categories.size(); i++) {
		frontPageList.add(MysqlCon.getAllProductsByCategory(categories.get(i).getCategoryId()));
	} 
%>
        <div class="container">
            <div class="row">
                <h1><%= "Hello, " + first_name + "!" %></h1>
            </div>
            <% for (int i = 0; i < categories.size(); i++) { %>
            <div class="row">
            	<% if(frontPageList.get(i).size() > 0) { %>
            	<h2><%= categories.get(i).getCategoryName() %></h2>
            	<% } %>
            	<% for(int j = 0; j < frontPageList.get(i).size(); j++) { 
						if(j > 2) {
							break;
						}
						Product productObj = frontPageList.get(i).get(j);
            	%>
            	<%= "<div class=\"col-sm-6 col-md-4 product\">" %>
            	<%= "<div class=\"thumbnail\">" %>
            	<%= "<img src=\"" + RoutingUtility.toImageURL(productObj.getProductImageURLs()) + "\" alt=\"product image\" class=\"product thumbnail\">" %>
            	<%= "<div class=\"caption\"><h3 class=\"product_name\">" + productObj.getProductName() + "</h3>"%>
				<%= "<p>" + productObj.getDescription() + "</p><p>" + RoutingUtility.toBuyButton(productObj) + "</p></div></div></div>"%>
				<% } %>
            </div>
           <% } %>
        </div>
        
<script>
	var initProductsObj = {
		init : true
	};
</script>
<jsp:include page="/views/includes/footer.jsp" />
