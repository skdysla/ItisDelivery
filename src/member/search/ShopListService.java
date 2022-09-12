package member.search;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import member.main.memberController;

public class ShopListService {
	//SearchDTO / SearchDAO
	private memberController con;
	private ShopListController shoplistcon;
	private SearchDAO searchDao;
	
	public ShopListService() {
		searchDao = new SearchDAO();
	}
	
	 

	public ShopListController getShoplistcon() {
		return shoplistcon;
	}



	public void setShoplistcon(ShopListController shoplistcon) {
		this.shoplistcon = shoplistcon;
		this.con = shoplistcon.getCon();
	}



	public memberController getCon() {
		return con;
	}



	public void setCon(memberController con) {
		this.con = con;
	}


	//searchform의 보기버튼
	public void goshopProc(SearchDTO searchDto) {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/member/search/MemberShopForm.fxml"));
			Parent shopform;
			try {
				shopform = loader.load();
				
				SearchMDTO searchmDto = searchDao.goshopProc(searchDto.getS_id());
				
				Label shopname = (Label) shopform.lookup("#shopname");
				shopname.setText(searchmDto.getS_name() + " - " + searchmDto.getS_branch());
				System.out.println("가게명 : " + searchmDto.getS_name());
				System.out.println("지점명 : " + searchmDto.getS_branch());
				con.setsName(searchmDto.getS_name());
				con.setsBranch(searchmDto.getS_branch());
				//찜 개수
				Label shopLikeCnt = (Label) shopform.lookup("#shopLikeCnt");
				shopLikeCnt.setText("찜 개수 " + searchmDto.getS_like_cnt());
				//주문건수
				Label shopOrderCnt = (Label)shopform.lookup("#shopOrderCnt");
				shopOrderCnt.setText("주문 건수 " + searchmDto.getS_order_cnt());
				
				//공지사항
				TextField notice = (TextField)shopform.lookup("#notice");
				notice.setDisable(true);
				notice.setText(searchmDto.getS_notice());
				
				//가게정보
				TextField shopText = (TextField)shopform.lookup("#shopText");
				shopText.setDisable(true);
				shopText.setText(searchmDto.getF_explain());
				
				Button shopReviewBtn = (Button)shopform.lookup("#shopReviewBtn");
				shopReviewBtn.setText("리뷰 수 " + searchmDto.getS_review_cnt());
				
				ShopController shopcon = loader.getController();
				shopcon.setShopform(shopform);	
				
				con.setShopcon(shopcon);
				
				Scene scene = new Scene(shopform);
				Stage stage = new Stage();
				stage.setTitle("shopform");
				stage.setScene(scene);
				stage.show();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
		
	

	
	public ObservableList<SearchDTO> show(ObservableList<SearchDTO> shoplist) {
		ArrayList<SearchDTO> list = searchDao.selectshop();
		shoplist.addAll(list);
		return shoplist;
		
	}

	public ObservableList<SearchDTO> showshow(ObservableList<SearchDTO> shopnamelist, String s_name) {
		ArrayList<SearchDTO> list = searchDao.selectshopname(s_name);
		shopnamelist.addAll(list);
		return shopnamelist;
	}

	public ObservableList<SearchDTO> showshowshow(ObservableList<SearchDTO> foodcatelist, String s_food_cate) {
		ArrayList<SearchDTO> list = searchDao.selectfoodcate(s_food_cate);
		foodcatelist.addAll(list);
		return foodcatelist;
	}



}
