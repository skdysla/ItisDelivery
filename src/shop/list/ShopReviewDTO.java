package shop.list;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;

public class ShopReviewDTO {
	private String o_time;
	private String m_id;
	private String o_menu;
	private String r_text;
	private int r_score;
	
	public String getO_time() {
		return o_time;
	}
	public String getM_id() {
		return m_id;
	}
	public String getO_menu() {
		return o_menu;
	}
	public String getR_text() {
		return r_text;
	}
	public int getR_score() {
		return r_score;
	}
	public void setO_time(String o_time) {
		this.o_time = o_time;
	}
	public void setM_id(String m_id) {
		this.m_id = m_id;
	}
	public void setO_menu(String o_menu) {
		this.o_menu = o_menu;
	}
	public void setR_text(String r_text) {
		this.r_text = r_text;
	}
	public void setR_score(int r_score) {
		this.r_score = r_score;
	}

}
	
	
