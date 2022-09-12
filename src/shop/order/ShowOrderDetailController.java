package shop.order;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shop.main.ShopMainController;

public class ShowOrderDetailController implements Initializable {
	
	private ShopMainController con;
	private Parent detailForm;
	private ShowOrderDetailService showDetailSvc;
	private Integer oNum;
	private Integer total;
	
	@FXML private TableView<DetailDTO> table;
	@FXML private TableColumn<DetailDTO, String> o_menu;
	@FXML private TableColumn<DetailDTO, String> o_cnt;
	@FXML private TableColumn<DetailDTO, String> o_price;
	
	private ObservableList<DetailDTO> menuList;

	public void setCon(ShopMainController con) {
		this.con = con;
		this.showDetailSvc.setShowDetailCon(this);
		show();
	}
	
	public void setDetailForm(Parent detailForm) {
		this.detailForm = detailForm;
	}
	
	public Integer getoNum() {
		return oNum;
	}
	
	public void setoNum(Integer oNum) {
		this.oNum = oNum;
	}
	
	public void setTotal(Integer total) {
		this.total = total;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		showDetailSvc = new ShowOrderDetailService();
		menuList = FXCollections.observableArrayList();
	}
	
	public void show() {
		menuList = showDetailSvc.showDetail(menuList);
		
		if(menuList != null) {
			for(int i = 0; i < menuList.size(); i++) {
				o_menu.setCellValueFactory(new PropertyValueFactory<DetailDTO, String>("o_menu"));
				o_cnt.setCellValueFactory(new PropertyValueFactory<DetailDTO, String>("o_cnt"));
				o_price.setCellValueFactory(new PropertyValueFactory<DetailDTO, String>("o_price"));
				table.setItems(menuList);
			}
		}
		Label totalPrice = (Label) detailForm.lookup("#totalPrice");
		totalPrice.setText(this.total.toString());
	}
	
	public void acceptOrder() {
		CommonService.closeForm(detailForm);
		showDetailSvc.acceptOrder();
		con.getHomeCon().clickOrderBtn();
	}
	
	public void refuseOrder() {
		CommonService.closeForm(detailForm);
		showDetailSvc.refuseOrder();
		con.getHomeCon().clickOrderBtn();
	}

	public void clickHomeBtn() {
		CommonService.closeForm(detailForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(detailForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(detailForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(detailForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(detailForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(detailForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(detailForm);
		con.openForm("acceptedOrders");
	}
	
}
