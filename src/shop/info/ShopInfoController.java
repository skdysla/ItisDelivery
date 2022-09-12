package shop.info;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class ShopInfoController implements Initializable {
	
	private ShopMainController con;
	private CheckPwController chkPwCon;
	private ShowShopInfoController showSICon;
	private ShowShopOwnerInfoController showSOICon;
	private UpdateShopInfoController updateSICon;
	private UpdateShopOwnerInfoController updateSOICon;
	private ShopInfoService choiceISvc;
	private Parent choiceForm;
	
	public ShopMainController getCon() {
		return con;
	}

	public void setCon(ShopMainController con) {
		this.con = con;
		this.choiceISvc.setInfoCon(this);
	}
	
	public CheckPwController getChkPwCon() {
		return chkPwCon;
	}

	public void setChkPwCon(CheckPwController chkPwCon) {
		this.chkPwCon = chkPwCon;
		this.chkPwCon.setInfoCon(this);
	}
	
	public ShowShopInfoController getShowSICon() {
		return showSICon;
	}

	public void setShowSICon(ShowShopInfoController showSICon) {
		this.showSICon = showSICon;
		this.showSICon.setInfoCon(this);
	}
	
	public void setShowSOICon(ShowShopOwnerInfoController showSOICon) {
		this.showSOICon = showSOICon;
		this.showSOICon.setInfoCon(this);
	}
	
	public void setUpdateSICon(UpdateShopInfoController updateSICon) {
		this.updateSICon = updateSICon;
		this.updateSICon.setInfoCon(this);
	}
	
	public UpdateShopOwnerInfoController getUpdateSOICon() {
		return updateSOICon;
	}

	public void setUpdateSOICon(UpdateShopOwnerInfoController updateSOICon) {
		this.updateSOICon = updateSOICon;
		this.updateSOICon.setInfoCon(this);
	}

	public Parent getChoiceForm() {
		return choiceForm;
	}

	public void setChoiceForm(Parent choiceForm) {
		this.choiceForm = choiceForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		choiceISvc = new ShopInfoService();
	}
	
	public void showShopOwnerInfo() {
		CommonService.closeForm(choiceForm);
		choiceISvc.showShopOwnerInfo();
	}
	
	public void showShopInfo() {
		CommonService.closeForm(choiceForm);
		choiceISvc.showShopInfo();
	}
	
	public void goShopOwnerInfo() {
		choiceISvc.goShopOwnerInfo();
	}
	
	public void logout() {
		CommonService.closeForm(choiceForm);
		if(choiceISvc.logout() == 1) {
			CommonService.alert("로그아웃 완료!");
		}
		con.openForm("login");
	}

	public void clickHomeBtn() {
		CommonService.closeForm(choiceForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(choiceForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(choiceForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(choiceForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(choiceForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(choiceForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(choiceForm);
		con.openForm("acceptedOrders");
	}
	
}
