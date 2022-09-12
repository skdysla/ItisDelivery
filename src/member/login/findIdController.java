package member.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import member.main.memberController;

public class findIdController implements Initializable{
	private memberController con;
	private LoginController loginCon;
	private Parent findIdForm;
	private findIdService findIdSvc;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findIdSvc = new findIdService();
	}
	
	public LoginController getLoginCon() {
		return loginCon;
	}
	public void setLoginCon(LoginController loginCon) {
		this.loginCon = loginCon;
		this.con = loginCon.getCon();
		this.findIdSvc.setFindIdCon(this);
	}
	public void setFindIdForm(Parent findIdForm) {
		this.findIdForm = findIdForm;
	}
	
	public void idConfirmBtn() {
		boolean flag = findIdSvc.find(findIdForm);
		if(flag) {
			CommonService.closeForm(findIdForm);
			con.openForm("login");
		}
	}
	
	public void backBtn() {
		CommonService.closeForm(findIdForm);
		con.openForm("login");
	}
}
