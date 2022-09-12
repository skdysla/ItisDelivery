package admin.adminList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class AdminDAO {
	private Connection con;
	private PreparedStatement ps= null;
	private ResultSet rs= null;
	
	public Connection getCon() {
		return con;
	}
	AdminDTO adminDto = null;
	
	public AdminDAO() {
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
	public String insertImg(String data) {
		String sql = "SELECT * FROM admin_table Where a_tel=?";
		String path = "";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			if(rs.next()) {
				path=rs.getString("a_photo");
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
		return path;
	}
	public void updateImg(String path,String data) {
		try {
			String sql = "UPDATE admin_table SET a_photo=? WHERE a_tel=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, path);
			ps.setString(2, data);
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
	public void insert(String tel,String name,String position) {
		String sql = "insert into admin_table values('manager', ?, ?, ?, '')";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			ps.setString(2, name);
			ps.setString(3, position);
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
	
	public String getData() {
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
	
	public AdminDTO selectOne(String data) {
		String sql = "SELECT * FROM admin_table Where a_tel=?";
		adminDto = new AdminDTO();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, data);
			rs = ps.executeQuery();
			if(rs.next()) {
				adminDto.setName(rs.getString("a_name"));
				adminDto.setPosition(rs.getString("a_position"));
				adminDto.setTel(rs.getString("a_tel"));
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
		return adminDto;
	}
	public ArrayList<AdminDTO> selectAll() {
		String sql = "SELECT * FROM admin_table";
		ArrayList<AdminDTO> list = new ArrayList<AdminDTO>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new AdminDTO(
						rs.getString("a_name"),
						rs.getString("a_tel"),
						rs.getString("a_position")));
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
	
	public void sendData(String tel) {
		try {
			String sql = "insert into edit values(?,'default')";
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
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
	
	public void update(String name,String tel,String position,String path,String data) {
		try {
			String sql = "UPDATE admin_table SET a_name=?, a_tel=?, a_position=?, a_photo=? WHERE a_tel=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, tel);
			ps.setString(3, position);
			ps.setString(4, path);
			ps.setString(5, data);
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
	public void delete(String tel) {
		try {
			String sql = "delete from admin_table where a_tel=?";
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
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
