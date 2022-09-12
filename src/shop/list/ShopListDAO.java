package shop.list;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ShopListDAO {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	private ShopReviewDTO reviewDto;

	public ShopListDAO() {
		String url = "jdbc:oracle:thin:@ItsDelivery_medium?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String password = "Blljc123456789";

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, password);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<ShopBlackListDTO> selectAll() {
		ArrayList<ShopBlackListDTO> blackList = new ArrayList<>();
		ShopBlackListDTO blackDto;
		String sql = "SELECT M_ID, M_DES_TOTAL_CNT FROM MEMBER WHERE M_DES_TOTAL_CNT >= 10";

		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				blackDto = new ShopBlackListDTO();
				blackDto.setBlackMember(rs.getString("m_id"));
				blackDto.setBlackMemberCnt(rs.getInt("m_des_total_cnt"));
				blackList.add(blackDto);
			}
		} catch (SQLException e) {
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
		return blackList;
	}
	
	public ArrayList<ShopReviewDTO> selectReview(String sId) {
		String sql = "SELECT review.r_text, review.r_score,order_list.o_time, review.m_id, order_list.o_menu FROM review JOIN order_list ON review.s_id = order_list.s_id AND order_list.o_num = review.r_num WHERE review.s_id = ? ORDER BY o_time desc";
		ArrayList<ShopReviewDTO> reviewList = new ArrayList<ShopReviewDTO>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, sId);
			rs = ps.executeQuery();
			while(rs.next()) {
				reviewDto = new ShopReviewDTO();
				reviewDto.setO_time(rs.getString("o_time"));
				reviewDto.setM_id(rs.getString("m_id"));
				reviewDto.setO_menu(rs.getString("o_menu"));
				reviewDto.setR_text(rs.getString("r_text"));
				reviewDto.setR_score(rs.getInt("r_score"));
				reviewList.add(reviewDto);
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
		return reviewList;
	}
}
