<%@ page import="store.business.User" %>
<%@ page import="store.business.Category" %>
<%@ page import="store.utility.MysqlCon" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<jsp:include page="/views/includes/header.jsp"></jsp:include>
	<%
    	
		ArrayList<Category> categories = MysqlCon.getAllCategories();

	%>
<div class="container">
	<h3>Add a New Product</h3>
    <form action="/FastrSale/add_product_upload" method="POST" enctype="multipart/form-data"
        class="form-horizontal">
        <div class="form-group">
            <label for="productName" class="col-sm-2 control-label">Product Name</label>
            <div class="col-sm-10">
                <input type="text" class="form-control" id="productName" name="productName" placeholder="Product Name">
            </div>
        </div>
        <div class="form-group">
            <label for="description" class="col-sm-2 control-label">Description</label>
            <div class="col-sm-10">
                <textarea class="form-control" id="description" name="description" rows="3"></textarea>
            </div>
        </div>
        <div class="form-group">
            <label for="price" class="col-sm-2 control-label">Price</label>
            <div class="col-sm-10">
                <div class="input-group">
                    <div class="input-group-addon">$</div>
                    <input type="number" class="form-control" id="price" name="price" step="any" placeholder="9.99">
                </div>
            </div>
        </div>
        <div class="form-group">
            <label for="quantity" class="col-sm-2 control-label">Quantity</label>
            <div class="col-sm-10">
                <input type="number" class="form-control" id="quantity" name="quantity" placeholder="1">
            </div>
        </div>
        <div class="form-group">
        	<label for="category" class="col-sm-2 control-label">Category</label>
        	<div class="col-sm-10">
	            <select name="category" class="form-control">
	                <% for(int i = 0; i < categories.size(); i++) { %>
	                <option value="<%= categories.get(i).getCategoryId() %>"><%= categories.get(i).getCategoryName() %></option>
	                <%  } %>
	            </select>
            </div>
        </div>
        <div class="form-group">
        	<label for="product_image" class="col-sm-2 control-label">Product Image</label>
        	<div class="col-sm-10">
	        	<input type="file" id="product_image" name="product_image" accept="image/png,image/jpeg"/>
	        	<p class="help-block">Allowed file uploads jpg and png.</p>
        	</div>
        </div>
        <div class="form-group">
			<div class="col-sm-offset-2 col-sm-10">
				<button type="submit" class="btn btn-default">Add Product</button>
			</div>
		</div>
    </form>
</div>
<jsp:include page="/views/includes/footer.jsp" />
