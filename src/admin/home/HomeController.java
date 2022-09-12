package admin.home;

import java.net.URL;
import java.util.ResourceBundle;

import admin.common.CommonService;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import admin.main.AdminController;

public class HomeController implements Initializable {
	private Parent homeForm;
	private AdminController controller;
	private HomeDAO homeDao;
	
	@FXML private PieChart pieChart;
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	public void setHomeForm(Parent homeForm) {
		this.homeForm = homeForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		homeDao = new HomeDAO();
		
		
		pieChart.setData(FXCollections.observableArrayList(
				new PieChart.Data("회원 : "+homeDao.mCount()+"명", homeDao.mCount()),
				new PieChart.Data("가게 : "+homeDao.sCount()+"개", homeDao.sCount())
				));
	}
	
	public void logoutBtn() {
		if(CommonService.msgBtn("로그아웃 하시겠습니까?") == 1) {
			CommonService.windowClose(homeForm);
			controller.open("adminLogin");
		}
	}
	public void shopListBtn() {
		CommonService.windowClose(homeForm);
		controller.open("shopList");
	}
	public void adminListBtn() {
		CommonService.windowClose(homeForm);
		controller.open("adminList");
	}
	public void memberListBtn() {
		CommonService.windowClose(homeForm);
		controller.open("memberList");
	}
	public void blackListBtn() {
		CommonService.windowClose(homeForm);
		controller.open("blackList");
	}
}
