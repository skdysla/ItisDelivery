package shop.menu;

import java.util.ArrayList;

import common.CommonService;
import shop.info.CheckPwController;
import shop.info.ShopInfoController;
import shop.info.UpdateShopOwnerInfoService;
import javafx.collections.ObservableList;
import javafx.scene.Parent;
import shop.list.ShopBlackListDTO;
import shop.main.ShopMainController;

public class ShopMenuAddService {

	private ShopMainController con;
	private ShopMenuController menuCon;
	private ShopMenuAddController menuAddCon;
	private MenuDAO menuDao;
	private String sId;
	
	public void setMenuAddForm(Parent menuAddForm) {
		this.menuAddForm = menuAddForm;
	}

	private Parent menuAddForm;
	
	public ShopMenuAddService() {
		menuDao = new MenuDAO();
	}
	public void setMenuAddCon(ShopMenuAddController menuAddCon) {
		this.menuAddCon = menuAddCon;
		this.menuCon = menuAddCon.getMenuCon();
		this.con = menuCon.getCon();
	}
	
	//추가
	public boolean addSingleMenu(MenuDTO menuDto) {
		//동일한 이름의 메뉴는 불가
		MenuDTO check = menuDao.selectMenuName(menuDto);
		if(check.getF_name() == null) {
			menuDto.setS_tel(menuDao.selectTel(menuDto.getS_id()).getS_tel());
			menuDao.insertMenu(menuDto);
			CommonService.closeForm(menuAddForm);
			con.openForm("menu");
			CommonService.alert("메뉴가 등록되었습니다.");
			return false;
		}else CommonService.alert("이미 등록된 메뉴입니다.");return true;
	}
	
	
}
