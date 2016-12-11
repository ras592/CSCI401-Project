package store.business;

import java.io.Serializable;
//import java.util.ArrayList;

public class Product implements Serializable {
	private static final long serialVersionUID = 1L;
	private int productId;
	private String productName;
	private String description;
	private double price;
	private int quantity;
	private String productImageURLs;
	private int categoryId;
	private int storeId;
	
	public Product() {}
	
	public Product(int productId, String productName, String description,
			double price, int quantity, String productImageURLs,
			int storeId, int categoryId) {
		this.productId = productId;
		this.productName = productName;
		this.description = description;
		this.price = price;
		this.quantity = quantity;
		this.productImageURLs = productImageURLs;
		this.storeId = storeId;
		this.categoryId = categoryId;
	}

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

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getProductImageURLs() {
		return productImageURLs;
	}

	public void setProductImageURLs(String productImageURLs) {
		this.productImageURLs = productImageURLs;
	}
	
	public void setProductImageURLsArray(String[] productImageURLsArray) {
		String productImageURLs = "";
		for(int i = 0; i < productImageURLsArray.length; i++) {
			productImageURLs += productImageURLsArray[i] + "|";
		}
		setProductImageURLs(productImageURLs.substring(0, productImageURLs.length() - 1)); // remove trail '|'
	}
	
	public String[] getProductImageURLsArray() {
		return productImageURLs.split("\\|");
	}

	public int getStoreId() {
		return storeId;
	}

	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	
	@Override
	public String toString() {
		return String.format("%d, %s, %s, %f, %d, %s, %d, %d\n", productId, productName, description, price, quantity, productImageURLs, categoryId, storeId);
	}
}
