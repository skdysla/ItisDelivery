package admin.blackList;

public class BlackDTO {
	String id,during;
	int count;
	
	public BlackDTO(String id, int count, String during) {
		this.id = id;
		this.count = count;
		this.during = during;
	}
	public BlackDTO() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public String getDuring() {
		return during;
	}
	public void setDuring(String during) {
		this.during = during;
	}
	
}
