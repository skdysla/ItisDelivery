package admin.login;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginDAO {
	private Connection con;
	
	public Connection getCon() {
		return con;
	}
	
	public LoginDAO() {
		String url = "jdbc:oracle:thin:@ItsDelivery_medium?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String password = "Blljc123456789";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public LoginDTO selectTel(String tel) {
		PreparedStatement ps= null;
		ResultSet rs= null;
		LoginDTO login = null;
		String sql = "SELECT * FROM admin_table WHERE a_tel = ?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, tel);
			rs = ps.executeQuery();
			if(rs.next()) {
				login = new LoginDTO();
				login.setTel(rs.getString("a_tel"));
				login.setName(rs.getString("a_name"));
				login.setPosition(rs.getString("a_position"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs != null) rs.close();
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return login;
	}
	
}
