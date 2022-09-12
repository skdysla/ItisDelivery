package controller;

import java.io.IOException;

import admin.login.AdminLoginController;
import admin.main.AdminController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import member.login.LoginController;
import member.main.memberController;
import shop.login.ShopLoginController;
import shop.main.ShopDAO;
import shop.main.ShopMainController;
import shop.order.OrderDAO;

public class Service {
	
	private OrderDAO dao;
	
	public Service() {
		dao = new OrderDAO();
		dao.setTimeZone();
	}
	
	public void memberBtn() {
		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/member/login/LoginForm.fxml"));
		Parent loginForm;
		try {
			loginForm = loginLoader.load();
			
			LoginController loginCon = loginLoader.getController();
			loginCon.setLoginForm(loginForm);
			
			memberController con = new memberController();
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

	public void shopBtn() {
		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/shop/login/ShopLogin.fxml"));
		Parent loginForm;
		try {
			loginForm = loginLoader.load();
			
			ShopLoginController loginCon = loginLoader.getController();
			loginCon.setLoginForm(loginForm);
			
			ShopMainController con = new ShopMainController();
			con.setLoginCon(loginCon);
			
			Scene scene = new Scene(loginForm);
			
			Stage stage = new Stage();
			stage.setTitle("shopLogin");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void adminBtn() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/login/adminLoginForm.fxml"));
		
		Parent adminLoginForm;
		try {
			adminLoginForm = loader.load();
			
			AdminLoginController adminLoginController = loader.getController();
			adminLoginController.setAdminLoginForm(adminLoginForm);
			
			AdminController controller = new AdminController();
			controller.setAdminLoginController(adminLoginController);
			
			Scene scene = new Scene(adminLoginForm);
			
			Stage stage = new Stage();
			stage.setTitle("adminLogin");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	public void setTimeZone() {
		dao.setTimeZone();
	}

}
