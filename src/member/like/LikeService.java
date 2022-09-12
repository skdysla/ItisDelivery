package member.like;

import common.CommonService;
import javafx.collections.ObservableList;
import member.main.memberController;
import member.main.memberDAO;
import member.main.memberDTO;
import member.search.SearchDAO;
import member.search.SearchDTO;
import member.search.ShopListController;

public class LikeService {
	//shoplistform에서 찜하기 버튼 누르면 찜 페이지에 데이터 그대로 들어감
	private memberController con;
	private LikeController likecon;
	private ShopListController shoplistcon;
	private SearchDAO searchDao;
	private SearchDTO searchDto;
	
	public LikeService() {
		searchDao = new SearchDAO();
	}

	public memberController getCon() {
		return con;
	}



	public void setCon(memberController con) {
		this.con = con;
	}



	public LikeController getLikecon() {
		return likecon;
	}



	public void setLikecon(LikeController likecon) {
		this.likecon = likecon;
		this.con = likecon.getCon();
	}
	


	public void setLikecon(ShopListController shoplistcon) {
		this.shoplistcon = shoplistcon;
		this.con = shoplistcon.getCon();
		
	}

	public ObservableList<SearchDTO> show(ObservableList<SearchDTO> likelist) {
			SearchDTO list = searchDao.selectLikeList(con.getsId());
			likelist.addAll(list);
			return likelist;
		}
	
	// 가게의 찜하기 리스트에 회원 추가
		public void addLikeCnt() {
			SearchDTO searchDto = searchDao.selectLikeList(con.getsId());
			boolean chk = false;
			
			// 예빈님 코드랑 합치면!!!!!!
			
			// 현재 로그인한 회원 아이디 Controller에서 불러오기
			String mId = con.getmId();
			
			if(searchDto != null) {
				if(searchDto.getS_like_list() == null) {
					String new_like_list = mId;
					searchDao.updateLikeList(new_like_list, 1, con.getsId());
				}else {
					String[] tmp = searchDto.getS_like_list().split(", ");
					
					for(int i = 0; i < tmp.length; i++) {
						if(mId.equals(tmp[i])) {
							CommonService.alert("이미 찜한 가게입니다!");
							chk = true;
						}
					}
					if(!chk) {
						String new_like_list = searchDto.getS_like_list() + ", " + mId;
						searchDao.updateLikeList(new_like_list, searchDto.getS_like_cnt() + 1, con.getsId());
						CommonService.alert("가게 찜하기 리스트에 추가했습니다!");
					}
				}
				
				// 현재 로그인한 회원의 찜 목록에 가게 추가
				memberDAO memberDao = new memberDAO();
				memberDTO memberDto = memberDao.selectId(mId);
				
				String mlikeList = memberDto.getmLikeList() + con.getsId();
				memberDao.updateLikeList(mlikeList, mId);
			}
		}

		

}
