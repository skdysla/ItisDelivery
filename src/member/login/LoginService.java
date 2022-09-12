package member.login;

import java.io.IOException;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import member.join.regController;
import member.main.memberController;
import member.main.memberDAO;
import member.main.memberDTO;

public class LoginService {
	private memberController con;
	private LoginController loginCon;
	private memberDAO dao;
	
	public LoginService() {
		dao = new memberDAO();
	}
	
	public void setLoginCon(LoginController loginCon) {
		this.loginCon = loginCon;
		this.con = loginCon.getCon();
	}

	
	public memberDTO btnClick(Parent loginForm) {
		TextField mid = ((TextField) loginForm.lookup("#id"));
		PasswordField mpw = ((PasswordField) loginForm.lookup("#pw"));
		
		//검증
		if(mid.getText().isEmpty() || mpw.getText().isEmpty()) {
			return null;
		}
		
		memberDTO member = dao.selectId(mid.getText());
		
		if(member != null && mpw.getText().equals(member.getmPw())) {
		}else {
			CommonService.alert("로그인 실패");
			return null;
		}
		return member;
	}
	
	public void idFind() {
		FXMLLoader findIdLoader = new FXMLLoader(getClass().getResource("/member/login/findIdForm.fxml"));
		Parent findIdForm;
		try {
			findIdForm = findIdLoader.load();
			
			findIdController findIdCon = findIdLoader.getController();
			findIdCon.setFindIdForm(findIdForm);
			
			loginCon.setFindIdCon(findIdCon);
			
			Scene scene = new Scene(findIdForm);
			
			Stage stage = new Stage();
			
			stage.setTitle("findId");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	public void pwFind() {
		FXMLLoader findPwLoader = new FXMLLoader(getClass().getResource("/member/login/findPwForm.fxml"));
		Parent findPwForm;
		try {
			findPwForm = findPwLoader.load();
			
			findPwController findPwCon = findPwLoader.getController();
			findPwCon.setFindPwForm(findPwForm);
			
			loginCon.setFindPwCon(findPwCon);
			
			Scene scene = new Scene(findPwForm);
			
			Stage stage = new Stage();
			
			stage.setTitle("findPw");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void resetPw() {
		FXMLLoader resetPwLoader = new FXMLLoader(getClass().getResource("/member/login/resetPwForm.fxml"));
		Parent resetPwForm;
		try {
			resetPwForm = resetPwLoader.load();
			
			resetPwController resetPwCon = resetPwLoader.getController();
			resetPwCon.setResetPwForm(resetPwForm);
			
			loginCon.setResetPwCon(resetPwCon);
			
			Scene scene = new Scene(resetPwForm);
			
			Stage stage = new Stage();
			
			stage.setTitle("resetPw");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createBtn() {
		FXMLLoader regLoader = new FXMLLoader(getClass().getResource("/member/join/MemberRegForm.fxml"));
		Parent regForm;
		try {
			regForm = regLoader.load();
			
			regController regCon = regLoader.getController();
			regCon.setRegForm(regForm);
			
			con.setRegcon(regCon);
			
			Scene scene = new Scene(regForm);
			
			Stage stage = new Stage();
			
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
