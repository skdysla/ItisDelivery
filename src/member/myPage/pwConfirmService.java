package member.myPage;

import java.io.IOException;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.stage.Stage;
import member.main.memberController;
import member.main.memberDAO;
import member.main.memberDTO;

public class pwConfirmService {
	private memberController con;
	private myPageController mpCon;
	private pwConfirmController pwConfirmCon;
	private memberDAO dao;
	
	public pwConfirmService() {
		dao = new memberDAO();
	}
	
	public void setPwConfirmCon(pwConfirmController pwConfirmCon) {
		this.pwConfirmCon = pwConfirmCon;
		this.mpCon = pwConfirmCon.getMpCon();
		this.con = mpCon.getCon();
	}
	
	public boolean pwConfirm(Parent pwConfirmForm) {
		String oId = con.getmId();
		memberDTO dto = dao.selectId(oId);
		boolean closeForm = false;
		
		PasswordField pw = ((PasswordField) pwConfirmForm.lookup("#password"));
//		System.out.println("confirmpw : " + pw.getText());
		if (!pw.getText().isEmpty()) {
			if (pw.getText().equals(dto.getmPw())) {
				closeForm = true;

				FXMLLoader showMyInfoLoader = new FXMLLoader(getClass().getResource("/member/myPage/showMyInfoForm.fxml"));
				Parent showMyInfoForm;

				try {
					showMyInfoForm = showMyInfoLoader.load();

					Label mId = ((Label) showMyInfoForm.lookup("#mId"));
					mId.setText(dto.getmId());

					Label mPw = ((Label) showMyInfoForm.lookup("#mPw"));
					mPw.setText(dto.getmPw());

					Label mName = ((Label) showMyInfoForm.lookup("#mName"));
					mName.setText(dto.getmName());

					Label mTel = ((Label) showMyInfoForm.lookup("#mTel"));
					mTel.setText(dto.getmTel());
					
					Label mAdd = ((Label) showMyInfoForm.lookup("#mAddress"));
					mAdd.setText(dto.getmAddress());

					showMyInfoController showMyInfoCon = showMyInfoLoader.getController();
					showMyInfoCon.setShowMyInfoForm(showMyInfoForm);

					mpCon.setShowMICon(showMyInfoCon);

					Scene scene = new Scene(showMyInfoForm);

					Stage stage = new Stage();
					stage.setTitle("showMyInfo");
					stage.setScene(scene);
					stage.show();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else {
				pw.clear();
				pw.requestFocus();
				CommonService.alert("비밀번호가 일치하지 않습니다.");
			}
		} else {
			pw.requestFocus();
			CommonService.alert("비밀번호를 입력해주세요!");
		}
		return closeForm;
	}
}
