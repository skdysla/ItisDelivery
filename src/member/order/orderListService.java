package member.order;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import member.main.memberController;

public class orderListService {
	private memberController con;
	private orderListController orderCon;
	private orderDAO orderDao;
	private orderDetailController orderDetailCon;
	
	public orderListService(memberController con) {
		this.con = con;
//		System.out.println("orderService : " + con);
		orderDao = new orderDAO();
//		this.con = orderCon.getCon();
	}
	public void setOrderCon(orderListController orderCon) {
		this.orderCon = orderCon;
		
	}
	public void setOrderDetailCon(orderDetailController orderDetailCon) {
		this.orderDetailCon = orderDetailCon;
	}
	
	
	public ObservableList<orderDTO> show(ObservableList<orderDTO> orderList){
		ArrayList<orderDTO> list = orderDao.selectAll(con.getmId());
		orderList.addAll(list);
		return orderList;
	}
	
	
	public ObservableList<orderDetailDTO> showDetail(ObservableList<orderDetailDTO> list) {
		orderDetailDTO dto = orderDao.showDetail(orderDetailCon.getOnum());
		
		int total = 0;
		String[] menu = dto.getO_menu().split(", ");
		String[] cnt = dto.getO_cnt().split(", ");
		String[] price = dto.getO_price().split(", ");
		
		int length = menu.length;
		
		for(int i = 0; i < length; i++) {
			list.add(new orderDetailDTO(menu[i], cnt[i], price[i]));
			total += Integer.parseInt(price[i]) * Integer.parseInt(cnt[i]);
		}
		
		orderDetailCon.setTotal(total);
		return list;
	}

	public void openOrderListForm() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/order/orderListForm.fxml"));
		
		Parent orderListForm;
		
		try {
			orderListForm = loader.load();
			Scene scene = new Scene(orderListForm);
			
			orderListController orderCon = loader.getController();
			orderCon.setOrderListForm(orderListForm);
			orderCon.setCon(con);
			
			Stage stage = new Stage();
			stage.setTitle("주문 내역");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void openOrderListDetailForm() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/order/orderDetail.fxml"));
		Parent orderDetailForm;
		try {
			orderDetailForm = loader.load();
			orderListController orderCon = loader.getController();
			orderCon.setOrderDetailForm(orderDetailForm);
			orderCon.setCon(con);
//			con.setOrderCon(orderCon);
			
			Scene scene = new Scene(orderDetailForm);
			Stage stage = new Stage();
			stage.setTitle("주문 상세 보기");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public void showOrderDetail(orderDTO dto) {
		FXMLLoader showDetailLoader = new FXMLLoader(getClass().getResource("/member/order/orderDetailForm.fxml"));
		Parent orderDetailForm;
		
		try {
//			System.out.println("showOrderDetail : " + con);
			orderDetailForm = showDetailLoader.load();
			
			orderDetailDTO detail = orderDao.showDetail(dto.getO_num());
//			reviewDAO rDao = new reviewDAO();
//			String rtext = rDao.memberReview(con.getmId());
//			reviewDTO reviewDto = rDao.review(detail,r_text, r_score);
			
			Label sname = (Label) orderDetailForm.lookup("#s_name");
			sname.setText(detail.getS_name());
			
			Label sbranch = (Label) orderDetailForm.lookup("#s_branch");
			sbranch.setText(detail.getS_branch());
			
			Label otime = (Label) orderDetailForm.lookup("#o_time");
			otime.setText(detail.getO_time().substring(0, detail.getO_time().length()));
			
			Label onum = (Label) orderDetailForm.lookup("#o_num");
			onum.setText(""+detail.getO_num());
			
			//할인률
//			Label sSaleRate = (Label) orderDetailForm.lookup("#s_sale_rate");
//			sSaleRate.setText(detail.getS_sale_rate());
			
			Label omethod = (Label) orderDetailForm.lookup("#o_method");
			omethod.setText(detail.getO_method());
			
//			Label review = (Label) orderDetailForm.lookup("#review_cr_ch");
//			review.setText("리뷰쓰기");
			
//			if(reviewDto.getR_score() != null && reviewDto.getR_text() != null || reviewDto.getR_score() != null && reviewDto.getR_text() == null) {
//				Label review = (Label) orderDetailForm.lookup("#review_cr_ch");
//				review.setText("리뷰 수정");
//			}else if(reviewDto.getR_score() == null || reviewDto.getR_score() == null && reviewDto.getR_text() == null) {
//				Label review = (Label) orderDetailForm.lookup("#review_cr_ch");
//				review.setText("리뷰쓰기");
//			} // 이러고 clickReviewBtn() 눌렀을 시 페이지 이동 조건 걸어줌 
			
			
//			Button accept = (Button) orderDetailForm.lookup("#accept");
//			accept.setVisible(false);
//			
//			Button refuse = (Button) detailForm.lookup("#refuse");
//			refuse.setVisible(false);
			
			orderDetailController detailCon = showDetailLoader.getController();
			detailCon.setOrderDetailForm(orderDetailForm);
			detailCon.setOnum(dto.getO_num());
			
			con.setOrderDetailCon(detailCon);
			
			Scene scene = new Scene(orderDetailForm);
			
			Stage stage = new Stage();
			stage.setTitle("orderDetail");
			stage.setScene(scene);
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
