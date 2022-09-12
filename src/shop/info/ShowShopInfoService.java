package shop.info;

import java.io.IOException;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import javafx.stage.Stage;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class ShowShopInfoService {
	
	private ShopMainController con;
	private ShopInfoController infoCon;
	private ShowShopInfoController showSICon;
	private ShopDAO dao;
	
	public ShowShopInfoService() {
		dao = new ShopDAO();
	}
	
	public void setShowSICon(ShowShopInfoController showSICon) {
		this.showSICon = showSICon;
		this.infoCon = showSICon.getInfoCon();
		this.con = infoCon.getCon();
	}
	
	public void goUpdateInfo() {
		FXMLLoader updateShopLoader = new FXMLLoader(getClass().getResource("/shop/info/UpdateShopInfo.fxml"));
		Parent updateShopForm;
		
		try {
			ShopDTO dto = dao.selectId(con.getsId());
			
			updateShopForm = updateShopLoader.load();
			
			TextField sName = ((TextField) updateShopForm.lookup("#sName"));
			sName.setText(dto.getsName());
			
			TextField sBranch = ((TextField) updateShopForm.lookup("#sBranch"));
			sBranch.setText(dto.getsBranch());
			
			TextField sTel = ((TextField) updateShopForm.lookup("#sTel"));
			sTel.setText(dto.getsTel());
			
			ComboBox sFoodCate = (ComboBox) updateShopForm.lookup("#sFoodCate");
			sFoodCate.getItems().addAll("한식", "양식", "중식", "일식");
			sFoodCate.getSelectionModel().select(dto.getsFoodCate());
			
			String[] times = dto.getsTime().split("~");
			ComboBox runStart = (ComboBox) updateShopForm.lookup("#runStart");
			runStart.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
			runStart.getSelectionModel().select(times[0]);
			
			ComboBox runFinish = (ComboBox) updateShopForm.lookup("#runFinish");
			runFinish.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
			runFinish.getSelectionModel().select(times[1]);
			
			ComboBox sDayOff = (ComboBox) updateShopForm.lookup("#sDayOff");
			sDayOff.getItems().addAll("없음", "월", "화", "수", "목", "금", "토", "일");
			sDayOff.getSelectionModel().select(dto.getsDayOff());
			
			ComboBox sEvent = (ComboBox) updateShopForm.lookup("#sEvent");
			sEvent.getItems().addAll("없음", "월", "화", "수", "목", "금", "토", "일");
			sEvent.getSelectionModel().select(dto.getsEvent());

			TextField sSaleRate = ((TextField) updateShopForm.lookup("#sSaleRate"));
			sSaleRate.setText(dto.getsSaleRate().toString());
			
			TextField sAddress = ((TextField) updateShopForm.lookup("#sAddress"));
			sAddress.setText(dto.getsAddress());

			TextArea sExplain = ((TextArea) updateShopForm.lookup("#sExplain"));
			sExplain.setText(dto.getsExplain());
			
			TextArea sNotice = ((TextArea) updateShopForm.lookup("#sNotice"));
			sNotice.setText(dto.getsNotice());

			TextField sMinPay = (TextField) updateShopForm.lookup("#sMinPay");
			sMinPay.setText(dto.getsMinPay().toString());
			
			TextField sDeliveryDis = (TextField) updateShopForm.lookup("#sDeliveryDis");
			sDeliveryDis.setText(dto.getsDeliveryDis().toString());
			
			String[] deliveryTip = dto.getsDeliveryTip().split(":");
			TextField criteria = ((TextField) updateShopForm.lookup("#criteria"));
			criteria.setText(deliveryTip[0]);
			
			TextField down = ((TextField) updateShopForm.lookup("#down"));
			down.setText(deliveryTip[1]);
			
			TextField up = ((TextField) updateShopForm.lookup("#up"));
			up.setText(deliveryTip[2]);
			
			UpdateShopInfoController updateSICon = updateShopLoader.getController();
			updateSICon.setUpdateShopForm(updateShopForm);
			
			infoCon.setUpdateSICon(updateSICon);

			Scene scene = new Scene(updateShopForm);
			
			Stage stage = new Stage();
			stage.setTitle("updateShopInfo");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
