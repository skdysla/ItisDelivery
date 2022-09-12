package member.myPage;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class myPageController implements Initializable{
	private memberController con;
	private pwConfirmController pwConfirmCon;
	private showMyInfoController showMICon;
	private updateMyInfoController updateMICon;
	private myPageService mpSvc;
	private Parent myPageForm;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mpSvc = new myPageService(con); // 이거 
	}

	public memberController getCon() {
		return con;
	}
	public void setCon(memberController con) {
		this.con = con;
		this.mpSvc.setMpCon(this);
	}
	
	public pwConfirmController getPwConfirmCon() {
		return pwConfirmCon;
	}
	public void setPwConfirmCon(pwConfirmController pwConfirmCon) {
		this.pwConfirmCon = pwConfirmCon;
		this.pwConfirmCon.setMpCon(this);
	}
	
	public showMyInfoController getShowMICon() {
		return showMICon;
	}
	public void setShowMICon(showMyInfoController showMICon) {
		this.showMICon = showMICon;
		this.showMICon.setMpCon(this);
	}
	
	public void setUpdateMICon(updateMyInfoController updateMICon) {
		this.updateMICon = updateMICon;
		this.updateMICon.setMpCon(this);
	}
	
	public updateMyInfoController getUpdateMICon() {
		return updateMICon;
	}
	
	public Parent getMyPageForm() {
		return myPageForm;
	}
	public void setMyPageForm(Parent myPageForm) {
		this.myPageForm = myPageForm;
	}
	
	
	public void clickMyInfoDetailBtn() { //비밀번호 확인창으로
		CommonService.closeForm(myPageForm);
		mpSvc.openShowMyInfoForm();
	}
	
	public void goMemberInfo() { // 회원 정보 확인 창으로
		mpSvc.goMemberInfo();
	}
	
	public void logout() {
		CommonService.closeForm(myPageForm);
		mpSvc.logout();
		con.openForm("login");
	}
	
	public void clickMyReviewBtn() {
		System.out.println("@@@@@@@@@@@222" + con);
		CommonService.closeForm(myPageForm); 
		con.openForm("review");
	}
	
	public void clickLogoutBtn() {
		CommonService.closeForm(myPageForm);
		mpSvc.logout();
		con.openForm("login");		
	}
	
	/// 하단 버튼
	public void clickHomeBtn() { CommonService.closeForm(myPageForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(myPageForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(myPageForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(myPageForm); con.openForm("order"); }
	public void clickMyInfoBtn() { CommonService.closeForm(myPageForm); con.openForm("mypage"); }
}
