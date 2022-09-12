package shop.join;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class RegShopController implements Initializable {
	
	private ShopMainController con;
	private RegShopService regSvc;
	private Parent regForm;
	
	public ShopMainController getCon() {
		return con;
	}

	public void setCon(ShopMainController con) {
		this.con = con;
		regSvc.setRegCon(this);
	}
	
	public Parent getRegForm() {
		return regForm;
	}

	public void setRegForm(Parent regForm) {
		this.regForm = regForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regSvc = new RegShopService();
	}
	
	public void updateImage() {
		
	}
	
	public void openMap() {
		
	}

	public void regShopInfo() {
		int rs = regSvc.regShopInfo(regForm);
		if(rs != -1) {
			CommonService.closeForm(regForm);
			con.openForm("home");
		}
	}
	
	public void cancelReg() {
		CommonService.closeForm(regForm);
		con.openForm("home");
	}
	
	public void clickHomeBtn() {
		CommonService.closeForm(regForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(regForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(regForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(regForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(regForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(regForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(regForm);
		con.openForm("acceptedOrders");
	}
}
