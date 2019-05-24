package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface IuserDao {
	/**
	 * 
	* Method : userList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	List<UserVO> userList();
	
	/**
	 * 
	* Method : getUser
	* 작성자 : PC08
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자정보 조회
	 */
	UserVO getUser(String userId);
}
