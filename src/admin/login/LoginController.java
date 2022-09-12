package admin.login;

import java.net.URL;
import java.util.ResourceBundle;

import admin.common.CommonService;
import admin.main.AdminController;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class LoginController implements Initializable{
	private LoginService loginSvc;
	private Parent loginForm;
	private AdminController controller;
	
	public void setLoginForm(Parent loginForm) {
		this.loginForm = loginForm;
	}
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginSvc = new LoginService();
	}
	
	public void managerBtn() {
		CommonService.windowClose(loginForm);
		controller.open("adminLogin");
	}
}
