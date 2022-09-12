package shop.main;

public class ShopDTO {
	
	private String sClass;
	private String sId;
	private String sPw;
	private String sName;
	private String sBranch;
	private String sTel;
	private String sTime;
	private String sDayOff;
	private String sEvent;
	private Integer sSaleRate;
	private String sAddress;
	private String sExplain;
	private String sLogo;
	private String sNotice;
	private Integer sMinPay;
	private Integer sDeliveryDis;
	private String sDeliveryTip;
	private Integer sReviewCnt;
	private Integer sTotal;
	private String sMenuList;
	private String sFoodCate;
	private String sLogoutTime;
	private String sResting;
	private Integer sLikeCnt;
	private Integer sOrderCnt;
	private String sOwnerTel;
	
	public ShopDTO() {
		
	}
	
	public ShopDTO(String sId, String sPw, String sName, String sOwnerTel) {
		this.sId = sId;
		this.sPw = sPw;
		this.sName = sName;
		this.sOwnerTel = sOwnerTel;
	}
	
	public ShopDTO(String sId, String sName, String sBranch, String sTel, String sTime, String sDayOff, String sEvent, Integer sSaleRate,
			String sAddress, String sExplain, String sLogo, String sNotice, Integer sMinPay, Integer sDeliveryDis, String sDeliveryTip,
			String sFoodCate) {
		this.sId = sId;
		this.sName = sName;
		this.sBranch = sBranch; 
		this.sTel = sTel;
		this.sTime = sTime;
		this.sDayOff = sDayOff;
		this.sEvent = sEvent;
		this.sSaleRate = sSaleRate;
		this.sAddress = sAddress;
		this.sExplain = sExplain;
		this.sLogo = sLogo;
		this.sNotice = sNotice;
		this.sMinPay = sMinPay;
		this.sDeliveryDis = sDeliveryDis;
		this.sDeliveryTip = sDeliveryTip;
		this.sFoodCate = sFoodCate;
	}

	public String getsClass() {
		return sClass;
	}

	public void setsClass(String sClass) {
		this.sClass = sClass;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getsPw() {
		return sPw;
	}

	public void setsPw(String sPw) {
		this.sPw = sPw;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getsBranch() {
		return sBranch;
	}

	public void setsBranch(String sBranch) {
		this.sBranch = sBranch;
	}

	public String getsTel() {
		return sTel;
	}

	public void setsTel(String sTel) {
		this.sTel = sTel;
	}

	public String getsTime() {
		return sTime;
	}

	public void setsTime(String sTime) {
		this.sTime = sTime;
	}

	public String getsDayOff() {
		return sDayOff;
	}

	public void setsDayOff(String sDayOff) {
		this.sDayOff = sDayOff;
	}

	public String getsEvent() {
		return sEvent;
	}

	public void setsEvent(String sEvent) {
		this.sEvent = sEvent;
	}

	public Integer getsSaleRate() {
		return sSaleRate;
	}

	public void setsSaleRate(Integer sSaleRate) {
		this.sSaleRate = sSaleRate;
	}

	public String getsAddress() {
		return sAddress;
	}

	public void setsAddress(String sAddress) {
		this.sAddress = sAddress;
	}

	public String getsExplain() {
		return sExplain;
	}

	public void setsExplain(String sExplain) {
		this.sExplain = sExplain;
	}

	public String getsLogo() {
		return sLogo;
	}

	public void setsLogo(String sLogo) {
		this.sLogo = sLogo;
	}

	public String getsNotice() {
		return sNotice;
	}

	public void setsNotice(String sNotice) {
		this.sNotice = sNotice;
	}

	public Integer getsMinPay() {
		return sMinPay;
	}

	public void setsMinPay(Integer sMinPay) {
		this.sMinPay = sMinPay;
	}

	public Integer getsDeliveryDis() {
		return sDeliveryDis;
	}

	public void setsDeliveryDis(Integer sDeliveryDis) {
		this.sDeliveryDis = sDeliveryDis;
	}
	
	public String getsDeliveryTip() {
		return sDeliveryTip;
	}

	public void setsDeliveryTip(String sDeliveryTip) {
		this.sDeliveryTip = sDeliveryTip;
	}

	public Integer getsReviewCnt() {
		return sReviewCnt;
	}

	public void setsReviewCnt(Integer sReviewCnt) {
		this.sReviewCnt = sReviewCnt;
	}

	public Integer getsTotal() {
		return sTotal;
	}

	public void setsTotal(Integer sTotal) {
		this.sTotal = sTotal;
	}

	public String getsMenuList() {
		return sMenuList;
	}

	public void setsMenuList(String sMenuList) {
		this.sMenuList = sMenuList;
	}

	public String getsFoodCate() {
		return sFoodCate;
	}

	public void setsFoodCate(String sFoodCate) {
		this.sFoodCate = sFoodCate;
	}

	public String getsLogoutTime() {
		return sLogoutTime;
	}

	public void setsLogoutTime(String sLogoutTime) {
		this.sLogoutTime = sLogoutTime;
	}

	public String getsResting() {
		return sResting;
	}

	public void setsResting(String sResting) {
		this.sResting = sResting;
	}

	public Integer getsLikeCnt() {
		return sLikeCnt;
	}

	public void setsLikeCnt(Integer sLikeCnt) {
		this.sLikeCnt = sLikeCnt;
	}

	public Integer getsOrderCnt() {
		return sOrderCnt;
	}

	public void setsOrderCnt(Integer sOrderCnt) {
		this.sOrderCnt = sOrderCnt;
	}

	public String getsOwnerTel() {
		return sOwnerTel;
	}

	public void setsOwnerTel(String sOwnerTel) {
		this.sOwnerTel = sOwnerTel;
	}
	
}