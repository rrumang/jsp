package kr.or.ddit.user.service;

import static org.junit.Assert.*;

import java.util.List;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserServiceTest {
	
	// 사용자 전체리스트를 조회하는 메소드
	//1,메소드 인자가 필요한가? : 별다른 인자는 불필요
	//2. 리턴타립은 뭐가 될까? : List<UserVO>
	//3. 메소드 이름은 뭐가 적당하지? : userList
	
	private static final Logger logger = LoggerFactory
			.getLogger(UserServiceTest.class);

	@Test
	public void userListTest() {
		/***Given***/
		IuserService userService = new UserService();

		/***When***/
		List<UserVO> userList = userService.userList();

		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		
		logger.debug("userList : {}", userList);

	}
	
	@Test
	public void getUserTest(){
		/***Given***/
		IuserService userService = new UserService();
		String userId = "brown";
		
		/***When***/
		UserVO userVo = userService.getUser(userId);

		/***Then***/
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		logger.debug("userVo : {}", userVo);

	}

}
