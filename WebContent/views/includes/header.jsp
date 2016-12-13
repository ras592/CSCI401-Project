<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="store.business.User" %>
<!DOCTYPE html>
<html>
	<% 
    	User current_user = (User)request.getSession().getAttribute("current_user");
		Boolean authenticated = false;
		int role_id = 1;
		String first_name = "";
		
		if (current_user != null) {
    		first_name = current_user.getFirstName();
    		authenticated = true;
    		role_id = current_user.getRole_id();
		}
    	
	%>

    <head>
        <title>Fastr Sale</title>

        <!-- Bootstrap CDN -->
        <!-- <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous"> -->
        <link rel="stylesheet" href="./lib/bootstrap-3.3.7/css/bootstrap.min.css" />
        <!-- Custom CSS -->
        <link rel="stylesheet" href="./css/main.css" />
    </head>
    <body>
        <div class="navbar navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
	                <a class="navbar-brand" href="./">
	                    <img src="./img/run.svg" alt="FastrSale Logo" class="logo_banner">
	                </a>
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="./">Fastr Sale</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <%  if (authenticated) { %>
                        <li><a href="./products">Browse Products</a></li>
                        	<%  if (role_id == 2) { %>
                        	<li class="dropdown">
	                        	<a href="#" class="dropdown-toggle" data-toggle="dropdown">Store Account <b class="caret"></b></a>
	                            <ul class="dropdown-menu">
	                        		<li><a href="./store_account">Inventory Management</a></li>
	                        		<li><a href="./add_product">Add Product</a></li>
	                        	</ul>
                        	</li>
                        	<% } %>
                        <% } %>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%  if (authenticated) { %>
                        <!-- if user is authenticated -->
				        <li id="shopping-cart" class="dropdown">
				          <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"> <span class="glyphicon glyphicon-shopping-cart"></span> <span id="shopping-quantity">0</span> <span class="caret"></span></a>
				          <ul id="shopping-cart" class="dropdown-menu dropdown-cart" role="menu">
				              <li class="divider"></li>
				              <li><a class="text-center" href="./view_cart">View Cart</a></li>
				          </ul>
				        </li>
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Account <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Change Password</a></li>
                                <li><a href="#">Change Email</a></li>
                                <li><a href="./logout">Sign Out</a></li>
                            </ul>
                        </li>
                        <% } else { %>
                        <!-- if user is not authenticated -->
                        <li><a href="./registration">Sign Up</a></li>
                        <li><a href="./login">Sign In</a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </div>