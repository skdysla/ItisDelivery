package shop.ask;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import shop.main.ShopMainController;
import shop.menu.ShopMenuAddController;

public class ShopAskService {
	
	private ShopMainController con;
	private ShopAskController askCon;
	private ShopAskDAO askDao;
	private ShopAskDTO askDto;
	
	public ShopAskService(ShopMainController con) {
		this.con = con;
		askDao = new ShopAskDAO();
		
	}
	
	public void setAskCon(ShopAskController askCon) {
		this.askCon = askCon;
		this.con = askCon.getCon();
	}

	public void call() {
		CommonService.alert("고객센터 연락처 : " + askDao.selectAsk().getC_tel() + "\n" +"\n" + "자동복사되었습니다.");
		
		final Clipboard clipboard = Clipboard.getSystemClipboard();
	    final ClipboardContent content = new ClipboardContent();
	    content.putString(askDao.selectAsk().getC_tel());
	    clipboard.setContent(content);
	}

	public void email() {
		CommonService.alert("고객센터 E-MAIL : " + askDao.selectAsk().getC_email() + "\n" +"\n" + "자동복사되었습니다.");
		
		final Clipboard clipboard = Clipboard.getSystemClipboard();
	    final ClipboardContent content = new ClipboardContent();
	    content.putString(askDao.selectAsk().getC_email());
	    clipboard.setContent(content);
		
	}
	
	public void showAskChat() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/ask/ShopAsk.fxml"));
		Parent askChatForm;
		try {
			askChatForm = loader.load();
			Scene scene = new Scene(askChatForm);
			
			ShopAskChatController askChatCon = loader.getController();
			askChatCon.setAskChatForm(askChatForm);
			
			askCon.setAskChatCon(askChatCon);
			
			Stage stage = new Stage();
			stage.setTitle("chatbot");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
