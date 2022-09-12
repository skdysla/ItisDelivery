package member.order;

public class orderDetailDTO {
	private String s_id;
	private String s_name;
	private String s_branch;
	private String o_time;
	private String o_menu;
	private String o_cnt;
	private String o_price;
//	private Integer s_sale_rate;
	private String o_method;
	private Integer o_num;
	private String m_id;
	
	public orderDetailDTO(String o_menu, String o_cnt, String o_price) {
		this.o_menu = o_menu;
		this.o_cnt = o_cnt;
		this.o_price = o_price;
	}
	
	public orderDetailDTO(String s_id, String s_name, String s_branch, String o_time, String o_menu, String o_cnt, String o_price,
			String o_method, Integer o_num, String m_id) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_branch = s_branch;
		this.o_time = o_time;
		this.o_menu = o_menu;
		this.o_cnt = o_cnt;
		this.o_price = o_price;
		this.o_method = o_method;
		this.o_num = o_num;
		this.m_id = m_id;
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
//	public Integer getS_sale_rate() {
//		return s_sale_rate;
//	}
//	public void setS_sale_rate(Integer s_sale_rate) {
//		this.s_sale_rate = s_sale_rate;
//	}
	public String getO_method() {
		return o_method;
	}
	public void setO_method(String o_method) {
		this.o_method = o_method;
	}
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public Integer getO_num() {
		return o_num;
	}
	public void setO_num(Integer o_num) {
		this.o_num = o_num;
	}
	public String getM_id() {
		return m_id;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	
	
}
