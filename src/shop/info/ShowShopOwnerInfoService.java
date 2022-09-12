package shop.info;

import java.io.IOException;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.login.ShopLoginController;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class ShowShopOwnerInfoService {
	
	private ShopMainController con;
	private ShopInfoController infoCon;
	private ShowShopOwnerInfoController showSOICon;
	private ShopDAO dao;
	
	public ShowShopOwnerInfoService() {
		dao = new ShopDAO();
	}
	
	public void setShowSOICon(ShowShopOwnerInfoController showSOICon) {
		this.showSOICon = showSOICon;
		this.infoCon = showSOICon.getInfoCon();
		this.con = showSOICon.getCon();
	}

	public void modifyOwnerInfo() {
		FXMLLoader updateOwnerLoader = new FXMLLoader(getClass().getResource("/shop/info/UpdateShopOwnerInfo.fxml"));
		Parent updateOwnerForm;
		
		ShopDTO dto = dao.selectId(con.getsId());
		
		try {
			updateOwnerForm = updateOwnerLoader.load();
			
			TextField sId = ((TextField) updateOwnerForm.lookup("#id"));
			sId.setText(dto.getsId());
			sId.setDisable(true);
			
			TextField sName = ((TextField) updateOwnerForm.lookup("#name"));
			sName.setText(dto.getsName());

			TextField sOwnerTel = ((TextField) updateOwnerForm.lookup("#ownerTel"));
			sOwnerTel.setText(dto.getsOwnerTel());
			
			UpdateShopOwnerInfoController updateOwnerCon = updateOwnerLoader.getController();
			updateOwnerCon.setUpdateOwnerForm(updateOwnerForm);
			
			infoCon.setUpdateSOICon(updateOwnerCon);
			
			Scene scene = new Scene(updateOwnerForm);
			
			Stage stage = new Stage();
			stage.setTitle("updateOwnerInfo");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void resignShopOwner() {
		int rs = dao.resignShop(con.getsId());
		if(rs == 1) CommonService.alert("점주 탈퇴 성공!");
		else CommonService.alert("점주 탈퇴 실패");
	}
}
