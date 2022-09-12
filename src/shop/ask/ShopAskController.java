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

public class ShopAskController implements Initializable {
	private ShopMainController con;
	private ShopAskChatController askChatCon;
	private ShopAskService askSvc;
	private Parent askForm;
	private Parent askChatForm;

	@FXML
	private TextArea chat;
	@FXML
	private TextField chatText;
	

	public ShopMainController getCon() {
		return con;
	}

	public void setCon(ShopMainController con) {
		this.con = con;
		this.askSvc = new ShopAskService(con);
		this.askSvc.setAskCon(this);
	}

	public Parent getAskForm() {
		return askForm;
	}

	public void setAskForm(Parent askForm) {
		this.askForm = askForm;
	}
	public void setAskChatForm(Parent askChatForm) {
		this.askChatForm = askChatForm;
	}
	public void setAskChatCon(ShopAskChatController askChatCon) {
		this.askChatCon = askChatCon;
		this.askChatCon.setAskCon(this);
	}

	// 챗봇
	public void chatbot() {
		askSvc.showAskChat();
	}

	// 관리자 전화
	public void adminCall() {
		askSvc.call();
	}

	// 관리자 이메일
	public void adminEmail() {
		askSvc.email();
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}

	// 화면 하단아이콘 버튼
	public void clickHomeBtn() {
		CommonService.closeForm(askForm);
		con.openForm("home");
	}

	public void clickMenuBtn() {
		CommonService.closeForm(askForm);
		con.openForm("menu");
	}

	public void clickSalesBtn() {
		CommonService.closeForm(askForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(askForm);
		con.openForm("ask");
	}

	public void clickListBtn() {
		CommonService.closeForm(askForm);
		con.openForm("list");
	}

	public void clickShopInfoBtn() {
		CommonService.closeForm(askForm);
		con.openForm("shopInfo");
	}

	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(askForm);
		con.openForm("acceptedOrders");
	}

	

	

}
