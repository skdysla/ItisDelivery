package shop.ask;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import shop.main.ShopMainController;

public class ShopAskChatController implements Initializable {
	private ShopMainController con;
	private ShopAskController askCon;
	private ShopAskChatService askChatSvc;
	private Parent askChatForm;

	@FXML
	private TextArea chat;
	@FXML
	private TextField chatText;
	
	public void setAskChatForm(Parent askChatForm) {
		this.askChatForm = askChatForm;
	}
	public void setAskCon(ShopAskController askCon) {
		this.askCon = askCon;
		this.con = askCon.getCon();
		this.askChatSvc = new ShopAskChatService(askCon);
		this.askChatSvc.setAskChatCon(this);
		this.askChatSvc.setAskChatForm(askChatForm);
		chat.appendText("이메일 주소를 원하신다면 1을 입력해주세요.\n전화번호를 원하신다면 2을 입력해주세요.\n나가기를 원하신다면 3을 입력해주세요.");
		//press();
	}
	
	public void chatBtn() {
		String text = "\n고객 : " + chatText.getText();
		chat.appendText(text);
		if (chatText.getText().equals("1")) {
			chat.appendText("\n관리자 : 이메일 주소는 admin@gmail.com 입니다.");
		} else if (chatText.getText().equals("2")) {
			chat.appendText("\n관리자 : 고객센터 연락처는 02-230-5462");
		} else if (chatText.getText().equals("3")) {
			CommonService.closeForm(askChatForm);
		} else
			chat.appendText("\n관리자 : 다시 입력해주세요.");
		chatText.clear();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	public void press() {
		chatText.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				send();
			}
			private void send() {
				String text = "\n고객 : " + chatText.getText();
				chat.appendText(text);
				if (text.equals("1")) {
					chat.appendText("\n관리자 : 이메일 주소는 admin@gmail.com 입니다.");
				} else if (text.equals("1")) {
					chat.appendText("\n관리자 : 고객센터 연락처는 02-230-5462");
				} else if (text.equals("3")) {
					CommonService.closeForm(askChatForm);
				} else
					chat.appendText("\n관리자 : 다시 입력해주세요.");
				chatText.clear();
			}
		});
	}	
}
