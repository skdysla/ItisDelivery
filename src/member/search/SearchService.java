package member.search;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import member.main.memberController;

public class SearchService {
	private memberController con;
	private SearchDAO searchDao;
	private SearchController searchcon;
	private ShopListController shoplistcon;
	private SearchDTO searchDto;
	
	public SearchService() {
		searchDao = new SearchDAO();
	}

	public void setSearchcon(SearchController searchcon) {
		this.searchcon = searchcon;
		this.con = searchcon.getCon();
	}

	public void setShoplistcon(ShopListController shoplistcon) {
		this.shoplistcon = shoplistcon;
		this.searchcon = shoplistcon.getSearchcon();
	}


	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
	}

	//검색버튼
	public void searchListBtnProc(Parent searchcomboform, String searchBy, String value) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/search/MemberShopListForm.fxml"));
		Parent shoplistform;
		try {
			shoplistform = loader.load();
			
			ShopListController shoplistcon = loader.getController();
			shoplistcon.setShoplistForm(shoplistform);
			shoplistcon.setSearchBy(searchBy);
			shoplistcon.setValue(value);
			
			con.setShoplistcon(shoplistcon);
			
			Scene scene = new Scene(shoplistform);
			Stage stage = new Stage();
			stage.setTitle("shoplistform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}



}
