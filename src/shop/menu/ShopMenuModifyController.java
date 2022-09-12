package shop.menu;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import shop.main.ShopMainController;

public class ShopMenuModifyController implements Initializable{
	private ShopMainController con;
	private ShopMenuController menuCon;
	private ShopMenuController modifyCon;
	private ShopMenuModifyService modifySvc;
	private Parent modifyMenuForm;
	private MenuDTO menuDto;
	private MenuDTO menuDto_before;
	
	@FXML
	private TextField f_name; // 무조건
	@FXML
	private TextField f_price;// 무조건
	@FXML
	private TextField f_exp_time;// 무조건
	@FXML
	private TextArea f_explain;
	@FXML
	private ImageView f_photo;
	
	public void setModifyForm(Parent modifyMenuForm) {
		this.modifyMenuForm = modifyMenuForm;
	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	public void setMenuCon(ShopMenuController menuCon) {
		this.menuCon = menuCon;
		this.con = menuCon.getCon();
		modifySvc = new ShopMenuModifyService();
		modifySvc.setMenuModifyForm(modifyMenuForm);
		modifySvc.setMenuModifyCon(this);
		menuDto = new MenuDTO();
		
	}
	private Stage primaryStage;
	//파일경로지정
	String data = null;
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
		
	// 메뉴수정 버튼
	public void modifySingleMenu() {
		String price = f_price.getText();
		String time = f_exp_time.getText();
		
		menuDto.setF_name(f_name.getText());
		menuDto.setF_name_before(menuDto_before.getF_name_before());
		menuDto.setF_price(Integer.parseInt(price));
		menuDto.setF_exp_time(Integer.parseInt(time));
		menuDto.setF_explain(f_explain.getText());
		menuDto.setF_photo(data);
		menuDto.setS_id(con.getsId());
		//menuDto.setS_id(sId);
		if (fieldCheck()) {
			if(modifySvc.ModifySingleMenu(menuDto)) {
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
		
	//수정취소
	public void cancelModify() {
		CommonService.closeForm(modifyMenuForm);
		con.openForm("menu");
	}

	public ShopMainController getCon() {
		return con;
	}

	public void setMenuDto(MenuDTO menuDto) {
		this.menuDto_before = menuDto;
	}
}
