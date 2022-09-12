package shop.home;

public class ShopHomeDTO {
	
	private String o_time;
	private int o_num;
	private String o_menu;
	private String o_cnt;
	private String o_price;
	private String o_is_accepted;
	private String s_id;
	
	public ShopHomeDTO() {
	}
	public ShopHomeDTO(String menu, String cnt, String price) {
		this.o_menu = menu;
		this.o_cnt = cnt;
		this.o_price = price;
	}
	public String getO_time() {
		return o_time;
	}
	public int getO_num() {
		return o_num;
	}
	public String getO_menu() {
		return o_menu;
	}
	public String getO_cnt() {
		return o_cnt;
	}
	public String getO_price() {
		return o_price;
	}
	public String getO_is_accepted() {
		return o_is_accepted;
	}
	public String getS_id() {
		return s_id;
	}
	public void setO_time(String o_time) {
		this.o_time = o_time;
	}
	public void setO_num(int o_num) {
		this.o_num = o_num;
	}
	public void setO_menu(String o_menu) {
		this.o_menu = o_menu;
	}
	public void setO_cnt(String o_cnt) {
		this.o_cnt = o_cnt;
	}
	public void setO_price(String o_price) {
		this.o_price = o_price;
	}
	public void setO_is_accepted(String o_is_accepted) {
		this.o_is_accepted = o_is_accepted;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	
}
