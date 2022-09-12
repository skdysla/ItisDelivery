package member.main;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import member.join.regController;
import member.like.LikeController;
import member.login.LoginController;
import member.myPage.myPageController;
import member.order.orderDetailController;
import member.order.orderListController;
import member.review.reviewCreateController;
import member.review.reviewListController;
import member.review.reviewListService;
import member.review.updateReviewController;
import member.search.CartController;
import member.search.PayController;
import member.search.SearchController;
import member.search.SearchMDTO;
import member.search.ShopController;
import member.search.ShopListController;

public class memberController implements Initializable{
	
	private LoginController loginCon;
	private LikeController likecon;
	private CartController cartcon;
	private MainController maincon;
	private PayController ordercon;
	private SearchController searchcon;
	private ShopController shopcon;
	private ShopListController shoplistcon;
	private regController regcon;

	private reviewListController reviewCon;
	private myPageController mpCon;
	private orderListController orderCon;
	private orderDetailController orderDetailCon;
	private reviewCreateController createReviewCon;
	private updateReviewController updateRCon;
	
	private memberService Svc;
	private reviewListService reviewSvc;
	private String mId;
	private String sId;
	private String fName;
	private String fPrice;
	private String sName;
	private String sBranch;
	private TableView<SearchMDTO> cartTable;
	private Parent MemberCartForm;
	private int oNum;
	
	
	
	//controller
	public memberController() {
		Svc = new memberService();
		Svc.setCon(this);
	}


	public LoginController getLoginCon() {
		return loginCon;
	}

	public void setLoginCon(LoginController loginCon) {
		this.loginCon = loginCon;
		this.loginCon.setCon(this);
	}

	public LikeController getLikecon() {
		return likecon;
	}




	public void setLikecon(LikeController likecon) {
		this.likecon = likecon;
		this.likecon.setCon(this);
	}




	public CartController getCartcon() {
		return cartcon;
	}




	public void setCartcon(CartController cartcon) {
		this.cartcon = cartcon;
		this.cartcon.setCon(this);
	}




	public MainController getMaincon() {
		return maincon;
	}




	public void setMaincon(MainController maincon) {
		this.maincon = maincon;
		this.maincon.setCon(this);
	}




	public PayController getOrdercon() {
		return ordercon;
	}




	public void setOrdercon(PayController ordercon) {
		this.ordercon = ordercon;
		this.ordercon.setCon(this);
	}




	public SearchController getSearchcon() {
		return searchcon;
	}




	public void setSearchcon(SearchController searchcon) {
		this.searchcon = searchcon;
		this.searchcon.setCon(this);
	}




	public ShopController getShopcon() {
		return shopcon;
	}




	public void setShopcon(ShopController shopcon) {
		this.shopcon = shopcon;
		this.shopcon.setCon(this);
	}




	public ShopListController getShoplistcon() {
		return shoplistcon;
	}




	public void setShoplistcon(ShopListController shoplistcon) {
		this.shoplistcon = shoplistcon;
		this.shoplistcon.setCon(this);
	}

	public String getmId() {
		return mId;
	}


	public regController getRegcon() {
		return regcon;
	}
	
	public String getsId() {
		return sId;
	}
	
	public void setsId(String sId) {
		this.sId = sId;
	}


	public void setRegcon(regController regcon) {
		this.regcon = regcon;
		this.regcon.setCon(this);
	}

	//컬럼 데이터
	public void setmId(String mId) {
		this.mId = mId;
	}
	
	public String getfName() {
		return fName;
	}


	public void setfName(String fName) {
		this.fName = fName;
	}

	public String getsName() {
		return sName;
	}


	public void setsName(String sName) {
		this.sName = sName;
	}


	public String getsBranch() {
		return sBranch;
	}


	public void setsBranch(String sBranch) {
		this.sBranch = sBranch;
	}


	public String getfPrice() {
		return fPrice;
	}


	public void setfPrice(String fPrice) {
		this.fPrice = fPrice;
	}

	//controller
	public reviewListController getReviewCon() {
		return reviewCon;
	}


	public void setReviewCon(reviewListController reviewCon) {
		System.out.println("################" + reviewCon);
		this.reviewCon = reviewCon;
		this.reviewCon.setCon(this);
	}


	public myPageController getMpCon() {
		return mpCon;
	}


	public void setMpCon(myPageController mpCon) {
		this.mpCon = mpCon;
		this.mpCon.setCon(this);
	}


	public orderListController getOrderCon() {
		return orderCon;
	}


	public void setOrderCon(orderListController orderCon) {
		this.orderCon = orderCon;
		this.orderCon.setCon(this);
	}


	public orderDetailController getOrderDetailCon() {
		return orderDetailCon;
	}


	public void setOrderDetailCon(orderDetailController orderDetailCon) {
		this.orderDetailCon = orderDetailCon;
		this.orderDetailCon.setCon(this);
	}


	public reviewCreateController getCreateReviewCon() {
		return createReviewCon;
	}


	public void setCreateReviewCon(reviewCreateController createReviewCon) {
		this.createReviewCon = createReviewCon;
		this.createReviewCon.setCon(this);
	}


	public updateReviewController getUpdateRCon() {
		return updateRCon;
	}


	public void setUpdateRCon(updateReviewController updateRCon) {
		this.updateRCon = updateRCon;
		this.updateRCon.setCon(this);
	}

	//service
	public memberService getSvc() {
		return Svc;
	}


	public void setSvc(memberService svc) {
		Svc = svc;
	}


	public reviewListService getReviewSvc() {
		return reviewSvc;
	}


	public void setReviewSvc(reviewListService reviewSvc) {
		this.reviewSvc = reviewSvc;
	}
	
	

	//table
	public TableView<SearchMDTO> getCartTable() {
		return cartTable;
	}


	public void setCartTable(TableView<SearchMDTO> cartTable) {
		this.cartTable = cartTable;
	}
	
	
	//form
	public Parent getMemberCartForm() {
		return MemberCartForm;
	}


	public void setMemberCartForm(Parent memberCartForm) {
		MemberCartForm = memberCartForm;
	}


	public int getoNum() {
		return oNum;
	}


	public void setoNum(int oNum) {
		this.oNum = oNum;
	}


	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void openForm(String formName) {
		if (formName.equals("main")) {
			Svc.openMain();
		} else if (formName.equals("like")) {
			Svc.openLike();
		} else if (formName.equals("search")) {
			Svc.openSearch();
		} else if (formName.equals("order")) {
			Svc.openOrder();
		} else if (formName.equals("mypage")) {
			Svc.openMypage();
		} else if (formName.equals("cart")) {
			Svc.openCart();
		} else if (formName.equals("review")) {
			Svc.openReviewForm();
		} else if (formName.equals("login")) {
			Svc.openLogin();
		}
		
	}



}
