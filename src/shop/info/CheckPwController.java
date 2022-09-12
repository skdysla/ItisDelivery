package shop.info;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class CheckPwController implements Initializable {
	
	private ShopMainController con;	
	private ShopInfoController infoCon;
	private Parent chkPwForm;
	private CheckPwService chkPwSvc;
	
	public ShopMainController getCon() {
		return con;
	}
	
	public ShopInfoController getInfoCon() {
		return infoCon;
	}

	public void setInfoCon(ShopInfoController infoCon) {
		this.infoCon = infoCon;
		this.con = infoCon.getCon();
		chkPwSvc.setChkPwCon(this);
	}

	public void setChkPwForm(Parent chkPwForm) {
		this.chkPwForm = chkPwForm;
	} 
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		chkPwSvc = new CheckPwService();
	}
	
	public void confirmOwnerPw() {
		boolean closeForm = chkPwSvc.confirmOwnerPw(chkPwForm);
		if(closeForm) CommonService.closeForm(chkPwForm);
	}

	public void clickHomeBtn() {
		CommonService.closeForm(chkPwForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(chkPwForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(chkPwForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(chkPwForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(chkPwForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(chkPwForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(chkPwForm);
		con.openForm("acceptedOrders");
	}
}
