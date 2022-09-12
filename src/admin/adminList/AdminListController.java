package admin.adminList;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import admin.main.AdminController;
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

public class AdminListController implements Initializable {
	@FXML private TableView<AdminDTO> table;
	@FXML private TableColumn<AdminDTO, String> name;
	@FXML private TableColumn<AdminDTO, String> tel;
	@FXML private TableColumn<AdminDTO, String> position;
	
	@FXML private TextField nameText;
	@FXML private TextField telText;
	@FXML private TextField positionText;
	
	AdminDTO adminDto = null;
	
	ObservableList<AdminDTO> list = FXCollections.observableArrayList();
	
	private AdminDAO adminDao;
	private Parent adminListForm;
	private AdminController controller;
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	
	public void setAdminListForm(Parent adminListForm) {
		this.adminListForm = adminListForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		adminDao = new AdminDAO();
		
		name.setCellValueFactory(new PropertyValueFactory<AdminDTO,String>("name"));
		tel.setCellValueFactory(new PropertyValueFactory<AdminDTO,String>("tel"));
		position.setCellValueFactory(new PropertyValueFactory<AdminDTO,String>("position"));
		table.setItems(list);
		refresh();
	}
	
	public void addBtn() {
		String telT = telText.getText();
		String nameT = nameText.getText();
		String positionT = positionText.getText();
		if(telT.isEmpty() && nameT.isEmpty() && positionT.isEmpty()) {
			CommonService.msg("텍스트가 비어있습니다.");
		}else {
			adminDto = adminDao.selectOne(telT);
			if(adminDto.getTel()== null) {
				adminDao.insert(telT,nameT,positionT);
				CommonService.msg(nameT+" 추가완료");
				nameText.clear(); telText.clear(); positionText.clear();
				refresh();
			}else {
				CommonService.msg("이미 있는 전화번호 입니다.");
			}
		}
	}
	
	public void refresh() {
		list.clear();
		ArrayList<AdminDTO> arr = new ArrayList<AdminDTO>();
		arr = adminDao.selectAll();
		list.addAll(arr);
		table.setItems(list);
	}
	
	public void deleteBtn() {
		adminDto = table.getSelectionModel().getSelectedItem();
		if(adminDto != null) {
			String telT = adminDto.getTel();
			String nameT = adminDto.getName();
			if (CommonService.msgBtn(nameT+" 을/를 삭제하시겠습니까?") == 1){
				adminDao.delete(telT);
				CommonService.msg(nameT+" 삭제완료");
				refresh();
			}
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
	
	public void homeBtn() {
		CommonService.windowClose(adminListForm);
		controller.open("home");
	}
	public void blackListBtn() {
		CommonService.windowClose(adminListForm);
		controller.open("blackList");
	}
	public void detail() {
		adminDto = table.getSelectionModel().getSelectedItem();
		if(adminDto != null) {
			String telT = adminDto.getTel();
			adminDao.sendData(telT);
			CommonService.windowClose(adminListForm);
			controller.open("adminDetail");
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
}
