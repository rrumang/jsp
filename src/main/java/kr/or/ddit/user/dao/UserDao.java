package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IuserService;
import kr.or.ddit.user.service.UserService;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDao implements IuserDao {
	private static final Logger logger = LoggerFactory
			.getLogger(UserDao.class);
	
	@BeforeClass
	public static void beforeClass(){
		logger.debug("beforeClass");
	}
	
	private IuserService userService;
	
	@Before
	public void setup(){
		userService = new UserService();
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
	
	public static void main(String[] args) {
		
		/***Given***/
		IuserDao userDao = new UserDao();
		/***When***/
		List<UserVO> userList = userDao.userList();
		/***Then***/
		logger.debug("userList : {}", userList);
		
		
		/***Given***/
		String userId = "brown";
		/***When***/
		UserVO vo = userDao.getUser(userId);
		/***Then***/
		logger.debug("getUser : {}", vo);
	}
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	@Override
	public List<UserVO> userList() {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		List<UserVO> userList = sqlSession.selectList("user.userList");
		return userList;
	}

	/**
	 * 
	* Method : getUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자정보 조회
	 */
	@Override
	public UserVO getUser(String userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSession();
		UserVO vo = sqlSession.selectOne("user.getUser", userId);
		return vo;
	}

}
