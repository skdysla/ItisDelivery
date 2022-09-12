package member.order;

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
import member.main.memberController;
import member.review.reviewListService;

public class orderDetailController implements Initializable{
	@FXML private TableView<orderDetailDTO> detailTable;
	@FXML private TableColumn<orderDetailDTO, String> o_menu;
	@FXML private TableColumn<orderDetailDTO, String> o_cnt;
	@FXML private TableColumn<orderDetailDTO, String> o_price;
	
	private ObservableList<orderDetailDTO> menuList;
	
	private memberController con;
	private Parent orderListForm;
	private Parent orderDetailForm;
	private orderListService orderSvc;
	private reviewListService reviewSvc;
	private Integer Onum;
	private Integer total;
	
	public memberController getCon() {
		return con;
	}
	
	public void setCon(memberController con) {
		this.con = con;
//		System.out.println("orderDetailCon : " + con);
		orderSvc = new orderListService(con);
		this.orderSvc.setOrderDetailCon(this);
		show();
	}
	
	public Integer getOnum() {
		return Onum;
	}
	public void setOnum(Integer onum) {
		Onum = onum;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public void setOrderDetailForm(Parent orderDetailForm) {
		this.orderDetailForm = orderDetailForm;
	}
	
	public void setReviewSvc(reviewListService reviewSvc) {
		this.reviewSvc = reviewSvc;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
//		orderSvc = new orderService(con);
		menuList = FXCollections.observableArrayList();
		reviewSvc = new reviewListService(con);
		
	}
	
	//리뷰 쓰기 버튼
	public void clickReviewBtn() {
		orderDTO oderDto = new orderDTO(Onum);
		CommonService.closeForm(orderDetailForm);
//		System.out.println("insertReviewBtn : " + con);
		reviewSvc.openReviewCreateForm(oderDto);
	}
	
	public void show() {
		System.out.println("orderDetailConshow : " + con);
		menuList = orderSvc.showDetail(menuList);
		
		if(menuList != null) {
			for(int i = 0; i < menuList.size(); i++) {
				o_menu.setCellValueFactory(new PropertyValueFactory<orderDetailDTO, String>("o_menu"));
				o_cnt.setCellValueFactory(new PropertyValueFactory<orderDetailDTO, String>("o_cnt"));
				o_price.setCellValueFactory(new PropertyValueFactory<orderDetailDTO, String>("o_price"));
				detailTable.setItems(menuList);
			}
		}
		
		Label totalPrice = (Label) orderDetailForm.lookup("#totalPrice");
		totalPrice.setText(this.total.toString());
	}
	
	
	
	
	public void clickHomeBtn() { CommonService.closeForm(orderDetailForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(orderDetailForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(orderDetailForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(orderDetailForm); con.openForm("order"); }
	public void clickMyInfoBtn() { CommonService.closeForm(orderDetailForm); con.openForm("mypage"); }
}
