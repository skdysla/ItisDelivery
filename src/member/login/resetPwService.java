package member.login;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import member.main.memberController;
import member.main.memberDAO;
import member.main.memberDTO;

public class resetPwService {
	private memberController con;
	private LoginController loginCon;
	private resetPwController resetPwCon;
	private memberDAO dao;
	
	public resetPwService() {
		dao = new memberDAO();
	}
	
	public void setResetPwCon(resetPwController resetPwCon) {
		this.resetPwCon = resetPwCon;
		this.loginCon = resetPwCon.getLoginCon();
		this.con = loginCon.getCon();
	}
	
	public boolean reset(Parent resetPwForm) {
		Boolean flag = false;
		
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
				memberDTO dto = dao.selectId(loginCon.getmId());
				dto.setmPw(pw.getText());
				int rs = dao.updateMember(dto);

				if (rs == 1)
					CommonService.alert("비밀번호 재설정 성공!");
				else
					CommonService.alert("비밀번호 재설정 실패");
			} else
				CommonService.alert("비밀번호를 다시 확인해주세요");
		}
		return flag;
	}
}
