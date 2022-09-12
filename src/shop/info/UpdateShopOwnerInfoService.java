package shop.info;

import java.io.IOException;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class UpdateShopOwnerInfoService {
	
	private ShopMainController con;
	private ShopInfoController infoCon;
	private UpdateShopOwnerInfoController updateOwnerCon;
	private ShopDAO dao;
	
	public void setUpdateOwnerCon(UpdateShopOwnerInfoController updateOwnerCon) {
		this.updateOwnerCon = updateOwnerCon;
		this.infoCon = updateOwnerCon.getInfoCon();
		this.con = infoCon.getCon();
	}
	
	public UpdateShopOwnerInfoService() {
		dao = new ShopDAO();
	}
	
	public int updateOwnerInfo(Parent updateOwnerForm) {
		
		int rs = -1;
		
		TextField id = ((TextField) updateOwnerForm.lookup("#id"));
		TextField pw = ((TextField) updateOwnerForm.lookup("#pw"));
		TextField cPw = ((TextField) updateOwnerForm.lookup("#confirmPw"));
		TextField name = ((TextField) updateOwnerForm.lookup("#name"));
		TextField ownerTel = ((TextField) updateOwnerForm.lookup("#ownerTel"));
		
		if (!pw.getText().isEmpty() && !cPw.getText().isEmpty() && !name.getText().isEmpty()
				&& !ownerTel.getText().isEmpty()) {
			String sId = id.getText();
			String sPw = pw.getText();
			String sName = name.getText();
			String sOwnerTel = ownerTel.getText();

			if (pw.getText().equals(cPw.getText())) {
				ShopDTO dto = new ShopDTO();
				dto.setsId(sId);
				dto.setsPw(sPw);
				dto.setsName(sName);
				dto.setsOwnerTel(sOwnerTel);

				rs = dao.updateShopOwner(dto);
				if (rs == 1)
					CommonService.alert("점주 정보 수정 성공!");
				else
					CommonService.alert("점주 정보 수정 실패");
			} else {
				CommonService.alert("동일한 비밀번호를 입력해주세요!");
			}
		} else {
			CommonService.alert("모든 정보를 입력해주세요!");
		}
	return rs;
	}
	
}
