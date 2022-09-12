package shop.join;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class RegOwnerController implements Initializable {
	
	private ShopMainController con;
	private RegOwnerService regOSvc;
	private Parent regOwnerForm;
	
	public ShopMainController getCon() {
		return con;
	}
	
	public void setCon(ShopMainController con) {
		this.con = con;
	}
	
	public void setRegOwnerForm(Parent regOwnerForm) {
		this.regOwnerForm = regOwnerForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regOSvc = new RegOwnerService();
	}
	
	public void regShopOwner() {
		ShopDTO dto = regOSvc.regShopOwner(regOwnerForm);
		if(dto != null) {
			CommonService.closeForm(regOwnerForm);
			con.openForm("login");
		}
	}
	
	public void cancelReg() {
		CommonService.closeForm(regOwnerForm);
		con.openForm("login");
	}

}
