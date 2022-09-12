package admin.memberList;

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

public class MemberListController implements Initializable {
	@FXML private TableView<MemberDTO> table;
	@FXML private TableColumn<MemberDTO, String> id;
	@FXML private TableColumn<MemberDTO, String> name;
	@FXML private TableColumn<MemberDTO, String> tel;
	@FXML private TableColumn<MemberDTO, String> time;
	@FXML private TableColumn<MemberDTO, String> rest;
	
	@FXML private TextField serch;
	MemberDTO memberDto = null;
	
	ObservableList<MemberDTO> list = FXCollections.observableArrayList();
	
	private MemberDAO memberDao;
	private Parent memberForm;
	private AdminController controller;
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	public void setMemberForm(Parent memberForm) {
		this.memberForm = memberForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		memberDao = new MemberDAO();
		
		id.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("id"));
		name.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("name"));
		tel.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("tel"));
		time.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("time"));
		rest.setCellValueFactory(new PropertyValueFactory<MemberDTO,String>("rest"));
		table.setItems(list);
		refresh();
	}
	
	public void refresh() {
		list.clear();
		ArrayList<MemberDTO> arr = new ArrayList<MemberDTO>();
		arr = memberDao.selectAll();
		list.addAll(arr);
		table.setItems(list);
	}
	
	public void serchBtn() {
		String serchT = serch.getText();
		memberDto = new MemberDTO();
		memberDto = memberDao.selectOne(serchT);
		if (serchT.equals("")) {
			refresh();
		} else if(memberDto.getTel() == null) {
			CommonService.msg("찾는 아이디가 없습니다.");
			refresh();
			serch.clear();
		}else {
			list.clear();
			list.add(memberDto);
			table.setItems(list);
			serch.clear();
		}
	}
	
	public void reviewBtn() {
		memberDto = table.getSelectionModel().getSelectedItem();
		if(memberDto != null) {
			String idT = memberDto.getId();
			String restT = memberDto.getRest();
			memberDao.sendData(idT,restT);
			CommonService.windowClose(memberForm);
			controller.open("review");
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
	public void deleteBtn() {
		memberDto = table.getSelectionModel().getSelectedItem();
		if(memberDto != null) {
			String idT = memberDto.getId();
			if (CommonService.msgBtn(idT+" 를 삭제하시겠습니까?") == 1){
				memberDao.delete(idT);
				refresh();
				CommonService.msg(idT+" 삭제완료");
			}
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
	
	public void restBtn() {
		memberDto = table.getSelectionModel().getSelectedItem();
		if(memberDto != null) {
			String idT = memberDto.getId();
			String restT = memberDto.getRest();
			if(restT.equals("false")) {
				restT = "true";
			}else {
				restT = "false";
			}
			if (CommonService.msgBtn(idT+" 의 휴면상태를 변경하시겠습니까?") == 1){
				memberDao.rest(idT,restT);
				CommonService.msg(idT+" 정보 변경완료");
				refresh();
			}
		}else {
			CommonService.msg("목록을 선택해 주세요");
		}
	}
	public void homeBtn() {
		CommonService.windowClose(memberForm);
		controller.open("home");
	}
	public void blackListBtn() {
		CommonService.windowClose(memberForm);
		controller.open("blackList");
	}
	public void adminListBtn() {
		CommonService.windowClose(memberForm);
		controller.open("adminList");
	}
}
