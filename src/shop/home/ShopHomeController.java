package shop.home;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import shop.home.ShopHomeService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import shop.main.ShopMainController;

public class ShopHomeController implements Initializable {
	
	@FXML private Label datePrice;
	@FXML private Label dateCount;
	@FXML private Label monthPrice;
	@FXML private Label monthCount;
	@FXML private Label yearPrice;
	@FXML private Label yearCount;
	@FXML private Label beforeCnt;
	
	private ShopMainController con;
	private ShopHomeService homeSvc;
	private Parent homeForm;
	
	public ShopMainController getCon() {
		return con;
	}

	public void setCon(ShopMainController con) {
		this.con = con;
		homeSvc = new ShopHomeService(con);
		homeSvc.setHomeCon(this);
		homeData();
		this.homeSvc.setHomeCon(this);
	}

	public ShopHomeService getHomeSvc() {
		return homeSvc;
	}

	public void setHomeSvc(ShopHomeService homeSvc) {
		this.homeSvc = homeSvc;
	}

	public Parent getHomeForm() {
		return homeForm;
	}

	public void setHomeForm(Parent homeForm) {
		this.homeForm = homeForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		//homeSvc = new ShopHomeService();
	}
	public void homeData() {
		//미승인 주문내역
		String order = homeSvc.beforeCnt() + "";
		//beforeCnt = (Label)homeForm.lookup("#beforeCnt"); 활성화시 null발생
		beforeCnt.setText(order);
		//매출내역
		int[] day = homeSvc.shopSales(10);
		int[] month = homeSvc.shopSales(7);
		int[] year = homeSvc.shopSales(4);
		
		datePrice.setText(day[0] + "");
		dateCount.setText(day[1] +"");
		monthPrice.setText(month[0] + "");
		monthCount.setText(month[1] + "");
		yearPrice.setText(year[0] + "");
		yearCount.setText(year[1] + "");
	}
	
	public void clickOrderBtn() {
		CommonService.closeForm(homeForm);
		homeSvc.clickOrderBtn();
	}
	
	public void clickHomeBtn() {
		CommonService.closeForm(homeForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(homeForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(homeForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(homeForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(homeForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(homeForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(homeForm);
		con.openForm("acceptedOrders");
	}

}
