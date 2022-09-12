package admin.blackList;

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
import javafx.scene.control.cell.PropertyValueFactory;
import admin.main.AdminController;

public class BlackListController implements Initializable {
	@FXML private TableView<BlackDTO> table;
	@FXML private TableColumn<BlackDTO, String> id;
	@FXML private TableColumn<BlackDTO, Number> count;
	@FXML private TableColumn<BlackDTO, String> during;
	
	ObservableList<BlackDTO> list = FXCollections.observableArrayList();

	private Parent blackListForm;
	private AdminController controller;
	private BlackDAO blackDao;
	BlackDTO blackDto = null;
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	public void setBlackListForm(Parent blackListForm) {
		this.blackListForm = blackListForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		blackDao = new BlackDAO();
		
		id.setCellValueFactory(new PropertyValueFactory<BlackDTO, String>("id"));
		count.setCellValueFactory(new PropertyValueFactory<BlackDTO, Number>("count"));
		during.setCellValueFactory(new PropertyValueFactory<BlackDTO, String>("during"));
		table.setItems(list);
		refresh();
	}
	
	public void deleteBtn() {
		blackDto = table.getSelectionModel().getSelectedItem();
		if(blackDto != null) {
			String idT = blackDto.getId();
			if (CommonService.msgBtn(idT+" 를 블랙에서 해제하시겠습니까?") == 1){
				blackDao.update(idT);
				refresh();
				CommonService.msg(idT+" 블랙 해제 완료");
			}
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
	
	public void refresh() {
		list.clear();
		ArrayList<BlackDTO> arr = new ArrayList<BlackDTO>();
		arr = blackDao.selectAll();
		list.addAll(arr);
		table.setItems(list);
	}
	
	public void homeBtn() {
		CommonService.windowClose(blackListForm);
		controller.open("home");
	}
	public void adminListBtn() {
		CommonService.windowClose(blackListForm);
		controller.open("adminList");
	}
}
