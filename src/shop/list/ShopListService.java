package shop.list;

import shop.info.ShopInfoController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class ShopListService {
	private ShopMainController con;
	private ShopListController listCon;
	private ShopDAO dao;
	private ShopDTO dto;
	
	
	public ShopListService() {
	}
	public void setListCon(ShopListController ListCon) {
		this.listCon = ListCon;
		this.con = ListCon.getCon();
	}
	
	public ShopListController getListCon() {
		return listCon;
	}
	
	
	//리뷰조회페이지
	public void openReviewListForm() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/list/ShopReviewForm.fxml"));
		Parent reviewForm;
		try {
			reviewForm = loader.load();
			Scene scene = new Scene(reviewForm);
			
			ShopReviewController reviewCon = loader.getController();
			reviewCon.setReviewForm(reviewForm);
			
			listCon.setShopReviewController(reviewCon);
			
			Stage stage = new Stage();
			stage.setTitle("reviewList");
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	//블랙리스트 조회
	public void openBlackListForm() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/list/ShopBlackListForm.fxml"));
		Parent BlackListForm;
		try {
			BlackListForm = loader.load();
			Scene scene = new Scene(BlackListForm);
			
			ShopBlackListController blackListCon = loader.getController();
			blackListCon.setBlackListForm(BlackListForm);
			
			listCon.setShopBlackListController(blackListCon);
			
			Stage stage = new Stage();
			stage.setTitle("ListForm");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
