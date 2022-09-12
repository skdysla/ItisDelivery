package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StartForm extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		FXMLLoader firstLoader = new FXMLLoader(getClass().getResource("/controller/FirstForm.fxml"));
		Parent firstForm = firstLoader.load();
		
		Controller con = firstLoader.getController();
		con.setFirstForm(firstForm);
		
		Scene scene = new Scene(firstForm);
		
		primaryStage.setTitle("choiceMember");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
}
