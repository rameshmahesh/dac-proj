package com.dac.onlineparking.module.login;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginService {
	@Autowired
	private LoginDAO loginDAO;

	public LoginStatusVO login(String userName, String password) throws Exception {
		LoginVO vo = loginDAO.login(userName, password);
		LoginStatusVO loginStatusVO = new LoginStatusVO();
		if (vo != null) {
			loginStatusVO.setStatus(true);
			loginStatusVO.setMessage("Login succedd");
			loginStatusVO.setLoginVO(vo);
		} else {
			loginStatusVO.setStatus(false);
			loginStatusVO.setMessage("Login faild");

		}
		return loginStatusVO;
	}

}