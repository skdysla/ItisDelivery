package member.review;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import member.main.memberController;
import member.order.orderDetailDTO;

public class reviewDAO {
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	private memberController con;
	
	public static Connection getConn() {
		return conn;
	}
	
	public reviewDAO() {
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
	
	public ArrayList<reviewDTO> memberReview(String mId){
		String sql = "SELECT shop.s_name, shop.s_branch, order_list.o_menu, review.r_score, review.r_text, review.r_num, shop.s_id, order_list.o_num FROM review JOIN order_list ON review.m_id = order_list.m_id AND review.r_num = order_list.o_num AND review.s_id = order_list.s_id JOIN shop ON order_list.s_id = shop.s_id WHERE order_list.m_id = ? ORDER BY r_num DESC";
		
		ArrayList<reviewDTO> memberReviews = new ArrayList<>();
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				memberReviews.add(new reviewDTO(rs.getString("s_name"),
						rs.getString("s_branch"),
						rs.getString("o_menu"),
						rs.getInt("r_score"),
						rs.getString("r_text"),
						rs.getInt("r_num"),
						rs.getString("s_id"),
						rs.getInt("o_num")));
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
		System.out.println(mId);
		return memberReviews;
	}
	
	public void review(orderDetailDTO detailDto, String r_text, Integer r_score) {
		String sql = "INSERT INTO review(m_id, s_id, r_text, r_score, r_num) VALUES(?, ?, ?, ?, ?)";
		Connection connection = getConn();
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, detailDto.getM_id());//con에서 mid 받아오기
			ps.setString(2, detailDto.getS_id());//orderdto에서 sid 받아오기
			ps.setString(3, r_text);
			ps.setInt(4, r_score);
			ps.setInt(5, detailDto.getO_num());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	public reviewDTO showDetail(Integer r_num) {
		String sql = "SELECT shop.s_name, shop.s_branch, order_list.o_menu, review.r_score, review.r_text, review.r_num, shop.s_id, order_list.o_num FROM review JOIN order_list ON review.r_num = order_list.o_num AND review.r_num = ? JOIN shop ON order_list.s_id = shop.s_id";
		reviewDTO dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, r_num);
			
			rs = ps.executeQuery();
			
			while (rs.next()) {
				dto = new reviewDTO(
						rs.getString("s_name"),
						rs.getString("s_branch"),
						rs.getString("o_menu"),
						rs.getInt("r_score"),
						rs.getString("r_text"),
						rs.getInt("r_num"),
						rs.getString("s_id"),
						rs.getInt("o_num"));
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
	
	
	public static int reviewUpdate(reviewDTO dto) {
		String sql = "UPDATE review set r_score = ?, r_text = ? WHERE r_num = ?";
		int rs = -1;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getR_score());
			ps.setString(2, dto.getR_text());
			ps.setInt(3, dto.getR_num());
			rs = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public void reviewDelete(Integer r_num) {
		String sql = "DELETE FROM review WHERE r_num = ?";
		try {
			reviewDTO dto = new reviewDTO();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, dto.getR_num());
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
	}
}
	

