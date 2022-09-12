package member.login;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import member.main.memberDAO;
import member.main.memberDTO;

public class findPwService {
	private LoginController loginCon;
	private findPwController findPwCon;
	private memberDAO dao;
	
	public findPwService() {
		dao = new memberDAO();
	}
	public void setFindPwCon(findPwController findPwCon) {
		this.findPwCon = findPwCon;
		this.loginCon = findPwCon.getLoginCon();
	}
	
	public boolean find(Parent findPwForm) {
		Boolean flag = false;
		
		TextField id = (TextField) findPwForm.lookup("#mId");
		TextField tel = (TextField) findPwForm.lookup("#mTel");
		
		if(tel.getText().isEmpty() || id.getText().isEmpty()) {
			if(tel.getText().isEmpty()) tel.requestFocus();
			else id.requestFocus();
			CommonService.alert("아이디와 전화번호 모두 입력하세요.");
		}else {
			String mTel = tel.getText();
			memberDTO dto = dao.findInfo(mTel);
			
			if(dto != null) 
				if(dto.getmId().equals(id.getText())) {
					loginCon.setmId(dto.getmId());
					flag = true;
				}
				else
					CommonService.alert("아이디를 다시 확인해주세요.");
			else CommonService.alert("입력하신 정보와 일치하는 회원정보가 없습니다.");
		}
		return flag;
	}
}
