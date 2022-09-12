package shop.home;

import java.io.IOException;
import java.util.ArrayList;

import shop.home.ShopHomeDAO;
import shop.home.ShopHomeDTO;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import shop.main.ShopMainController;
import shop.order.OrderDAO;
import shop.order.ShopAllOController;

public class ShopHomeService {
	private ShopMainController con;
	private ShopHomeController homeCon;
	private ShopHomeDAO homeDao;
	private String sId;
	private OrderDAO dao;
	
	public ShopHomeService(ShopMainController con) {
		this.con = con;
		this.sId = con.getsId();
		homeDao = new ShopHomeDAO();
		dao = new OrderDAO();
	}
	
	public void setHomeCon(ShopHomeController homeCon) {
		this.homeCon = homeCon;
		this.con = homeCon.getCon();
	}

	public void clickOrderBtn() {
		//주문 시간으로부터 1시간 이상 지났고, 점주가 수락하지 않은 주문을 자동으로 주문 거절로 변환시키는 함수
		dao.refuseOrder();
		
		FXMLLoader allOLoader = new FXMLLoader(getClass().getResource("/shop/order/ShowAllOrders.fxml"));
		Parent allOForm;
		
		try {
			allOForm = allOLoader.load();
			
			ShopAllOController allOrdersCon = allOLoader.getController();
			allOrdersCon.setAllOrdersForm(allOForm);
			
			con.setAllOrdersCon(allOrdersCon);

			Scene scene = new Scene(allOForm);
			
			Stage stage = new Stage();
			stage.setTitle("AllOrders");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public int beforeCnt() {
		String sId = this.sId;
		int order = 0;
		order = homeDao.selectCondition(sId);
		return order;
	}

	public int[] shopSales(int num) {
		ArrayList<ShopHomeDTO> orderList = new ArrayList<>();
		int size = 0;
		// 4 / 7 /11 yyyy/yyyy-mm/yyyy-mm-dd
		if (num == 4) {// String sId, int num, String date
			//year 기준 건수와 매출
			orderList = homeDao.selectSales(sId, num, "yyyy");
			return homeShow(orderList);
		} else if (num == 7) {
			//month 기준 건수와 매출
			orderList = homeDao.selectSales(sId, num, "yyyy-mm");
			return homeShow(orderList);
		} else {
			//day 기준 건수와 매출
			orderList = homeDao.selectSales(sId, num, "yyyy-mm-dd");
			homeShow(orderList);
			return homeShow(orderList);
		}
		
	}
	//매출 및 건수 함수
	public int[] homeShow(ArrayList List) {
		String sId = this.sId;
		int[] home = new int[2]; 
		// db에서 가져올 오더리스트 및 리스트 내에 여러건들을 구분자를 통해 분리하여 저장할 리스트
		ArrayList<ShopHomeDTO> orderList = List;
		ArrayList<ShopHomeDTO> tmp = new ArrayList<>();
		int size = 0;
		// 4 / 7 /11 yyyy/yyyy-mm/yyyy-mm-dd
		int count = orderList.size(); // 건수
		int totalPrice = 0; //매출금액
		//오더리스트에서 구분자를 통해 배열에 집어넣기
		String[] menu_tmp = null;
		String[] cnt_tmp = null;
		String[] price_tmp = null;
		for (int i = 0; i < orderList.size(); i++) {
			menu_tmp = orderList.get(i).getO_menu().split(", ");
			cnt_tmp = orderList.get(i).getO_cnt().split(", ");
			price_tmp = orderList.get(i).getO_price().split(", ");
			size = cnt_tmp.length;
			for (int j = 0; j < size; j++) {
				int chk = orderList.get(i).getO_num();
				tmp.add(new ShopHomeDTO(menu_tmp[j], cnt_tmp[j], price_tmp[j]));
			}
		}
		//totalPrice
		for(int i= 0;i<tmp.size();i++) {
			int price = Integer.parseInt(tmp.get(i).getO_cnt()) * Integer.parseInt(tmp.get(i).getO_price());
			totalPrice += price;
		}
		home[0] = totalPrice;
		home[1] = count;
		return home;
		
	}

}
