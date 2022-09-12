package shop.join;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TextInputControl;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class RegShopService {
	private ShopMainController con;
	private RegShopController regCon;
	private ShopDAO dao;
	
	public RegShopService() {
		dao = new ShopDAO();
	}
	
	public void setRegCon(RegShopController regCon) {
		this.regCon = regCon;
		this.con = regCon.getCon();
	}
	
	public int regShopInfo(Parent regForm) {
		int rs = -1;
		
		TextField name = ((TextField)regForm.lookup("#sName"));
		TextField branch = ((TextField)regForm.lookup("#sBranch"));
		TextField tel = ((TextField)regForm.lookup("#sTel"));
		
		ComboBox start = (ComboBox) regForm.lookup("#runStart");
		ComboBox finish = (ComboBox) regForm.lookup("#runFinish");
		
		ComboBox dayOff = (ComboBox) regForm.lookup("#sDayOff");
		ComboBox event = (ComboBox) regForm.lookup("#sEvent");
		TextField saleRate = ((TextField)regForm.lookup("#sSaleRate"));
		TextField address = ((TextField)regForm.lookup("#sAddress"));
		
		String sExplain = ((TextInputControl) regForm.lookup("#sExplain")).getText();
		String sNotice = ((TextInputControl) regForm.lookup("#sNotice")).getText();
		
		TextField minPay = (TextField)regForm.lookup("#sMinPay");
		TextField deliveryDis = (TextField)regForm.lookup("#sDeliveryDis");
		ComboBox foodCate = (ComboBox) regForm.lookup("#sFoodCate");
		
		TextField criteria = ((TextField)regForm.lookup("#criteria"));
		TextField down = ((TextField)regForm.lookup("#down"));
		TextField up = ((TextField)regForm.lookup("#up"));
		
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
				CommonService.alert("점포 정보 등록 성공!");
			}
			else {
				CommonService.alert("점포 정보 등록 실패");
			}
		}else {
			CommonService.alert("모든 정보를 입력해주세요!");
		}
		return rs;
	}

}
