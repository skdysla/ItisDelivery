package member.order;

public class orderDTO {
	private Integer o_num;
	private String s_name, s_branch, o_menu, o_price, o_cnt, o_time;
	
	public orderDTO(Integer o_num, String s_name, String s_branch, String o_menu, String o_cnt, String o_price, String o_time) {
		this.o_num = o_num;
		this.s_name = s_name;
		this.s_branch = s_branch;
		this.o_menu = o_menu;
		this.o_cnt = o_cnt;
		this.o_price = o_price;
		this.o_time = o_time;
	}
	
	public orderDTO(Integer o_num) {
		this.o_num = o_num;
	}
	
	public orderDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getO_num() {
		return o_num;
	}
	
	public void setO_num(Integer o_num) {
		this.o_num = o_num;
	}

	public String getS_name() {
		return s_name;
	}

	public void setS_name(String s_name) {
		this.s_name = s_name;
	}

	public String getS_branch() {
		return s_branch;
	}

	public void setS_branch(String s_branch) {
		this.s_branch = s_branch;
	}

	public String getO_menu() {
		return o_menu;
	}

	public void setO_menu(String o_menu) {
		this.o_menu = o_menu;
	}

	public String getO_price() {
		return o_price;
	}

	public void setO_price(String o_price) {
		this.o_price = o_price;
	}

	public String getO_cnt() {
		return o_cnt;
	}

	public void setO_cnt(String o_cnt) {
		this.o_cnt = o_cnt;
	}
	public String getO_time() {
		return o_time;
	}
	public void setO_time(String o_time) {
		this.o_time = o_time;
	}

//	public Button getOrederDetail() {
//		return orederDetail;
//	}
//
//	public void setOrederDetail(Button orederDetail) {
//		this.orederDetail = orederDetail;
//	}


	
}
