package member.myPage;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class pwConfirmController implements Initializable{
	private memberController con;
	private myPageController mpCon;
	private Parent pwConfirmForm;
	private pwConfirmService pwCSvc;
	
	public memberController getCon() {
		return con;
	}
	public myPageController getMpCon() {
		return mpCon;
	}
	public void setMpCon(myPageController mpCon) {
		this.mpCon = mpCon;
		this.con = mpCon.getCon();
		pwCSvc.setPwConfirmCon(this);
	}
	
	public void setPwConfirmForm(Parent pwConfirmForm) {
		this.pwConfirmForm = pwConfirmForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pwCSvc = new pwConfirmService();
	}
	
	public void clickCheckBtn() {
		boolean closeForm = pwCSvc.pwConfirm(pwConfirmForm);
		if(closeForm) CommonService.closeForm(pwConfirmForm);
	}
	
	
	///하단 버튼
	public void clickHomeBtn() { CommonService.closeForm(pwConfirmForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(pwConfirmForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(pwConfirmForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(pwConfirmForm); con.openForm("order"); }
	public void clickMyInfoBtn() { CommonService.closeForm(pwConfirmForm); con.openForm("mypage"); }
	
}
