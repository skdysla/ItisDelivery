package member.myPage;

import java.io.IOException;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import member.main.memberController;
import member.main.memberDAO;
import member.main.memberDTO;

public class showMyInfoService {
	private memberController con;
	private myPageController mpCon;
	private showMyInfoController showMICon;
	private memberDAO dao;
	
	public showMyInfoService() {
		dao = new memberDAO();
	}
	
	public void setShowMICon(showMyInfoController showMICon) {
		this.showMICon = showMICon;
		this.mpCon = showMICon.getMpCon();
		this.con = showMICon.getCon();
	}
	
	public void modifyMyInfo() {
		FXMLLoader updateLoader = new FXMLLoader(getClass().getResource("/member/myPage/updateMyInfoForm.fxml"));
		Parent updateMyInfoForm;
		
		memberDTO dto = dao.selectId(con.getmId());
		
		try {
			updateMyInfoForm = updateLoader.load();
			
			TextField mId = ((TextField) updateMyInfoForm.lookup("#id"));
			mId.setText(dto.getmId());
			mId.setDisable(true);
			
			TextField mName = ((TextField) updateMyInfoForm.lookup("#name"));
			mName.setText(dto.getmName());

			TextField mTel = ((TextField) updateMyInfoForm.lookup("#tel"));
			mTel.setText(dto.getmTel());
			mTel.setDisable(true);
			
			updateMyInfoController updateMyCon = updateLoader.getController();
			updateMyCon.setUpdateMyInfoForm(updateMyInfoForm);
			
			mpCon.setUpdateMICon(updateMyCon);
			
			Scene scene = new Scene(updateMyInfoForm);
			
			Stage stage = new Stage();
			stage.setTitle("updateMyInfo");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void resignMember() {
		int rs = dao.resignMember(con.getmId());
		if(rs == -1) CommonService.alert("점주 삭제 실패");
	}
}
