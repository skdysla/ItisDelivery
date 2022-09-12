package shop.login;

import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class ShopLoginController implements Initializable {
	
	private ShopMainController con;
	private FindOwnerIdController findOIdCon;
	private FindOwnerPwController findOPwCon;
	private ResetPwController resetPwCon;
	private ShopLoginService loginSvc;
	private Parent loginForm;
	private String sId;
	private String rId;
	
	public ShopMainController getCon() {
		return con;
	}

	public void setCon(ShopMainController con) {
		this.con = con;
		this.loginSvc.setLoginCon(this);
	}
	
	public void setFindOIdCon(FindOwnerIdController findOIdCon) {
		this.findOIdCon = findOIdCon;
		this.findOIdCon.setLoginCon(this);
	}
	
	public void setFindOPwCon(FindOwnerPwController findOPwCon) {
		this.findOPwCon = findOPwCon;
		this.findOPwCon.setLoginCon(this);
	}
	
	public void setResetPwCon(ResetPwController resetPwCon) {
		this.resetPwCon = resetPwCon;
		this.resetPwCon.setLoginCon(this);
	}

	public ShopLoginService getLoginSvc() {
		return loginSvc;
	}
	
	public String getsId() {
		return sId;
	}
	
	public void setsId(String sId) {
		this.sId = sId;
	}
	
	public String getrId() {
		return rId;
	}
	
	public void setrId(String rId) {
		this.rId = rId;
	}

	public void setLoginSvc() {
		
	}

	public Parent getLoginForm() {
		return loginForm;
	}

	public void setLoginForm(Parent loginForm) {
		this.loginForm = loginForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		loginSvc = new ShopLoginService();
	}
	
	public void managerBtn() {
		
	}
	
	public void btnClick() {
		String uId  = ((TextField) loginForm.lookup("#id")).getText();
		
		loginSvc.isResting();
		ShopDTO result = loginSvc.btnClick(loginForm);
		
		if(result != null) {
			if(result.getsResting().equals("false")) {
				con.setsId(uId);
				CommonService.closeForm(loginForm);
				con.openForm("home");
			}else {
				setrId(uId);
				CommonService.alert(uId + "1년 동안 로그인 기록이 없어 휴면 계정으로 분류되었습니다. 비밀번호 재설정 화면으로 이동합니다.");
				resetPw();
			}
		}
	}
	
	public void idFind() {
		CommonService.closeForm(loginForm);
		loginSvc.idFind();
	}
	
	public void pwFind() {
		CommonService.closeForm(loginForm);
		loginSvc.pwFind();
	}
	
	public void resetPw() {
		CommonService.closeForm(loginForm);
		loginSvc.resetPw();
	}

	public void createBtn() {
		CommonService.closeForm(loginForm);
		loginSvc.createBtn();
	}
	
}
