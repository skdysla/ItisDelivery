package shop.list;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import shop.main.ShopMainController;

public class ShopBlackListController implements Initializable{
	
	private ShopMainController con;
	private ShopListController listCon;
	private ShopBlackListService blackListSvc;
	private Parent blackListForm;
	
	private ShopBlackListDTO blackDto;
	
	
	@FXML private TableView<ShopBlackListDTO> blackTable;
	@FXML private TableColumn<ShopBlackListDTO, String> blackMember;
	@FXML private TableColumn<ShopBlackListDTO, Number> blackMemberCnt;
	
	ObservableList<ShopBlackListDTO> blackList = FXCollections.observableArrayList();
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void show(){
		blackDto = new ShopBlackListDTO();
		
		blackMember.setCellValueFactory(new PropertyValueFactory<ShopBlackListDTO, String>("blackMember"));
		blackMemberCnt.setCellValueFactory(new PropertyValueFactory<ShopBlackListDTO, Number>("blackMemberCnt"));
		
		blackTable.setItems(blackList);
		blackList.clear();//재업데이트 작업
		blackTable.setItems(blackListSvc.refresh());
	}
	public ShopMainController getCon() {
		return con;
	}
	public ShopListController getListCon() {
		return listCon;
	}
	public void setListCon(ShopListController listCon) {
		this.listCon = listCon;
		this.con = listCon.getCon();
		blackListSvc = new ShopBlackListService(blackList);
		blackListSvc.setBlackListCon(this);
		show();
	}
	public void setBlackListForm(Parent blackListForm) {
		this.blackListForm = blackListForm;
	}
	
	public void blackListBackBtn() {
		CommonService.closeForm(blackListForm);
		con.openForm("list");
	}
	//화면 하단아이콘 버튼
	public void clickHomeBtn() {
		CommonService.closeForm(blackListForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(blackListForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(blackListForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(blackListForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(blackListForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(blackListForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(blackListForm);
		con.openForm("acceptedOrders");
	}

	
}
