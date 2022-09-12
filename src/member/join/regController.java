package member.join;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import member.main.memberController;
import member.main.memberDTO;

public class regController implements Initializable{
	@FXML Button backBtn;
	private memberController con;
	private Parent regForm;
	private regService regSvc;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		regSvc = new regService();
	}

	public memberController getCon() {
		return con;
	}

	public void setCon(memberController con) {
		this.con = con;
//		this.regSvc.setRegCon(this);
	}

	public void setRegForm(Parent regForm) {
		this.regForm = regForm;
	}
	
	public void clickJoin() {
		memberDTO dto = regSvc.regMember(regForm);
		if(dto != null) {
			CommonService.closeForm(regForm);
			con.openForm("login");
		}
	}
	
	public void backBtnProc() {
		System.out.println("RegCon : " + con);
		//현재 창 닫고 로그인 창으로 이동
		Stage stage = (Stage) backBtn.getScene().getWindow();
		Platform.runLater(() -> {
			stage.close();
		});
		con.openForm("login");
	}
	
//	public void openForm(String formName) {
//		if(formName.equals("register")) {
//			regSvc.openRegisterForm();
//		}
//	}

}
