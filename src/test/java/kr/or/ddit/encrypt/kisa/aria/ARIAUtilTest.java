package kr.or.ddit.encrypt.kisa.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARIAUtilTest {
	private static final Logger logger = LoggerFactory
			.getLogger(ARIAUtilTest.class);
	@Test
	public void encrypttest() throws InvalidKeyException, UnsupportedEncodingException {
		/***Given***/
		String plainText = "brown123";

		/***When***/
		//평문을 암호화
		String ecncryptText = ARIAUtil.ariaEncrypt(plainText);
		logger.debug("ecncryptText : {}",ecncryptText );
		//brown1234 : ED4024DC5EB54D47E7041B4FA0A34F3D
		//brown123  : EC957ACAE6C6ADB3A704EC3F4F00DBEE
		
		//암호문을 복호화
		String decryptText = ARIAUtil.ariaDecrypt(ecncryptText);

		/***Then***/
		assertEquals(plainText, decryptText);

	}

}
