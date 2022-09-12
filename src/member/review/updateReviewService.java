package member.review;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextInputControl;
import member.main.memberController;

public class updateReviewService {
	
	private reviewDAO dao;
	private memberController con;
	private reviewListController reviewCon;
	private updateReviewController updateCon;
	private reviewDTO dto;
	
	public void setUpdateCon(updateReviewController updateCon) {
		this.updateCon = updateCon;
		this.con = updateCon.getCon();
		this.reviewCon = updateCon.getReviewCon();
		System.out.println("wregrlgjerlgkjre"+con);
	}
	
	public void setReviewCon(reviewListController reviewCon) {
		this.reviewCon = reviewCon;
	}
	
	
	public int updateReview(Parent updateReviewForm) {
		
		int rs = -1;
		
		RadioButton one = ((RadioButton) updateReviewForm.lookup("#like1"));
		RadioButton two = ((RadioButton) updateReviewForm.lookup("#like2"));
		RadioButton three = ((RadioButton) updateReviewForm.lookup("#like3"));
		RadioButton four = ((RadioButton) updateReviewForm.lookup("#like4"));
		RadioButton five = ((RadioButton) updateReviewForm.lookup("#like5"));
		TextInputControl rtext = ((TextInputControl) updateReviewForm.lookup("#rText"));
		
//		if (!one.getText().isEmpty() || !two.getText().isEmpty() || !three.getText().isEmpty()
//				|| !four.getText().isEmpty() || !five.getText().isEmpty() && !rtext.getText().isEmpty()) {
//			Integer rone = Integer.parseInt(one.getText());
//			Integer rtwo = Integer.parseInt(two.getText());
//			Integer rthree = Integer.parseInt(three.getText());
//			Integer rfour = Integer.parseInt(four.getText());
//			Integer rfive = Integer.parseInt(five.getText());
			
			
			String rText = ((TextInputControl) updateReviewForm.lookup("#rText")).getText();
			
			String selected = null;
			if(one.isSelected() || two.isSelected() || three.isSelected() || four.isSelected() || five.isSelected()) {
				if(one.isSelected()) {
					selected = one.getText();
				}else if(two.isSelected()) {
					selected = two.getText();
				}else if(three.isSelected()) {
					selected = three.getText();
				}else if(four.isSelected()) {
					selected = four.getText();
				}else if(five.isSelected()) {
					selected = five.getText();
				}
				System.out.println("별점 : " + selected);
				System.out.println(con);
			}
			Integer select = Integer.parseInt(selected);
			System.out.println("nbnbnbnbnbnbn" + con.getoNum());
			
			dto = new reviewDTO(select, rText, con.getoNum());
			rs = dao.reviewUpdate(dto);
			if (rs == 1)
				CommonService.alert("회원 정보 수정 성공!");
			else
				CommonService.alert("회원 정보 수정 실패");
	return rs;
	}
}
