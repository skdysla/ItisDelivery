package admin.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ReviewDAO {
	private Connection con;
	private PreparedStatement ps= null;
	private ResultSet rs= null;
	
	public Connection getCon() {
		return con;
	}
	ReviewDTO reviewDto = null;
	
	public ReviewDAO() {
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
	
	public String getData1() {
		String sql = "SELECT data1 from edit";
		String data = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				data = rs.getString("data1");
			}
		}catch (SQLException e) {
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
		return data;
	}
	public String getData2() {
		String sql = "SELECT data2 from edit";
		String data = null;
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				data = rs.getString("data2");
			}
		}catch (SQLException e) {
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
		return data;
	}
	public void deleteData(String data) {
		try {
			String sql = "DELETE from edit WHERE data1=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			ps.executeUpdate();
		}catch (SQLException e) {
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
//
	public void delete(int num) {
		try {
			String sql = "delete from review where r_num=?";
			ps = con.prepareStatement(sql);
			ps.setInt(1, num);
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
	//
	public ArrayList<ReviewDTO> selectAll(String data) {
		String sql = "SELECT * FROM review WHERE m_id=?";
		ArrayList<ReviewDTO> list = new ArrayList<ReviewDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			while(rs.next()) {
				list.add(new ReviewDTO(
						rs.getInt("r_num"),
						rs.getString("s_id"),
						rs.getString("r_text"),
						rs.getInt("r_score")));
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
}
