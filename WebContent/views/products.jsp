<%@ page import="store.business.Category" %>
<%@ page import="store.utility.MysqlCon" %>
<%@ page import="java.util.ArrayList" %>
<jsp:include page="/views/includes/header.jsp"></jsp:include>
<%
   	
	ArrayList<Category> categories = MysqlCon.getAllCategories();

%>

<div id="search" class="container">
	<div class="row">    
        <div class="col-xs-8 col-xs-offset-2">
		    <div class="input-group">
                <div class="input-group-btn search-panel">
                    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
                    	<span id="search_concept">Filter by</span> <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu" role="menu">
	                   	<% for(int i = 0; i < categories.size(); i++) { %>
	               		<li><a class="category_search" data-value="<%= categories.get(i).getCategoryId() %>"><%= categories.get(i).getCategoryName() %></a></li>
	               		<%  } %>
                      <li class="divider"></li>
                      <li><a class="category_search" data-value="all">Anything</a></li>
                    </ul>
                </div>
                <input type="text" class="form-control" id="search" placeholder="Product Name...">
                <span class="input-group-btn">
                    <button class="btn btn-default" id="search_button" type="button"><span class="glyphicon glyphicon-search"></span></button>
                </span>
            </div>
        </div>
	</div>
</div>
<div id="products" class="container"></div>
<script>
	var initProductsObj = {
		init : true,
		param : 'default'
	};
</script>
<jsp:include page="/views/includes/footer.jsp" />