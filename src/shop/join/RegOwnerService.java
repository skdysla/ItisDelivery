package shop.join;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class RegOwnerService {
	
	private ShopMainController con;
	private RegOwnerController regCon;
	private ShopDAO dao;
	
	public RegOwnerService() {
		dao = new ShopDAO();
	}
	
	public void setRegCon(RegOwnerController regCon) {
		this.regCon = regCon;
		this.con = regCon.getCon();
	}
	
	public ShopDTO regShopOwner(Parent regOwnerForm) {
		
		ShopDTO dto = null;
		
		TextField id = ((TextField) regOwnerForm.lookup("#id"));
		TextField pw = ((TextField) regOwnerForm.lookup("#pw"));
		TextField cPw = ((TextField) regOwnerForm.lookup("#confirmPw"));
		TextField name = ((TextField) regOwnerForm.lookup("#name"));
		TextField ownerTel = ((TextField) regOwnerForm.lookup("#ownerTel"));
		
		if (!id.getText().isEmpty() && !pw.getText().isEmpty() && !cPw.getText().isEmpty() && !name.getText().isEmpty()
				&& !ownerTel.getText().isEmpty()) {
			String sId = id.getText();
			String sPw = pw.getText();
			String confirmPw = cPw.getText();
			String sName = name.getText();
			String sOwnerTel = ownerTel.getText();

			if (sPw.equals(confirmPw)) {
				dto = dao.selectId(sId);
				if (dto == null) {
					dto = new ShopDTO();
					dto.setsId(sId);
					dto.setsPw(sPw);
					dto.setsName(sName);
					dto.setsOwnerTel(sOwnerTel);

					int rs = dao.regShopOwner(dto);

					if (rs == 1)
						CommonService.alert("점주 회원가입 성공!");
					else
						CommonService.alert("점주 회원가입 실패");
				} else {
					CommonService.alert("중복되는 ID입니다.");
				}
			} else {
				CommonService.alert("동일한 비밀번호를 입력해주세요!");
			}
		} else {
			CommonService.alert("모든 정보를 입력해주세요!");
		}
		return dto;
	}

}
