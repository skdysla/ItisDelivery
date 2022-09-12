package member.review;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class updateReviewController implements Initializable{
	private memberController con;
	private reviewListController reviewCon;
	private Parent reviewListForm;
	private Parent reviewDetailForm;
	private Parent updateReviewForm;
	private Parent reviewCreateForm;
	private reviewListService reviewSvc;
	private updateReviewService updateSvc;
	private Integer Onum;
	private Integer Rnum;
	
	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
		reviewSvc = new reviewListService(con);
		System.out.println("@@@@@@@@@@@@@@@@@@67868@@" + con);
		this.reviewCon = reviewCon;
		System.out.println(con);
		updateSvc.setUpdateCon(this);
//		this.updateSvc.setUpdateCon(this);
	}
	
	public reviewListController getReviewCon() {
		return reviewCon;
	}
	
//	public void setReviewCon(reviewListController reviewCon) {
//		this.reviewCon = reviewCon;
//		System.out.println(con);
//		updateSvc.setUpdateCon(this);
//	}
	
	public Parent getReviewListForm() {
		return reviewListForm;
	}
	public void setReviewListForm(Parent reviewListForm) {
		this.reviewListForm = reviewListForm;
	}
	public Parent getUpdateReviewForm() {
		return updateReviewForm;
	}
	public void setUpdateReviewForm(Parent updateReviewForm) {
		this.updateReviewForm = updateReviewForm;
	}
	
	public void setRnum(Integer rnum) {
		Rnum = rnum;
	}
	
	
	
	public void updateReviewBtn() {
		int rs = updateSvc.updateReview(updateReviewForm);
		if(rs != -1) {
			CommonService.closeForm(updateReviewForm);
			con.openForm("review");
		}
	}
	
	
	public void deleteReviewBtn() {
		reviewSvc.deleteReviewProc();
		con.openForm("review");
		CommonService.alert("리뷰 삭제 완료!");
	}
	
	
	public void clickHomeBtn() { CommonService.closeForm(updateReviewForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(updateReviewForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(updateReviewForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(updateReviewForm); con.openForm("order"); }
	public void clickMyInfoBtn() { 
		//만약 화면이 reviewListForm 이면 reviewListForm을 닫기
		// reviewDetailForm 이면 reviewDetailForm 닫기
		CommonService.closeForm(updateReviewForm); 
		con.openForm("mypage"); }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateSvc = new updateReviewService();
	}
	
	
}
