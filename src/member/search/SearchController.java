package member.search;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import member.main.memberController;

public class SearchController implements Initializable{
	
	@FXML private ComboBox<String> searchCombo;
	@FXML private ComboBox<String> searchFoodCombo = new ComboBox<>();
	@FXML private TextField searchShop  = new TextField();
	@FXML private Button searchListBtn;
	
	private memberController con;
	private Parent searchForm;
	private SearchService searchSvc;

	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
		this.searchSvc.setSearchcon(this);
	}

	public Parent getSearchForm() {
		return searchForm;
	}

	public void setSearchForm(Parent searchForm) {
		this.searchForm = searchForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		searchSvc = new SearchService();	
		
		searchShop.setDisable(false);
		searchFoodCombo.setDisable(true);
		searchShop.setStyle("-fx-background-color: transparent;");
		searchFoodCombo.setStyle("-fx-background-color: transparent;");
		
	}
	
	//이름별/종류별 선택 콤보
	public void searchComboProc() {
		String shopname = searchCombo.getSelectionModel().getSelectedItem().toString();
		if(shopname.equals("가게 이름별 검색")) {
			searchShop.setDisable(false);
			searchFoodCombo.setDisable(true);
			searchShop.setStyle("-fx-border-color: black;");
			searchFoodCombo.setStyle("-fx-background-color: transparent;");
		}else if(shopname.equals("음식 종류별 검색")){
			searchShop.setDisable(true);
			searchFoodCombo.setDisable(false);
			searchShop.setStyle("-fx-background-color: transparent;");
			searchFoodCombo.setStyle("-fx-border-color: black;");
		}else {
			searchShop.setDisable(true);
			searchFoodCombo.setDisable(true);
			searchShop.setStyle("-fx-background-color: transparent;");
			searchFoodCombo.setStyle("-fx-background-color: transparent;");
		}
		
	}
	
	
	//검색버튼
	public void searchListBtnProc() {
		String shopname = searchCombo.getSelectionModel().getSelectedItem().toString();
		if(shopname.equals("모두 검색")) {
			searchSvc.searchListBtnProc(searchForm, "all", "all");
		}else if(shopname.equals("가게 이름별 검색")){
			searchSvc.searchListBtnProc(searchForm, "name", searchShop.getText());
		}else {
			searchSvc.searchListBtnProc(searchForm, "cate", searchFoodCombo.getSelectionModel().getSelectedItem().toString());
		}
		CommonService.closeForm(searchForm);
	}
	
	
	//하단
		public void clickHomeBtn() {
			CommonService.closeForm(searchForm);
			con.openForm("main");
		}
		public void clickLikeBtn() {
			CommonService.closeForm(searchForm);
			con.openForm("like");
		}
		public void clickSearchBtn() {
			CommonService.closeForm(searchForm);
			con.openForm("search");
		}
		public void clickOrderListBtn() {
			CommonService.closeForm(searchForm);
			con.openForm("order");
		}
		public void clickMyInfoBtn() {
			CommonService.closeForm(searchForm);
			con.openForm("mypage");
		}
		public void mainCartBtnProc() {
			CommonService.closeForm(searchForm);
			con.openForm("cart");
		}

	
}
