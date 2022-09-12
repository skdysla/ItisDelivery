package shop.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class ResetPwController implements Initializable {
	
	private ShopMainController con;
	private ShopLoginController loginCon;
	private Parent resetPwForm;
	private ResetPwService resetSvc;
	
	public ShopLoginController getLoginCon() {
		return loginCon;
	}
	
	public void setLoginCon(ShopLoginController loginCon) {
		this.loginCon = loginCon;
		this.con = loginCon.getCon();
		this.resetSvc.setResetPwCon(this);
	}
	
	public void setResetPwForm(Parent resetPwForm) {
		this.resetPwForm = resetPwForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		resetSvc = new ResetPwService();
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
