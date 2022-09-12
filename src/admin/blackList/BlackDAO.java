package admin.blackList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BlackDAO {
	private Connection con;
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	
	public Connection getCon() {
		return con;
	}
	
	public BlackDAO() {
//		String url = "jdbc:oracle:thin:@localhost:1521:xe";
//		String user = "oracle";
//		String password = "oracle";
		String url = "jdbc:oracle:thin:@ItsDelivery_high?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String password = "Blljc123456789";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<BlackDTO> selectAll() {
		String sql = "SELECT * FROM member";
		ArrayList<BlackDTO> list = new ArrayList<BlackDTO>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				if(rs.getString("m_ban_dur") != null) {
					list.add(new BlackDTO(
							rs.getString("m_id"),
							rs.getInt("m_des_total_cnt"),
							rs.getString("m_ban_dur")
							));
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null)
					rs.close();
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	public void update(String id) {
		try {
			String sql = "update member SET m_ban_dur='' WHERE m_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
