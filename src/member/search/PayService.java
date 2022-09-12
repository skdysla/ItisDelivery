package member.search;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import member.main.memberController;

public class PayService {
	//SearchMDTO / SearchDAO (cartform의 데이터 중 가게명, 메뉴명, 메뉴가격만 보여줌)
	private memberController con;
	private PayController ordercon;
	private SearchDAO searchDao;
	private SearchMDTO searchmDto;
	
	public PayService() {
		searchDao = new SearchDAO();
	}

	

	public memberController getCon() {
		return con;
	}



	public void setCon(memberController con) {
		this.con = con;
	}



	public PayController getOrdercon() {
		return ordercon;
	}



	public void setOrdercon(PayController ordercon) {
		this.ordercon = ordercon;
		this.con = ordercon.getCon();
	}




	public ObservableList<SearchMDTO> show(ObservableList<SearchMDTO> memberlist) {
	      ArrayList<SearchMDTO> list = searchDao.selectmember(con.getmId());
	      memberlist.addAll(list);
	      return memberlist;
	   }
	
	////
	
	//payform
//	public void orderPayBtnProc(Button orderPayBtn) {
//		Alert alert = new Alert(AlertType.INFORMATION);
//		alert.setTitle("주문완료!");
//		alert.setContentText("주문이 완료되었습니다!");
//		alert.show();
//	}

	public void cartAddBtnProc(Parent cartForm) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/search/MemberShopForm.fxml"));
		Parent shopform;
		try {
			shopform = loader.load();
			
			ShopController shopcon = loader.getController();
			shopcon.setShopform(shopform);
			
			con.setShopcon(shopcon);
			
			Scene scene = new Scene(shopform);
			Stage stage = new Stage();
			stage.setTitle("shopform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	//장바구니 추가 버튼에서 받음
	public void addcartbtnProc(SearchMDTO searchmDto) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/search/MemberCartForm.fxml"));
		Parent cartform;
		try {
			cartform = loader.load();
			
			searchDao.goshopProc(searchmDto.getF_name());
			
			Label cartshopname = (Label) cartform.lookup("#cartshopname");
			cartshopname.setText(searchmDto.getS_name());
			
			Label cartTotalSal = (Label)cartform.lookup("#cartTotalSal");
			String price = Integer.toString(searchmDto.getF_price());
			cartTotalSal.setText(price);
			
			CartController cartcon = loader.getController();
			cartcon.setCartForm(cartform);	
			
			Scene scene = new Scene(cartform);
			Stage stage = new Stage();
			stage.setTitle("cartform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}



	public void orderPayBtnProc(Parent orderForm) {
		
	}

}
