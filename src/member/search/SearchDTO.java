package member.search;

public class SearchDTO {
	//가게 리스트에 보여줄 shop테이블의 가게정보
	//가게id, 가게 수, 가게 이미지, 가게 명, 평점, 주문건수, 찜 수, 리뷰 수, 찜 버튼 
	private String s_id, s_logo, s_name, s_food_cate, s_like_list;
	private int s_total, s_order_cnt, s_like_cnt, s_review_cnt;
	
	public SearchDTO() {
	}
	
	public SearchDTO(String s_id, String s_logo, String s_name, String s_food_cate , int s_total, int s_order_cnt, int s_like_cnt, int s_review_cnt) {
		this.s_id = s_id;
		this.s_logo = s_logo;
		this.s_name = s_name;
		this.s_food_cate = s_food_cate;
		this.s_total = s_total;
		this.s_order_cnt = s_order_cnt;
		this.s_like_cnt = s_like_cnt;
		this.s_review_cnt = s_review_cnt;
	}
	//s_id, s_logo, s_name, s_food_cate;
	public SearchDTO(String s_id, String s_logo, String s_name, String s_food_cate) {
		this.s_id = s_id;
		this.s_logo = s_logo;
		this.s_name = s_name;
		this.s_food_cate = s_food_cate;
	}
	
	public String getS_id() {
		return s_id;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	public String getS_logo() {
		return s_logo;
	}
	public void setS_logo(String s_logo) {
		this.s_logo = s_logo;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public int getS_total() {
		return s_total;
	}
	public void setS_total(int s_total) {
		this.s_total = s_total;
	}
	public int getS_order_cnt() {
		return s_order_cnt;
	}
	public void setS_order_cnt(int s_order_cnt) {
		this.s_order_cnt = s_order_cnt;
	}
	public int getS_like_cnt() {
		return s_like_cnt;
	}
	public void setS_like_cnt(int s_like_cnt) {
		this.s_like_cnt = s_like_cnt;
	}
	public int getS_review_cnt() {
		return s_review_cnt;
	}
	public void setS_review_cnt(int s_review_cnt) {
		this.s_review_cnt = s_review_cnt;
	}
	public String getS_food_cate() {
		return s_food_cate;
	}
	public void setS_food_cate(String s_food_cate) {
		this.s_food_cate = s_food_cate;
	}

	public String getS_like_list() {
		return s_like_list;
	}

	public void setS_like_list(String s_like_list) {
		this.s_like_list = s_like_list;
	}
	
	
	
	

}
