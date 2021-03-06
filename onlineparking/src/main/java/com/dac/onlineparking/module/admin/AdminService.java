package com.dac.onlineparking.module.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dac.onlineparking.module.user.CityAreaVO;

@Service
public class AdminService {
	@Autowired
	private AdminDAO adminDAO;

	public List<CityVO> selectCity() {
		return adminDAO.selectCity();
	}

	public boolean register(RegisterVO vo) {
		int status = adminDAO.register(vo);
		boolean flag = false;
		if (status == 1) {
			int id = adminDAO.getGenerartedKey(vo.getEmail());
			if (id > 1) {
				int walletStatus = adminDAO.createUserWolet(id);
				if (walletStatus == 1) {
					if (status == 0) {
						flag = false;
					} else {
						flag = true;
					}
				}
			}
		} else {
			flag = false;
		}
		return flag;

	}// method

}
