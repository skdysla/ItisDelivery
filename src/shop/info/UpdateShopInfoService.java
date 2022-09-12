package shop.info;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class UpdateShopInfoService {
	private ShopMainController con;
	private ShopInfoController infoCon;
	private UpdateShopInfoController updateSICon;
	private ShopDAO dao;
	
	public UpdateShopInfoService() {
		dao = new ShopDAO();
	}
	
	public void setUpdateSICon(UpdateShopInfoController updateSICon) {
		this.updateSICon = updateSICon;
		this.infoCon = updateSICon.getInfoCon();
		this.con = infoCon.getCon();
	}
	
	public void updateImage() {
		
	}

	public void openMap() {

	}

	public int goShopUpdate(Parent updateShopForm) {
		int rs = -1;
		
		TextField name = ((TextField)updateShopForm.lookup("#sName"));
		TextField branch = ((TextField)updateShopForm.lookup("#sBranch"));
		TextField tel = ((TextField)updateShopForm.lookup("#sTel"));
		
		ComboBox start = (ComboBox) updateShopForm.lookup("#runStart");
		ComboBox finish = (ComboBox) updateShopForm.lookup("#runFinish");
		
		ComboBox dayOff = (ComboBox) updateShopForm.lookup("#sDayOff");
		ComboBox event = (ComboBox) updateShopForm.lookup("#sEvent");
		TextField saleRate = ((TextField)updateShopForm.lookup("#sSaleRate"));
		TextField address = ((TextField)updateShopForm.lookup("#sAddress"));
		
		String sExplain = ((TextInputControl) updateShopForm.lookup("#sExplain")).getText();
		String sNotice = ((TextInputControl) updateShopForm.lookup("#sNotice")).getText();
		
		TextField minPay = (TextField)updateShopForm.lookup("#sMinPay");
		TextField deliveryDis = (TextField)updateShopForm.lookup("#sDeliveryDis");
		ComboBox foodCate = (ComboBox) updateShopForm.lookup("#sFoodCate");
		
		TextField criteria = ((TextField)updateShopForm.lookup("#criteria"));
		TextField down = ((TextField)updateShopForm.lookup("#down"));
		TextField up = ((TextField)updateShopForm.lookup("#up"));
		
		if(!branch.getText().isEmpty() && !tel.getText().isEmpty() && (start.getSelectionModel().getSelectedItem() != null) && (finish.getSelectionModel().getSelectedItem() != null)
				&& (dayOff.getSelectionModel().getSelectedItem() != null) && (event.getSelectionModel().getSelectedItem() != null) && !address.getText().isEmpty()
				&& !minPay.getText().isEmpty() && !deliveryDis.getText().isEmpty() && (foodCate.getSelectionModel().getSelectedItem() != null)
				&& !criteria.getText().isEmpty() && !down.getText().isEmpty() && !up.getText().isEmpty()) {
			String sName = name.getText();
			String sBranch = branch.getText();
			String sTel = tel.getText();
			
			String sDayOff = dayOff.getSelectionModel().getSelectedItem().toString();
			String sEvent = event.getSelectionModel().getSelectedItem().toString();
			
			Integer sSaleRate = 0;
			if(!saleRate.getText().isEmpty()) sSaleRate = Integer.parseInt(saleRate.getText());
			
			String sAddress = address.getText();
			Integer sMinPay = Integer.parseInt(minPay.getText());
			Integer sDeliveryDis = Integer.parseInt(deliveryDis.getText());
			String sFoodCate = foodCate.getSelectionModel().getSelectedItem().toString();
			
			String startTime = start.getSelectionModel().getSelectedItem().toString();
			String finishTime = finish.getSelectionModel().getSelectedItem().toString();
			String sTime = startTime + "~" + finishTime;
			
			String c = criteria.getText();
			String d = down.getText();
			String u = up.getText();
			String sDeliveryTip = c + ":" + d + ":" + u;
			
			String sId = con.getsId();
	
			ShopDTO dto = new ShopDTO(sId, sName, sBranch, sTel, sTime, sDayOff, sEvent, sSaleRate, sAddress, sExplain, null,
					sNotice, sMinPay, sDeliveryDis, sDeliveryTip, sFoodCate);
	
			rs = dao.regShopInfo(dto);
	
			if (rs == 1) {
				CommonService.alert("점포 정보 수정 성공!");
			}
			else {
				CommonService.alert("점포 정보 수정 실패");
			}
		}else {
			CommonService.alert("모든 정보를 입력해주세요!");
		}
		return rs;
	}
	
}
