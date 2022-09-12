package shop.info;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class UpdateShopInfoController implements Initializable {
	
	private ShopMainController con;
	private ShopInfoController infoCon;
	private Parent updateShopForm;
	private UpdateShopInfoService updateSISvc;
	
	public ShopInfoController getInfoCon() {
		return infoCon;
	}

	public void setInfoCon(ShopInfoController infoCon) {
		this.infoCon = infoCon;
		this.con = infoCon.getCon();
		this.updateSISvc.setUpdateSICon(this);
	}
	
	public void setUpdateShopForm(Parent updateShopForm) {
		this.updateShopForm = updateShopForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateSISvc = new UpdateShopInfoService();
	}
	
	public void updateImage() {

	}

	public void openMap() {

	}

	public void goShopUpdate() {
		int rs = updateSISvc.goShopUpdate(updateShopForm);
		if(rs != -1) {
			CommonService.closeForm(updateShopForm);
			infoCon.showShopInfo();
		}
	}

	public void cancelUpdate() {
		CommonService.closeForm(updateShopForm);
		infoCon.showShopInfo();
	}

	public void clickHomeBtn() {
		CommonService.closeForm(updateShopForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(updateShopForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(updateShopForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(updateShopForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(updateShopForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(updateShopForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(updateShopForm);
		con.openForm("acceptedOrders");
	}
	
}
