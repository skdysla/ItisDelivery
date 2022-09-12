package shop.order;

import common.CommonService;
import javafx.collections.ObservableList;

public class ShowOrderDetailService {
	
	private ShowOrderDetailController showDetailCon;
	private OrderDAO dao;
	
	public ShowOrderDetailService() {
		dao = new OrderDAO();
	}
	
	public void setShowDetailCon(ShowOrderDetailController showDetailCon) {
		this.showDetailCon = showDetailCon;
	}

	public ObservableList<DetailDTO> showDetail(ObservableList<DetailDTO> list) {
		DetailDTO dto = dao.showDetail(showDetailCon.getoNum());
		
		int total = 0;
		String[] menu = dto.getO_menu().split(", ");
		String[] cnt = dto.getO_cnt().split(", ");
		String[] price = dto.getO_price().split(", ");
		
		int length = menu.length;
		
		for(int i = 0; i < length; i++) {
			list.add(new DetailDTO(menu[i], cnt[i], price[i]));
			total += (Integer.parseInt(cnt[i]) * Integer.parseInt(price[i]));
		}
		showDetailCon.setTotal(total);
		return list;
	}

	public void acceptOrder() {
		int rs = dao.changeOrderState("accepted", showDetailCon.getoNum());
		if(rs == 1) CommonService.alert("주문 승인 완료!");
		else CommonService.alert("주문 승인 실패");
	}

	public void refuseOrder() {
		int rs = dao.changeOrderState("refused", showDetailCon.getoNum());
		if(rs == 1) CommonService.alert("주문 거절 완료!");
		else CommonService.alert("주문 거절 실패");
	}
	
}
