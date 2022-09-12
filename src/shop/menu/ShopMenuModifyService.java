package shop.menu;

import common.CommonService;
import javafx.scene.Parent;
import javafx.scene.control.TableView;
import shop.main.ShopMainController;

public class ShopMenuModifyService {

	private ShopMainController con;
	private ShopMenuModifyController shopMenuModifyCon;
	private MenuDAO menuDao;
	private Parent menuModifyForm;
	private String sId;
	
	public void setMenuModifyCon(ShopMenuModifyController shopMenuModifyCon) {
		this.shopMenuModifyCon = shopMenuModifyCon;
		this.con = shopMenuModifyCon.getCon();
		this.sId = con.getsId();
	}
	public void setMenuModifyForm(Parent modifyMenuForm) {
		this.menuModifyForm = modifyMenuForm;
	}

	public boolean ModifySingleMenu(MenuDTO menuDto) {
		menuDao = new MenuDAO();
		MenuDTO check = menuDao.selectMenuName(menuDto);
		if(check.getF_name() == null || check.getF_name().equals(menuDto.getF_name_before())) {
			menuDao.menuUpdate(menuDto);
			CommonService.closeForm(menuModifyForm);
			con.openForm("menu");
			CommonService.alert("메뉴가 수정되었습니다.");
			return false;
		}else CommonService.alert("이미 등록된 메뉴입니다.");return true;
		}
}
