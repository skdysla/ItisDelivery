package shop.list;

import java.util.ArrayList;

import javafx.collections.ObservableList;
import shop.main.ShopMainController;

public class ShopReviewService {
	
	private ShopMainController con;
	private ShopListController ListCon;
	private ShopReviewController reviewCon;
	private ShopListDAO reviewDao;
	private ShopReviewDTO reviewDto;
	private ObservableList<ShopReviewDTO> reviewList;
	private String sId;
	
	public ShopReviewService() {
		reviewDto = new ShopReviewDTO();
	}

	public void setReviewCon(ShopReviewController reviewCon, ShopMainController con) {
		this.reviewCon = reviewCon;
		this.ListCon = reviewCon.getListCon();
		this.con = con;
		this.con = ListCon.getCon();
		this.sId = con.getsId();
	}
	public ObservableList<ShopReviewDTO> refresh(ObservableList<ShopReviewDTO> reviewList) {
		reviewDao = new ShopListDAO();
		ArrayList<ShopReviewDTO> reviewChange = new ArrayList<>();
		reviewChange = reviewDao.selectReview(sId);
		reviewList.addAll(reviewChange);
		return reviewList;
	}
}
