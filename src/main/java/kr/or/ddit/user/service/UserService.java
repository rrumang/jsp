package kr.or.ddit.user.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.mybatis.MyBatisUtil;
import kr.or.ddit.paging.model.PageVo;
import kr.or.ddit.user.dao.IuserDao;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.model.UserVo;

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
	public List<UserVo> userList() {
		//db에서 데이터를 조회했다고 사정
		List<UserVo> userList = new ArrayList<UserVo>();
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
	public UserVo getUser(String userId) {
		UserVo userVo = new UserVo();
		userVo = dao.getUser(userId);
		return userVo;
	}
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC08
	* 변경이력 :
	* @param pageVo
	* @return
	* Method 설명 : 사용자 페이징 리스트 조회
	 */
	@Override
	public Map<String, Object> userPagingList(PageVo pageVo) {
		//1. List<UserVo>, userCnt를 필드로 하는 vo
		//2. List<Object> resultList = new ArrayList<Object>();
		//resultList.add(userList);
		//resultList.add(usersCnt);
		//3.Map<String, Object> resultMap = new HashMap<String, Object>();
		//resultMap.put("userList", userList);
		//resultMap.put("usersCnt", usersCnt)
		
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("userList", dao.userPagingList(pageVo));
		// usersCnt ==> paginationSize로 변경
		//resultMap.put("usersCnt", dao.usersCnt());
		int usersCnt = dao.usersCnt();
		//pageSize ==> pageVo.getPageSize();
		
		int paginationSize = (int)Math.ceil((double)usersCnt/pageVo.getPageSize());
		resultMap.put("paginationSize", paginationSize);
		
		return resultMap;
	}
	
}
