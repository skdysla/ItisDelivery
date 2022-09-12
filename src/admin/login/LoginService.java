package admin.login;

import admin.common.CommonService;

public class LoginService {
	
	public LoginDTO loginProc(String tel, String name) {
		LoginDAO loginDao = new LoginDAO();
		LoginDTO loginDto = loginDao.selectTel(tel);
		
		if(loginDto != null && loginDto.getTel().equals(tel) && loginDto.getName().equals(name)) {
			return loginDto;
		}else {
			CommonService.msg("로그인 실패");
			return null;
		}
	}
	
}
