package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVO;

public class UserService implements IuserService{
	private IuserDao dao;
	
	public UserService(){
		dao = new UserDao();
	}
	/**
	 * 
	* Method : userList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	 */
	@Override
	public List<UserVO> userList() {
		//db에서 데이터를 조회했다고 사정
		List<UserVO> userList = new ArrayList<UserVO>();
		userList = dao.userList();
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
		UserVO userVo = new UserVO();
		userVo = dao.getUser(userId);
		return userVo;
	}
	
}
