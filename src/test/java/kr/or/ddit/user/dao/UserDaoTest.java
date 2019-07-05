package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

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
		List<UserVo> userList = userDao.userList();
		
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
		UserVo userVo = userDao.getUser(userId);

		/***Then***/
		assertEquals("브라운", userVo.getName());

	}
	
	//사용자 페이징 리스트 조회
	//고려사항
	//몇번째 페이지 조회인지? 페이징 몇건씩 데이터를 보여줄건지 : 쿼리실행 파라미터
	//정렬순서 ? : 로직 --> 파라미터화 시킬수 있다. 
	//--> 우리는 사용자 아이디 순으로 정렬
	
	/**
	 * 
	* Method : userPagingListTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회 테스트
	 */
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		List<UserVo> userList = userDao.userPagingList(pageVo);
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList.size());

	}
	
	/**
	 * 
	* Method : usersCntTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	 */
	@Test
	public void usersCntTest(){
		/***Given***/
		

		/***When***/
		int userCnt = userDao.usersCnt();

		/***Then***/
		assertEquals(105, userCnt);

	}
	
	/**
	 * 
	* Method : insertUserTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트
	 */
	@Test
	public void insertUserTest() throws ParseException{
		/***Given***/
		//사용자정보를 담고있는 vo객체 준비
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVo userVo = new UserVo("대덕쓰", "userTest",  "중앙쓰", "userTest1234", "영민쓰", "204호", "34940", sdf.parse("2019-05-31"));

		/***When***/
		//userDao.insertUser()
		int insertCnt = userDao.insertUser(userVo);

		/***Then***/
		//insertCnt(1)
		assertEquals(1, insertCnt);
		
		//data삭제
		//useDao.deleteUser(userId);
		userDao.deleteUser(userVo.getUserId());
	}
	
	/**
	 * 
	* Method : updateUser
	* 작성자 : PC08
	* 변경이력 :
	* @param vo
	* @return
	* Method 설명 : 사용자 수정
	 */
	@Test
	public void updateUserTest() throws ParseException{
		/***Given***/
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		UserVo userVo = new UserVo("대덕쓰", "brown",  "중앙쓰", "userTest1234", "영민쓰", "204호", "34940", sdf.parse("2019-08-20"));

		/***When***/
		int updateCnt = userDao.updateUser(userVo);

		/***Then***/
		assertEquals(1, updateCnt);

	}
	
	
	
	
	
	
	
	
	
	
	
}
