package controller;

import java.net.URL;
import java.util.ResourceBundle;

import admin.adminList.AdminDAO;
import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class Controller implements Initializable {
	
	private ShopMainController shopCon;
	private Service svc;
	private Parent firstForm;
	
	public void setShopCon(ShopMainController shopCon) {
		this.shopCon = shopCon;
//		this.svc.setCon(this);
	}
	
	public void setFirstForm(Parent firstForm) {
		this.firstForm = firstForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		svc = new Service();
		svc.setTimeZone();
	}
	
	public void memberBtn() {
		CommonService.closeForm(firstForm);
		svc.memberBtn();
	}
	
	public void shopBtn() {
		CommonService.closeForm(firstForm);
		svc.shopBtn();
	}
	
	public void adminBtn() {
		CommonService.closeForm(firstForm);
		svc.adminBtn();
	}
	
	
}
