package shop.order;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Callback;
import shop.main.ShopMainController;

public class ShopAllOController implements Initializable {
	
	private ShopMainController con;
	private ShopAllOService allOrdersSvc;
	private Parent allOrdersForm;
	private ObservableList<OrderDTO> orderList;
	
	@FXML private TableView<OrderDTO> all_orders;
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
		this.allOrdersSvc.setAllOCon(this);
		show();
	}

	public void setAllOrdersForm(Parent allOrdersForm) {
		this.allOrdersForm = allOrdersForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		allOrdersSvc = new ShopAllOService();
		orderList = FXCollections.observableArrayList();
	}
	
	public void show() {
		orderList = allOrdersSvc.show(orderList);
		
		if(orderList != null) {
			for(int i = 0; i < orderList.size(); i++) {
				o_num.setCellValueFactory(new PropertyValueFactory<OrderDTO, Integer>("o_num"));
				o_time.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_time"));
				o_menu.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_menu"));
				o_cnt.setCellValueFactory(new PropertyValueFactory<OrderDTO, Integer>("o_cnt"));
				o_price.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_price"));
				all_orders.setItems(orderList);
			}
		}
	}
	
	public void showOrderDetail() {
		OrderDTO dto = all_orders.getSelectionModel().getSelectedItem();
		if (dto != null) {
			CommonService.closeForm(allOrdersForm);
			allOrdersSvc.showOrderDetail(dto);
		} else {
			CommonService.msgBtn("목록을 선택해 주세요");
		}
	}
	
	public void clickHomeBtn() {
		CommonService.closeForm(allOrdersForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(allOrdersForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(allOrdersForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(allOrdersForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(allOrdersForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(allOrdersForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(allOrdersForm);
		con.openForm("acceptedOrders");
	}

}
