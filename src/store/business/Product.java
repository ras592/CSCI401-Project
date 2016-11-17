package store.business;

import java.io.Serializable;
//import java.util.ArrayList;

public class Product implements Serializable {
	private Long productId;
	private String productName;
	private String description;
	private double price;
	private String[] productImageURLs;
	private Long userId;
	private Long storeId;
	
	public Product() {}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
}
