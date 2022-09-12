package member.review;

public class reviewDTO {
	private String s_name, s_branch, o_menu, r_text;
	private String s_id;
	private Integer o_num;
//	private String pic;
	private Integer r_score, r_num;
	
	public reviewDTO(Integer r_score, String r_text, Integer r_num) {
		this.r_score = r_score;
		this.r_text = r_text;
		this.r_num = r_num;
	}
	
	public reviewDTO(String s_name, String s_branch, String o_menu, Integer r_score, String r_text, Integer r_num, String s_id, Integer o_num) {
		this.s_name = s_name;
		this.s_branch = s_branch;
		this.o_menu = o_menu;
		this.r_score = r_score;
		this.r_text = r_text;
		this.r_num = r_num;
		this.s_id = s_id;
		this.o_num = o_num;
	}

	public reviewDTO() {
		// TODO Auto-generated constructor stub
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

	public String getR_text() {
		return r_text;
	}

	public void setR_text(String r_text) {
		this.r_text = r_text;
	}

//	public String getPic() {
//		return pic;
//	}
//
//	public void setPic(String pic) {
//		this.pic = pic;
//	}

	public Integer getR_score() {
		return r_score;
	}

	public void setR_score(Integer r_score) {
		this.r_score = r_score;
	}
	
	public Integer getR_num() {
		return r_num;
	}
	public void setR_num(Integer r_num) {
		this.r_num = r_num;
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

	
}
