package kr.or.ddit.db.dao;

import java.util.List;

import kr.or.ddit.db.model.DbVo;

public interface IdbDao {
	/**
	 * 
	* Method : dbList
	* 작성자 : PC08
	* 변경이력 :
	* @return
	* Method 설명 : db리스트 조회
	 */
	List<DbVo> dbList();
}
