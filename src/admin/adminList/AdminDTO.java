package admin.adminList;

public class AdminDTO {
	String name,tel,position;
	
	public AdminDTO(String name, String tel, String position) {
		this.name = name;
		this.tel = tel;
		this.position = position;
	}
	public AdminDTO() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}
	  
}