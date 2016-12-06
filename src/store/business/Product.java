package store.business;

import java.io.Serializable;
//import java.util.ArrayList;

public class Product implements Serializable {
	private int productId;
	private String productName;
	private String description;
	private double price;
	private String[] productImageURLs;
	private int userId;
	private int storeId;
	
	public Product() {}

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String[] getProductImageURLs() {
		return productImageURLs;
	}

	public void setProductImageURLs(String[] productImageURLs) {
		this.productImageURLs = productImageURLs;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
}
