package com.dac.onlineparking.module.admin;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.dac.onlineparking.util.UserQuery;

@Repository
public class AdminDAO {
	private final Logger log = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private JdbcTemplate jdbcTemplate;

	/**
	 * @param no param
	 * @return cityVOs
	 * @throws Exception
	 * @author Anil D. Ingle 0
	 * 
	 */
	public List<CityVO> selectCity() {

		List<CityVO> cityVOs = null;
		try {
			cityVOs = jdbcTemplate.query(UserQuery.SELECT_USER_CITY, (ResultSet rs) -> {
				List<CityVO> cityVOs1 = new ArrayList<CityVO>();
				while (rs.next()) {
					CityVO cityVO = new CityVO();
					cityVO.setCityId(rs.getInt("city_id"));
					cityVO.setCityName(rs.getString("city_name"));
					cityVOs1.add(cityVO);
				} // while
				return cityVOs1;
			}// extractData(-)
			);
		} catch (Exception e) {
			log.error("An error occurred while Fetching City . Please contact the Support Team.", e);
			throw e;
		}
		return cityVOs;
	}

	/**
	 * @param Object RegisterVO
	 * @return cityVOs
	 * @throws Exception
	 * @author Anil D. Ingle
	 */

	public int register(RegisterVO vo) {
		try {
			return jdbcTemplate.update(UserQuery.REGISTER_USER, vo.getfName(), vo.getlName(), vo.getEmail(),
					vo.getMobileNumber(), vo.getCurrentTime(), vo.getDob(), vo.getCityId(), vo.getPass(),
					vo.getGender(), 1);
		} catch (Exception e) {
			log.error("An error occurred while Register new User. Please contact the Support Team.", e);
			throw e;
		}
	}

	public int createUserWolet(int count) {
		try {
			return jdbcTemplate.update(UserQuery.CREATE_USER_WOLET, 10000, count);
		} catch (Exception e) {
			log.error("An error occurred while Create New Wallet. Please contact the Support Team.", e);
			throw e;
		}
	}

	public Integer getGenerartedKey(String email) {
		List<Integer> list = null;
		try {
			// execute the query
			list = jdbcTemplate.query("select id from user_info where email=?", (ResultSet rs) -> {
				List<Integer> wList = new ArrayList<Integer>();
				while (rs.next()) {
					wList.add(rs.getInt("id"));
				} // while
				return wList;
			}// extractData(-)
					, email);
		} catch (Exception e) {
			log.error("An error occurred while getGenerartedKey. Please contact the Support Team.", e);
			throw e;
		}
		if (list.size() == 1) {
			return list.get(0);
		} else
			return null;
	}

}
