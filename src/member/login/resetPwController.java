package member.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class resetPwController implements Initializable{
	private memberController con;
	private LoginController loginCon;
	private Parent resetPwForm;
	private resetPwService resetSvc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		resetSvc = new resetPwService();
	}
	
	public LoginController getLoginCon() {
		return loginCon;
	}
	public void setLoginCon(LoginController loginCon) {
		this.loginCon = loginCon;
		this.con = loginCon.getCon();
		this.resetSvc.setResetPwCon(this);
	}
	public void setResetPwForm(Parent resetPwForm) {
		this.resetPwForm = resetPwForm;
	}
	
	public void reset() {
		boolean flag = resetSvc.reset(resetPwForm);
		if(flag) {
			CommonService.closeForm(resetPwForm);
			con.openForm("login");
		}
	}
	
	public void cancelReset() {
		CommonService.closeForm(resetPwForm);
		con.openForm("login");
	}
}
