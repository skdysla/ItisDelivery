package shop.login;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import shop.main.ShopDAO;
import shop.main.ShopDTO;

public class FindOwnerIdService {
	
	private ShopLoginController loginCon;
	private FindOwnerIdController findOIdCon;
	private ShopDAO dao;
	
	public FindOwnerIdService() {
		dao = new ShopDAO();
	}
	
	public void setFindOIdCon(FindOwnerIdController findOIdCon) {
		this.findOIdCon = findOIdCon;
		this.loginCon = findOIdCon.getLoginCon();
	}

	public boolean find(Parent findIdForm) {
		boolean flag = false;
		
		TextField name = (TextField) findIdForm.lookup("#sName");
		TextField ownerTel = (TextField) findIdForm.lookup("#sOwnerTel");
		
		if(name.getText().isEmpty() || ownerTel.getText().isEmpty()) {
			if(name.getText().isEmpty()) name.requestFocus();
			else ownerTel.requestFocus();
			CommonService.alert("이름과 전화번호 모두 입력하세요");
		}else {
			String sOwnerTel = ownerTel.getText();
			ShopDTO dto = dao.findInfo(sOwnerTel);
			
			if(dto != null) {
				if(dto.getsName().equals(name.getText())) {
					flag = true;
					CommonService.alert(name.getText() + " 점주님의 아이디는 " + dto.getsId() + "입니다!");
				}else CommonService.alert("가게명을 다시 확인해주세요");
			}
			else {
				CommonService.alert("입력하신 정보와 일치하는 점주가 없습니다");
			}
		}
		return flag;
	}

}
