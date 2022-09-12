package shop.menu;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import common.CommonService;
import shop.home.ShopHomeService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.util.Callback;
import shop.list.ShopBlackListDTO;
import shop.list.ShopBlackListService;
import shop.main.ShopMainController;
import shop.main.ShopMainService;

public class ShopMenuController implements Initializable {
	
	private ShopMainController con;
	private ShopMenuAddController addMenuCon;
	private ShopMenuModifyController modifyMenuCon;
	private ShopMenuService menuSvc;
	private Parent menuForm;
	
	public ShopMainController getCon() {
		return con;
	}
	public void setCon(ShopMainController con) {
		this.con = con;
		menuSvc = new ShopMenuService(con);
		menuSvc.setMenuCon(this);
		menuList = FXCollections.observableArrayList();
		show();
	}
	public Parent getMenuForm() {
		return menuForm;
	}
	public void setMenuForm(Parent menuForm) {
		this.menuForm = menuForm;
	}
	public void setAddMenuCon(ShopMenuAddController addMenuCon) {
		this.addMenuCon = addMenuCon;
		this.addMenuCon.setMenuCon(this);
	}
	public void setModifyMenuCon(ShopMenuModifyController modifyMenuCon) {
		this.modifyMenuCon = modifyMenuCon;
		this.modifyMenuCon.setMenuCon(this);
	}	
	
	@FXML TableView<MenuTableDTO> menuTable;
	@FXML TableColumn<MenuTableDTO, String> f_name;
	@FXML TableColumn<MenuTableDTO, Number> f_price;
	@FXML TableColumn<MenuTableDTO, Number> f_exp_time;
	@FXML TableColumn<MenuTableDTO, Void> menuModifyBtn;//버튼컬럼,,,
	
	ObservableList<MenuTableDTO> menuList;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
	}
	
	public void show() {
		menuList = menuSvc.refresh(menuList);
		if(menuList != null) {
			for(int i = 0; i < menuList.size(); i++) {
				f_name.setCellValueFactory(new PropertyValueFactory<MenuTableDTO, String>("f_name"));
				f_price.setCellValueFactory(new PropertyValueFactory<MenuTableDTO, Number>("f_price"));
				f_exp_time.setCellValueFactory(new PropertyValueFactory<MenuTableDTO, Number>("f_exp_time"));
				//addButtonToTable(menuList.get(i).getF_name());
				menuTable.setItems(menuList);
			}
		}
	}
	//삭제버튼
	public void showShopMenuDelete() {
		menuSvc.delete(menuTable);
		menuList.clear();//재업데이트 작업
		menuTable.setItems(menuSvc.refresh(menuList));
	}
	//추가버튼
	public void showShopMenuAdd() {
		CommonService.closeForm(menuForm);
		menuSvc.showShopMenuAdd();
	}
	//수정버튼
	public void showShopMenuModify() {
		menuSvc.showShopMenuModify(menuSvc.modify(menuTable));
		modifyMenuCon.setMenuDto(menuSvc.modify(menuTable));
		CommonService.closeForm(menuForm);
	}
	
	public void clickHomeBtn() {
		CommonService.closeForm(menuForm);
		con.openForm("home");
	}
	
	public void clickMenuBtn() {
		CommonService.closeForm(menuForm);
		con.openForm("menu");
	}
	
	public void clickSalesBtn() {
		CommonService.closeForm(menuForm);
		con.openForm("sales");
	}

	public void clickAskBtn() {
		CommonService.closeForm(menuForm);
		con.openForm("ask");
	}
	
	public void clickListBtn() {
		CommonService.closeForm(menuForm);
		con.openForm("list");
	}
	
	public void clickShopInfoBtn() {
		CommonService.closeForm(menuForm);
		con.openForm("shopInfo");
	}
	
	public void clickAcceptedOrdersBtn() {
		CommonService.closeForm(menuForm);
		con.openForm("acceptedOrders");
	}

//	private void addButtonToTable(String name) {
//
//        Callback<TableColumn<MenuTableDTO, Void>, TableCell<MenuTableDTO, Void>> cellFactory = new Callback<TableColumn<MenuTableDTO, Void>, TableCell<MenuTableDTO, Void>>() {
//            @Override
//            public TableCell<MenuTableDTO, Void> call(final TableColumn<MenuTableDTO, Void> param) {
//                final TableCell<MenuTableDTO, Void> cell = new TableCell<MenuTableDTO, Void>() {
//                    private final Button showShopMenuModify = new Button("수정하기");
//                    {
//                    	showShopMenuModify.setOnAction((ActionEvent event) -> {
//                    		showShopMenuModify(name);
//                        });
//                    }
//                    @Override
//                    public void updateItem(Void item, boolean empty) {
//                        super.updateItem(item, empty);
//                        if (empty) {
//                            setGraphic(null);
//                        } else {
//                            setGraphic(showShopMenuModify);
//                        }
//                    }
//                };
//                return cell;
//            }
//        };
//        menuModifyBtn.setCellFactory(cellFactory);
//       // menuTable.getColumns().add(menuModifyBtn);
//    }
//
}
