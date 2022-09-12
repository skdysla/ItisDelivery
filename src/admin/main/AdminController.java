package admin.main;

import admin.adminList.AdminDetailController;
import admin.adminList.AdminListController;
import admin.blackList.BlackListController;
import admin.home.HomeController;
import admin.login.AdminLoginController;
import admin.login.LoginController;
import admin.memberList.MemberListController;
import admin.review.ReviewController;
import admin.shopList.ShopListController;
import javafx.scene.Parent;

public class AdminController {
	private MainService mainService;
	
	private LoginController loginController;
	private HomeController homeController;
	private AdminLoginController adminLoginController;
	private AdminListController adminListController;
	private MemberListController memberListController;
	private BlackListController blackListController;
	private AdminDetailController adminDetailController;
	private ShopListController shopListController;
	private ReviewController reviewController;
	
	private Parent homeForm, loginForm, adminLoginForm, adminListForm, reviewForm;
	private Parent memberForm, blackListForm, adminDetailForm, shopForm;
	
	public AdminController() {
		mainService = new MainService();
		mainService.setController(this);
	}
	
//setter and getter
	public HomeController getHomeController() {
		return homeController;
	}
	
	public void setHomeController(HomeController homeController) {
		this.homeController = homeController;
		this.homeController.setController(this);
	}
	//
	public void setAdminDetailController(AdminDetailController adminDetailController) {
		this.adminDetailController = adminDetailController;
		this.adminDetailController.setController(this);
	}
	public AdminDetailController getAdminDetailController() {
		return adminDetailController;
	}
	//
	public void setLoginController(LoginController loginController) {
		this.loginController = loginController;
		this.loginController.setController(this);
	}
	public LoginController getLoginController() {
		return loginController;
	}
	//
	public void setAdminLoginController(AdminLoginController adminLoginController) {
		this.adminLoginController = adminLoginController;
		this.adminLoginController.setController(this);
	}
	public AdminLoginController getAdminLoginController() {
		return adminLoginController;
	}
	//
	public void setAdminListController(AdminListController adminListController) {
		this.adminListController = adminListController;
		this.adminListController.setController(this);
	}
	public AdminListController getAdminListController() {
		return adminListController;
	}
	//
	public void setMemberListController(MemberListController memberListController) {
		this.memberListController = memberListController;
		this.memberListController.setController(this);
	}
	public MemberListController getMemberListController() {
		return memberListController;
	}
	//
	public void setBlackListController(BlackListController blackListController) {
		this.blackListController = blackListController;
		this.blackListController.setController(this);
	}
	public BlackListController getBlackListController() {
		return blackListController;
	}
	//
	public void setShopListController(ShopListController shopListController) {
		this.shopListController = shopListController;
		this.shopListController.setController(this);
	}
	public ShopListController getShopListController() {
		return shopListController;
	}
	public void setReviewController(ReviewController reviewController) {
		this.reviewController = reviewController;
		this.reviewController.setController(this);
	}
	public ReviewController getReviewController() {
		return reviewController;
	}
//form
	public void setAdminLoginForm(Parent adminLoginForm) {
		this.adminLoginForm = adminLoginForm;
	}
	public void setHomeForm(Parent homeForm) {
		this.homeForm = homeForm;
	}
	public void setLoginForm(Parent loginForm) {
		this.loginForm = loginForm;
	}
	public void setAdminListForm(Parent adminListForm) {
		this.adminListForm = adminListForm;
	}
	public void setMemberForm(Parent memberForm) {
		this.memberForm = memberForm;
	}
	public void setBlackListForm(Parent blackListForm) {
		this.blackListForm = blackListForm;
	}
	public void setAdminDetailForm(Parent adminDetailForm) {
		this.adminDetailForm = adminDetailForm;
	}
	public void setShopForm(Parent shopForm) {
		this.shopForm = shopForm;
	}
	public void setReviewForm(Parent reviewForm) {
		this.reviewForm = reviewForm;
	}
//
	public void open(String division) {
		if("home".equals(division)) {
			mainService.homeOpen();
		}else if("adminLogin".equals(division)) {
			mainService.adminLoginOpen();
		}else if("adminList".equals(division)) {
			mainService.adminListOpen();
		}else if("memberList".equals(division)) {
			mainService.memberListOpen();
		}else if("shopList".equals(division)) {
			mainService.shopListOpen();
		}else if("blackList".equals(division)) {
			mainService.blackListOpen();
		}else if("adminDetail".equals(division)) {
			mainService.adminDetailOpen();
		}else if("login".equals(division)) {
			mainService.loginOpen();
		}else if("review".equals(division)) {
			mainService.reviewOpen();
		}
	}
}
