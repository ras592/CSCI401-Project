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
        <link rel="stylesheet" href="lib/bootstrap-3.3.7/css/bootstrap.min.css" />
        <!-- JavaScript CDNs -->
        <!-- jQuery CDN -->
        <!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js" defer></script> -->
        <script src="lib/jquery-3.1.1.min.js" defer></script>
        <!-- Bootstrap JS CDN -->
        <!-- <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" integrity="sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa" crossorigin="anonymous" defer></script> -->
        <script src="lib/bootstrap-3.3.7/js/bootstrap.min.js" defer></script>
    </head>
    <body>
        <div class="navbar navbar-inverse" role="navigation">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                        <span class="sr-only">Toggle Navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="/FastrSale/">Fastr ecommerce</a>
                </div>
                <div class="navbar-collapse collapse">
                    <ul class="nav navbar-nav">
                        <li><a href="/FastrSale/home">Home</a></li>
                        <%  if (authenticated) { %>
                        <li><a href="/FastrSale/products">Browse Products</a></li>
                        <li><a href="/FastrSale/stores">Browse Sellers</a></li>
                        	<%  if (role_id == 2) { %>
                        	<li><a href="/FastrSale/store_account">Store Account</a></li>
                        	<% } %>
                        <% } %>
                    </ul>
                    <ul class="nav navbar-nav navbar-right">
                        <%  if (authenticated) { %>
                        <!-- if user is authenticated -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Account <b class="caret"></b></a>
                            <ul class="dropdown-menu">
                                <li><a href="#">Change Password</a></li>
                                <li><a href="#">Change Email</a></li>
                                <li><a href="/FastrSale/logout">Sign Out</a></li>
                            </ul>
                        </li>
                        <% } else { %>
                        <!-- if user is not authenticated -->
                        <li><a href="/FastrSale/registration">Sign Up</a></li>
                        <li><a href="/FastrSale/login">Sign In</a></li>
                        <% } %>
                    </ul>
                </div>
            </div>
        </div>