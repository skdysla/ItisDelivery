package member.search;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import shop.order.OrderDTO;

public class SearchDAO {
	
	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	
	
	public SearchDAO() {
		String url = "jdbc:oracle:thin:@ItsDelivery_medium?TNS_ADMIN=/Users/Admin/Downloads/Wallet_ItsDelivery";
		String user = "admin";
		String pass = "Blljc123456789";
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(url, user, pass);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	//s_id, s_logo, s_name, s_food_cate, s_total, s_order_cnt, s_like_cnt, s_review_cnt;
		//검색 shoplist 페이지(모두 검색)
		public ArrayList<SearchDTO> selectshop() {
			String sql = "SELECT s_id, s_logo, s_name, s_food_cate, s_total, s_order_cnt, s_like_cnt, s_review_cnt FROM shop";
			ArrayList<SearchDTO> shoplist = new ArrayList<>();
			try {
				ps = con.prepareStatement(sql);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					shoplist.add(new SearchDTO(
							rs.getString("s_id"),
							rs.getString("s_logo"),
							rs.getString("s_name"),
							rs.getString("s_food_cate"),
							rs.getInt("s_total"),
							rs.getInt("s_order_cnt"),
							rs.getInt("s_like_cnt"),
							rs.getInt("s_review_cnt")));
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
			return shoplist;
		}
	
	//s_id, s_logo, s_name, s_food_cate, s_total, s_order_cnt, s_like_cnt, s_review_cnt;
	//검색 shoplist 페이지(가게 음식별)
	public ArrayList<SearchDTO> selectshopname(String s_name) {
		String sql = "SELECT s_id, s_logo, s_name, s_food_cate, s_total, s_order_cnt, s_like_cnt, s_review_cnt FROM shop WHERE INSTR(s_name, ?) > 0";
		ArrayList<SearchDTO> shopnamelist = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, s_name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				shopnamelist.add(new SearchDTO(
						rs.getString("s_id"),
						rs.getString("s_logo"),
						rs.getString("s_name"),
						rs.getString("s_food_cate"),
						rs.getInt("s_total"),
						rs.getInt("s_order_cnt"),
						rs.getInt("s_like_cnt"),
						rs.getInt("s_review_cnt")));
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
		return shopnamelist;
	}
	
	//s_id, s_logo, s_name, s_food_cate, s_total, s_order_cnt, s_like_cnt, s_review_cnt;
		//검색 shoplist 페이지(음식 종류별)
		public ArrayList<SearchDTO> selectfoodcate(String s_food_cate) {
			String sql = "SELECT s_id, s_logo, s_name, s_food_cate, s_total, s_order_cnt, s_like_cnt, s_review_cnt FROM shop WHERE s_food_cate = ?";
			ArrayList<SearchDTO> foodcatelist = new ArrayList<>();
			try {
				ps = con.prepareStatement(sql);
				ps.setString(1, s_food_cate);
				rs = ps.executeQuery();
				
				while(rs.next()) {
					foodcatelist.add(new SearchDTO(
							rs.getString("s_id"),
							rs.getString("s_logo"),
							rs.getString("s_name"),
							rs.getString("s_food_cate"),
							rs.getInt("s_total"),
							rs.getInt("s_order_cnt"),
							rs.getInt("s_like_cnt"),
							rs.getInt("s_review_cnt")));
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
			return foodcatelist;
		}
	
	//검색 shop 페이지
	//s_id, f_photo, f_name, f_explain, f_price, f_exp_time
	public ArrayList<SearchMDTO> selectdetailshop(String s_id) {
		String sql = "SELECT * FROM food_menu WHERE s_id = ?";
		ArrayList<SearchMDTO> menulist = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, s_id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				menulist.add(new SearchMDTO(
						rs.getString("s_id"),
						rs.getString("f_photo"),
						rs.getString("f_name"),
						rs.getString("f_explain"),
						rs.getInt("f_price"),
						rs.getInt("f_exp_time")));
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
		
		return menulist;
	}
	// 장바구니
	public ArrayList<SearchMDTO> cartmenu(String f_name) {
		String sql = "SELECT * FROM food_menu WHERE f_name = ?";
		ArrayList<SearchMDTO> cartlist = new ArrayList<>();
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, f_name);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				cartlist.add(new SearchMDTO(
						rs.getString("s_id"),
						rs.getString("f_photo"),
						rs.getString("f_name"),
						rs.getString("f_explain"),
						rs.getInt("f_price"),
						rs.getInt("f_exp_time")));
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
		
		return cartlist;
	}

	//검색 shop 페이지
	//s_id, s_name, s_order_cnt, s_like_cnt, s_review_cnt, f_photo, f_name, f_explain, f_price, f_exp_time
	public SearchMDTO goshopProc(String s_id) {
		String sql = "SELECT * FROM food_menu JOIN shop ON food_menu.s_id = shop.s_id AND shop.s_id = ?";
		SearchMDTO searchMDto = null;
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, s_id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				searchMDto = new SearchMDTO(
						rs.getString("s_id"),
						rs.getString("s_name"),
						rs.getString("s_order_cnt"),
						rs.getString("s_like_cnt"),
						rs.getString("s_notice"),
						rs.getString("s_explain"),
						rs.getString("s_branch"),
						rs.getString("s_review_cnt"));
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
		
		return searchMDto;
	}
	//주문페이지
	//회원 아이디로 주문내역 저장하기
	public void orderpage(OrderDTO orderDto) {
		String sql = "INSERT INTO order_list(o_num, o_menu, o_cnt, o_time, o_delivery_time, o_delivery_tip, o_method, o_price, m_id, s_id) VALUES(order_seq .nextval,??,TO_CHAR(CURRENT_TIMESTAMP, 'YYYY-MM-DD HH24:MI'),??????)";
//		try {
//			ps = con.prepareStatement(sql);
//			ps.setInt(1, orderDto.getO_num());
//			ps.setString(2, orderDto.getO_menu());
//			ps.setString(3, orderDto.getO_cnt());
//			ps.setInt(4, orderDto.getO_delivery_time());
//			ps.setInt(5, orderDto.getO_delivery_tip());
//			ps.setString(6, orderDto.getO_method());
//			ps.setString(7, orderDto.getO_price());
//			ps.setString(8, orderDto.getM_id());
//			ps.setString(9, orderDto.getS_id());
//			ps.executeUpdate();
//			
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if(ps != null)
//					ps.close();
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
	}
	
	
	//찜 페이지
	public SearchDTO selectLikeList(String s_id) {
		String sql = "SELECT * FROM shop WHERE s_id = ?";
		SearchDTO dto = null;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, s_id);
			rs = ps.executeQuery();
			
			if(rs.next()) {
				dto = new SearchDTO();
				dto.setS_logo(rs.getString("s_logo"));
				dto.setS_name(rs.getString("s_name"));
				dto.setS_like_list(rs.getString("s_like_list"));
				dto.setS_like_cnt(rs.getInt("s_like_cnt"));
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
		return dto;
	}

	public int updateLikeList(String newLikeList, Integer sLikeCnt, String s_id) {
		String sql = "UPDATE shop SET s_like_list = ?, s_like_cnt = ? WHERE s_id = ?";
		int result = -1;
		
		try {
			ps = con.prepareStatement(sql);
			ps.setString(1, newLikeList);
			ps.setInt(2, sLikeCnt);
			ps.setString(3, s_id);
			
			result = ps.executeUpdate();
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
		return result;
	}
	
	public ArrayList<SearchMDTO> selectmember(String m_id) {
	      String sql = "SELECT * FROM member WHERE m_id = ?";
	      ArrayList<SearchMDTO> memberlist = new ArrayList<>();
	      try {
	         ps = con.prepareStatement(sql);
	         ps.setString(1, m_id);
	         rs = ps.executeQuery();
	         
	         while(rs.next()) {
	            memberlist.add(new SearchMDTO(
	                  rs.getString("m_id"),
	                  rs.getString("m_address"),
	                  rs.getString("m_tel")));
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
	      
	      return memberlist;
	   }
	
	
	
	
}
		


	
