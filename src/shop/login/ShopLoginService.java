package shop.login;

import java.io.IOException;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.join.RegOwnerController;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class ShopLoginService {
	private ShopMainController con;
	private ShopLoginController loginCon;
	private ShopDAO dao;
	
	public ShopLoginService() {
		dao = new ShopDAO();
	}
	
	public void setLoginCon(ShopLoginController loginCon) {
		this.loginCon = loginCon;
		this.con = loginCon.getCon();
	}

	public void managerBtn() {
		
	}
	
	public ShopDTO btnClick(Parent loginForm) {		
		TextField id = ((TextField) loginForm.lookup("#id"));
		PasswordField pw = ((PasswordField) loginForm.lookup("#pw"));
		
		ShopDTO dto = null;
		
		// 로그인 필수 값 검증
		if (id.getText().isEmpty() || pw.getText().isEmpty()) {
			return dto;
		}

		dto = dao.selectId(id.getText());

		if (dto != null) {
			if(pw.getText().equals(dto.getsPw())) {
				CommonService.alert("로그인 성공!");	
			}else {
				dto = null;
				CommonService.alert("로그인 실패");
			}
		}else {
			CommonService.alert("존재하지 않는 아이디입니다.");
		}
		return dto;
	}
	
	public void isResting() {
		dao.confirmOwnerRest();
	}
	
	public void idFind() {
		FXMLLoader findIdLoader = new FXMLLoader(getClass().getResource("/shop/login/FindOwnerId.fxml"));
		Parent findIdForm;
		try {
			findIdForm = findIdLoader.load();
			
			FindOwnerIdController findOIdCon = findIdLoader.getController();
			findOIdCon.setFindIdForm(findIdForm);
			
			loginCon.setFindOIdCon(findOIdCon);
			
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
		FXMLLoader findPwLoader = new FXMLLoader(getClass().getResource("/shop/login/FindOwnerPw.fxml"));
		Parent findPwForm;
		try {
			findPwForm = findPwLoader.load();
			
			FindOwnerPwController findOPwCon = findPwLoader.getController();
			findOPwCon.setFindPwForm(findPwForm);
			
			loginCon.setFindOPwCon(findOPwCon);
			
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
		FXMLLoader resetPwLoader = new FXMLLoader(getClass().getResource("/shop/login/ResetPw.fxml"));
		Parent resetPwForm;
		try {
			resetPwForm = resetPwLoader.load();
			
			ResetPwController resetPwCon = resetPwLoader.getController();
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
		FXMLLoader regShopLoader = new FXMLLoader(getClass().getResource("/shop/join/RegShopOwner.fxml"));
		Parent regShopForm;
		try {
			regShopForm = regShopLoader.load();
			
			RegOwnerController regOwnerCon = regShopLoader.getController();
			regOwnerCon.setRegOwnerForm(regShopForm);
			
			con.setRegOwnerCon(regOwnerCon);
			
			Scene scene = new Scene(regShopForm);
			
			Stage stage = new Stage();
			
			stage.setTitle("shopLogin");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
