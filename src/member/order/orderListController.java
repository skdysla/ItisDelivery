package member.order;

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
import member.main.memberController;

public class orderListController implements Initializable{
	@FXML private TableView<orderDTO> orderTable;
	@FXML private TableColumn<orderDTO, Integer> o_num;
	@FXML private TableColumn<orderDTO, String> s_name;
	@FXML private TableColumn<orderDTO, String> s_branch;
	@FXML private TableColumn<orderDTO, String> o_menu;
	@FXML private TableColumn<orderDTO, String> o_cnt;
	@FXML private TableColumn<orderDTO, String> o_price;
	
	private orderDTO orderDto;
	private ObservableList<orderDTO> orderList;
	
	private memberController con;
	private Parent orderListForm;
	private Parent orderDetailForm;
	private orderListService orderSvc;	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		orderList = FXCollections.observableArrayList();
	}
	
//	public orderListController() {
//		orderList = FXCollections.observableArrayList();
//	}

	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
		System.out.println("orderlistCon : " + con);
//		con.getmId();
		orderSvc = new orderListService(con);
		this.orderSvc.setOrderCon(this);
		showOrderList();
	}	

	public Parent getOrderListForm() {
		return orderListForm;
	}

	public void setOrderListForm(Parent orderListForm) {
		this.orderListForm = orderListForm;
	}
	
	public Parent getOrderDetailForm() {
		return orderDetailForm;
	}
	
	public void setOrderDetailForm(Parent orderDetailForm) {
		this.orderDetailForm = orderDetailForm;
	}
	
	public void showOrderList() {
		orderList = orderSvc.show(orderList);
		
		if(!orderList.isEmpty()) {
//			System.out.println(orderList.size());
			for(int i = 0; i< orderList.size(); i++) {
				
				o_num.setCellValueFactory(new PropertyValueFactory<orderDTO,Integer>("o_num"));
				s_name.setCellValueFactory(new PropertyValueFactory<orderDTO,String>("s_name"));
				s_branch.setCellValueFactory(new PropertyValueFactory<orderDTO,String>("s_branch"));
				o_menu.setCellValueFactory(new PropertyValueFactory<orderDTO,String>("o_menu"));
				o_cnt.setCellValueFactory(new PropertyValueFactory<orderDTO,String>("o_cnt"));
				o_price.setCellValueFactory(new PropertyValueFactory<orderDTO,String>("o_price"));
				orderTable.setItems(orderList);
			}
		}else {
			System.out.println("orderCon : " + con);
			System.out.println("빈 리스트");
		}
		
	}
	

	
	public void datailBtn() {
		orderDTO dto = orderTable.getSelectionModel().getSelectedItem();
		CommonService.closeForm(orderListForm);
		System.out.println("detailBtn : " + dto);
		orderSvc.showOrderDetail(dto);
	}
	
	//하단 버튼
//	public void mainCartBtnProc() {}
	public void clickHomeBtn() { CommonService.closeForm(orderListForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(orderListForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(orderListForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(orderListForm); con.openForm("order"); }
	public void clickMyInfoBtn() { CommonService.closeForm(orderListForm); con.openForm("mypage"); }

}
