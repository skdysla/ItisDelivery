package member.search;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import member.main.memberController;

public class CartService {
	//SearchMDTO / SearchDAO (shopform에서 선택한 메뉴를 메뉴명, 메뉴가격, 메뉴배달시간만 보여줌)
	private memberController con;
	private CartController cartcon;
	private SearchDAO searchDao;
	private SearchMDTO searchmDto;
	
	public CartService() {
		searchDao = new SearchDAO();
	}

	public void setCartcon(CartController cartcon) {
		this.cartcon = cartcon;
		this.con = cartcon.getCon();
	}
	
	

	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
	}

	public CartController getCartcon() {
		return cartcon;
	}

	public ObservableList<SearchMDTO> showCartList(ObservableList<SearchMDTO> cartlist) {
		ArrayList<SearchMDTO> list = searchDao.cartmenu(con.getfName());
		cartlist.addAll(list);
		return cartlist;
	}

	

	public void cartOrderBtnProc(Parent cartForm) {
		// orderform으로 이동
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/search/MemberOrderForm.fxml"));
		Parent orderform;
		try {
			orderform = loader.load();
			
			PayController ordercon = loader.getController();
			ordercon.setOrderForm(orderform);
			
			con.setOrdercon(ordercon);
			
			Scene scene = new Scene(orderform);
			Stage stage = new Stage();
			stage.setTitle("orderform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	

}
