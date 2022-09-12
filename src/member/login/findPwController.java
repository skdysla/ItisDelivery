package member.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class findPwController implements Initializable{
	private memberController con;
	private LoginController loginCon;
	private Parent findPwForm;
	private findPwService findPwSvc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findPwSvc = new findPwService();
	}
	
	public LoginController getLoginCon() {
		return loginCon;
	}
	public void setLoginCon(LoginController loginCon) {
		this.loginCon = loginCon;
		this.con = loginCon.getCon();
		this.findPwSvc.setFindPwCon(this);
	}
	
	public void setFindPwForm(Parent findPwForm) {
		this.findPwForm = findPwForm;
	}
	
	public void pwConfirmBtn() {
		boolean flag = findPwSvc.find(findPwForm);
		if(flag) {
			CommonService.closeForm(findPwForm);
			loginCon.resetPw();
		}
	}
	
	public void backBtn() {
		CommonService.closeForm(findPwForm);
		con.openForm("login");
	}
	
}
