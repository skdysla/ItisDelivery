package member.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import member.like.LikeController;
import member.login.LoginController;
import member.myPage.myPageController;
import member.order.orderListController;
import member.review.reviewListController;
import member.search.CartController;
import member.search.SearchController;

public class memberService {
	
	private memberController con;
	private memberDAO memberDao;
	
	public memberService() {
		memberDao = new memberDAO();
	}

	public void setCon(memberController con) {
		this.con = con;
	}

	public void openMain() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/main/MemberMainForm.fxml"));
		Parent mainform;
		try {
			mainform = loader.load();
			
			MainController maincon = loader.getController();
			maincon.setMainForm(mainform);
			
			con.setMaincon(maincon);
			
			Scene scene = new Scene(mainform);
			Stage stage = new Stage();
			stage.setTitle("mainform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void openLike() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/like/MemberLikeForm.fxml"));
		Parent likeform;
		try {
			likeform = loader.load();
			
			LikeController likecon = loader.getController();
			likecon.setLikeForm(likeform);
			
			System.out.println("???????????" + con);
			con.setLikecon(likecon);
			
			Scene scene = new Scene(likeform);
			Stage stage = new Stage();
			stage.setTitle("likeform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void openSearch() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/search/MemberSearchForm.fxml"));
		Parent searchform;
		try {
			searchform = loader.load();
			
			ComboBox<String> shoplist = (ComboBox<String>)searchform.lookup("#searchCombo");
			shoplist.getItems().addAll("모두 검색", "가게 이름별 검색", "음식 종류별 검색");
			shoplist.getSelectionModel().select("모두 검색");
			ComboBox<String> foodlist = (ComboBox<String>)searchform.lookup("#searchFoodCombo");
			//가능하면 음식종류별 데이터 불러와 추가될때마다 넣어주기
			foodlist.getItems().addAll("한식", "중식", "일식", "양식", "분식", "치킨", "피자", "패스트푸드", "카페");
			
			SearchController searchcon = loader.getController();
			searchcon.setSearchForm(searchform);
			
			con.setSearchcon(searchcon);
			
			Scene scene = new Scene(searchform);
			Stage stage = new Stage();
			stage.setTitle("searchform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void openOrder() {
		FXMLLoader orderLoader = new FXMLLoader(getClass().getResource("/member/order/orderListForm.fxml"));
		Parent orderListForm;
		
		try {
			orderListForm = orderLoader.load();

			orderListController orderCon = orderLoader.getController();
			orderCon.setOrderListForm(orderListForm);
			
			con.setOrderCon(orderCon);

			Scene scene = new Scene(orderListForm);
			
			Stage stage = new Stage();
			stage.setTitle("orderList");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void openMypage() {
		FXMLLoader mpLoader = new FXMLLoader(getClass().getResource("/member/myPage/myPageForm.fxml"));
		Parent myPageForm;
		
		try {
			myPageForm = mpLoader.load();
			
			myPageController mpCon = mpLoader.getController();
			mpCon.setMyPageForm(myPageForm);
			
			con.setMpCon(mpCon);

			Scene scene = new Scene(myPageForm);
			
			Stage stage = new Stage();
			stage.setTitle("Sales");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void openCart() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/search/MemberCartForm.fxml"));
		Parent cartform;
		try {
			cartform = loader.load();
			
			CartController cartcon = loader.getController();
			cartcon.setCartForm(cartform);
			
			//con.setCartcon(cartcon);
			
			Scene scene = new Scene(cartform);
			Stage stage = new Stage();
			stage.setTitle("cartform");
			stage.setScene(scene);
			stage.show();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void openLogin() {
		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/member/login/LoginForm.fxml"));
		Parent loginForm;
		try {
			loginForm = loginLoader.load();
			
			LoginController loginCon = loginLoader.getController();
			loginCon.setLoginForm(loginForm);
			
			con.setLoginCon(loginCon);
			
			Scene scene = new Scene(loginForm);
			
			Stage stage = new Stage();
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openReviewForm() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/review/reviewListForm.fxml"));
		
		Parent reviewListForm;
		
		try {
			reviewListForm = loader.load();
			
			System.out.println("@@@@@@@@@@@@@@@@@ : " + con);
			reviewListController reviewCon = loader.getController();
			reviewCon.setReviewListForm(reviewListForm);
			
			con.setReviewCon(reviewCon);

			Scene scene = new Scene(reviewListForm);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
