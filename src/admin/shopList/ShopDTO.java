package admin.shopList;

public class ShopDTO {
	String id, name, loc, tel, time, rest;
	
	public ShopDTO(String id, String name, String loc, String tel, String time, String rest) {
		this.id = id;
		this.name = name;
		this.loc = loc;
		this.tel = tel;
		this.time = time;
		this.rest = rest;
	}
	public ShopDTO() {
		
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getRest() {
		return rest;
	}
	public void setRest(String rest) {
		this.rest = rest;
	}
	
	
}
