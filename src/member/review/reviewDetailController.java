//package review;
//
//import java.net.URL;
//import java.util.ResourceBundle;
//
//import common.CommonService;
//import javafx.fxml.Initializable;
//import javafx.scene.Parent;
//import main.memberController;
//
//public class reviewDetailController implements Initializable{
//
//	private memberController con;
//	private reviewListController reviewCon;
//	private Parent reviewDetailForm;
//	private reviewDAO dao;
//	
//	public memberController getCon() {
//		return con;
//	}
//	public void setCon(memberController con) {
//		this.con = con;
//	}
//	
//	@Override
//	public void initialize(URL location, ResourceBundle resources) {
//		// TODO Auto-generated method stub
//		
//	}
//	
//	public void changeReview() {}
//	public void deleteReview() {}
//	
//	///하단버튼
//	public void clickHomeBtn() { CommonService.closeForm(reviewDetailForm); con.openForm("main"); }
//	public void clickLikeBtn() { CommonService.closeForm(reviewDetailForm); con.openForm("like"); }
//	public void clickSearchBtn() { CommonService.closeForm(reviewDetailForm); con.openForm("search"); }
//	public void clickOrderListBtn() { CommonService.closeForm(reviewDetailForm); con.openForm("order"); }
//	public void clickMyInfoBtn() { CommonService.closeForm(reviewDetailForm); con.openForm("mypage"); }
//	
//}
