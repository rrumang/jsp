package kr.or.ddit.util;

import static org.junit.Assert.*;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtilTest {

	/**
	 * 
	* Method : getCookieTest
	* 작성자 : PC08
	* 변경이력 :
	* Method 설명 : getCookie테스트
	 */
	@Test
	public void getCookieTest() {
		/***Given***/
		String cookieString = "rememberMe=true; userId=brown; test=testValue";
		CookieUtil.setCookieString(cookieString);

		/***When***/
//		String cookieValue = CookieUtil.getCookie("userId");
//		String cookieValue1 = CookieUtil.getCookie("rememberMe");
//		String cookieValue2 = CookieUtil.getCookie("test");
//		String cookieValue3 = CookieUtil.getCookie("test123123");
		String cookieValue4 = CookieUtil.getCookie("userI");

		/***Then***/
//		assertEquals("brown", cookieValue);
//		assertEquals("true", cookieValue1);
//		assertEquals("testValue", cookieValue2);
//		assertEquals("", cookieValue3);
		assertEquals("", cookieValue4);
	}

}
