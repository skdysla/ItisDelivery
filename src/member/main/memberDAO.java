package member.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class memberDAO {
	
	private static Connection conn;
	private static PreparedStatement ps;
	private static ResultSet rs;
	
	public memberDAO() {
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
	
	public memberDTO selectId(String mId) {
		String sql = "SELECT * FROM member WHERE m_id = ?";
		memberDTO member = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				member = new memberDTO();
				member.setmClass(rs.getString("m_class"));
				member.setmId(rs.getString("m_id"));
				member.setmPw(rs.getString("m_pw"));
				member.setmName(rs.getString("m_name"));
				member.setmAddress(rs.getString("m_address"));
				member.setmTel(rs.getString("m_tel"));
				member.setmLikeList(rs.getString("m_like_list"));
				member.setmDesCnt(rs.getInt("m_des_cnt"));
				member.setmBanDur(rs.getString("m_ban_dur"));
				member.setmPhoto(rs.getString("m_photo"));
				member.setmLogoutTime(rs.getString("m_logout_time"));
				member.setmResting(rs.getString("m_resting"));
				member.setmDesTotalCnt(rs.getInt("m_des_total_cnt"));
				member.setmOrderCnt(rs.getInt("m_order_cnt"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return member;
	}

	
	public static int regMember(memberDTO dto) {
		String sql = "INSERT INTO member(m_id, m_pw, m_name, m_address, m_tel) VALUES(?, ?, ?, ?, ?)";
		int rs = -1;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getmId());
			ps.setString(2, dto.getmPw());
			ps.setString(3, dto.getmName());
			ps.setString(4, dto.getmAddress());
			ps.setString(5, dto.getmTel());
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public static int updateMember(memberDTO dto) {
//		String query = "UPDATE shop SET s_pw = ?, s_name = ?, s_owner_tel = ? WHERE s_id = ?";
		String sql = "UPDATE member SET m_pw = ?, m_name = ?, m_tel = ?, m_address = ? WHERE m_id = ?";
		int rs = -1;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ps = conn.prepareStatement(sql);
			ps.setString(1, dto.getmPw());
			ps.setString(2, dto.getmName());
			ps.setString(3, dto.getmTel());
			ps.setString(4, dto.getmAddress());
			ps.setString(5, dto.getmId());
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public static int resignMember(String mId) {
		String sql = "DELETE FROM member WHERE m_id = ?";
		int rs = -1;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			ps = conn.prepareStatement(sql);
			ps.setString(1, mId);
			rs = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null)
					ps.close();
			}catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return rs;
	}
	
	public memberDTO findInfo(String mtel) {
		String sql = "SELECT * FROM member WHERE m_tel = ?";
		memberDTO dto = null;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, mtel);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new memberDTO();
				dto.setmId(rs.getString("m_id"));
				dto.setmName(rs.getString("m_name"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ps != null) ps.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	public int updateLikeList(String likeList, String mId) {
		
		String sql = "UPDATE member SET m_like_list = ? WHERE m_id = ?";
		int result = -1;
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, likeList);
			ps.setString(2, mId);
			result = ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if(ps != null) ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result;
	}
	
}
