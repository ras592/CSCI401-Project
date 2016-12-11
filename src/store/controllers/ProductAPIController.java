package store.controllers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import store.utility.MysqlCon;
import store.business.Product;

public class ProductAPIController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
	    List<Product> products = new ArrayList<Product>();
	    products.add(MysqlCon.getProductById(1));
	    products.add(MysqlCon.getProductById(2));
	    String json = new Gson().toJson(products);

	    response.setContentType("application/json");
	    response.setCharacterEncoding("UTF-8");
	    try {
			response.getWriter().write(json);
		} catch (IOException e) {
			e.printStackTrace();
			response.setStatus(500);
		}
	}
}
