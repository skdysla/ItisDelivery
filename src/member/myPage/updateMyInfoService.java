package member.myPage;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import member.main.memberController;
import member.main.memberDAO;
import member.main.memberDTO;

public class updateMyInfoService {
	private memberController con;
	private myPageController mpCon;
	private updateMyInfoController updateCon;
	private memberDAO dao;
	
	public void setUpdateCon(updateMyInfoController updateCon) {
		this.updateCon = updateCon;
		this.mpCon = updateCon.getMpCon();
		this.con = mpCon.getCon();
	}
	
	public updateMyInfoService() {
		dao = new memberDAO();
	}
	
	public int updateMyInfo(Parent updateMyInfoForm) {
		
		int rs = -1;
		
		TextField id = ((TextField) updateMyInfoForm.lookup("#id"));
		TextField pw = ((TextField) updateMyInfoForm.lookup("#pw"));
		TextField cPw = ((TextField) updateMyInfoForm.lookup("#pwConfirm"));
		TextField name = ((TextField) updateMyInfoForm.lookup("#name"));
		TextField tel = ((TextField) updateMyInfoForm.lookup("#tel"));
		TextField add = ((TextField) updateMyInfoForm.lookup("#address"));
		
		if (!pw.getText().isEmpty() && !cPw.getText().isEmpty() && !name.getText().isEmpty()
				&& !tel.getText().isEmpty() && !add.getText().isEmpty()) {
			String mId = id.getText();
			String mPw = pw.getText();
			String mName = name.getText();
			String mTel = tel.getText();
			String mAdd = add.getText();

			if (pw.getText().equals(cPw.getText())) {
				memberDTO dto = new memberDTO();
				dto.setmId(mId);
				dto.setmPw(mPw);
				dto.setmName(mName);
				dto.setmTel(mTel);
				dto.setmAddress(mAdd);

				rs = dao.updateMember(dto);
				if (rs == 1)
					CommonService.alert("회원 정보 수정 성공!");
				else
					CommonService.alert("회원 정보 수정 실패");
			} else {
				CommonService.alert("동일한 비밀번호를 입력해주세요!");
			}
		} else {
			CommonService.alert("모든 정보를 입력해주세요!");
		}
	return rs;
	}
}
