package shop.sales;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import shop.main.ShopMainController;
import shop.order.OrderDAO;
import shop.order.OrderDTO;

public class ShopSalesService {
	
	private ShopMainController con;
	private ShopSalesController salesCon;
	private OrderDAO dao;
	
	public ShopSalesService() {
		dao = new OrderDAO();
	}
	
	public void setSalesCon(ShopSalesController salesCon) {
		this.salesCon = salesCon;
		this.con = salesCon.getCon();
	}
	
	public ArrayList<OrderDTO> today() {
		return dao.selectByDate(con.getsId(), 10, "YYYY-MM-DD");
	}
	
	public ArrayList<OrderDTO> thisMonth() {
		return dao.selectByDate(con.getsId(), 7, "YYYY-MM");
	}
	
	public ArrayList<OrderDTO> thisYear() {
		return dao.selectByDate(con.getsId(), 4, "YYYY");
	}
	
	public ArrayList<OrderDTO> total() {
		return dao.selectTotal(con.getsId());
	}
	
	public ObservableList<OrderDTO> AddDto(ObservableList<OrderDTO> salesList, ArrayList<OrderDTO> dtoList, PieChart menuChart) {
		ArrayList<OrderDTO> list = dtoList;
		ArrayList<OrderDTO> tmp = new ArrayList<>();
		HashMap<String, Integer> menuList = new HashMap<>();
		
		DecimalFormat decFormat = new DecimalFormat("###,###");
		Integer salesTotal = 0;
		int size = 0;
		
		if(!list.isEmpty()) {
			for(int i = 0; i < list.size(); i++) {
				String[] menu_tmp = list.get(i).getO_menu().split(", ");
				String[] cnt_tmp = list.get(i).getO_cnt().split(", ");
				String[] price_tmp = list.get(i).getO_price().split(", ");
				size = menu_tmp.length;
				for(int j = 0; j < size; j++) {
					int num = list.get(i).getO_num();
					Integer total = Integer.parseInt(cnt_tmp[j]) * Integer.parseInt(price_tmp[j]);
					salesTotal += total; //주문별 총합 구하기
					tmp.add(new OrderDTO(num, null, menu_tmp[j], cnt_tmp[j], total.toString()));
					if(menuList.containsKey(menu_tmp[j])) {
						Integer cnt = menuList.get(menu_tmp[j]);
						menuList.put(menu_tmp[j], cnt + Integer.parseInt(cnt_tmp[j]));
					}else {
						menuList.put(menu_tmp[j], Integer.parseInt(cnt_tmp[j]));
					}
				}
			}
			String total = decFormat.format(salesTotal);
			salesCon.setTotal(total);
			
			//파이 차트에 메뉴별 점유율 표시 
			ObservableList<PieChart.Data> menus = FXCollections.observableArrayList();
			for(String key: menuList.keySet()) {
				menus.add(new PieChart.Data(key , (menuList.get(key) / (double)size) * 100));
			}
			menuChart.setData(FXCollections.observableArrayList(menus));
		}else {
			return null;
		}
		salesList.addAll(tmp);
		return salesList;
	}

}
