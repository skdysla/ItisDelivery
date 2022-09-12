package admin.shopList;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import admin.common.CommonService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import admin.main.AdminController;

public class ShopListController implements Initializable{
	@FXML private TableView<ShopDTO> table;
	@FXML private TableColumn<ShopDTO, String> id;
	@FXML private TableColumn<ShopDTO, String> name;
	@FXML private TableColumn<ShopDTO, String> loc;
	@FXML private TableColumn<ShopDTO, String> tel;
	@FXML private TableColumn<ShopDTO, String> time;
	@FXML private TableColumn<ShopDTO, String> rest;
	
	@FXML private TextField serch;
	ShopDTO shopDto = null;
	
	ObservableList<ShopDTO> list = FXCollections.observableArrayList();
	
	private ShopDAO shopDao;
	private Parent shopForm;
	private AdminController controller;
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	public void setShopForm(Parent shopForm) {
		this.shopForm = shopForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		shopDao = new ShopDAO();
		
		id.setCellValueFactory(new PropertyValueFactory<ShopDTO,String>("id"));
		name.setCellValueFactory(new PropertyValueFactory<ShopDTO,String>("name"));
		loc.setCellValueFactory(new PropertyValueFactory<ShopDTO,String>("loc"));
		tel.setCellValueFactory(new PropertyValueFactory<ShopDTO,String>("tel"));
		time.setCellValueFactory(new PropertyValueFactory<ShopDTO,String>("time"));
		rest.setCellValueFactory(new PropertyValueFactory<ShopDTO,String>("rest"));
		table.setItems(list);
		refresh();
	}
	
	public void refresh() {
		list.clear();
		ArrayList<ShopDTO> arr = new ArrayList<ShopDTO>();
		arr = shopDao.selectAll();
		list.addAll(arr);
		table.setItems(list);
	}
	
	public void serchBtn() {
		String serchT = serch.getText();
		shopDto = new ShopDTO();
		shopDto = shopDao.selectOne(serchT);
		if (serchT.equals("")) {
			refresh();
		} else if(shopDto.getTel() == null) {
			CommonService.msg("찾는 아이디가 없습니다.");
			refresh();
			serch.clear();
		}else {
			list.clear();
			list.add(shopDto);
			table.setItems(list);
			serch.clear();
		}
	}
	
	public void deleteBtn() {
		shopDto = table.getSelectionModel().getSelectedItem();
		if(shopDto != null) {
			String idT = shopDto.getId();
			if (CommonService.msgBtn(idT+" 를 삭제하시겠습니까?") == 1){
				shopDao.delete(idT);
				CommonService.msg(idT+" 삭제완료");
				refresh();
			}
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
	public void restBtn() {
		shopDto = table.getSelectionModel().getSelectedItem();
		if(shopDto != null) {
			String idT = shopDto.getId();
			String restT = shopDto.getRest();
			if(restT.equals("false")) {
				restT = "true";
			}else {
				restT = "false";
			}
			if (CommonService.msgBtn(idT+" 의 휴면상태를 변경하시겠습니까?") == 1){
				shopDao.rest(idT,restT);
				CommonService.msg(idT+" 정보 변경완료");
				refresh();
			}
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
	public void homeBtn() {
		CommonService.windowClose(shopForm);
		controller.open("home");
	}
	public void blackListBtn() {
		CommonService.windowClose(shopForm);
		controller.open("blackList");
	}
	public void adminListBtn() {
		CommonService.windowClose(shopForm);
		controller.open("adminList");
	}
	
}
