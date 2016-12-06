package store.business;

import java.io.Serializable;

public class Store implements Serializable {
	private int storeId;
	private String storeName;
	private int[] productIds;
	private int userId;
	
	public Store() {}
	
	public Store(int storeId, String storeName, int userId) {
		this.storeId = storeId;
		this.storeName = storeName;
		this.userId = userId;
	}
	
	public int getStoreId() {
		return storeId;
	}
	public void setStoreId(int storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public int[] getProductIds() {
		return productIds;
	}
	public void setProductIds(int[] productIds) {
		this.productIds = productIds;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
}
