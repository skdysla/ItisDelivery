package member.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import member.main.memberController;
import member.main.memberDTO;

public class LoginController implements Initializable {
	private memberController con;
	private findIdController findIdCon;
	private findPwController findPwCon;
	private resetPwController resetPwCon;
	private LoginService loginSvc;
	private Parent loginForm;
	private String mId;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginSvc = new LoginService();
	}
	
	public memberController getCon() {
		return con;
	}
	public void setCon(memberController con) {
		this.con = con;
		this.loginSvc.setLoginCon(this);
	}
	
	public void setFindIdCon(findIdController findIdCon) {
		this.findIdCon = findIdCon;
		this.findIdCon.setLoginCon(this);
	}
	public void setFindPwCon(findPwController findPwCon) {
		this.findPwCon = findPwCon;
		this.findPwCon.setLoginCon(this);
	}
	public void setResetPwCon(resetPwController resetPwCon) {
		this.resetPwCon = resetPwCon;
		this.resetPwCon.setLoginCon(this);
	}
	public LoginService getLoginSvc() {
		return loginSvc;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public void setLoginSvc(LoginService loginSvc) {
//		this.loginSvc = loginSvc;
	}
	public Parent getLoginForm() {
		return loginForm;
	}
	public void setLoginForm(Parent loginForm) {
		this.loginForm = loginForm;
	}
	
	
	public void btnClick() {
		memberDTO dto = loginSvc.btnClick(loginForm);
		
		//로그인에 성공한 가게의 id를 con에 저장
		if(dto != null) {
			String uId  = ((TextField) loginForm.lookup("#id")).getText();
			con.setmId(uId);
			CommonService.closeForm(loginForm);
			con.openForm("main");
		}
	}
	
	public void idFind() {
		CommonService.closeForm(loginForm);
		loginSvc.idFind();
	}
	
	public void pwFind() {
		CommonService.closeForm(loginForm);
		loginSvc.pwFind();
	}
	
	public void resetPw() {
		loginSvc.resetPw();
	}
	
	public void managerBtn() {}
	
	public void createBtn() {
		CommonService.closeForm(loginForm);
		loginSvc.createBtn();
	}
}
