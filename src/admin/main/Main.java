package admin.main;

import admin.login.AdminLoginController;
import admin.login.LoginController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/admin/login/adminLoginForm.fxml"));
		
		Parent adminLoginForm = loader.load();
		
		AdminLoginController adminLoginController = loader.getController();
		adminLoginController.setAdminLoginForm(adminLoginForm);
		
		AdminController controller = new AdminController();
		controller.setAdminLoginController(adminLoginController);
		
		Scene scene = new Scene(adminLoginForm);
		
		primaryStage.setScene(scene);
		primaryStage.show();
	}
}
