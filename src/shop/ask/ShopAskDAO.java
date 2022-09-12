package shop.ask;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShopAskDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	public ShopAskDAO() {
		String url = "jdbc:oracle:thin:@ItsDelivery_medium?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String password = "Blljc123456789";

		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url,user,password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	//고객센터 이메일주소와 연락처 
	public ShopAskDTO selectAsk() {
		String sql = "SELECT * FROM CUSTOMER_SERVICE";
		ShopAskDTO askDto = null;
		
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			if(rs.next()) {
				askDto = new ShopAskDTO();
				askDto.setC_tel(rs.getString("c_tel"));
				askDto.setC_email(rs.getString("c_email"));
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
		return askDto;
		
		
	}
	
	

}