package shop.order;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shop.main.ShopMainController;

public class ShopAcceptedOController implements Initializable {
	
	private ShopMainController con;
	private ShopAcceptedOService acceptedOSvc;
	private Parent acceptedOForm;
	private ObservableList<OrderDTO> orderList;
	
	@FXML private TableView<OrderDTO> accepted_orders;
	@FXML private TableColumn<OrderDTO, Integer> o_num;
	@FXML private TableColumn<OrderDTO, String> o_time;
	@FXML private TableColumn<OrderDTO, String> o_menu;
	@FXML private TableColumn<OrderDTO, Integer> o_cnt;
	@FXML private TableColumn<OrderDTO, String> o_price;
	
	public ShopMainController getCon() {
		return con;
	}

	public void setCon(ShopMainController con) {
		this.con = con;
		this.acceptedOSvc.setAcceptedOCon(this);
		show();
	}

	public Parent getAcceptedOForm() {
		return acceptedOForm;
	}

	public void setAcceptedOForm(Parent acceptedOForm) {
		this.acceptedOForm = acceptedOForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		acceptedOSvc = new ShopAcceptedOService();
		orderList = FXCollections.observableArrayList();
	}
	
	public void show() {
		orderList = acceptedOSvc.show(orderList);
		
		if(orderList != null) {
			for(int i = 0; i < orderList.size(); i++) {
				o_num.setCellValueFactory(new PropertyValueFactory<OrderDTO, Integer>("o_num"));
				o_time.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_time"));
				o_menu.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_menu"));
				o_cnt.setCellValueFactory(new PropertyValueFactory<OrderDTO, Integer>("o_cnt"));
				o_price.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_price"));
				accepted_orders.setItems(orderList);
			}
		}
	}
	
	public void showOrderDetail() {
		OrderDTO dto = accepted_orders.getSelectionModel().getSelectedItem();
		
		if (dto != null) {
			CommonService.closeForm(acceptedOForm);
			acceptedOSvc.showOrderDetail(dto);
		} else {
			CommonService.msgBtn("목록을 선택해 주세요");
		}
	}
	
	public void clickHomeBtn() {
		CommonService.closeForm(acceptedOForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(acceptedOForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(acceptedOForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(acceptedOForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(acceptedOForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(acceptedOForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(acceptedOForm);
		con.openForm("acceptedOrders");
	}

}
