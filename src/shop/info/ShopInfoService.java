package shop.info;

import java.io.IOException;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import shop.main.ShopDAO;
import shop.main.ShopDTO;
import shop.main.ShopMainController;

public class ShopInfoService {
	
	private ShopMainController con;
	private ShopInfoController infoCon;
	private ShopDAO dao;
	private ShopDTO dto;
	
	public ShopInfoService() {
		dao = new ShopDAO();
	}
	
	public void setInfoCon(ShopInfoController infoCon) {
		this.infoCon = infoCon;
		this.con = infoCon.getCon();
	}
	
	public ShopInfoController getInfoCon() {
		return infoCon;
	}
	
	public void showShopOwnerInfo() {
		FXMLLoader checkPwLoader = new FXMLLoader(getClass().getResource("/shop/info/CheckShopOwnerPw.fxml"));
		Parent checkPwForm;
		
		try {
			checkPwForm = checkPwLoader.load();

			CheckPwController chkPwCon = checkPwLoader.getController();
			chkPwCon.setChkPwForm(checkPwForm);
			
			infoCon.setChkPwCon(chkPwCon);
			
			Scene scene = new Scene(checkPwForm);
			
			Stage stage = new Stage();
			stage.setTitle("checkPw");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void showShopInfo() {
		FXMLLoader showInfoLoader = new FXMLLoader(getClass().getResource("/shop/info/ShowShopInfo.fxml"));
		Parent showShopForm;
		
		ShopDTO dto = dao.selectId(con.getsId());
		
		try {
			showShopForm = showInfoLoader.load();
			
			//sLogo
			
			Label sName = ((Label) showShopForm.lookup("#sName"));
			sName.setText(dto.getsName());
			
			Label sBranch = ((Label) showShopForm.lookup("#sBranch"));
			sBranch.setText(dto.getsBranch());
			
			Label sFoodCate = ((Label) showShopForm.lookup("#sFoodCate"));
			sFoodCate.setText(dto.getsFoodCate());
			
			Label sAddress = ((Label) showShopForm.lookup("#sAddress"));
			sAddress.setText(dto.getsAddress());
			
			Label sTel = ((Label) showShopForm.lookup("#sTel"));
			sTel.setText(dto.getsTel());
			
			Label sLikeCnt = ((Label) showShopForm.lookup("#sLikeCnt"));
			sLikeCnt.setText(dto.getsLikeCnt().toString());
			
			Label sOrderCnt = ((Label) showShopForm.lookup("#sOrderCnt"));
			sOrderCnt.setText(dto.getsOrderCnt().toString());
			
			Label sReviewCnt = ((Label) showShopForm.lookup("#sReviewCnt"));
			sReviewCnt.setText(dto.getsReviewCnt().toString());

			TextArea sExplain = (TextArea) showShopForm.lookup("#sExplain");
			sExplain.setText(dto.getsExplain());
			sExplain.setDisable(true);
			
			TextArea sNotice = (TextArea) showShopForm.lookup("#sNotice");
			sNotice.setText(dto.getsNotice());
			sNotice.setDisable(true);
			
			Label sTime = ((Label) showShopForm.lookup("#sTime"));
			sTime.setText(dto.getsTime());
			
			Label sDayOff = ((Label) showShopForm.lookup("#sDayOff"));
			sDayOff.setText(dto.getsDayOff());
			
			Label sEvent = ((Label) showShopForm.lookup("#sEvent"));
			sEvent.setText(dto.getsEvent());
			
			HBox rBox = (HBox) showShopForm.lookup("#sSale");
			
			if(sEvent.getText().equals("없음")) 
				rBox.setVisible(true);
			else {
				Label sSaleRate = ((Label) showShopForm.lookup("#sSaleRate"));
				sSaleRate.setText(dto.getsSaleRate().toString());
			}
			
			Label sMinPay = ((Label) showShopForm.lookup("#sMinPay"));
			sMinPay.setText(dto.getsMinPay().toString());
			
			Label sDeliveryDis = ((Label) showShopForm.lookup("#sDeliveryDis"));
			sDeliveryDis.setText(dto.getsDeliveryDis().toString());
			
			String[] deliveryTip = dto.getsDeliveryTip().split(":");
			
			Label criteria = ((Label) showShopForm.lookup("#criteria"));
			criteria.setText(deliveryTip[0]);
			
			Label down = ((Label) showShopForm.lookup("#down"));
			down.setText(deliveryTip[1]);
			
			Label up = ((Label) showShopForm.lookup("#up"));
			up.setText(deliveryTip[2]);
		
			ShowShopInfoController showSICon = showInfoLoader.getController();
			showSICon.setShowShopForm(showShopForm);
			
			infoCon.setShowSICon(showSICon);

			Scene scene = new Scene(showShopForm);
			
			Stage stage = new Stage();
			stage.setTitle("showShopInfo");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void goShopOwnerInfo() {
		FXMLLoader showSOILoader = new FXMLLoader(getClass().getResource("/shop/info/ShowShopOwnerInfo.fxml"));
		Parent showSOIForm;
		
		ShopDTO dto = dao.selectId(con.getsId());
		
		try {
			showSOIForm = showSOILoader.load();
			
			Label sId = ((Label) showSOIForm.lookup("#sId"));
			sId.setText(dto.getsId());
			
			Label sPw = ((Label) showSOIForm.lookup("#sPw"));
			sPw.setText(dto.getsPw());
			
			Label sName = ((Label) showSOIForm.lookup("#sName"));
			sName.setText(dto.getsName());
			
			Label sOwnerTel = ((Label) showSOIForm.lookup("#sOwnerTel"));
			sOwnerTel.setText(dto.getsOwnerTel());

			ShowShopOwnerInfoController showSOICon = showSOILoader.getController();
			showSOICon.setShowSOIForm(showSOIForm);
			
			infoCon.setShowSOICon(showSOICon);

			Scene scene = new Scene(showSOIForm);
			
			Stage stage = new Stage();
			stage.setTitle("shopOwnerInfo");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	
	public int logout() {
		return dao.updateLogoutTime(con.getsId());
	}

}
