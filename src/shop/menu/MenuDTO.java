package shop.menu;

import javafx.fxml.FXML;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;

public class MenuDTO {
	private String f_name; // 무조건
	private String f_name_before; // 무조건
	private int f_price;// 무조건
	private int f_exp_time;// 무조건 + 가게아이디도 무조건 db에 저장해야함
	private String f_explain;
	private String f_photo;
	private String s_id;
	private String s_tel;
	
	public String getS_tel() {
		return s_tel;
	}
	public void setS_tel(String s_tel) {
		this.s_tel = s_tel;
	}
	public String getF_name_before() {
		return f_name_before;
	}
	public void setF_name_before(String f_name_before) {
		this.f_name_before = f_name_before;
	}
	public String getF_name() {
		return f_name;
	}
	public int getF_price() {
		return f_price;
	}
	public int getF_exp_time() {
		return f_exp_time;
	}
	public String getF_explain() {
		return f_explain;
	}
	public String getF_photo() {
		return f_photo;
	}
	public String getS_id() {
		return s_id;
	}
	public void setF_name(String f_name) {
		this.f_name = f_name;
	}
	public void setF_price(int f_price) {
		this.f_price = f_price;
	}
	public void setF_exp_time(int f_exp_time) {
		this.f_exp_time = f_exp_time;
	}
	public void setF_explain(String f_explain) {
		this.f_explain = f_explain;
	}
	public void setF_photo(String f_photo) {
		this.f_photo = f_photo;
	}
	public void setS_id(String s_id) {
		this.s_id = s_id;
	}
	
	
	
}
