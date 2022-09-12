package shop.info;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class ShowShopInfoController implements Initializable {
	
	private ShopMainController con;
	private ShopInfoController infoCon;
	private Parent showShopForm;
	private ShowShopInfoService shopInfoSvc;
	
	public ShopInfoController getInfoCon() {
		return infoCon;
	}

	public void setInfoCon(ShopInfoController infoCon) {
		this.infoCon = infoCon;
		this.con = infoCon.getCon();
		this.shopInfoSvc.setShowSICon(this);
	}
	
	public void setShowShopForm(Parent showShopForm) {
		this.showShopForm = showShopForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shopInfoSvc = new ShowShopInfoService();
	}
	
	public void goUpdateInfo() {
		CommonService.closeForm(showShopForm);
		shopInfoSvc.goUpdateInfo();
	}

	public void clickHomeBtn() {
		CommonService.closeForm(showShopForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(showShopForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(showShopForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(showShopForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(showShopForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(showShopForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(showShopForm);
		con.openForm("acceptedOrders");
	}
	
}
