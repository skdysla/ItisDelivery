package shop.info;

import java.io.IOException;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class CheckPwService {

	private ShopMainController con;
	private ShopInfoController infoCon;
	private CheckPwController chkPwCon;
	private ShopDAO dao;
	
	public CheckPwService() {
		dao = new ShopDAO();
	}
	
	public void setChkPwCon(CheckPwController chkPwCon) {
		this.chkPwCon = chkPwCon;
		this.infoCon = chkPwCon.getInfoCon();
		this.con = infoCon.getCon();
	}

	public boolean confirmOwnerPw(Parent chkPwForm) {
		String oId = con.getsId();
		ShopDTO dto = dao.selectId(oId);
		boolean closeForm = false;
		
		TextField pw = ((TextField) chkPwForm.lookup("#pw"));
		
		if (!pw.getText().isEmpty()) {
			if (pw.getText().equals(dto.getsPw())) {
				closeForm = true;

				FXMLLoader showOwnerInfoLoader = new FXMLLoader(getClass().getResource("/shop/info/ShowShopOwnerInfo.fxml"));
				Parent showOwnerInfoForm;

				try {
					showOwnerInfoForm = showOwnerInfoLoader.load();

					Label sId = ((Label) showOwnerInfoForm.lookup("#sId"));
					sId.setText(dto.getsId());

					Label sPw = ((Label) showOwnerInfoForm.lookup("#sPw"));
					sPw.setText(dto.getsPw());

					Label sName = ((Label) showOwnerInfoForm.lookup("#sName"));
					sName.setText(dto.getsName());

					Label sOwnerTel = ((Label) showOwnerInfoForm.lookup("#sOwnerTel"));
					sOwnerTel.setText(dto.getsOwnerTel());

					ShowShopOwnerInfoController showOwnerInfoCon = showOwnerInfoLoader.getController();
					showOwnerInfoCon.setShowSOIForm(showOwnerInfoForm);

					infoCon.setShowSOICon(showOwnerInfoCon);

					Scene scene = new Scene(showOwnerInfoForm);

					Stage stage = new Stage();
					stage.setTitle("showOwnerInfo");
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
