package shop.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class OrderDAO {
	
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public OrderDAO() {
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
	
	public ArrayList<OrderDTO> selectByDate(String sId, Integer size, String filter) {
		String sql = "SELECT o_time, o_num, o_menu, o_cnt, o_price FROM order_list "
				+ "JOIN shop ON order_list.s_id = shop.s_id AND shop.s_id = ? "
				+ "AND order_list.o_is_accepted = 'accepted' "
				+ "WHERE (SUBSTR(o_time, 0, ?)) = TO_CHAR(CURRENT_TIMESTAMP, ?)";
		ArrayList<OrderDTO> allOrders = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sId);
			ps.setInt(2, size);
			ps.setString(3, filter);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				allOrders.add(new OrderDTO(rs.getInt("o_num"),
						rs.getString("o_time"),
						rs.getString("o_menu"), 
						rs.getString("o_cnt"),
						rs.getString("o_price")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return allOrders;
	}
	
	public ArrayList<OrderDTO> selectTotal(String sId) {
		String sql = "SELECT o_time, o_num, o_menu, o_cnt, o_price FROM order_list "
				+ "JOIN shop ON order_list.s_id = shop.s_id AND shop.s_id = ? "
				+ "AND order_list.o_is_accepted = 'accepted' ORDER BY o_num DESC";
		ArrayList<OrderDTO> allOrders = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sId);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				allOrders.add(new OrderDTO(rs.getInt("o_num"),
						rs.getString("o_time"),
						rs.getString("o_menu"), 
						rs.getString("o_cnt"),
						rs.getString("o_price")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return allOrders;
	}
	
	public ArrayList<OrderDTO> selectAll(String sId) {
		String sql = "SELECT o_time, o_num, o_menu, o_cnt, o_price FROM order_list JOIN shop ON order_list.s_id = shop.s_id AND shop.s_id = ? WHERE order_list.o_is_accepted = 'beforeView' ORDER BY o_num DESC";
		ArrayList<OrderDTO> allOrders = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sId);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				allOrders.add(new OrderDTO(rs.getInt("o_num"),
						rs.getString("o_time"),
						rs.getString("o_menu"), 
						rs.getString("o_cnt"),
						rs.getString("o_price")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return allOrders;
	}
	
	public DetailDTO showDetail(Integer oNum) {
		String sql = "SELECT s_name, s_branch, o_menu, o_cnt, o_price, (SELECT m_tel FROM member WHERE order_list.m_id = member.m_id) AS m_tel, (SELECT m_address FROM member WHERE order_list.m_id = member.m_id) AS m_address FROM order_list JOIN shop ON order_list.o_num = ?";
		DetailDTO dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, oNum);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				dto = new DetailDTO(
						rs.getString("s_name"),
						rs.getString("s_branch"),
						rs.getString("o_menu"),
						rs.getString("o_cnt"),
						rs.getString("o_price"),
						rs.getString("m_address"),
						rs.getString("m_tel")
						);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) rs.close();
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}
	
	public int changeOrderState(String state, Integer oNum) {
		String sql = "UPDATE order_list SET o_is_accepted = ? WHERE o_num = ?";
		int rs = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, state);
			ps.setInt(2, oNum);
			
			rs = ps.executeUpdate();	
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public int refuseOrder() {
		String sql = "UPDATE order_list SET o_is_accepted = 'refused' WHERE TO_DATE(o_time, 'YYYY-MM-DD HH24:MI') + 1/24 <= CURRENT_TIMESTAMP AND o_is_accepted = 'beforeView'";
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
