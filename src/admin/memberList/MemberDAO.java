package admin.memberList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MemberDAO {
	private Connection con;
	private PreparedStatement ps= null;
	private ResultSet rs= null;
	private String sql="";
	public Connection getCon() {
		return con;
	}
	MemberDTO memberDto = null;
	
	public MemberDAO() {
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
	public ArrayList<MemberDTO> selectAll() {
		String sql = "SELECT * FROM member";
		ArrayList<MemberDTO> list = new ArrayList<MemberDTO>();
		try {
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				list.add(new MemberDTO(
					rs.getString("m_id"),
					rs.getString("m_name"),
					rs.getString("m_tel"),
					rs.getString("m_logout_time"),
					rs.getString("m_resting")));
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
	public void sendData(String id,String rest) {
		try {
			String sql = "insert into edit values(?, ?)";
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			ps.setString(2, rest);
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
	public void delete(String id) {
		try {
			String sql = "delete from member where m_id=?";
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
			String sql = "UPDATE member SET m_resting=? WHERE m_id=?";
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
	public MemberDTO selectOne(String serch) {
		String sql = "SELECT * FROM member Where m_id=?";
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, serch);
			rs = ps.executeQuery();
			memberDto = new MemberDTO();
			if(rs.next()) {
				memberDto.setId(rs.getString("m_id"));
				memberDto.setName(rs.getString("m_name"));
				memberDto.setTel(rs.getString("m_tel"));
				memberDto.setTime(rs.getString("m_logout_time"));
				memberDto.setRest(rs.getString("m_resting"));
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
		return memberDto;
	}
}
