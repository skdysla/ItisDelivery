package shop.info;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class UpdateShopOwnerInfoController implements Initializable {
	
	private ShopMainController con;
	private ShopInfoController infoCon;
	private Parent updateOwnerForm;
	private UpdateShopOwnerInfoService updateOwnerSvc;
	
	public ShopMainController getCon() {
		return con;
	}
	
	public ShopInfoController getInfoCon() {
		return infoCon;
	}

	public void setInfoCon(ShopInfoController infoCon) {
		this.infoCon = infoCon;
		this.con = infoCon.getCon();
		updateOwnerSvc.setUpdateOwnerCon(this);
	}

	public Parent getUpdateOwnerForm() {
		return updateOwnerForm;
	}

	public void setUpdateOwnerForm(Parent updateOwnerForm) {
		this.updateOwnerForm = updateOwnerForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateOwnerSvc = new UpdateShopOwnerInfoService();
	}
	
	public void updateOwnerInfo() {
		int rs = updateOwnerSvc.updateOwnerInfo(updateOwnerForm);
		if(rs != -1) {
			CommonService.closeForm(updateOwnerForm);
			infoCon.goShopOwnerInfo();
		}
	}
	
	public void cancelUpdate() {
		CommonService.closeForm(updateOwnerForm);
		infoCon.goShopOwnerInfo();
	}
	
	public void clickHomeBtn() {
		CommonService.closeForm(updateOwnerForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(updateOwnerForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(updateOwnerForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(updateOwnerForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(updateOwnerForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(updateOwnerForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(updateOwnerForm);
		con.openForm("acceptedOrders");
	}

}
