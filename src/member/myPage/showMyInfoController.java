package member.myPage;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class showMyInfoController implements Initializable{
	private memberController con;
	private myPageController mpCon;
	private Parent showMyInfoForm;
	private showMyInfoService showMISvc;
	
	public memberController getCon() {
		return con;
	}
	public Parent getShowMyInfoForm() {
		return showMyInfoForm;
	}
	public showMyInfoService getShowMISvc() {
		return showMISvc;
	}
	
	public void setCon(memberController con) {
		this.con = con;
	}
	
	public myPageController getMpCon() {
		return mpCon;
	}
	public void setMpCon(myPageController mpCon) {
		this.mpCon = mpCon;
		this.con = mpCon.getCon();
		this.showMISvc.setShowMICon(this);
	}
	
	public void setShowMyInfoForm(Parent showMyInfoForm) {
		this.showMyInfoForm = showMyInfoForm;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showMISvc = new showMyInfoService();
	}
	
	public void clickChangeBtn() {
		CommonService.closeForm(showMyInfoForm);
		showMISvc.modifyMyInfo();
	}
	
	public void clickLeaveApp() {
		CommonService.closeForm(showMyInfoForm);
		showMISvc.resignMember();
		con.openForm("login");
	}
	
	///하단 버튼
	public void clickHomeBtn() { CommonService.closeForm(showMyInfoForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(showMyInfoForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(showMyInfoForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(showMyInfoForm); con.openForm("order"); }
	public void clickMyInfoBtn() { CommonService.closeForm(showMyInfoForm); con.openForm("mypage"); }
	
}
