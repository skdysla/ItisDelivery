package admin.login;

import java.net.URL;
import java.util.ResourceBundle;

import admin.common.CommonService;
import admin.main.AdminController;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;

public class AdminLoginController implements Initializable {
	@FXML private TextField name;
	@FXML private TextField tel;
	
	private LoginService loginSvc;
	private Parent adminLoginForm;
	private AdminController controller;
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	public void setAdminLoginForm(Parent adminLoginForm) {
		this.adminLoginForm = adminLoginForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginSvc = new LoginService();
	}
	
	public void loginProc() {
		LoginDTO loginDto = loginSvc.loginProc(tel.getText(), name.getText());
		
		if(loginDto != null) {
			CommonService.windowClose(adminLoginForm);
			controller.open("home");
		}
	}
}
