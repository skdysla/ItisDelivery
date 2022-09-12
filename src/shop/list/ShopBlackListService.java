package shop.list;

import java.util.ArrayList;

import shop.info.CheckPwController;
import shop.info.ShopInfoController;
import javafx.collections.ObservableList;
import shop.main.ShopDAO;
import shop.main.ShopMainController;

public class ShopBlackListService {
	private ShopMainController con;
	private ShopListController listCon;
	private ShopBlackListController blackListCon;
	private ObservableList<ShopBlackListDTO> blackList;
	private ShopBlackListDTO blackListDto;
	private ShopListDAO blackListDao;
	
	public ShopBlackListService(ObservableList<ShopBlackListDTO> blackList) {
		this.blackList = blackList;
		blackListDto = new ShopBlackListDTO();
	}

	public void setBlackListCon(ShopBlackListController blackListCon) {
		this.blackListCon = blackListCon;
		this.listCon = blackListCon.getListCon();
		this.con = blackListCon.getCon();
	}

	public ObservableList<ShopBlackListDTO> refresh() {
		blackListDao = new ShopListDAO();
		ArrayList<ShopBlackListDTO> blackListChange = new ArrayList<>();
		blackListChange = blackListDao.selectAll();
		blackList.addAll(blackListChange);
		return blackList;
	}
}
