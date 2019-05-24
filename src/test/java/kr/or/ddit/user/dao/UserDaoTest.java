package kr.or.ddit.user.dao;

import static org.junit.Assert.assertEquals;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.Logger;

public class UserDaoTest {
	private static final Logger logger = (Logger) LoggerFactory
			.getLogger(UserDaoTest.class);
	
	//junit 실행순서
	//@BeforeClass가 적용된 메소드가 1회 실행된다
	
	//다음 구간은 @Test가 적용된 모든 메소드에 대해 반복 적용
	//@BeforeClass가 적용된 메소드 실행
	//@Test가 적용된 메소드가 실행
	//@Atter가 적용된 메소드가 실행
	
	//@AfterClass가 적용된 메소드가 1회 실행
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	private IuserDao userDao;
	
	@Before
	public void setup(){
		userDao = new UserDao();
		logger.debug("setup");
	}
	
	@After
	public void teardown(){
		logger.debug("teardown");
	}
	
	@AfterClass
	public static void afterClass(){
		logger.debug("afterClass");
	}
	
	
	/**
	 * 
	* Method : userListTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 전체 조회 테스트
	 */
	@Test
	public void userListTest() {
		/***Given***/
		/***When***/
		List<UserVO> userList = userDao.userList();
		
		/***Then***/
		assertEquals("brown", userList.get(0).getUserId());
		assertEquals(105, userList.size());
		
		logger.debug("userList : {}",userList);
	}
	
	@Test
	public void getUserTest(){
		/***Given***/
		String userId = "brown";
		
		/***When***/
		UserVO userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getName());

	}
}
