package shop.order;

public class DetailDTO {
	
	private String s_name;
	private String s_branch;
	private String o_menu;
	private String o_cnt;
	private String o_price;
	private String m_address;
	private String m_tel;
	
	public DetailDTO(String o_menu, String o_cnt, String o_price) {
		this.o_menu = o_menu;
		this.o_cnt = o_cnt;
		this.o_price = o_price;
	}

	public DetailDTO(String s_name, String s_branch, String o_menu, String o_cnt, String o_price, String m_address,
			String m_tel) {
		this.s_name = s_name;
		this.s_branch = s_branch;
		this.o_menu = o_menu;
		this.o_cnt = o_cnt;
		this.o_price = o_price;
		this.m_address = m_address;
		this.m_tel = m_tel;
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

	public String getM_address() {
		return m_address;
	}

	public void setM_address(String m_address) {
		this.m_address = m_address;
	}

	public String getM_tel() {
		return m_tel;
	}

	public void setM_tel(String m_tel) {
		this.m_tel = m_tel;
	}
	
}
