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
        <div class="container">
            <div class="row">
                <h1><%= "Hello, " + first_name + "!" %></h1>
            </div>
            <div class="row">
                <h2>Highlighted Products</h2>
              <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                  <img src="http://placehold.it/192x200" alt="product image" class="thumbnail">
                  <div class="caption">
                    <h3>Product 1</h3>
                    <p>Sample Product Description blah blah blah. Sample Product Description blah blah blah. Sample Product Description blah blah blah.</p>
                    <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                  <img src="http://placehold.it/192x200" alt="product image" class="thumbnail">
                  <div class="caption">
                    <h3>Product 2</h3>
                    <p>Sample Product Description blah blah blah. Sample Product Description blah blah blah. Sample Product Description blah blah blah.</p>
                    <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                  </div>
                </div>
              </div>
              <div class="col-sm-6 col-md-4">
                <div class="thumbnail">
                    <img src="http://placehold.it/192x200" alt="product image" class="thumbnail">
                  <div class="caption">
                    <h3>Product 3</h3>
                    <p>Sample Product Description blah blah blah. Sample Product Description blah blah blah. Sample Product Description blah blah blah.</p>
                    <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p>
                  </div>
                </div>
              </div>
            </div>
        </div>
<jsp:include page="/views/includes/footer.jsp" />
