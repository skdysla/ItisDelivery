package shop.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class FindOwnerIdController implements Initializable{
	
	private ShopMainController con;
	private ShopLoginController loginCon;
	private Parent findIdForm;
	private FindOwnerIdService findIdSvc;
	
	public ShopLoginController getLoginCon() {
		return loginCon;
	}
	
	public void setLoginCon(ShopLoginController loginCon) {
		this.loginCon = loginCon;
		this.con = loginCon.getCon();
		this.findIdSvc.setFindOIdCon(this);
	}
	
	public void setFindIdForm(Parent findIdForm) {
		this.findIdForm = findIdForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		findIdSvc = new FindOwnerIdService();
	}
	
	public void find() {
		boolean flag = findIdSvc.find(findIdForm);
		if(flag) {
			CommonService.closeForm(findIdForm);
			con.openForm("login");
		}
	}
	
	public void cancelFind() {
		CommonService.closeForm(findIdForm);
		con.openForm("login");
	}

}
