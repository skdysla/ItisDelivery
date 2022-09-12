package shop.order;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import shop.main.ShopMainController;

public class ShopAllOService {
	
	private ShopMainController con;
	private ShopAllOController allOCon;
	private OrderDAO dao;
	
	public ShopAllOService() {
		dao = new OrderDAO();
	}
	
	public ShopMainController getCon() {
		return con;
	}
	
	public void setAllOCon(ShopAllOController allOCon) {
		this.allOCon = allOCon;
		this.con = allOCon.getCon();
	}
	
	public ObservableList<OrderDTO> show(ObservableList<OrderDTO> orderList) {
		ArrayList<OrderDTO> list = dao.selectAll(con.getsId());
		ArrayList<OrderDTO> tmp = new ArrayList<>();
		
		int size = 0;
		
		if(!list.isEmpty()) {
			String[] menu_tmp = null;
			String[] cnt_tmp = null;
			String[] price_tmp = null;
			for(int i = 0; i < list.size(); i++) {
				menu_tmp = list.get(i).getO_menu().split(", ");
				cnt_tmp = list.get(i).getO_cnt().split(", ");
				price_tmp = list.get(i).getO_price().split(", ");
				size = cnt_tmp.length;
				for(int j = 0; j < size; j++) {
					int num = list.get(i).getO_num();
					tmp.add(new OrderDTO(num, list.get(i).getO_time().substring(5, list.get(i).getO_time().length()), 
							menu_tmp[j], cnt_tmp[j], price_tmp[j]));
				}
			}
		}else {
			return null;
		}
		orderList.addAll(tmp);
		return orderList;
	}

	public void showOrderDetail(OrderDTO dto) {
		FXMLLoader showDetailLoader = new FXMLLoader(getClass().getResource("/shop/order/ShowOrderDetail.fxml"));
		Parent detailForm;
		
		try {
			detailForm = showDetailLoader.load();
			
			DetailDTO detail = dao.showDetail(dto.getO_num());
			
			Label sName = (Label) detailForm.lookup("#sName");
			sName.setText(detail.getS_name());
			
			Label sBranch = (Label) detailForm.lookup("#sBranch");
			sBranch.setText(detail.getS_branch());
			
			Label oNum = (Label) detailForm.lookup("#oNum");
			oNum.setText(dto.getO_num().toString());
			
			Label oTime = (Label) detailForm.lookup("#oTime");
			oTime.setText(dto.getO_time().substring(0, dto.getO_time().length()));
			
			Label mAddress = (Label) detailForm.lookup("#mAddress");
			mAddress.setText(detail.getM_address());
			
			Label mTel = (Label) detailForm.lookup("#mTel");
			mTel.setText(detail.getM_tel());
			
			Button accept = (Button) detailForm.lookup("#accept");
			accept.setVisible(true);
			
			Button refuse = (Button) detailForm.lookup("#refuse");
			refuse.setVisible(true);
			
			ShowOrderDetailController showDetailCon = showDetailLoader.getController();
			showDetailCon.setDetailForm(detailForm);
			showDetailCon.setoNum(dto.getO_num());
			
			con.setShowDetailCon(showDetailCon);
			
			Scene scene = new Scene(detailForm);
			
			Stage stage = new Stage();
			stage.setTitle("orderDetail");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
