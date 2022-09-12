package admin.review;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import admin.common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import admin.main.AdminController;

public class ReviewController implements Initializable{
	@FXML private TableView<ReviewDTO> table;
	@FXML private TableColumn<ReviewDTO, Integer> number;
	@FXML private TableColumn<ReviewDTO, String> shop;
	@FXML private TableColumn<ReviewDTO, String> text;
	@FXML private TableColumn<ReviewDTO, Integer> score;
	
	@FXML private Label memberId;
	@FXML private Label rest;
	ReviewDTO reviewDto = null;
	
	ObservableList<ReviewDTO> list = FXCollections.observableArrayList();
	
	private ReviewDAO reviewDao;
	private Parent reviewForm;
	private AdminController controller;
	private String data1,data2;
	
	public void setData1(String data1) {
		this.data1 = data1;
	}
	public String getData1() {
		return data1;
	}
	public void setData2(String data2) {
		this.data2 = data2;
	}
	public String getData2() {
		return data2;
	}
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	public void setReviewForm(Parent reviewForm) {
		this.reviewForm = reviewForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		reviewDao = new ReviewDAO();
		setData1(reviewDao.getData1());
		setData2(reviewDao.getData2());
		memberId.setText(getData1());
		String restMsg = "";
		if(getData2().equals("true")) {
			restMsg = "휴면";
		}
		rest.setText(restMsg);
		
		number.setCellValueFactory(new PropertyValueFactory<ReviewDTO,Integer>("number"));
		shop.setCellValueFactory(new PropertyValueFactory<ReviewDTO,String>("shop"));
		text.setCellValueFactory(new PropertyValueFactory<ReviewDTO,String>("text"));
		score.setCellValueFactory(new PropertyValueFactory<ReviewDTO,Integer>("score"));
		refresh();
	}
	
	public void refresh() {
		list.clear();
		ArrayList<ReviewDTO> arr = new ArrayList<ReviewDTO>();
		arr = reviewDao.selectAll(getData1());
		list.addAll(arr);
		table.setItems(list);
	}
	
	public void deleteBtn() {
		reviewDto = table.getSelectionModel().getSelectedItem();
		if(reviewDto != null) {
			int rNum = reviewDto.getNumber();
			
			if(CommonService.msgBtn(rNum+"번 리뷰를 삭제하시겠습니까?") == 1){
				reviewDao.delete(rNum);
				CommonService.msg(rNum+"번 리뷰 삭제완료");
				refresh();
			}
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
	public void cancleBtn() {
		reviewDao.deleteData(getData1());
		CommonService.windowClose(reviewForm);
		controller.open("memberList");
	}
	public void homeBtn() {
		reviewDao.deleteData(getData1());
		CommonService.windowClose(reviewForm);
		controller.open("home");
	}
	public void blackListBtn() {
		reviewDao.deleteData(getData1());
		CommonService.windowClose(reviewForm);
		controller.open("blackList");
	}
	public void adminListBtn() {
		reviewDao.deleteData(getData1());
		CommonService.windowClose(reviewForm);
		controller.open("adminList");
	}
}
