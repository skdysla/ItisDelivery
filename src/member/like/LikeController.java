package member.like;

import java.net.URL;
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
import member.main.memberController;
import member.search.SearchDTO;

public class LikeController implements Initializable{
	
	@FXML private TableView<SearchDTO> likeTable;
	@FXML private TableColumn<SearchDTO, String> s_logo;
	@FXML private TableColumn<SearchDTO, String> s_name;
	@FXML private TableColumn<SearchDTO, Integer> s_total;
	@FXML private TableColumn<SearchDTO, Integer> s_order_cnt;
	
	private memberController con;
	private LikeService likeSvc;
	private Parent likeForm;
	
	private ObservableList<SearchDTO> likelist;
    
	public memberController getCon() {
		return con;
	}
	public Parent getLikeForm() {
		return likeForm;
	}
	public void setLikeForm(Parent likeForm) {
		this.likeForm = likeForm;
	}
	
	
	public void setCon(memberController con) {
		this.con = con;
		this.likeSvc.setLikecon(this);
		show();
	}
	@Override
	public void initialize(URL location, ResourceBundle resources) {
    	likeSvc = new LikeService();
    	likelist = FXCollections.observableArrayList();
	}
	public void show() {
    	likelist = likeSvc.show(likelist);
    	
    	if(likelist != null) {
			for(int i = 0; i < likelist.size(); i++) {
			s_logo.setCellValueFactory(new PropertyValueFactory<SearchDTO,String>("s_logo"));
			s_name.setCellValueFactory(new PropertyValueFactory<SearchDTO,String>("s_name"));
			s_total.setCellValueFactory(new PropertyValueFactory<SearchDTO,Integer>("s_total"));
			s_order_cnt.setCellValueFactory(new PropertyValueFactory<SearchDTO,Integer>("s_order_cnt"));
			likeTable.setItems(likelist);
			}
		}
    	
    }
    public void dellikebtnProc() {
    	//찜 버튼 삭제
    	SearchDTO searchDto = likeTable.getSelectionModel().getSelectedItem();
		likeTable.getItems().clear();
    	
    }

	
	
	
	//하단
	public void clickHomeBtn() {
		CommonService.closeForm(likeForm);
		con.openForm("main");
	}
	public void clickLikeBtn() {
		CommonService.closeForm(likeForm);
		con.openForm("like");
	}
	public void clickSearchBtn() {
		CommonService.closeForm(likeForm);
		con.openForm("search");
	}
	public void clickOrderListBtn() {
		CommonService.closeForm(likeForm);
		con.openForm("order");
	}
	public void clickMyInfoBtn() {
		CommonService.closeForm(likeForm);
		con.openForm("mypage");
	}
	public void mainCartBtnProc() {
		CommonService.closeForm(likeForm);
		con.openForm("cart");
	}

	

}
