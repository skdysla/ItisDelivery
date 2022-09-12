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

public class ShopService {
	//SearchMDTO / SearchDAO
	private memberController con;
	private ShopController shopcon;
	private SearchDAO searchDao;
	private SearchMDTO searchmDto;
	
	public ShopService() {
		searchDao = new SearchDAO();
	}
	
	

	public memberController getCon() {
		return con;
	}



	public void setCon(memberController con) {
		this.con = con;
	}



	public ShopController getShopcon() {
		return shopcon;
	}



	public void setShopcon(ShopController shopcon) {
		this.shopcon = shopcon;
		this.con = shopcon.getCon();
	}

	public ObservableList<SearchMDTO> showMenuList(ObservableList<SearchMDTO> menulist) {
		ArrayList<SearchMDTO> list = searchDao.selectdetailshop(con.getsId());
		menulist.addAll(list);
		return menulist;
	}

	public void addcartbtnProc(SearchMDTO searchmDto) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/search/MemberCartForm.fxml"));
		Parent cartform;
		try {
			cartform = loader.load();
			
			searchDao.selectdetailshop(searchmDto.getF_name());
			
			Label shopname = (Label) cartform.lookup("#shopname");
			shopname.setText(con.getsName() + " - " + con.getsBranch());
			
			Label cartTotalSal = (Label) cartform.lookup("#cartTotalSal");
			String price = Integer.toString(searchmDto.getF_price());
			cartTotalSal.setText(price);
			con.setfPrice(price);
			
			CartController cartcon = loader.getController();
			cartcon.setCartForm(cartform);	
			
			con.setCartcon(cartcon);
			
			Scene scene = new Scene(cartform);
			Stage stage = new Stage();
			stage.setTitle("cartform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
