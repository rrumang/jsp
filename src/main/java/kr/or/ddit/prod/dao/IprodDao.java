package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.model.ProdVo;

public interface IprodDao {
	/**
	 * 
	* Method : prodList
	* 작성자 : PC08
	* 변경이력 :
	* @param lprod_lgu
	* @return
	* Method 설명 : prod_lgu에 해당하는 prod리스트 조회
	 */
	List<ProdVo> prodList(String prod_lgu);
}
