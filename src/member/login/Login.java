package member.login;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import member.main.memberController;

public class Login extends Application{
	
	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/login/LoginForm.fxml"));
		Parent loginForm = loginLoader.load();
		
		LoginController loginCon = loginLoader.getController();
		loginCon.setLoginForm(loginForm);
		
		memberController con = new memberController();
		con.setLoginCon(loginCon);
		
		Scene scene = new Scene(loginForm);
		
		primaryStage.setTitle("Login");
		primaryStage.setScene(scene);
		primaryStage.show();
	}

}
