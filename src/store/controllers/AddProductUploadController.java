package store.controllers;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import store.business.Store;
import store.utility.FileUtility;
import store.utility.MysqlCon;

@MultipartConfig(maxFileSize = 1600000000)
public class AddProductUploadController extends HttpServlet {
	
	public AddProductUploadController() {
		super();
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String productName = request.getParameter("productName");
		String description = request.getParameter("description");
		double price = Double.parseDouble(request.getParameter("price"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		int categoryId = Integer.parseInt(request.getParameter("category"));
		String fileName = "";
		
	 	try{
		 	Part filePart = request.getPart("product_image");
		 	String fileType = filePart.getContentType();
		 	InputStream inputStream = null;
		 	if(filePart != null){
			 	inputStream = filePart.getInputStream();
			 	byte[] buffer = new byte[8 * 1024];
                
                try {
                	File uploadFile = null;
                	if (fileType.contains("image/jpeg")) {
                		fileName = FileUtility.uniqueFileName() + ".jpg";
                		uploadFile = new File(fileName);
                	} else if (fileType.contains("image/png")) {
                		fileName = FileUtility.uniqueFileName() + ".png";
                		uploadFile = new File(fileName);
                	}
                	if (uploadFile != null) {
	                	OutputStream output = new FileOutputStream(uploadFile);
	                	try {
	                		int bytesRead;
	                		while ((bytesRead = inputStream.read(buffer)) != -1) {
	                			output.write(buffer, 0, bytesRead);
	                		}
	                	} finally {
	                		output.close();
	                	}
                	}
                } finally {
                	inputStream.close();
                }
		 	}
	 	} catch (Exception ex) {
	    	System.out.println(ex);
	    	String url = "/views/add_product.jsp";
			System.out.println("add product upload error redirect to: " + url);
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
			dispatcher.forward(request,response);
	    }
	 	
	 	Store currentStore = (Store)request.getSession(false).getAttribute("current_store");
	 	
	 	MysqlCon.insertProduct(productName, description, price, quantity, fileName, currentStore.getStoreId(), categoryId);
	 	
	 	String url = "/views/inventory.jsp"; // CHANGE TO INVENTORY
		System.out.println("add product success redirect to: " + url);
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher(url);
		dispatcher.forward(request,response);
	}
}
