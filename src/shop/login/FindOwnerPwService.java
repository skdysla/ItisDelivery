package shop.login;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import shop.main.ShopDAO;
import shop.main.ShopDTO;

public class FindOwnerPwService {
	private ShopLoginController loginCon;
	private FindOwnerPwController findOPwCon;
	private ShopDAO dao;
	
	public FindOwnerPwService() {
		dao = new ShopDAO();
	}
	
	public void setFindOPwCon(FindOwnerPwController findOPwCon) {
		this.findOPwCon = findOPwCon;
		this.loginCon = findOPwCon.getLoginCon();
	}
	
	public boolean find(Parent findPwForm) {
		Boolean flag = false;
		
		TextField ownerTel = (TextField) findPwForm.lookup("#sOwnerTel");
		TextField id = (TextField) findPwForm.lookup("#sId");
		
		if(ownerTel.getText().isEmpty() || id.getText().isEmpty()) {
			if(ownerTel.getText().isEmpty()) ownerTel.requestFocus();
			else id.requestFocus();
			CommonService.alert("아이디와 전화번호 모두 입력하세요");
		}else {
			String sOwnerTel = ownerTel.getText();
			ShopDTO dto = dao.findInfo(sOwnerTel);
			
			if(dto != null) 
				if(dto.getsId().equals(id.getText())) {
					loginCon.setsId(dto.getsId());
					flag = true;
				}
				else
					CommonService.alert("아이디를 다시 확인해주세요");
			else CommonService.alert("입력하신 정보와 일치하는 점주가 없습니다");
		}
		return flag;
	}
	
}
