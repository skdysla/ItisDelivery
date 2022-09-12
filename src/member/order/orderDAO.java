package member.order;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.main.memberController;

public class orderDAO {
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	private memberController con;
	
	public void setCon(memberController con) {
		this.con = con;
	}
	
	public orderDAO() {
		String url = "jdbc:oracle:thin:@ItsDelivery_medium?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String pw = "Blljc123456789";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, pw);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<orderDTO> selectAll(String mId) {
		String sql = "SELECT o_num, s_name, s_branch, o_menu, o_cnt, o_price, o_time FROM order_list JOIN shop ON order_list.s_id = shop.s_id AND m_id = ? ORDER BY o_num DESC";
		
		ArrayList<orderDTO> allOrders = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, mId);

			rs = ps.executeQuery();
			
			while (rs.next()) {
				allOrders.add(new orderDTO(rs.getInt("o_num"),
						rs.getString("s_name"), 
						rs.getString("s_branch"), 
						rs.getString("o_menu"), 
						rs.getString("o_cnt"), 
						rs.getString("o_price"),
						rs.getString("o_time")));
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
		System.out.println("orderDAO : " + mId);
		return allOrders;
	}

	
	public orderDetailDTO showDetail(Integer o_num) {
		String sql = "SELECT shop.s_id, s_name, s_branch, o_time, o_menu, o_cnt, o_price, o_method, o_num, m_id FROM order_list JOIN shop ON order_list.o_num = ?";
		orderDetailDTO dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, o_num);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				dto = new orderDetailDTO(
						rs.getString("s_id"),
						rs.getString("s_name"),
						rs.getString("s_branch"),
						rs.getString("o_time"),
						rs.getString("o_menu"),
						rs.getString("o_cnt"),
						rs.getString("o_price"),
						rs.getString("o_method"),
						rs.getInt("o_num"),
						rs.getString("m_id"));
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
	
}
