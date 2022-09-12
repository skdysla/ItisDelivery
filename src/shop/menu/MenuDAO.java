package shop.menu;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.list.ShopBlackListDTO;
import shop.main.ShopDTO;

public class MenuDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private String sId;

	public MenuDAO() {
		String url = "jdbc:oracle:thin:@ItsDelivery_medium?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String password = "Blljc123456789";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//수정할 메뉴 불러오기
	public MenuTableDTO selectMenu(MenuDTO menuDto) {
		String sql = "SELECT * FROM FOOD_MENU WHERE F_NAME = ? AND S_ID = ?";
		MenuTableDTO checkDto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menuDto.getF_name());
			ps.setString(1, menuDto.getS_id());
			rs = ps.executeQuery();
			if (rs.next()) {
				checkDto = new MenuTableDTO();
				checkDto.setF_name(rs.getString("f_name"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkDto;
	}
	//테이블메뉴
	public MenuDTO selectMenuName(MenuDTO menu) {
		String sql = "SELECT * FROM FOOD_MENU WHERE F_NAME = ? AND S_ID = ?";
		MenuDTO checkDto = null;
		checkDto = new MenuDTO();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menu.getF_name());
			ps.setString(2, menu.getS_id());
			rs = ps.executeQuery();
			if (rs.next()) {
				
				checkDto.setF_name(rs.getString("f_name"));
				checkDto.setF_name_before(rs.getString("f_name"));
				checkDto.setF_photo(rs.getString("f_photo"));
				checkDto.setF_explain(rs.getString("f_explain"));
				checkDto.setF_price(rs.getInt("f_price"));
				checkDto.setF_exp_time(rs.getInt("f_exp_time"));
				checkDto.setS_id(rs.getString("s_id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return checkDto;
	}

	// 추가
	public void insertMenu(MenuDTO menuDto) {
		String sql = "INSERT INTO FOOD_MENU (f_name, f_photo, f_explain,f_price,f_exp_time,s_id) VALUES(?,?,?,?,?,?)";
		try {
			ps = con.prepareStatement(sql);
			
			
			ps.setString(1, menuDto.getF_name());
			ps.setString(2, menuDto.getF_photo());
			ps.setString(3, menuDto.getF_explain());
			ps.setInt(4, menuDto.getF_price());
			ps.setInt(5, menuDto.getF_exp_time());
			ps.setString(6, menuDto.getS_id());
			ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 메뉴리스트 불러오기
	public ArrayList<MenuTableDTO> selectAll(String sId) {
		ArrayList<MenuTableDTO> menuList = new ArrayList<>();
		MenuTableDTO menuDto = null;
		String sql = "SELECT f_name,f_price,f_exp_time FROM FOOD_MENU WHERE S_ID = ?"; //
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sId);
			rs = ps.executeQuery();
			while (rs.next()) {
				menuDto = new MenuTableDTO();
				menuDto.setF_name(rs.getString("f_name"));
				menuDto.setF_price(rs.getInt("f_price"));
				menuDto.setF_exp_time(rs.getInt("f_exp_time"));
				menuList.add(menuDto);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return menuList;
	}

	// 메뉴수정하기
	public void menuUpdate(MenuDTO menuDto) {
		String sql = "UPDATE FOOD_MENU SET f_name = ?, f_price = ?,f_exp_time = ?,f_explain = ?,f_photo = ? WHERE F_NAME = ? AND S_ID = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menuDto.getF_name());
			ps.setInt(2, menuDto.getF_price());
			ps.setInt(3, menuDto.getF_exp_time());
			ps.setString(4, menuDto.getF_explain());
			ps.setString(5, menuDto.getF_photo());
			ps.setString(6, menuDto.getF_name_before());
			ps.setString(7, menuDto.getS_id());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 메뉴삭제하기
	public void menuDelete(MenuTableDTO menuDto, String sId) {
		String sql = "DELETE FOOD_MENU WHERE F_NAME = ? AND S_ID = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, menuDto.getF_name());
			ps.setString(2, sId);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public MenuDTO selectTel(String sId) {
		MenuDTO menuDto= null;
		
		String sql = "SELECT s_tel FROM shop WHERE s_id = ?";
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				menuDto = new MenuDTO();
				menuDto.setS_tel(rs.getString("s_tel"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return menuDto;
	}
}
