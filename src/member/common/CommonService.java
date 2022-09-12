package member.common;

import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;

public class CommonService {
	
	public static void openAlert() {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("로그인");
		alert.setContentText("로그인 성공!");
		alert.show();
	}
	
	public static void msg(String content) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(content);
		alert.show();
	}

	public static void closeForm(Parent form) {
		Stage stage = (Stage) form.getScene().getWindow();
		stage.close();
	}

	public static void alert(String msg) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setContentText(msg);
		alert.show();
	}
	

}
