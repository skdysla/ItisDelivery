package admin.main;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainService {
	private AdminController controller;
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
//
	
	public void homeOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/home/homeForm.fxml"));
		
		Parent homeForm;
		try {
			homeForm = loader.load();
			
			controller.setHomeForm(homeForm);
			controller.setHomeController(loader.getController());
			controller.getHomeController().setHomeForm(homeForm);
			
			Scene scene = new Scene(homeForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void adminLoginOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/login/adminLoginForm.fxml"));
		
		Parent adminLoginForm;
		try {
			adminLoginForm = loader.load();
			
			controller.setAdminLoginForm(adminLoginForm);
			controller.setAdminLoginController(loader.getController());
			controller.getAdminLoginController().setAdminLoginForm(adminLoginForm);
			
			Scene scene = new Scene(adminLoginForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void loginOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/login/loginForm.fxml"));
		
		Parent loginForm;
		try {
			loginForm = loader.load();
			
			controller.setLoginForm(loginForm);
			controller.setLoginController(loader.getController());
			controller.getLoginController().setLoginForm(loginForm);
			
			Scene scene = new Scene(loginForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void adminListOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/adminList/adminListForm.fxml"));
		
		Parent adminListForm;
		try {
			adminListForm = loader.load();
			
			controller.setAdminListForm(adminListForm);
			controller.setAdminListController(loader.getController());
			controller.getAdminListController().setAdminListForm(adminListForm);
			
			Scene scene = new Scene(adminListForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void memberListOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/memberList/memberForm.fxml"));
		
		Parent memberForm;
		try {
			memberForm = loader.load();
			
			controller.setMemberForm(memberForm);
			controller.setMemberListController(loader.getController());
			controller.getMemberListController().setMemberForm(memberForm);
			
			Scene scene = new Scene(memberForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void shopListOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/shopList/shopForm.fxml"));
		
		Parent shopForm;
		try {
			shopForm = loader.load();
			
			controller.setShopForm(shopForm);
			controller.setShopListController(loader.getController());
			controller.getShopListController().setShopForm(shopForm);
			
			Scene scene = new Scene(shopForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void blackListOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/blackList/blackListForm.fxml"));
		
		Parent blackListForm;
		try {
			blackListForm = loader.load();
			
			controller.setBlackListForm(blackListForm);
			controller.setBlackListController(loader.getController());
			controller.getBlackListController().setBlackListForm(blackListForm);
			
			Scene scene = new Scene(blackListForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adminDetailOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/adminList/adminDetailForm.fxml"));
		
		Parent adminDetailForm;
		try {
			adminDetailForm = loader.load();
			
			controller.setAdminDetailForm(adminDetailForm);
			controller.setAdminDetailController(loader.getController());
			controller.getAdminDetailController().setAdminDetailForm(adminDetailForm);
			
			Scene scene = new Scene(adminDetailForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public void reviewOpen() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/review/reviewForm.fxml"));
		
		Parent reviewForm;
		try {
			reviewForm = loader.load();
			
			controller.setReviewForm(reviewForm);
			controller.setReviewController(loader.getController());
			controller.getReviewController().setReviewForm(reviewForm);
			
			Scene scene = new Scene(reviewForm);
		
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
