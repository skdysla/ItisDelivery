package member.join;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import member.main.memberController;
import member.main.memberDAO;
import member.main.memberDTO;

public class regService {
	private memberController con;
	private regController regCon;
	private memberDAO dao;
	
	public regService() {
		dao = new memberDAO();
	}

	public void setRegCon(regController regCon) {
		this.regCon = regCon;
		this.con = regCon.getCon();
	}
//
//	public void openRegisterForm() {
//		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/reg/MemberRegForm.fxml"));
//		
//		Parent memberRegForm;
//		
//		try {
//			memberRegForm = loader.load();
//			Scene scene = new Scene(memberRegForm);
//			
//			regController regCon = loader.getController();
//			regCon.setRegForm(memberRegForm);
//			regCon.setCon(con);
//			
//			con.setRegCon(regCon);
//			Stage stage = new Stage();
//			stage.setTitle("회원가입");
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	public memberDTO regMember(Parent regForm) {
		
		memberDTO dto = null;
		
		TextField idField = (TextField)regForm.lookup("#id");
		TextField nameField = (TextField)regForm.lookup("#name");
		PasswordField pwField = (PasswordField)regForm.lookup("#pw");
		PasswordField confirmField = (PasswordField)regForm.lookup("#pwConfirm");
		TextField telField = (TextField)regForm.lookup("#tel");
		TextField addField = (TextField)regForm.lookup("#address");
		
		if (!idField.getText().isEmpty() && !pwField.getText().isEmpty() && !confirmField.getText().isEmpty() 
				&& !nameField.getText().isEmpty() && !telField.getText().isEmpty() && !addField.getText().isEmpty()) {
			String id = idField.getText();
			String name = nameField.getText();
			String pw = pwField.getText();
			String pwConfirm = confirmField.getText();
			String tel = telField.getText();
			String address = addField.getText();

			if (pw.equals(pwConfirm)) {
				dto = new memberDTO();
				dto.setmId(id);
				dto.setmPw(pw);
				dto.setmName(name);
				dto.setmTel(tel);
				dto.setmAddress(address);
				
				int rs = dao.regMember(dto);
				if (rs == 1)
					CommonService.alert("회원가입 성공!");
				else
					CommonService.alert("회원가입 실패");
			} else {
				CommonService.alert("동일한 비밀번호를 입력해주세요!");
			}
		}else {
			CommonService.alert("모든 정보를 입력해주세요!");
		}
		return dto;
	}
	
}
