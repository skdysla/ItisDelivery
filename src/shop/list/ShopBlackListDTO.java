package shop.list;

public class ShopBlackListDTO {
	private String blackMember; 
	private int blackMemberCnt;
	
	public String getBlackMember() {
		return blackMember;
	}
	public int getBlackMemberCnt() {
		return blackMemberCnt;
	}
	public void setBlackMember(String blackMember) {
		this.blackMember = blackMember;
	}
	public void setBlackMemberCnt(int blackMemberCnt) {
		this.blackMemberCnt = blackMemberCnt;
	}

}
