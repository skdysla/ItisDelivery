package member.review;

import java.net.URL;
import java.util.ArrayList;
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

public class reviewListController implements Initializable{
	@FXML private TableView<reviewDTO> reviewTable;
	@FXML private TableColumn<reviewDTO, String> s_name;
	@FXML private TableColumn<reviewDTO, String> s_branch;
	@FXML private TableColumn<reviewDTO, String> o_menu;
	@FXML private TableColumn<reviewDTO, Integer> r_score;
//	@FXML private TableColumn<reviewDTO, String> r_text;
//	@FXML private TableColumn<LoginDTO, String> pic;
	
	private memberController con;
	private updateReviewController upCon;
	private Parent reviewListForm;
	private Parent reviewDetailForm;
	private Parent updateReviewForm;
	private Parent reviewCreateForm;
	private reviewListService reviewSvc;
	private ObservableList<reviewDTO> list;
	private Integer Onum;
	
//	ObservableList<reviewDTO> list = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {	
		reviewSvc = new reviewListService(con);
		list = FXCollections.observableArrayList();
		
	}
	

	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
//		setOnum(con.getrNum());
		this.reviewSvc.setReviewCon(this);
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$4" + con);
		showReviewList();
	}
	
	public void setUpCon(updateReviewController upCon) {
		this.upCon = upCon;
	}
	
	public Integer getOnum() {
		return Onum;
	}
	public void setOnum(Integer onum) {
		Onum = onum;
	}
	
	public void showReviewList() {
		ArrayList<reviewDTO> tmp = reviewSvc.show();
		list.addAll(tmp);
		
		
		if(!list.isEmpty()) {
			for(int i = 0; i < list.size(); i++) {
				s_name.setCellValueFactory(new PropertyValueFactory<reviewDTO,String>("s_name"));
				s_branch.setCellValueFactory(new PropertyValueFactory<reviewDTO,String>("s_branch"));
				o_menu.setCellValueFactory(new PropertyValueFactory<reviewDTO,String>("o_menu"));
				r_score.setCellValueFactory(new PropertyValueFactory<reviewDTO,Integer>("r_score"));
//				r_text.setCellValueFactory(new PropertyValueFactory<reviewDTO,String>("r_text"));
//				pic.setCellValueFactory(new PropertyValueFactory<reviewDTO,String>("pic"));
				
				reviewTable.setItems(list);
				System.out.println("뭐야..");
			}
		}else {
			System.out.println("reviewCon : " + con);
			System.out.println("빈 리스트");
		}
	}

	public Parent getReviewListForm() {
		return reviewListForm;
	}
	
	public reviewListController() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public void setReviewListForm(Parent reviewListForm) {
		this.reviewListForm = reviewListForm;
	}
	
	public Parent getReviewDetailForm() {
		return reviewDetailForm;
	}
	
	public void setReviewDetailForm(Parent reviewDetailForm) {
		this.reviewDetailForm = reviewDetailForm;
	}
	
	public Parent getUpdateReviewForm() {
		return updateReviewForm;
	}
	
	public void setUpdateReviewForm(Parent updateReviewForm) {
		this.updateReviewForm = updateReviewForm;
	}
	
	public Parent getReviewCreateForm() {
		return reviewCreateForm;
	}
	public void setReviewCreateForm(Parent reviewCreateForm) {
		this.reviewCreateForm = reviewCreateForm;
	}
	
	
	public void datailBtn() {
		reviewDTO dto = reviewTable.getSelectionModel().getSelectedItem();
		CommonService.closeForm(reviewListForm);
		con.setoNum(dto.getO_num());
		reviewSvc.openReviewUpdateForm(dto);
	}
	

	//하단 버튼
	public void clickHomeBtn() { CommonService.closeForm(reviewListForm); con.openForm("main"); }
	public void clickLikeBtn() { CommonService.closeForm(reviewListForm); con.openForm("like"); }
	public void clickSearchBtn() { CommonService.closeForm(reviewListForm); con.openForm("search"); }
	public void clickOrderListBtn() { CommonService.closeForm(reviewListForm); con.openForm("order"); }
	public void clickMyInfoBtn() { CommonService.closeForm(reviewListForm); con.openForm("mypage"); }
	
}
