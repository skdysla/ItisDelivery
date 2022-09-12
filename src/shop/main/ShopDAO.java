package shop.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopDAO {
	
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public ShopDAO() {
		String url = "jdbc:oracle:thin:@ItsDelivery_medium?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String password = "Blljc123456789";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ShopDTO selectId(String sId) {
		String sql = "SELECT * FROM shop WHERE s_id = ?";
		ShopDTO owner = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				owner = new ShopDTO();
				owner.setsClass(rs.getString("s_class"));
				owner.setsId(rs.getString("s_id"));
				owner.setsPw(rs.getString("s_pw"));
				owner.setsName(rs.getString("s_name"));
				owner.setsOwnerTel(rs.getString("s_owner_tel"));
				owner.setsBranch(rs.getString("s_branch"));
				owner.setsTel(rs.getString("s_tel"));
				owner.setsTime(rs.getString("s_time"));
				owner.setsDayOff(rs.getString("s_day_off"));
				owner.setsEvent(rs.getString("s_event"));
				owner.setsSaleRate(rs.getInt("s_sale_rate"));
				owner.setsAddress(rs.getString("s_address"));
				owner.setsExplain(rs.getString("s_explain"));
				owner.setsLogo(rs.getString("s_logo"));
				owner.setsNotice(rs.getString("s_notice"));
				owner.setsMinPay(rs.getInt("s_min_pay"));
				owner.setsDeliveryDis(rs.getInt("s_delivery_dis"));
				owner.setsDeliveryTip(rs.getString("s_delivery_tip"));
				owner.setsReviewCnt(rs.getInt("s_review_cnt"));
				owner.setsTotal(rs.getInt("s_total"));
				owner.setsMenuList(rs.getString("s_menu_list"));
				owner.setsFoodCate(rs.getString("s_food_cate"));
				owner.setsLogoutTime(rs.getString("s_logout_time"));
				owner.setsResting(rs.getString("s_resting"));
				owner.setsLikeCnt(rs.getInt("s_like_cnt"));
				owner.setsOrderCnt(rs.getInt("s_order_cnt"));
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
		
		return owner;
	}

	
	public static int regShopOwner(ShopDTO dto) {
		String query = "INSERT INTO shop(s_id, s_pw, s_name, s_owner_tel) VALUES(?, ?, ?, ?)";
		int rs = -1;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getsId());
			ps.setString(2, dto.getsPw());
			ps.setString(3, dto.getsName());
			ps.setString(4, dto.getsOwnerTel());
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public static int regShopInfo(ShopDTO dto) {
		String query = "UPDATE shop SET s_name = ?, s_branch = ?, s_food_cate = ?, s_address = ?, s_tel = ?, s_explain = ?, s_notice = ?, "
				+ "s_time = ?, s_day_off = ?, s_event = ?, s_sale_rate = ?, s_delivery_dis = ?, s_delivery_tip = ?, s_min_pay = ?, s_logo = ? WHERE s_id = ?";
		int rs = -1;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getsName());
			ps.setString(2, dto.getsBranch());
			ps.setString(3, dto.getsFoodCate());
			ps.setString(4, dto.getsAddress());
			ps.setString(5, dto.getsTel());
			ps.setString(6, dto.getsExplain());
			ps.setString(7, dto.getsNotice());
			ps.setString(8, dto.getsTime());
			ps.setString(9, dto.getsDayOff());
			ps.setString(10, dto.getsEvent());
			ps.setInt(11, dto.getsSaleRate());
			ps.setInt(12, dto.getsDeliveryDis());
			ps.setString(13, dto.getsDeliveryTip());
			ps.setInt(14, dto.getsMinPay());
			ps.setString(15, dto.getsLogo());
			ps.setString(16, dto.getsId());

			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public static int updateShopOwner(ShopDTO dto) {
		String query = "UPDATE shop SET s_pw = ?, s_name = ?, s_owner_tel = ? WHERE s_id = ?";
		int rs = -1;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ps = conn.prepareStatement(query);
			ps.setString(1, dto.getsPw());
			ps.setString(2, dto.getsName());
			ps.setString(3, dto.getsOwnerTel());
			ps.setString(4, dto.getsId());
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public static int resignShop(String sId) {
		String query = "DELETE FROM shop WHERE s_id = ?";
		int rs = -1;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ps = conn.prepareStatement(query);
			ps.setString(1, sId);
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public ShopDTO findInfo(String ownerTel) {
		String sql = "SELECT * FROM shop WHERE s_owner_tel = ?";
		ShopDTO dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, ownerTel);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new ShopDTO();
				dto.setsId(rs.getString("s_id"));
				dto.setsName(rs.getString("s_name"));
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
		return dto;
	}
	
	public int updateLogoutTime(String sId) {
		String sql = "UPDATE shop SET s_logout_time = TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI') WHERE s_id = ?";
		int result = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int confirmOwnerRest() {
		String sql = "UPDATE shop SET s_resting = 'true' "
				+ "WHERE TO_DATE(s_logout_time, 'YYYY-MM-DD HH24:MI') + 365 <= CURRENT_TIMESTAMP";
		int result = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public int resetUnRest(String sId) {
		String sql = "UPDATE shop SET s_resting = 'false', s_logout_time = TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI') WHERE s_id = ?";
		int result = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
	public void setTimeZone() {
		String sql = "ALTER SESSION SET TIME_ZONE = 'Asia/Seoul'";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
