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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import member.main.memberController;

public class ShopController implements Initializable{
	//shoplistform controller
	@FXML private TableView<SearchMDTO> searchshopTable;
	@FXML private TableColumn<SearchMDTO, String> f_photo;
	@FXML private TableColumn<SearchMDTO, String> f_name;
	@FXML private TableColumn<SearchMDTO, String> f_explain;
	@FXML private TableColumn<SearchMDTO, Integer> f_price;
	@FXML private TableColumn<SearchMDTO, Integer> f_exp_time;
	@FXML private Label shopname;
	@FXML private Label shopLikeCnt;
	@FXML private Label shopOrderCnt;
	@FXML private Button shopReviewBtn;
	@FXML private TextField shopText;
	@FXML private Button addcartbtn;
	
	private memberController con;
	private ShopService shopSvc;
	private Parent shopform;
	
	private ObservableList<SearchMDTO> menulist;

	
	
	public Parent getShopform() {
		return shopform;
	}

	public void setShopform(Parent shopform) {
		this.shopform = shopform;
	}

	public memberController getCon() {
		return con;
	}
	

	public void setCon(memberController con) {
		this.con = con;
		this.shopSvc.setShopcon(this);
		showMenuList();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shopSvc = new ShopService();
		menulist = FXCollections.observableArrayList();
	}

	public void showMenuList() {
		menulist = shopSvc.showMenuList(menulist);
		
		if(menulist != null) {
			for(int i = 0; i < menulist.size(); i++) {
				f_photo.setCellValueFactory(new PropertyValueFactory<SearchMDTO,String>("f_photo"));
				f_name.setCellValueFactory(new PropertyValueFactory<SearchMDTO,String>("f_name"));
				f_explain.setCellValueFactory(new PropertyValueFactory<SearchMDTO,String>("f_explain"));
				f_price.setCellValueFactory(new PropertyValueFactory<SearchMDTO,Integer>("f_price"));
				f_exp_time.setCellValueFactory(new PropertyValueFactory<SearchMDTO,Integer>("f_exp_time"));
				searchshopTable.setItems(menulist);
			}
		}
	}
	
	
	//가게 리뷰로 이동
	public void shopReviewBtnProc() {
		System.out.println("가게 리뷰로 이동");
	}
	
	//장바구니로 이동
	public void addcartbtnProc() {
		SearchMDTO searchmDto = searchshopTable.getSelectionModel().getSelectedItem();
		System.out.println("장바구니 버튼 : " + searchmDto.getF_name());
		con.setfName(searchmDto.getF_name());
		System.out.println("장바구니 버튼 콘으로 : " + con.getfName());
		shopSvc.addcartbtnProc(searchmDto);
		
		System.out.println("회원 아이디 : " +  con.getmId()) ;
		
		//CommonService.closeForm(shopform);
	}
	
	
	
	
	
	//하단
			public void clickHomeBtn() {
				CommonService.closeForm(shopform);
				con.openForm("main");
			}
			public void clickLikeBtn() {
				CommonService.closeForm(shopform);
				con.openForm("like");
			}
			public void clickSearchBtn() {
				CommonService.closeForm(shopform);
				con.openForm("search");
			}
			public void clickOrderListBtn() {
				CommonService.closeForm(shopform);
				con.openForm("order");
			}
			public void clickMyInfoBtn() {
				CommonService.closeForm(shopform);
				con.openForm("mypage");
			}
			public void mainCartBtnProc() {
				CommonService.closeForm(shopform);
				con.openForm("cart");
			}

			

	

	

}
