package admin.shopList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShopDAO {
	private Connection con;
	private PreparedStatement ps= null;
	private ResultSet rs= null;
	private String sql="";
	public Connection getCon() {
		return con;
	}
	
	ShopDTO shopDto = null;
	
	public ShopDAO() {
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
	public ArrayList<ShopDTO> selectAll() {
		String sql = "SELECT * FROM shop";
		ArrayList<ShopDTO> list = new ArrayList<ShopDTO>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new ShopDTO(
					rs.getString("s_id"),
					rs.getString("s_name"),
					rs.getString("s_branch"),
					rs.getString("s_tel"),
					rs.getString("s_logout_time"),
					rs.getString("s_resting")));
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
	public void delete(String id) {
		try {
			String sql = "delete from shop where s_id=?";
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
	public void rest(String id, String rest) {
		try {
			String sql = "UPDATE shop SET s_resting=? WHERE s_id=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, rest);
			ps.setString(2, id);
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
	public ShopDTO selectOne(String serch) {
		String sql = "SELECT * FROM shop Where s_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, serch);
			rs = ps.executeQuery();
			shopDto = new ShopDTO();
			if(rs.next()) {
				shopDto.setId(rs.getString("s_id"));
				shopDto.setName(rs.getString("s_name"));
				shopDto.setLoc(rs.getString("s_branch"));
				shopDto.setTel(rs.getString("s_tel"));
				shopDto.setTime(rs.getString("s_logout_time"));
				shopDto.setRest(rs.getString("s_resting"));
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
		return shopDto;
	}
}
