package shop.main;

import java.io.IOException;

import shop.ask.ShopAskController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shop.list.ShopListController;
import shop.menu.ShopMenuController;
import shop.home.ShopHomeController;
import shop.info.ShopInfoController;
import shop.join.RegShopController;
import shop.login.ShopLoginController;
import shop.order.ShopAcceptedOController;
import shop.sales.ShopSalesController;

public class ShopMainService {
	
	private ShopMainController con;
	private ShopDAO dao;
	
	public ShopMainService() {
		dao = new ShopDAO();
	}
	
	public void setCon(ShopMainController con) {
		this.con = con;
	}
	
	public void openHome() {
		
		FXMLLoader homeLoader = new FXMLLoader(getClass().getResource("/shop/home/ShopHomeForm.fxml"));
		Parent homeForm;
		
		try {
			homeForm = homeLoader.load();

			ShopHomeController homeCon = homeLoader.getController();
			homeCon.setHomeForm(homeForm);
			
			con.setHomeCon(homeCon);

			Scene scene = new Scene(homeForm);
			
			Stage stage = new Stage();
			stage.setTitle("shopHome");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	public void openMenu() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/menu/ShopMenuForm.fxml"));
		Parent menuForm;
			
			try {
				menuForm = loader.load();
				Scene scene = new Scene(menuForm);
				
				ShopMenuController menuCon = loader.getController();
				menuCon.setMenuForm(menuForm);
				con.setShopMenuCon(menuCon);
				
				Stage stage = new Stage();
				stage.setTitle("shopMenu");
				stage.setScene(scene);
				stage.show();
			} catch (IOException e) {
				e.printStackTrace();
		}
		
	}

	public void openSales() {
		FXMLLoader salesLoader = new FXMLLoader(getClass().getResource("/shop/sales/ShowSales.fxml"));
		Parent salesForm;
		
		try {
			salesForm = salesLoader.load();
			
			ShopSalesController salesCon = salesLoader.getController();
			salesCon.setSalesForm(salesForm);
			
			con.setSalesCon(salesCon);

			Scene scene = new Scene(salesForm);
			
			Stage stage = new Stage();
			stage.setTitle("Sales");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openAsk() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/ask/ShopAskForm.fxml"));
		Parent askForm;
		
		try {
			askForm = loader.load();

			
			
			ShopAskController askCon = loader.getController();
			askCon.setAskForm(askForm);
			
			con.setAskController(askCon);
			Scene scene = new Scene(askForm);
			
			Stage stage = new Stage();
			stage.setTitle("ask");
			stage.setScene(scene);
			stage.show();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	public void openList() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/list/ShopListForm.fxml"));
		Parent ListForm;
		
		try {
			ListForm = loader.load();
			Scene scene = new Scene(ListForm);
			
			ShopListController ListCon = loader.getController();
			ListCon.setListForm(ListForm);
			
			con.setShopListCon(ListCon);
			
			
			Stage stage = new Stage();
			stage.setTitle("ListForm");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void openShopInfo() {
		FXMLLoader shopInfoCLoader = new FXMLLoader(getClass().getResource("/shop/info/ShopInfoChoice.fxml"));
		Parent shopInfoCForm;
		
		try {
			shopInfoCForm = shopInfoCLoader.load();
			
			ShopInfoController infoCon = shopInfoCLoader.getController();
			infoCon.setChoiceForm(shopInfoCForm);
			
			con.setInfoCon(infoCon);
			
			Scene scene = new Scene(shopInfoCForm);
			
			Stage stage = new Stage();
			stage.setTitle("choiceInfo");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openRegShop() {
		FXMLLoader regShopLoader = new FXMLLoader(getClass().getResource("/shop/join/RegShopInfo.fxml"));
		Parent regShopForm;
		
		try {
			regShopForm = regShopLoader.load();
			
			ComboBox sFoodCate = (ComboBox) regShopForm.lookup("#sFoodCate");
			sFoodCate.getItems().addAll("한식", "양식", "중식", "일식");
			
			ComboBox runStart = (ComboBox) regShopForm.lookup("#runStart");
			runStart.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
			
			ComboBox runFinish = (ComboBox) regShopForm.lookup("#runFinish");
			runFinish.getItems().addAll("1", "2", "3", "4", "5", "6", "7", "8", "9", "10",
					"11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24");
			
			ComboBox sDayOff = (ComboBox) regShopForm.lookup("#sDayOff");
			sDayOff.getItems().addAll("없음", "월", "화", "수", "목", "금", "토", "일");
			
			ComboBox sEvent = (ComboBox) regShopForm.lookup("#sEvent");
			sEvent.getItems().addAll("없음", "월", "화", "수", "목", "금", "토", "일");
			
			RegShopController regCon = regShopLoader.getController();
			regCon.setRegForm(regShopForm);
			
			con.setRegCon(regCon);
			
			Scene scene = new Scene(regShopForm);
			
			Stage stage = new Stage();
			stage.setTitle("regShopInfo");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openAcceptedOrders() {
		FXMLLoader acceptedOLoader = new FXMLLoader(getClass().getResource("/shop/order/ShowAcceptedOrders.fxml"));
		Parent acceptedOForm;
		
		try {
			acceptedOForm = acceptedOLoader.load();
			
			ShopAcceptedOController acceptedOCon = acceptedOLoader.getController();
			acceptedOCon.setAcceptedOForm(acceptedOForm);
			
			con.setAcceptedOCon(acceptedOCon);

			Scene scene = new Scene(acceptedOForm);
			
			Stage stage = new Stage();
			stage.setTitle("acceptedOrders");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void openLogin() {
		FXMLLoader loginLoader = new FXMLLoader(getClass().getResource("/shop/login/ShopLogin.fxml"));
		Parent loginForm;
		try {
			loginForm = loginLoader.load();
			
			ShopLoginController loginCon = loginLoader.getController();
			loginCon.setLoginForm(loginForm);
			
			con.setLoginCon(loginCon);
			
			Scene scene = new Scene(loginForm);
			
			Stage stage = new Stage();
			stage.setTitle("Login");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public boolean checkShopTel(String sId) {
		boolean flag = false;
		
		String oId = con.getsId();
		ShopDTO result = dao.selectId(oId);
		String sTel = result.getsTel();
		
		if(sTel != null) {
			flag = true;
		}
		
		return flag;
	}

}
