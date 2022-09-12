package member.review;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class reviewCreateController implements Initializable{
	private memberController con;
	private reviewListController reviewCon;
	private Parent reviewCreateForm;
	private reviewDAO dao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public memberController getCon() {
		return con;
	}
	public void setCon(memberController con) {
		this.con = con;
	}
	
	public void setReviewCreateForm(Parent reviewCreateForm) {
		this.reviewCreateForm = reviewCreateForm;
	}
	
	
	public void clickCreateReviewBtn() {}
	
	public void clickHomeBtn() { CommonService.closeForm(reviewCreateForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(reviewCreateForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(reviewCreateForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(reviewCreateForm); con.openForm("order"); }
	public void clickMyInfoBtn() { CommonService.closeForm(reviewCreateForm); con.openForm("mypage"); }
	
}
