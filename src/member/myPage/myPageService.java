package member.myPage;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import member.main.memberController;
import member.main.memberDAO;
import member.main.memberDTO;

public class myPageService {
	private memberController con;
	private myPageController mpCon;
	private memberDAO dao;
	private memberDTO dto;
	
	public myPageService(memberController con) {
		this.con = con;
		dao = new memberDAO();
	}

	public void setMpCon(myPageController mpCon) {
		this.mpCon = mpCon;
		this.con = mpCon.getCon();
	}
	
	public myPageController getMpCon() {
		return mpCon;
	}
	
	public void openShowMyInfoForm() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/myPage/pwConfirmForm.fxml"));
		Parent pwConfirmForm;
		
		try {
			pwConfirmForm = loader.load();
			
			pwConfirmController pwConfirmCon = loader.getController();
			pwConfirmCon.setPwConfirmForm(pwConfirmForm);

			mpCon.setPwConfirmCon(pwConfirmCon);
			
			Stage stage = new Stage();
			Scene scene = new Scene(pwConfirmForm);
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void goMemberInfo() {
		FXMLLoader memberInfoLoader = new FXMLLoader(getClass().getResource("/member/myPage/showMyInfoForm.fxml"));
		Parent showMyInfoForm;
		
		memberDTO dto = dao.selectId(con.getmId());
		
		try {
			showMyInfoForm = memberInfoLoader.load();
			
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

			showMyInfoController showMICon = memberInfoLoader.getController();
			showMICon.setShowMyInfoForm(showMyInfoForm);
			
			mpCon.setShowMICon(showMICon);

			Scene scene = new Scene(showMyInfoForm);
			
			Stage stage = new Stage();
			stage.setTitle("myInfo");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public void logout() {
		con.setmId(null);
	}
	
//	public int changemyInfo(Parent myInfoChangeForm) {
//		
//		int rs = -1;
//		
//		TextField id = ((TextField) myInfoChangeForm.lookup("#id"));
//		TextField pw = ((TextField) myInfoChangeForm.lookup("#pw"));
//		TextField cPw = ((TextField) myInfoChangeForm.lookup("#pwConfirm"));
//		TextField name = ((TextField) myInfoChangeForm.lookup("#name"));
//		TextField tel = ((TextField) myInfoChangeForm.lookup("#tel"));
//		TextField address = ((TextField) myInfoChangeForm.lookup("#address"));
//		
//		if (!pw.getText().isEmpty() && !cPw.getText().isEmpty() && !name.getText().isEmpty()
//				&& !tel.getText().isEmpty() && !address.getText().isEmpty()) {
//			String mId = id.getText();
//			String mPw = pw.getText();
//			String mName = name.getText();
//			String mTel = tel.getText();
//			String mAddress = address.getText();
//
//			if (pw.getText().equals(cPw.getText())) {
//				LoginDTO dto = new LoginDTO();
//				dto.setM_id(mId);
//				dto.setM_pw(mPw);
//				dto.setM_name(mName);
//				dto.setM_tel(mTel);
//
//				rs = loginDao.updateMemberInfo(dto);
//				if (rs == 1)
//					CommonService.msg("회원정보 수정 성공");
//				else
//					CommonService.msg("회원정보 수정 실패");
//			} else {
//				CommonService.msg("동일한 비밀번호를 입력해주세요!");
//			}
//		} else {
//			CommonService.msg("모든 정보를 입력해주세요!");
//		}
//	return rs;
//	}
//	
//	public void resignMember() {
//		int rs = loginDao.resignMember(con.getmId());
//		if(rs == -1) CommonService.msg("회원 삭제 실패");
//	}
//	
//	public void openPwConfirmForm() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/myPage/pwConfirmForm.fxml"));
//		Parent pwConfirmForm;
//		
//		try {
//			pwConfirmForm = loader.load();
//			
//			myPageController myPageCon = loader.getController();
//			myPageCon.setPwConfirmForm(pwConfirmForm);
//			myPageCon.setCon(con);
////			con.setMyPageCon(myPageCon);
////			System.out.println("openPwConfirmForm : " + con.getmId());
//			Stage stage = new Stage();
//			Scene scene = new Scene(pwConfirmForm);
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
//	}
//	
//	public void openMyInfoChangeForm() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/myPage/myInfoChangeForm.fxml"));
//		Parent myInfoChangeForm;
//		
//		try {
//			myInfoChangeForm = loader.load();
//			
//			myPageController myPageCon = loader.getController();
//			myPageCon.setMyPageForm(myInfoChangeForm);
//			myPageCon.setCon(con);
////			con.setMyPageCon(myPageCon);
//			
//			Stage stage = new Stage();
//			Scene scene = new Scene(myInfoChangeForm);
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}	
//	}
//	
//
//	
//	public void openMyPageForm() {
//		Stage primaryStage = new Stage();
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/myPage/myPageForm.fxml"));
//		
//		Parent myPageForm;
//		
//		try {
//			myPageForm = loader.load();
//			Scene scene = new Scene(myPageForm);
//			
//			myPageController myPageCon = loader.getController();
//			myPageCon.setMyPageForm(myPageForm);
//			myPageCon.setCon(con);
//			
//	//		con.setMyPageCon(myPageCon);
//			System.out.println("openMyPageForm : " + con.getmId());
//			primaryStage.setScene(scene);
//			primaryStage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
}
