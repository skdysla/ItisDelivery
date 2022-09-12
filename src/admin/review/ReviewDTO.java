package admin.review;

public class ReviewDTO {
	String shop,text;
	Integer number, score;
	
	public ReviewDTO(Integer number, String shop, String text, Integer score) {
		this.number = number;
		this.shop = shop;
		this.text = text;
		this.score = score;
	}
	public ReviewDTO() {
		
	}
	public Integer getNumber() {
		return number;
	}
	public void setNumber(Integer number) {
		this.number = number;
	}
	public String getShop() {
		return shop;
	}
	public void setShop(String shop) {
		this.shop = shop;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public Integer getScore() {
		return score;
	}
	public void setScore(Integer score) {
		this.score = score;
	}
	
	
}
