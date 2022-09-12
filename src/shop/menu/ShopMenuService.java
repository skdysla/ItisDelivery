package shop.menu;


import java.util.ArrayList;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import shop.main.ShopMainController;

public class ShopMenuService {

	private ShopMainController con;
	private ShopMenuController menuCon;
	private MenuDAO menuDao;
	private MenuTableDTO menuTableDto;
	private MenuDTO menuDto;
	private String sId;

	@FXML ImageView f_photo;
	
	public ShopMenuService(ShopMainController con) {
		this.con = con;
	}
	public void setMenuCon(ShopMenuController menuCon) {
		this.menuCon = menuCon;
		this.sId = con.getsId();
	}	
	
	
//	메뉴테이블
	public ObservableList<MenuTableDTO> refresh(ObservableList<MenuTableDTO> menuList) {
		String sId = con.getsId();
		menuDao = new MenuDAO();
		ArrayList<MenuTableDTO> menuListChange = new ArrayList<>();
		menuListChange = menuDao.selectAll(sId);
		menuList.addAll(menuListChange);
		return menuList;
	}
	
//메뉴추가페이지
	public void showShopMenuAdd() {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/menu/ShopMenuAddForm.fxml"));
		Parent addMenuForm;
		try {
			addMenuForm = loader.load();
			Scene scene = new Scene(addMenuForm);
			
			ShopMenuAddController addMenuCon = loader.getController();
			addMenuCon.setAddForm(addMenuForm);
			
			menuCon.setAddMenuCon(addMenuCon);
			
			Stage stage = new Stage();
			stage.setTitle("addMenu");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public MenuDTO selectMenu(String name) {
		menuDao = new MenuDAO();
		MenuDTO menu = new MenuDTO();
		menu.setF_name(name);
		menu.setS_id(sId);
		return menuDao.selectMenuName(menu);
	}
//메뉴수정페이지 - sid주는것부터 다시 해야함,,
	public void showShopMenuModify(MenuDTO menuDto) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/shop/menu/ShopMenuModifyForm.fxml"));
		Parent modifyMenuForm;
		try {
			modifyMenuForm = loader.load();
			Scene scene = new Scene(modifyMenuForm);
			
			TextField f_name = ((TextField) modifyMenuForm.lookup("#f_name"));
			f_name.setText(menuDto.getF_name());
			
			TextField f_price = ((TextField) modifyMenuForm.lookup("#f_price"));
			String price = menuDto.getF_price() + "";
			f_price.setText(price);
			
			TextField f_exp_time = ((TextField) modifyMenuForm.lookup("#f_exp_time"));
			String exp_time = menuDto.getF_exp_time() + "";
			f_exp_time.setText(exp_time);
			
			TextArea f_explain = ((TextArea) modifyMenuForm.lookup("#f_explain"));
			f_explain.setText(menuDto.getF_explain());
			
			ShopMenuModifyController modifyMenuCon = loader.getController();
			modifyMenuCon.setModifyForm(modifyMenuForm);
			
			menuCon.setModifyMenuCon(modifyMenuCon);
			
			Stage stage = new Stage();
			stage.setTitle("modifyMenu");
			stage.setScene(scene);
			stage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(TableView<MenuTableDTO> menuTable) {
		menuTableDto = new MenuTableDTO();
		menuTableDto = menuTable.getSelectionModel().getSelectedItem();
		menuDao.menuDelete(menuTableDto,sId);
	}
	public MenuDTO modify(TableView<MenuTableDTO> menuTable) {
		menuTableDto = new MenuTableDTO();
		menuTableDto = menuTable.getSelectionModel().getSelectedItem();
		menuDto = new MenuDTO();
		menuDto.setF_name_before(menuTableDto.getF_name());
		menuDto.setF_name(menuTableDto.getF_name());
		menuDto.setS_id(sId);
		
		return menuDao.selectMenuName(menuDto);
	}


}
