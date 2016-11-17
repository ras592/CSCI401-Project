package store.business;

import java.io.Serializable;

public class Store implements Serializable {
	private Long storeId;
	private String storeName;
	private Long[] productIds;
	private Long userId;
	
	public Store() {}
	
	public Long getStoreId() {
		return storeId;
	}
	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}
	public String getStoreName() {
		return storeName;
	}
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}
	public Long[] getProductIds() {
		return productIds;
	}
	public void setProductIds(Long[] productIds) {
		this.productIds = productIds;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
}
