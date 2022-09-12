package shop.order;

public class OrderDTO {
	
	private Integer o_num;
	private String o_time;
	private String o_menu;
	private String o_cnt;
	private String o_price;
	
	public OrderDTO() {
		
	}
	
	public OrderDTO(Integer o_num, String o_time, String o_menu, String o_cnt, String o_price) {
		this.o_num = o_num;
		this.o_time = o_time;
		this.o_menu = o_menu;
		this.o_cnt = o_cnt;
		this.o_price = o_price;
	}

	public Integer getO_num() {
		return o_num;
	}

	public void setO_num(Integer o_num) {
		this.o_num = o_num;
	}

	public String getO_time() {
		return o_time;
	}

	public void setO_time(String o_time) {
		this.o_time = o_time;
	}

	public String getO_menu() {
		return o_menu;
	}

	public void setO_menu(String o_menu) {
		this.o_menu = o_menu;
	}

	public String getO_cnt() {
		return o_cnt;
	}

	public void setO_cnt(String o_cnt) {
		this.o_cnt = o_cnt;
	}

	public String getO_price() {
		return o_price;
	}

	public void setO_price(String o_price) {
		this.o_price = o_price;
	}
	
}
