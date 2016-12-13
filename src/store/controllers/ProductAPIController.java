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
import store.business.Status;
import store.business.Store;

public class ProductAPIController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Product> products = null;
		
		if (request.getParameter("id") != null) {
			try {
				int id = -1;
				id = Integer.parseInt(request.getParameter("id"));
				if(id != -1) {
					MysqlCon.removeProduct(id);
					
					String json = new Gson().toJson(new Status("success"));
					
					response.setContentType("application/json");
				    response.setCharacterEncoding("UTF-8");
				    try {
						response.getWriter().write(json);
					} catch (IOException e) {
						e.printStackTrace();
						response.setStatus(500);
					}
				}
			} catch(Exception ex) {
				// do nothing
			}
		} else if(request.getParameter("cat") != null) {
			int requestCat = Integer.parseInt(request.getParameter("cat"));
			
			products = MysqlCon.getAllProductsByCategory(requestCat);
		    String json = new Gson().toJson(products);
	
		    response.setContentType("application/json");
		    response.setCharacterEncoding("UTF-8");
		    try {
				response.getWriter().write(json);
			} catch (IOException e) {
				e.printStackTrace();
				response.setStatus(500);
			}
		} else {
			Boolean requestStore = Boolean.parseBoolean(request.getParameter("store"));
			if (requestStore) {
				if (request.getSession(false).getAttribute("current_store") != null) {
					Store currentStore = (Store)request.getSession(false).getAttribute("current_store");
					products = MysqlCon.getAllProductsByStore(currentStore.getStoreId());
				}
			} else {
				products = MysqlCon.getAllProducts();
			}
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
}
