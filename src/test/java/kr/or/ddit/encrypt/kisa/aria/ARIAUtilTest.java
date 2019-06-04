package kr.or.ddit.encrypt.kisa.aria;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;

import org.junit.AfterClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ARIAUtilTest {
private static final Logger logger = LoggerFactory
		.getLogger(ARIAUtilTest.class);

	@Test
	public void encryptTest() throws InvalidKeyException, UnsupportedEncodingException {
		/***Given***/
		String plainText = "brown1234";

		/***When***/
		// 평문을 암호화 시키고
		String encryptText = ARIAUtil.ariaEncrypt(plainText);
		logger.debug(encryptText);
		
		// 암호문을 복호화 시킨
		String decryptText = ARIAUtil.ariaDecrypt(encryptText);
				
		/***Then***/
		assertEquals(plainText, decryptText);
	}

}
