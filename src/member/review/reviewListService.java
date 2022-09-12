package member.review;

import java.io.IOException;
import java.util.ArrayList;

import common.CommonService;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import member.main.memberController;
import member.order.orderDAO;
import member.order.orderDTO;
import member.order.orderDetailDTO;

public class reviewListService {
	private memberController con;
	private reviewListController reviewCon;
	private updateReviewController updateReviewCon;
	private reviewCreateController createReviewCon;
	private reviewDAO dao;
	
	public reviewListService(memberController con) {
		dao = new reviewDAO();
	}
	
	public void setReviewCon(reviewListController reviewCon) {
		this.reviewCon = reviewCon;
		this.con = reviewCon.getCon();
	}
	
	public void setUpdateReviewCon(updateReviewController updateReviewCon) {
		this.updateReviewCon = updateReviewCon;
		this.con = reviewCon.getCon();
	}
	
	
	public ArrayList<reviewDTO> show(){
//		System.out.println("reviewService2 : " + con);
//		System.out.println("reviewService id : " + con.getmId());
		return dao.memberReview(con.getmId());
	}
	
	public void openReviewUpdateForm(reviewDTO dto) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/review/updateReviewForm.fxml"));
		Parent updateReviewForm;
		orderDAO orderDao = new orderDAO();
		orderDetailDTO detail = orderDao.showDetail(dto.getO_num());
			
