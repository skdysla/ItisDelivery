package shop.info;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class ShowShopOwnerInfoController implements Initializable {
	
	private ShopMainController con;
	private ShopInfoController infoCon;
	private Parent showSOIForm;
	private ShowShopOwnerInfoService showSOISvc;
	
	public ShopMainController getCon() {
		return con;
	}

	public Parent getShowSOIForm() {
		return showSOIForm;
	}

	public ShowShopOwnerInfoService getShowSOISvc() {
		return showSOISvc;
	}

	public void setCon(ShopMainController con) {
		this.con = con;
	}
	
	public ShopInfoController getInfoCon() {
		return infoCon;
	}

	public void setInfoCon(ShopInfoController infoCon) {
		this.infoCon = infoCon;
		this.con = infoCon.getCon();
		this.showSOISvc.setShowSOICon(this);
	}
	
	public void setShowSOIForm(Parent showSOIForm) {
		this.showSOIForm = showSOIForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showSOISvc = new ShowShopOwnerInfoService();
	} 

	public void modifyOwnerInfo() {
		CommonService.closeForm(showSOIForm);
		showSOISvc.modifyOwnerInfo();
	}
	
	public void resignShopOwner() {
		CommonService.closeForm(showSOIForm);
		showSOISvc.resignShopOwner();
		con.openForm("login");
	}
	
	public void clickHomeBtn() {
		CommonService.closeForm(showSOIForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(showSOIForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(showSOIForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(showSOIForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(showSOIForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(showSOIForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(showSOIForm);
		con.openForm("acceptedOrders");
	}
}
