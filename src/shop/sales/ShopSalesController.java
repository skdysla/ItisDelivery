package shop.sales;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shop.main.ShopMainController;
import shop.order.OrderDTO;

public class ShopSalesController implements Initializable {
	
	private ShopMainController con;
	private ShopSalesService salesSvc;
	private Parent salesForm;
	private String total;
	
	@FXML private TableView<OrderDTO> sales;
	@FXML private TableColumn<OrderDTO, String> o_menu;
	@FXML private TableColumn<OrderDTO, String> o_cnt;
	@FXML private TableColumn<OrderDTO, String> o_price;
	@FXML private PieChart menuChart;
	@FXML private Label salesTotal; 
	
	private ObservableList<OrderDTO> salesList;

	public ShopMainController getCon() {
		return con;
	}

	public void setCon(ShopMainController con) {
		this.con = con;
		this.salesSvc.setSalesCon(this);
		today();
	}

	public Parent getSalesForm() {
		return salesForm;
	}

	public void setSalesForm(Parent salesForm) {
		this.salesForm = salesForm;
	}
	
	public void setTotal(String total) {
		this.total = total;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		salesSvc = new ShopSalesService();
		salesList = FXCollections.observableArrayList();
	}
	
	public void addTable(ObservableList<OrderDTO> salesList) {
		if (salesList != null) {
			for (int i = 0; i < salesList.size(); i++) {
				o_menu.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_menu"));
				o_cnt.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_cnt"));
				o_price.setCellValueFactory(new PropertyValueFactory<OrderDTO, String>("o_price"));
				sales.setItems(salesList);
			}
		}else {
			setTotal("0");
		}
	}
	
	public void today() {
		if (salesList != null) salesList.clear();
		salesList = FXCollections.observableArrayList();
		salesList = salesSvc.AddDto(salesList, salesSvc.today(), menuChart);
		addTable(salesList);
		salesTotal.setText(total);
	}

	public void thisMonth() {
		if (salesList != null) salesList.clear();
		salesList = FXCollections.observableArrayList();
		salesList = salesSvc.AddDto(salesList, salesSvc.thisMonth(), menuChart);
		addTable(salesList);
		salesTotal.setText(total);
	}

	public void thisYear() {
		if (salesList != null) salesList.clear();
		salesList = FXCollections.observableArrayList();
		salesList = salesSvc.AddDto(salesList, salesSvc.thisYear(), menuChart);
		addTable(salesList);
		salesTotal.setText(total);
	}

	public void total() {
		if (salesList != null) salesList.clear();
		salesList = FXCollections.observableArrayList();
		salesList = salesSvc.AddDto(salesList, salesSvc.total(), menuChart);
		addTable(salesList);
		salesTotal.setText(total);
	}
	
	public void clickHomeBtn() {
		CommonService.closeForm(salesForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(salesForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(salesForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(salesForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(salesForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(salesForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(salesForm);
		con.openForm("acceptedOrders");
	}

}