		try {
			updateReviewForm = loader.load();
			Scene scene = new Scene(updateReviewForm);
			
			Label sname = ((Label) updateReviewForm.lookup("#sname"));
			sname.setText(detail.getS_name());
			Label sbranch = ((Label) updateReviewForm.lookup("#sbranch"));
			sbranch.setText(detail.getS_branch());
			
			dto = dao.showDetail(detail.getO_num());
			
			TextArea rText = ((TextArea) updateReviewForm.lookup("#rText"));
			if(dto.getR_text() != null) {
				rText.setText(dto.getR_text());
			}else{
				rText.setText("비어있음");
			}
			
			int a = dto.getR_score();
			
			RadioButton one = ((RadioButton) updateReviewForm.lookup("#like1"));
			RadioButton two = ((RadioButton) updateReviewForm.lookup("#like2"));
			RadioButton three = ((RadioButton) updateReviewForm.lookup("#like3"));
			RadioButton four = ((RadioButton) updateReviewForm.lookup("#like4"));
			RadioButton five = ((RadioButton) updateReviewForm.lookup("#like5"));
			if(a == 1) {
				one.getText();
				one.setSelected(true);
			}else if(a == 2) {
				two.getText();
				two.setSelected(true);
			}else if(a == 3) {
				three.getText();
				three.setSelected(true);
			}else if(a == 4) {
				four.getText();
				four.setSelected(true);
			}else if(a == 5) {
				five.getText();
				five.setSelected(true);
			}
			
			
			updateReviewController reviewCon = loader.getController();
			reviewCon.setUpdateReviewForm(updateReviewForm);
//			reviewCon.setCon(con);
			
			con.setUpdateRCon(reviewCon);
			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("리뷰 수정하기");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void openReviewCreateForm(orderDTO dto) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/review/reviewCreateForm.fxml"));
		Parent reviewCreateForm;
		orderDAO orderDao = new orderDAO();
		
		// 리뷰 작성 폼을 열면 r_num에 o_num 넣어주기
		try {
			reviewCreateForm = loader.load();
			Scene scene = new Scene(reviewCreateForm);
			
			orderDetailDTO detail = orderDao.showDetail(dto.getO_num());
			
			Label sname = ((Label) reviewCreateForm.lookup("#sname"));
			sname.setText(detail.getS_name());
			Label sbranch = ((Label) reviewCreateForm.lookup("#sbranch"));
			sbranch.setText(detail.getS_branch());
			
			reviewCreateController reviewcreateCon = loader.getController();
			reviewcreateCon.setReviewCreateForm(reviewCreateForm);

			Stage stage = new Stage();
			stage.setScene(scene);
			stage.setTitle("리뷰 작성하기");
			stage.show();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void createReviewProc(Parent reviewCreateForm) {
		RadioButton like_one = (RadioButton)reviewCreateForm.lookup("#like1");
		RadioButton like_two = (RadioButton)reviewCreateForm.lookup("#like2");
		RadioButton like_three = (RadioButton)reviewCreateForm.lookup("#like3");
		RadioButton like_four = (RadioButton)reviewCreateForm.lookup("#like4");
		RadioButton like_five = (RadioButton)reviewCreateForm.lookup("#like5");
		TextArea review_text = (TextArea)reviewCreateForm.lookup("#rText");
		
//		String one = like_one.getText();
//		String two = like_two.getText();
//		String three = like_three.getText();
//		String four = like_four.getText();
//		String five = like_five.getText();
		String rtext = review_text.getText();
		
		int grade = 0;
		if(like_one.isSelected())
			grade += 1;
		else if(like_two.isSelected())
			grade += 2;
		else if(like_three.isSelected())
			grade += 3;
		else if(like_four.isSelected())
			grade += 4;
		else if(like_five.isSelected())
			grade += 5;
		
//		reviewDTO reviewDto = new reviewDTO();
//		reviewDto.setR_text(rtext);
		
		if(grade == 0 && rtext.isEmpty() || grade == 0) {
			CommonService.alert("필수 정보입니다.");
			return;
		}
		
		if(grade > 0 && !rtext.isEmpty() || grade > 0) {
			reviewDAO dao = new reviewDAO();
			reviewDTO dto = new reviewDTO();
			orderDTO orderDto = new orderDTO();
			dto.setR_score(grade);
			dto.setR_text(rtext);
			//dao.review(dto, rtext, grade);
				CommonService.alert("리뷰 작성 완료!");
			}
	}
	
//	public int updateReviewProc(Parent updateReviewForm) {
//		System.out.println("MNMNMNMNMNMNMNMNM" + updateReviewForm);
//		int rs = -1;
//		
//		RadioButton one = (RadioButton)updateReviewForm.lookup("#like1");
//		RadioButton two = (RadioButton)updateReviewForm.lookup("#like2");
//		RadioButton three = (RadioButton)updateReviewForm.lookup("#like3");
//		RadioButton four = (RadioButton)updateReviewForm.lookup("#like4");
//		RadioButton five = (RadioButton)updateReviewForm.lookup("#like5");
////		TextField rtext = (TextField)updateReviewForm.lookup("#rText");
//		
//		TextArea rText = ((TextArea) updateReviewForm.lookup("#rText"));
//		
//		if(!one.getText().isEmpty() && !two.getText().isEmpty() && !three.getText().isEmpty() && !four.getText().isEmpty()
//				&& five.getText().isEmpty() && rText.getText().isEmpty()) {
//			String rtext = rText.getText();			
//			Integer rone = Integer.parseInt(one.getText());
//			Integer rtwo = Integer.parseInt(two.getText());
//			Integer rthree = Integer.parseInt(three.getText());
//			Integer rfour = Integer.parseInt(four.getText());
//			Integer rfive = Integer.parseInt(five.getText());
//			
//			reviewDTO dto = new reviewDTO();
//			
//			int a = dto.getR_score();
//			
//			if(one.isSelected() || two.isSelected() || three.isSelected() || four.isSelected() || five.isSelected()) {
//				
//				dto.setR_text(rtext);
//				switch(a) {
//				case 1: dto.setR_score(rone); break;
//				case 2: dto.setR_score(rtwo); break;
//				case 3: dto.setR_score(rthree); break;
//				case 4: dto.setR_score(rfour); break;
//				case 5: dto.setR_score(rfive); break;
//				default: break;
//				}
//				rs = dao.reviewUpdate(dto);
//				if(rs == 1)
//					CommonService.alert("리뷰 수정 완료!");
//				else
//					CommonService.alert("리뷰 수정 실패!");
//			}else {
//				CommonService.alert("모든 정보를 입력해주세요.");
//			}
//		}
//		return rs;
//	}
	
//	public void modifyReview() {
//		FXMLLoader updateLoader = new FXMLLoader(getClass().getResource("/review/updateReviewForm.fxml"));
//		Parent updateReviewForm;
//		
////		memberDTO dto = dao.selectId(con.getmId());
//		
//		try {
//			updateReviewForm = updateLoader.load();
//			
//			RadioButton rScore = ((RadioButton) updateReviewForm.lookup("#"))
//			
//			TextField mId = ((TextField) updateReviewForm.lookup("#id"));
//			mId.setText(dto.getmId());
//			
//			TextField mName = ((TextField) updateReviewForm.lookup("#name"));
//			mName.setText(dto.getmName());
//			
//			updateMyInfoController updateMyCon = updateLoader.getController();
//			updateMyCon.setUpdateMyInfoForm(updateMyInfoForm);
//			
//			mpCon.setUpdateMICon(updateMyCon);
//			
//			Scene scene = new Scene(updateMyInfoForm);
//			
//			Stage stage = new Stage();
//			stage.setTitle("updateOwnerInfo");
//			stage.setScene(scene);
//			stage.show();
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}
	
	
	public void deleteReviewProc() {
//		reviewDTO dto = dao
//		dao.reviewDelete(dto.getR_num());
	}
	
	
}
