package member.main;

public class memberDTO {
//	M_CLASS         NOT NULL VARCHAR2(10)   
//	M_ID            NOT NULL VARCHAR2(20)   
//	M_PW            NOT NULL VARCHAR2(20)   
//	M_NAME          NOT NULL VARCHAR2(15)   
//	M_ADDRESS       NOT NULL VARCHAR2(50)   
//	M_TEL           NOT NULL VARCHAR2(15)   
//	M_LIKE_LIST              VARCHAR2(1000) 
//	M_DES_CNT                NUMBER(2)      
//	M_BAN_DUR                VARCHAR2(20)   
//	M_PHOTO                  VARCHAR2(90)   
//	M_LOGOUT_TIME            VARCHAR2(20)   
//	M_RESTING                VARCHAR2(5)    
//	M_DES_TOTAL_CNT          NUMBER(2)      
//	M_ORDER_CNT              NUMBER(4) 
	private String mClass;
	private String mId;
	private String mPw;
	private String mName;
	private String mAddress;
	private String mTel;
	private String mLikeList;
	private Integer mDesCnt;
	private String mBanDur;
	private String mPhoto;
	private String mLogoutTime;
	private String mResting;
	private Integer mDesTotalCnt;
	private Integer mOrderCnt;
	
	public memberDTO(){}
	
	public memberDTO(String mId, String mPw, String mName, String mAddress, String mTel) {
		this.mId = mId;
		this.mPw = mPw;
		this.mName = mName;
		this.mAddress = mAddress;
		this.mTel = mTel;
	}
	
	public String getmClass() {
		return mClass;
	}
	public void setmClass(String mClass) {
		this.mClass = mClass;
	}
	public String getmId() {
		return mId;
	}
	public void setmId(String mId) {
		this.mId = mId;
	}
	public String getmPw() {
		return mPw;
	}
	public void setmPw(String mPw) {
		this.mPw = mPw;
	}
	public String getmName() {
		return mName;
	}
	public void setmName(String mName) {
		this.mName = mName;
	}
	public String getmAddress() {
		return mAddress;
	}
	public void setmAddress(String mAddress) {
		this.mAddress = mAddress;
	}
	public String getmTel() {
		return mTel;
	}
	public void setmTel(String mTel) {
		this.mTel = mTel;
	}
	public String getmLikeList() {
		return mLikeList;
	}
	public void setmLikeList(String mLikeList) {
		this.mLikeList = mLikeList;
	}
	public Integer getmDesCnt() {
		return mDesCnt;
	}
	public void setmDesCnt(Integer mDesCnt) {
		this.mDesCnt = mDesCnt;
	}
	public String getmBanDur() {
		return mBanDur;
	}
	public void setmBanDur(String mBanDur) {
		this.mBanDur = mBanDur;
	}
	public String getmPhoto() {
		return mPhoto;
	}
	public void setmPhoto(String mPhoto) {
		this.mPhoto = mPhoto;
	}
	public String getmLogoutTime() {
		return mLogoutTime;
	}
	public void setmLogoutTime(String mLogoutTime) {
		this.mLogoutTime = mLogoutTime;
	}
	public String getmResting() {
		return mResting;
	}
	public void setmResting(String mResting) {
		this.mResting = mResting;
	}
	public Integer getmDesTotalCnt() {
		return mDesTotalCnt;
	}
	public void setmDesTotalCnt(Integer mDesTotalCnt) {
		this.mDesTotalCnt = mDesTotalCnt;
	}
	public Integer getmOrderCnt() {
		return mOrderCnt;
	}
	public void setmOrderCnt(Integer mOrderCnt) {
		this.mOrderCnt = mOrderCnt;
	}
	
}