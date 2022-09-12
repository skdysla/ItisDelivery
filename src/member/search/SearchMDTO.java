package member.search;

public class SearchMDTO {
	//shopform에 보여줄 shoplistform에서 선택한 가게의 메뉴 정보
	private String s_id, s_name, f_photo, f_name, f_explain, m_id, m_address, m_tel;
	private String s_order_cnt, s_like_cnt, s_review_cnt, s_notice, s_explain, s_branch;
	private int f_price, f_exp_time;
	
	//s_id, s_name, s_order_cnt, s_like_cnt, s_review_cnt, f_photo, f_name, f_explain, f_price, f_exp_time
//	public SearchMDTO(String s_id, String s_name, int s_order_cnt, int s_like_cnt, int s_review_cnt, String f_photo,
//			String f_name, String f_explain, int f_price, int f_exp_time) {
//		this.s_id = s_id;
//		this.s_name = s_name;
//		this.s_order_cnt = s_order_cnt;
//		this.s_like_cnt = s_like_cnt;
//		this.s_review_cnt = s_review_cnt;
//		this.f_photo = f_photo;
//		this.f_name = f_name;
//		this.f_explain = f_explain;
//		this.f_price = f_price;
//		this.f_exp_time = f_exp_time;
//	}

	public SearchMDTO( String s_id, String f_photo, String f_name, String f_explain, int f_price, int f_exp_time) {
		this.s_id = s_id;
		this.f_photo = f_photo;
		this.f_name = f_name;
		this.f_explain = f_explain;
		this.f_price = f_price;
		this.f_exp_time = f_exp_time;
	}
	

	public SearchMDTO(String s_id, String s_name, String s_order_cnt, String s_like_cnt, String s_notice, String s_explain, String s_branch, String s_review_cnt) {
		this.s_id = s_id;
		this.s_name = s_name;
		this.s_order_cnt = s_order_cnt;
		this.s_like_cnt = s_like_cnt;
		this.s_notice = s_notice;
		this.s_explain = s_explain;
		this.s_branch = s_branch;
		this.s_review_cnt = s_review_cnt;
	}
	
	public SearchMDTO(String m_id, String m_address, String m_tel) {
	      this.m_id = m_id;
	      this.m_address = m_address;
	      this.m_tel = m_tel;
	   }
	
	
	
	


	public String getM_id() {
		return m_id;
	}


	public void setM_id(String m_id) {
		this.m_id = m_id;
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


	public String getS_branch() {
		return s_branch;
	}


	public void setS_branch(String s_branch) {
		this.s_branch = s_branch;
	}


	public String getS_notice() {
		return s_notice;
	}


	public void setS_notice(String s_notice) {
		this.s_notice = s_notice;
	}


	public String getS_explain() {
		return s_explain;
	}


	public void setS_explain(String s_explain) {
		this.s_explain = s_explain;
	}


	


	public String getS_id() {
		return s_id;
	}


	public void setS_id(String s_id) {
		this.s_id = s_id;
	}


	public String getS_name() {
		return s_name;
	}


	public void setS_name(String s_name) {
		this.s_name = s_name;
	}


	public String getF_photo() {
		return f_photo;
	}


	public void setF_photo(String f_photo) {
		this.f_photo = f_photo;
	}


	public String getF_name() {
		return f_name;
	}


	public void setF_name(String f_name) {
		this.f_name = f_name;
	}


	public String getF_explain() {
		return f_explain;
	}


	public void setF_explain(String f_explain) {
		this.f_explain = f_explain;
	}


	public String getS_order_cnt() {
		return s_order_cnt;
	}


	public void setS_order_cnt(String s_order_cnt) {
		this.s_order_cnt = s_order_cnt;
	}


	public String getS_like_cnt() {
		return s_like_cnt;
	}


	public void setS_like_cnt(String s_like_cnt) {
		this.s_like_cnt = s_like_cnt;
	}


	public String getS_review_cnt() {
		return s_review_cnt;
	}


	public void setS_review_cnt(String s_review_cnt) {
		this.s_review_cnt = s_review_cnt;
	}


	public int getF_price() {
		return f_price;
	}


	public void setF_price(int f_price) {
		this.f_price = f_price;
	}


	public int getF_exp_time() {
		return f_exp_time;
	}


	public void setF_exp_time(int f_exp_time) {
		this.f_exp_time = f_exp_time;
	}

	
	
	
	
	
	

}
