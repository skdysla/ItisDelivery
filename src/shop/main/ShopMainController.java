package shop.main;

import java.net.URL;
import java.util.ResourceBundle;

import shop.ask.ShopAskController;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.list.ShopListController;
import shop.main.ShopMainService;
import shop.menu.ShopMenuController;
import shop.home.ShopHomeController;
import shop.info.ShopInfoController;
import shop.join.RegOwnerController;
import shop.join.RegShopController;
import shop.login.ShopLoginController;
import shop.order.ShopAcceptedOController;
import shop.order.ShopAllOController;
import shop.order.ShowOrderDetailController;
import shop.sales.ShopSalesController;

public class ShopMainController implements Initializable {
	private ShopLoginController loginCon;
	private ShopHomeController homeCon;
	private ShopSalesController salesCon;
	private ShopAllOController allOCon;
	private ShopAcceptedOController acceptedOCon;
	private ShowOrderDetailController showDetailCon;
	private RegOwnerController regOwnerCon;
	private RegShopController regCon;
	private ShopInfoController infoCon;
	private ShopMenuController menuCon;
	private ShopListController listCon;
	private ShopAskController askCon;
	private ShopMainService mainSvc;
	private Parent salesForm;
	private Parent loginForm;
	private Parent homeForm;
	private String sId;
	
	public ShopMainController() {
		mainSvc = new ShopMainService();
		mainSvc.setCon(this);
	}
	
	public ShopLoginController getLoginCon() {
		return loginCon;
	}

	public void setLoginCon(ShopLoginController loginCon) {
		this.loginCon = loginCon;
		this.loginCon.setCon(this);
	}
	
	public ShopHomeController getHomeCon() {
		return homeCon;
	}

	public void setHomeCon(ShopHomeController homeCon) {
		this.homeCon = homeCon;
		this.homeCon.setCon(this);
	}
	
	public ShopSalesController getSalesCon() {
		return salesCon;
	}

	public void setSalesCon(ShopSalesController salesCon) {
		this.salesCon = salesCon;
		this.salesCon.setCon(this);
	}

	public ShopAllOController getAllOrdersCon() {
		return allOCon;
	}

	public void setAllOrdersCon(ShopAllOController allOrdersCon) {
		this.allOCon = allOrdersCon;
		this.allOCon.setCon(this);
	}
	
	public ShopAcceptedOController getAcceptedOCon() {
		return acceptedOCon;
	}

	public void setAcceptedOCon(ShopAcceptedOController acceptedOCon) {
		this.acceptedOCon = acceptedOCon;
		this.acceptedOCon.setCon(this);
	}
	
	public void setShowDetailCon(ShowOrderDetailController showDetailCon) {
		this.showDetailCon = showDetailCon;
		this.showDetailCon.setCon(this);
	}
	
	public RegShopController getRegCon() {
		return regCon;
	}

	public RegOwnerController getRegOwnerCon() {
		return regOwnerCon;
	}

	public void setRegOwnerCon(RegOwnerController regOwnerCon) {
		this.regOwnerCon = regOwnerCon;
		this.regOwnerCon.setCon(this);
	}

	public void setRegCon(RegShopController regCon) {
		this.regCon = regCon;
		this.regCon.setCon(this);
	}
	
	public ShopInfoController getInfoCon() {
		return infoCon;
	}

	public void setInfoCon(ShopInfoController infoCon) {
		this.infoCon = infoCon;
		this.infoCon.setCon(this);
	}
	public void setShopMenuCon(ShopMenuController menuCon) {
		this.menuCon = menuCon;
		this.menuCon.setCon(this);
	}
	public void setShopListCon(ShopListController listCon) {
		this.listCon = listCon;
		this.listCon.setCon(this);		
	}
	public void setAskController(ShopAskController askCon) {
		this.askCon = askCon;
		this.askCon.setCon(this);
	}
	public String getsId() {
		return sId;
	}
	
	public void setsId(String sId) {
		this.sId = sId;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}
	
	public void openForm(String formName) {
		if (formName.equals("home")) {
			mainSvc.openHome();
		} else if (formName.equals("menu")) {
			mainSvc.openMenu();
		} else if (formName.equals("sales")) {
			mainSvc.openSales();
		} else if (formName.equals("ask")) {
			mainSvc.openAsk();
		}else if(formName.equals("list")) {
			mainSvc.openList();
		} else if (formName.equals("shopInfo")) {
			boolean flag = mainSvc.checkShopTel(sId);
			if (flag) mainSvc.openShopInfo();
			else mainSvc.openRegShop();
		} else if (formName.equals("acceptedOrders")) {
			mainSvc.openAcceptedOrders();
		} else if (formName.equals("login")) {
			mainSvc.openLogin();
		}
	}

}
