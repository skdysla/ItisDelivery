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
import javafx.scene.control.cell.PropertyValueFactory;
import member.main.memberController;

public class CartController implements Initializable {
	@FXML private TableView<SearchMDTO> cartTable;
	@FXML private TableColumn<SearchMDTO, String> f_name;
	@FXML private TableColumn<SearchMDTO, String> f_price;
	@FXML private TableColumn<SearchMDTO, Integer> f_exp_time;
	
	@FXML private Button cartCancelBtn;
	@FXML private Button cartMinusBtn;
	@FXML private Button cartPlusBtn;
	@FXML private Button cartAddBtn;
	@FXML private Button cartOrderBtn;
	@FXML private Button addcart;
	@FXML private Label cartCntLabel;
	@FXML private Label cartTotalSal;
	
	private memberController con;
	private Parent cartForm;
	private CartService cartSvc;
	
	private  ObservableList<SearchMDTO> cartlist;
	

	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
		this.cartSvc.setCartcon(this);
		showCartList();
	}

	public Parent getCartForm() {
		return cartForm;
	}

	public void setCartForm(Parent cartForm) {
		this.cartForm = cartForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		cartSvc = new CartService();
		cartlist = FXCollections.observableArrayList();
		
	}
	
	public void showCartList() {
		cartlist = cartSvc.showCartList(cartlist);
		
		//s_id, f_name, f_price, f_exp_time
		if(cartlist != null) {
			for(int i = 0; i < cartlist.size(); i++) {
				f_name.setCellValueFactory(new PropertyValueFactory<SearchMDTO,String>("f_name"));
				f_price.setCellValueFactory(new PropertyValueFactory<SearchMDTO,String>("f_price"));
				f_exp_time.setCellValueFactory(new PropertyValueFactory<SearchMDTO,Integer>("f_exp_time"));
				cartTable.setItems(cartlist);
				con.setCartTable(cartTable);
			}
		}else {
			System.out.println("없음");
		}
	}
	
	
	///
	public void cartCancelBtnProc() {
		SearchMDTO searchmDto = cartTable.getSelectionModel().getSelectedItem();
		System.out.println(searchmDto.getF_name());
		cartTable.getItems().clear();
	}
	
	int cnt = 1;
	public void cartMinusBtnProc() {
		//label -
		if(cnt > 1) 
		cnt--;
		int price = Integer.valueOf(con.getfPrice());
		int total = price * cnt;
		cartTotalSal.setText("" + total);
		cartCntLabel.setText("" + cnt);
		
		
	}
	public void cartPlusBtnProc() {
		//label +		
		cnt++;
		cartCntLabel.setText("" + cnt);
		int price = Integer.valueOf(con.getfPrice());
		int total = price * cnt;
		cartTotalSal.setText("" + total);
		cartCntLabel.setText("" + cnt);
	}
//	public void goshopProc() {
//		//장바구니 화면으로 돌아가기
//		
//		CommonService.msg("커밍순..");
//	}
	
	public void cartOrderBtnProc() {
		//다음내용 주문내역 테이블에 insert
		con.setMemberCartForm(cartForm);
		cartSvc.cartOrderBtnProc(cartForm);
	}
	
	public void backProc() {
		CommonService.closeForm(cartForm);
	}
	
	
	//하단
	public void clickHomeBtn() {
		CommonService.closeForm(cartForm);
		con.openForm("main");
	}
	public void clickLikeBtn() {
		CommonService.closeForm(cartForm);
		con.openForm("like");
	}
	public void clickSearchBtn() {
		CommonService.closeForm(cartForm);
		con.openForm("search");
	}
	public void clickOrderListBtn() {
		CommonService.closeForm(cartForm);
		con.openForm("order");
	}
	public void clickMyInfoBtn() {
		CommonService.closeForm(cartForm);
		con.openForm("mypage");
	}
	public void mainCartBtnProc() {
		CommonService.closeForm(cartForm);
		con.openForm("cart");
	}
	
	

}
