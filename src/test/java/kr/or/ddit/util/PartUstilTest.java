package kr.or.ddit.util;

import static org.junit.Assert.*;

import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUstilTest {
	private static final Logger logger = LoggerFactory
			.getLogger(PartUstilTest.class);

	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"sally.png\"";

		/***When***/
		PartUtil partUtil = new PartUtil();
		String j = partUtil.getFileName(contentDisposition);

		/***Then***/
		assertEquals("sally.png", j);

	}
	
	//uuid test
	@Test
	public void uuidTest(){
		/***Given***/
		

		/***When***/
		//511b05e3-b2a5-4b93-ae04-ff1ff475429e
		logger.debug("UUID.randomUUID().toString() : {}", UUID.randomUUID().toString());

		/***Then***/

	}
	
	@Test
	public void getExtTest(){
		/***Given***/
		String filename = "sally.png";
		String filename2 = "sally.picture.png";
		String filename3 = "sally";

		/***When***/
		String ext = PartUtil.getExt(filename);
		String ext2 = PartUtil.getExt(filename2);
		String ext3 = PartUtil.getExt(filename3);

		/***Then***/
		assertEquals("png", ext);
		assertEquals("png", ext2);
		assertEquals("", ext3);
		

	}
	
	@Test
	public void substringTest(){
		/***Given***/
		String yyyyMM = "201906"; 
		

		/***When***/
		String yyyy = yyyyMM.substring(0,4);
		String mm = yyyyMM.substring(4,6);

		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);

	}

}
