package shop.list;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import shop.info.CheckPwController;
import shop.info.ShopInfoService;
import shop.info.ShowShopInfoController;
import shop.info.ShowShopOwnerInfoController;
import shop.info.UpdateShopOwnerInfoController;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import shop.main.ShopMainController;

public class ShopListController implements Initializable{
	
	private ShopMainController con;
	private ShopBlackListController blackListCon;
	private ShopReviewController reviewCon;
	private ShopListService ListSvc;
	private Parent listForm;
	private String sId;
	
	public ShopMainController getCon() {
		return con;
	}
	public void setCon(ShopMainController con) {
		this.con = con;
		this.ListSvc.setListCon(this);
	}
	public void setShopReviewController(ShopReviewController reviewCon) {
		this.reviewCon = reviewCon;
		this.reviewCon.setListCon(this);
	}
	public void setShopBlackListController(ShopBlackListController blackListCon) {
		this.blackListCon = blackListCon;
		this.blackListCon.setListCon(this);
	}
	public void setsId(String sId) {
		this.sId = sId;		
	}
	//블랙리스트 조회페이지 버튼
	public void blackListBtn() {
		CommonService.closeForm(listForm);
		ListSvc.openBlackListForm();
	}
	
	//리뷰리스트 조회페이지 버튼
	public void reviewBtn() {
		CommonService.closeForm(listForm);
		ListSvc.openReviewListForm();
	}
	
	//화면 하단아이콘 버튼
	public void clickHomeBtn() {
		CommonService.closeForm(listForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(listForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(listForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(listForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(listForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(listForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(listForm);
		con.openForm("acceptedOrders");
	}
	public void setListForm(Parent listForm) {
		this.listForm = listForm;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		ListSvc = new ShopListService();
	}
	

	
	
	
	
}
