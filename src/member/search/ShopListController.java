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
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import member.like.LikeService;
import member.main.memberController;

public class ShopListController implements Initializable{
	
	@FXML private TableView<SearchDTO> searchTable;
	@FXML private TableColumn<SearchDTO, String> s_logo;
	@FXML private TableColumn<SearchDTO, String> s_name;
	@FXML private TableColumn<SearchDTO, String> s_food_cate;
	@FXML private TableColumn<SearchDTO, Integer> s_total;
	@FXML private TableColumn<SearchDTO, Integer> s_order_cnt;
	@FXML private TableColumn<SearchDTO, Integer> s_like_cnt;
	@FXML private TableColumn<SearchDTO, Integer> s_review_cnt;
	@FXML private Label listShopCnt;
	@FXML private ComboBox<String> listCombo;
	@FXML private Button addlikebtn;
	@FXML private Button goshop;
	
	private memberController con;
	private ShopListService shoplistSvc;
	private LikeService likeSvc;
	private Parent shoplistForm;
	private SearchController searchcon;
	
	private String searchBy;
	private String value;
	
	private ObservableList<SearchDTO> shoplist;
	private ObservableList<SearchDTO> shopnamelist;
	private ObservableList<SearchDTO> foodcatelist;
	
	public ShopListService getShoplistSvc() {
		return shoplistSvc;
	}

	public void setShoplistSvc(ShopListService shoplistSvc) {
		this.shoplistSvc = shoplistSvc;
	}

	public Parent getShoplistForm() {
		return shoplistForm;
	}

	public void setShoplistForm(Parent shoplistForm) {
		this.shoplistForm = shoplistForm;
	}

	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
		this.shoplistSvc.setShoplistcon(this);
		this.likeSvc.setLikecon(this);
		show();
	}

	public SearchController getSearchcon() {
		return searchcon;
	}

	public void setSearchcon(SearchController searchcon) {
		this.searchcon = searchcon;
	}

	
	//////
	public void setSearchBy(String searchBy) {
		this.searchBy = searchBy;
	}
	
	public void setValue(String value) {
		this.value = value;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shoplistSvc = new ShopListService();
		likeSvc = new LikeService();
		shoplist = FXCollections.observableArrayList();
		shopnamelist = FXCollections.observableArrayList();
		foodcatelist = FXCollections.observableArrayList();
		
	}
	public void show() {
		if(searchBy.equals("all")) {
			shoplist = shoplistSvc.show(shoplist);
		}else if(searchBy.equals("name")) {
			//value: sName
			shoplist = shoplistSvc.showshow(shoplist, value);
		}else {
			//value: foodCate
			shoplist = shoplistSvc.showshowshow(shoplist, value);
		}
		
		listShopCnt.setText("찾은 가게 수 : " + shoplist.size());
		//s_id, s_logo, s_name, s_food_cate, s_total, s_order_cnt, s_like_cnt, s_review_cnt;
		if(shoplist != null) {
			for(int i = 0; i < shoplist.size(); i++) {
				s_logo.setCellValueFactory(new PropertyValueFactory<SearchDTO,String>("s_logo"));
				s_name.setCellValueFactory(new PropertyValueFactory<SearchDTO,String>("s_name"));
				s_food_cate.setCellValueFactory(new PropertyValueFactory<SearchDTO,String>("s_food_cate"));
				s_total.setCellValueFactory(new PropertyValueFactory<SearchDTO,Integer>("s_total"));
				s_order_cnt.setCellValueFactory(new PropertyValueFactory<SearchDTO,Integer>("s_order_cnt"));
				s_like_cnt.setCellValueFactory(new PropertyValueFactory<SearchDTO,Integer>("s_like_cnt"));
				s_review_cnt.setCellValueFactory(new PropertyValueFactory<SearchDTO,Integer>("s_review_cnt"));
				searchTable.setItems(shoplist);

			}
		}
	}
	
	//주문건수 combo
	public void listComboProc() {}
	
	//shoplistform에서 보기 버튼
	public void goshopProc() {
		SearchDTO searchDto = searchTable.getSelectionModel().getSelectedItem();
		System.out.println(searchDto.getS_id());
		con.setsId(searchDto.getS_id());
		System.out.println(con.getsId());
		closeForm(goshop);
		//searchSvc.goshopProc(shoplistform, "id", searchDto.getS_id());
		shoplistSvc.goshopProc(searchDto);
		
	}
	
	//shoplistform에서 찜 추가 버튼
	public void addlikebtnProc() {
		SearchDTO searchDto = searchTable.getSelectionModel().getSelectedItem();
		con.setsId(searchDto.getS_id());
		System.out.println("찜 추가 버튼 / 가게 아이디 : " + con.getsId() + "회원 아이디 : " + con.getmId());
		likeSvc.addLikeCnt();
		
	}
	
	
	public void closeForm(Button button) {
		Stage stage = (Stage)button.getScene().getWindow();
		stage.close();
	}
	
	//하단
	public void clickHomeBtn() {
		CommonService.closeForm(shoplistForm);
		con.openForm("main");
	}
	public void clickLikeBtn() {
		CommonService.closeForm(shoplistForm);
		con.openForm("like");
	}
	public void clickSearchBtn() {
		CommonService.closeForm(shoplistForm);
		con.openForm("search");
	}
	public void clickOrderListBtn() {
		CommonService.closeForm(shoplistForm);
		con.openForm("order");
	}
	public void clickMyInfoBtn() {
		CommonService.closeForm(shoplistForm);
		con.openForm("mypage");
	}
	public void mainCartBtnProc() {
		CommonService.closeForm(shoplistForm);
		con.openForm("cart");
	}

	

	

	

}
