package kr.or.ddit.user.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;
import java.util.Map;

import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.model.UserVo;

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
	
	private IuserService userService;

	@Test
	public void userListTest() {
		/***Given***/
		IuserService userService = new UserService();

		/***When***/
		List<UserVo> userList = userService.userList();

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
		UserVo userVo = userService.getUser(userId);

		/***Then***/
		assertNotNull(userVo);
		assertEquals("브라운", userVo.getName());
		logger.debug("userVo : {}", userVo);

	}
	
	@Test
	public void userPagingListTest(){
		/***Given***/
		PageVo pageVo = new PageVo(1,10);

		/***When***/
		Map<String, Object> resultMap = userService.userPagingList(pageVo);
		List<UserVo> userList = (List<UserVo>) resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		/***Then***/
		assertNotNull(userList);
		assertEquals(10, userList);
		assertEquals(11, paginationSize);

	}
	
	/**
	 * 
	* Method : usersCntTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : 사용자 전체수 조회 테스트
	 */
	
	@Test
	public void ceilTest(){
		/***Given***/
		int usersCnt = 105;
		int pageSize = 10;

		/***When***/
		double paginationSize = Math.ceil((double)usersCnt/pageSize);
		logger.debug("paginationSize : {}" , paginationSize);

		/***Then***/
		assertEquals(11, (int)paginationSize);

	}
	

}
