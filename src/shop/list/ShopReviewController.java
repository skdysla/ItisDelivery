package shop.list;

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

public class ShopReviewController implements Initializable{
	
	private ShopMainController con;
	private ShopListController ListCon;
	private ShopReviewService reviewSvc;
	private Parent reviewForm;
	private ShopReviewDTO reviewDto;
	
	
	@FXML private TableView<ShopReviewDTO> reviewTable;
	@FXML private TableColumn<ShopReviewDTO, String> o_time;
	@FXML private TableColumn<ShopReviewDTO, String> m_id;
	@FXML private TableColumn<ShopReviewDTO, String> o_menu;
	@FXML private TableColumn<ShopReviewDTO, String> r_text;
	@FXML private TableColumn<ShopReviewDTO, Number> r_score;
	
	ObservableList<ShopReviewDTO> reviewList = FXCollections.observableArrayList();
	//dao 기준은 가게 기준으로 긁기
	public ShopMainController getCon() {
		return con;
	}
	public void setListCon(ShopListController ListCon) {
		this.ListCon = ListCon;
		this.con = ListCon.getCon();
		reviewSvc = new ShopReviewService();
		reviewSvc.setReviewCon(this,con);
		show();
	}
	public void show(){
		reviewDto = new ShopReviewDTO();
		
		o_time.setCellValueFactory(new PropertyValueFactory<ShopReviewDTO, String>("o_time"));
		m_id.setCellValueFactory(new PropertyValueFactory<ShopReviewDTO, String>("m_id"));
		o_menu.setCellValueFactory(new PropertyValueFactory<ShopReviewDTO, String>("o_menu"));
		r_text.setCellValueFactory(new PropertyValueFactory<ShopReviewDTO, String>("r_text"));
		r_score.setCellValueFactory(new PropertyValueFactory<ShopReviewDTO, Number>("r_score"));
		
		reviewTable.setItems(reviewList);
		reviewList.clear();//재업데이트 작업
		reviewTable.setItems(reviewSvc.refresh(reviewList));
	}
	
	public void setReviewForm(Parent reviewForm) {
		this.reviewForm = reviewForm;
	}
	
	public ShopListController getListCon() {
		return ListCon;
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void reviewBackBtn(){
		CommonService.closeForm(reviewForm);
		con.openForm("list");
	}
	//화면 하단아이콘 버튼
	public void clickHomeBtn() {
		CommonService.closeForm(reviewForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(reviewForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(reviewForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(reviewForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(reviewForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(reviewForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(reviewForm);
		con.openForm("acceptedOrders");
	}
	
}
