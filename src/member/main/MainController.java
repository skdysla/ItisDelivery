package member.main;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;

public class MainController implements Initializable{
	
	private memberController con;
	private MainService mainSvc;
	private Parent mainForm;
	
	

	public memberController getCon() {
		return con;
	}



	public void setCon(memberController con) {
		this.con = con;
		//this.mainSvc.setMainCon(this);
	}



	public MainService getMainSvc() {
		return mainSvc;
	}



	public void setMainSvc(MainService mainSvc) {
		this.mainSvc = mainSvc;
	}



	public Parent getMainForm() {
		return mainForm;
	}



	public void setMainForm(Parent mainForm) {
		this.mainForm = mainForm;
	}



	@Override
	public void initialize(URL location, ResourceBundle resources) {
		mainSvc = new MainService();
	}
	
	
	
	//하단
	public void clickHomeBtn() {
		CommonService.closeForm(mainForm);
		con.openForm("main");
	}
	public void clickLikeBtn() {
		CommonService.closeForm(mainForm);
		con.openForm("like");
	}
	public void clickSearchBtn() {
		CommonService.closeForm(mainForm);
		con.openForm("search");
	}
	public void clickOrderListBtn() {
		CommonService.closeForm(mainForm);
		con.openForm("order");
	}
	public void clickMyInfoBtn() {
		CommonService.closeForm(mainForm);
		con.openForm("mypage");
	}
	public void mainCartBtnProc() {
		CommonService.closeForm(mainForm);
		con.openForm("cart");
	}



	
	
	


}
