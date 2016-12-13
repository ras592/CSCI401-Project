package store.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import store.business.Category;
import store.business.Store;
import store.utility.MysqlCon;

import com.google.gson.Gson;

public class CategoryAPIController  extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) {
		List<Category> categories = MysqlCon.getAllCategories();
	    String json = new Gson().toJson(categories);

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
