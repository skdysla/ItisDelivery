package shop.menu;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.stage.FileChooser.ExtensionFilter;
import shop.main.ShopMainController;

public class ShopMenuAddController implements Initializable {

	private ShopMainController con;
	private ShopMenuController menuCon;
	private Parent menuAddForm;
	private ShopMenuAddService addService;
	private MenuDTO menuDto;
	
	@FXML
	private TextField f_name; // 무조건
	@FXML
	private TextField f_price;// 무조건
	@FXML
	private TextField f_exp_time;// 무조건 + 가게아이디도 무조건 db에 저장해야함
	@FXML
	private TextArea f_explain;
	@FXML
	private ImageView f_photo;
	
	private String sId;
	private Stage primaryStage;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	String data = null;
	//파일경로지정
	public void openFilePath() {
		FileChooser fileChooser = new FileChooser();
		fileChooser.getExtensionFilters().addAll(new ExtensionFilter("그림파일 : Image Files", "*.png", "*.jpg", "*.gif"));
		File file = fileChooser.showOpenDialog(primaryStage);
		
		//취소시  else
		if (file != null) {
			data = file.getPath();
			data = data.substring(data.indexOf("javae"));
			data = "/" + data.replaceAll("\\\\", "/");
			f_photo.setImage(new Image("file:" + data));
		}else {
			CommonService.alert("이미지를 넣어주세요.");
		}
	}
	
	// 메뉴추가 버튼
	public void addSingleMenu() {
		String price = f_price.getText();
		String time = f_exp_time.getText();
		
		menuDto.setF_name(f_name.getText());
		menuDto.setF_price(Integer.parseInt(price));
		menuDto.setF_exp_time(Integer.parseInt(time));
		menuDto.setF_explain(f_explain.getText());
		if(data == null){
			//menuDto.setF_photo("file:javae/workspace/itsDelivery/src/img/logo.png");
		} else menuDto.setF_photo("file:" + data);
		menuDto.setS_id(con.getsId());
		//menuDto.setS_id(sId);
		if (fieldCheck()) {
			if(addService.addSingleMenu(menuDto)) {
				f_name.requestFocus();//메뉴이름 중복시 커서이동
			};
		}
	}
	private boolean fieldCheck() {
		if (f_name.getText().isEmpty()) {
			CommonService.alert("메뉴이름을 등록해주세요.");
			f_name.requestFocus();
			return false;
		} else if (f_price.getText().isEmpty()) {
			CommonService.alert("메뉴가격을 등록해주세요.");
			f_price.requestFocus();
			return false;
		} else if (f_exp_time.getText().isEmpty()) {
			CommonService.alert("조리시간을 등록해주세요.");
			f_exp_time.requestFocus();
			return false;
		} else
			return true;
	}
	
	// 메뉴추가페이지 취소버튼 클릭시 메뉴관리페이지로 되돌아가기
	public void cancelAdd() {
		CommonService.closeForm(menuAddForm);
		con.openForm("menu");
	}

	public void setAddForm(Parent menuAddForm) {
		this.menuAddForm = menuAddForm;
	}

	public void setMenuCon(ShopMenuController menuCon) {
		this.menuCon = menuCon;
		this.con = menuCon.getCon();
		addService = new ShopMenuAddService();
		menuDto = new MenuDTO();
		addService.setMenuAddCon(this);
		addService.setMenuAddForm(menuAddForm);
	}

	public ShopMenuController getMenuCon() {
		return menuCon;
	}

}
