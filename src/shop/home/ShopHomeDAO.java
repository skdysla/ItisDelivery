package shop.home;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import shop.main.ShopMainController;

public class ShopHomeDAO {

	private ShopHomeController homeCon;

	public void setCon(ShopHomeController homeCon) {
		this.homeCon = homeCon;
	}

	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public ShopHomeDAO() {
		String url = "jdbc:oracle:thin:@ItsDelivery_medium?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String password = "Blljc123456789";
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// 승인전 건수
	public int selectCondition(String sId) {
		int orderCheck = 0;
		String condi = "beforeView";
		String sql = "SELECT o_is_accepted FROM ORDER_LIST WHERE S_ID = ?";

		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sId);

			rs = ps.executeQuery();
			while (rs.next()) {
				if (condi.equals(rs.getString("o_is_accepted"))) {
					orderCheck++;
				}
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
		return orderCheck;
	}

	// 메인페이지 매출내역
	public ArrayList<ShopHomeDTO> selectSales(String sId, int num, String date) {

		ShopHomeDTO homeDto;
		List orderList = new ArrayList();
		String sql = "SELECT o_time, o_num, o_menu, o_cnt, o_price FROM order_list JOIN shop ON order_list.s_id = shop.s_id AND shop.s_id = ? \r\n"
				+ " WHERE (SUBSTR(o_time, 0, ?)) = TO_CHAR(CURRENT_TIMESTAMP, ?) AND o_is_accepted = 'accepted'";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, sId);
			ps.setInt(2, num);
			ps.setString(3, date);

			rs = ps.executeQuery();
			while (rs.next()) {
				homeDto = new ShopHomeDTO();
				homeDto.setO_time(rs.getString("o_time"));
				homeDto.setO_num(rs.getInt("o_num"));
				homeDto.setO_menu(rs.getString("o_menu"));
				homeDto.setO_cnt(rs.getString("o_cnt"));
				homeDto.setO_price(rs.getString("o_price"));
				orderList.add(homeDto);
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
		return (ArrayList<ShopHomeDTO>) orderList;
	}
}
