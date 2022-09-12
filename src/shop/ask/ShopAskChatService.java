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

public class ShopAskChatService {
	
	private ShopMainController con;
	private ShopAskController askCon;
	private ShopAskChatController askChatCon;
	private Parent askChatForm;
	
	public ShopAskChatService(ShopAskController askCon) {
		this.askCon = askCon;
		this.con = askCon.getCon();
	}
	public void setAskChatCon(ShopAskChatController askChatCon) {
		this.askChatCon = askChatCon;
	}
	public void setAskChatForm(Parent askChatForm) {
		this.askChatForm = askChatForm;
	}
}
