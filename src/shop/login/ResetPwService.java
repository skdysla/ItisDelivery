package shop.login;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class ResetPwService {
	
	private ShopMainController con;
	private ShopLoginController loginCon;
	private ResetPwController resetPwCon;
	private ShopDAO dao;
	
	public ResetPwService() {
		dao = new ShopDAO();
	}
	
	public void setResetPwCon(ResetPwController resetPwCon) {
		this.resetPwCon = resetPwCon;
		this.loginCon = resetPwCon.getLoginCon();
		this.con = loginCon.getCon();
	}
	
	public boolean reset(Parent resetPwForm) {
		Boolean flag = false;
		ShopDTO dto = null;

		TextField pw = (TextField) resetPwForm.lookup("#pw");
		TextField confirmPw = (TextField) resetPwForm.lookup("#confirmPw");

		if (pw.getText().isEmpty() || confirmPw.getText().isEmpty()) {
			if (pw.getText().isEmpty())
				pw.requestFocus();
			else
				confirmPw.requestFocus();
			CommonService.alert("모두 입력하세요");
		} else {
			if (pw.getText().equals(confirmPw.getText())) {
				flag = true;
				if(loginCon.getrId() != null) {
					dto = dao.selectId(loginCon.getrId());
				}else {
					dto = dao.selectId(loginCon.getsId());
				}
				dto.setsPw(pw.getText());
				int rs = dao.updateShopOwner(dto);

				if(rs == 1) {
					CommonService.alert("비밀번호 재설정 성공!");
					if (loginCon.getrId() != null) dao.resetUnRest(loginCon.getrId());
				}
				else CommonService.alert("비밀번호 재설정 실패");
			} else
				CommonService.alert("비밀번호를 다시 확인해주세요");
		}
		return flag;
	}
	
}
