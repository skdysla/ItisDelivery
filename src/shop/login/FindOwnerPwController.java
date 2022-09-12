package shop.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class FindOwnerPwController implements Initializable {
	
	private ShopMainController con;
	private ShopLoginController loginCon;
	private Parent findPwForm;
	private FindOwnerPwService findPwSvc;
	
	public ShopLoginController getLoginCon() {
		return loginCon;
	}
	
	public void setLoginCon(ShopLoginController loginCon) {
		this.loginCon = loginCon;
		this.con = loginCon.getCon();
		this.findPwSvc.setFindOPwCon(this);
	}
	
	public void setFindPwForm(Parent findPwForm) {
		this.findPwForm = findPwForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findPwSvc = new FindOwnerPwService();
	}
	
	public void find() {
		boolean flag = findPwSvc.find(findPwForm);
		if(flag) {
			CommonService.closeForm(findPwForm);
			loginCon.resetPw();
		}
	}
	
	public void cancelFind() {
		CommonService.closeForm(findPwForm);
		con.openForm("login");
	}
	
}
