package store.business;

public class Status {
	private String status;
	
	public Status() {}
	
	public Status(String status) {
		this.setStatus(status);
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
