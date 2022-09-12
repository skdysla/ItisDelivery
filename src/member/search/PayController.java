package member.search;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import member.main.memberController;

public class PayController implements Initializable {
	
	@FXML private TableView<SearchMDTO> orderTable;
	@FXML private TableColumn<SearchMDTO, String> m_address;
	@FXML private TableColumn<SearchMDTO, String> m_tel;
	@FXML private Button orderPayBtn;
	@FXML private Button back;
	
	private memberController con;
	private PayService orderSvc;
	private Parent orderForm;
	
	private ObservableList<SearchMDTO> memberlist;
	
	public Parent getOrderForm() {
		return orderForm;
	}

	public void setOrderForm(Parent orderForm) {
		this.orderForm = orderForm;
	}

	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
		this.orderSvc.setOrdercon(this);
		show();
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		orderSvc = new PayService();
		memberlist = FXCollections.observableArrayList();
	}
	
	public void show() {
	      memberlist = orderSvc.show(memberlist);
	      
	      //s_name, f_name, f_price
	      if(memberlist != null) {
	         for(int i = 0; i < memberlist.size(); i++) {
	            m_address.setCellValueFactory(new PropertyValueFactory<SearchMDTO,String>("m_address"));
	            m_tel.setCellValueFactory(new PropertyValueFactory<SearchMDTO,String>("m_tel"));
	            orderTable.setItems(memberlist);
	         }
	      }else {
	         System.out.println("없음");
	      }
	   }

	
	public void orderPayBtnProc() {
		//주문완료 알림창 띄우고 정보 주문내역 테이블에 저장
		orderSvc.orderPayBtnProc(orderForm);
	}
	
	public void backProc() {
		//장바구니 페이지로 돌아가기
		CommonService.closeForm(orderForm);
	}
	
	
	
	//하단
		public void clickHomeBtn() {
			CommonService.closeForm(orderForm);
			con.openForm("main");
		}
		public void clickLikeBtn() {
			CommonService.closeForm(orderForm);
			con.openForm("like");
		}
		public void clickSearchBtn() {
			CommonService.closeForm(orderForm);
			con.openForm("search");
		}
		public void clickOrderListBtn() {
			CommonService.closeForm(orderForm);
			con.openForm("order");
		}
		public void clickMyInfoBtn() {
			CommonService.closeForm(orderForm);
			con.openForm("mypage");
		}
		public void mainCartBtnProc() {
			CommonService.closeForm(orderForm);
			con.openForm("cart");
		}
	

	
}
