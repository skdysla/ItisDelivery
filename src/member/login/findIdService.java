package member.login;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import member.main.memberDAO;
import member.main.memberDTO;

public class findIdService {
	private LoginController loginCon;
	private findIdController findIdCon;
	private memberDAO dao;
	
	public findIdService() {
		dao = new memberDAO();
	}
	
	public void setFindIdCon(findIdController findIdCon) {
		this.findIdCon = findIdCon;
		this.loginCon = findIdCon.getLoginCon();
	}
	
	public boolean find(Parent findIdForm) {
		boolean flag = false;
		
		TextField name = (TextField) findIdForm.lookup("#mName");
		TextField tel = (TextField) findIdForm.lookup("#mTel");
		
		if(name.getText().isEmpty() || tel.getText().isEmpty()) {
			if(name.getText().isEmpty()) name.requestFocus();
			else tel.requestFocus();
			CommonService.alert("이름과 전화번호 모두 입력하세요");
		}else {
			String mTel = tel.getText();
			memberDTO dto = dao.findInfo(mTel);
			
			if(dto != null) {
				if(dto.getmName().equals(name.getText())) {
					flag = true;
					CommonService.alert(name.getText() + " 점주님의 아이디는 " + dto.getmId() + "입니다!");
				}else CommonService.alert("이름을 다시 확인해주세요");
			}
			else {
				CommonService.alert("입력하신 정보와 일치하는 회원정보가 없습니다");
			}
		}
		return flag;
	}
}
