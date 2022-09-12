package member.myPage;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class updateMyInfoController implements Initializable{
	private memberController con;
	private myPageController mpCon;
	private Parent updateMyInfoForm;
	private updateMyInfoService updateSvc;
	
	public memberController getCon() {
		return con;
	}
	public myPageController getMpCon() {
		return mpCon;
	}
	public void setMpCon(myPageController mpCon) {
		this.mpCon = mpCon;
		this.con = mpCon.getCon();
		updateSvc.setUpdateCon(this);
	}
	public Parent getUpdateMyInfoForm() {
		return updateMyInfoForm;
	}
	public void setUpdateMyInfoForm(Parent updateMyInfoForm) {
		this.updateMyInfoForm = updateMyInfoForm;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateSvc = new updateMyInfoService();
	}
	
	public void clickUpdateBtn() {
		int rs = updateSvc.updateMyInfo(updateMyInfoForm);
		if(rs != -1) {
			CommonService.closeForm(updateMyInfoForm);
			mpCon.goMemberInfo();
		}
	}
	
	public void clickImageChange() {}
	
	///하단 버튼
	public void clickHomeBtn() { CommonService.closeForm(updateMyInfoForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(updateMyInfoForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(updateMyInfoForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(updateMyInfoForm); con.openForm("order"); }
	public void clickMyInfoBtn() { CommonService.closeForm(updateMyInfoForm); con.openForm("mypage"); }
}
