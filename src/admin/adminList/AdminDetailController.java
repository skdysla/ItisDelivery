package admin.adminList;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import admin.common.CommonService;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import admin.main.AdminController;

public class AdminDetailController implements Initializable {
	private Parent adminDetailForm;
	private AdminController controller;
	private AdminDAO adminDao;
	private String data;
	AdminDTO adminDto = null;
	
	@FXML private TextField name;
	@FXML private TextField position;
	@FXML private TextField tel;
	@FXML private ImageView photo;
	private String path = null;
	public void setPath(String path) {
		this.path = path;
	}
	public String getPath() {
		return path;
	}
	
	//
	public void setData(String data) {
		this.data = data;
	}
	public String getData() {
		return data;
	}
	
	public void setController(AdminController controller) {
		this.controller = controller;
	}
	public void setAdminDetailForm(Parent adminDetailForm) {
		this.adminDetailForm = adminDetailForm;
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		adminDao = new AdminDAO();
		setData(adminDao.getData());
		adminDto = adminDao.selectOne(getData());
		
		name.setText(adminDto.getName());
		position.setText(adminDto.getPosition());
		tel.setText(adminDto.getTel());
		//
		setPath(adminDao.insertImg(getData()));
		if(getPath() != null) {
			try {
				FileInputStream fis = new FileInputStream(getPath());
				BufferedInputStream bis = new BufferedInputStream(fis);
				Image img = new Image(bis);
				photo.setImage(img);
				
				try {
					bis.close();
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			}
		}
	}
//
	public void updateImgBtn() {
		if(getPath() != null) {
			if(CommonService.msgBtn("현재 사진을 저장하시겠습니까?")==1) {
				adminDao.updateImg(getPath(),getData());
				CommonService.msg("사진 저장 완료");
			}
		}else {
			CommonService.msg("사진을 등록해 주세요");
		}
	}
	public void imgBtn() {
		FileChooser fc = new FileChooser();
		fc.setInitialDirectory(new File("c:/"));
		ExtensionFilter imgType = new ExtensionFilter("image file", "*.jpg","*.gif","*.png");
		fc.getExtensionFilters().add(imgType);
		
		File path1 = fc.showOpenDialog(null);
		setPath(path1.toString());
		
		try {
			FileInputStream fis = new FileInputStream(path1);
			BufferedInputStream bis = new BufferedInputStream(fis);
			Image img = new Image(bis);
			photo.setImage(img);
			try {
				bis.close();
				fis.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
//
	public void updateBtn() {
		String n = name.getText();
		String p = position.getText();
		String t = tel.getText();
		if(n.length() != 0 && p.length() != 0 && t.length() != 0) {
			adminDto = adminDao.selectOne(t);
			if(adminDto.getTel()==null) {
				if (CommonService.msgBtn(n+" 을/를 수정하시겠습니까?") == 1){
					adminDao.update(n,t,p,getPath(),getData());
					adminDao.deleteData(getData());
					CommonService.windowClose(adminDetailForm);
					controller.open("adminList");
					CommonService.msg(n+" 수정완료");
				}
			}else {
				
				CommonService.msg("이미 있는 전화번호 입니다.");
			}
		}else {
			CommonService.msg("텍스트가 비어있습니다.");
		}
	}
	public void adminListBtn() {
		adminDao.deleteData(getData());
		CommonService.windowClose(adminDetailForm);
		controller.open("adminList");
	}
	public void homeBtn() {
		adminDao.deleteData(getData());
		CommonService.windowClose(adminDetailForm);
		controller.open("home");
	}
	public void blackListBtn() {
		adminDao.deleteData(getData());
		CommonService.windowClose(adminDetailForm);
		controller.open("blackList");
	}
}
