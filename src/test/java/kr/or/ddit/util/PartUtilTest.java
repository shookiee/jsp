package kr.or.ddit.util;

import static org.junit.Assert.*;

import java.text.SimpleDateFormat;
import java.util.UUID;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtilTest {
	private static final Logger logger = LoggerFactory
			.getLogger(PartUtilTest.class);
	
	@Test
	public void getFileNameTest() {
		/***Given***/
		String contentDisposition = "form-data; name=\"profile\"; filename=\"sally.png\"";
		
		/***When***/
		String fileName = PartUtil.getFileName(contentDisposition);
		
		/***Then***/
		assertEquals("sally.png", fileName);
	}

	@Test
	public void uuidTest(){
		/***Given***/
		
		/***When***/
//		809307ea-2b8c-469e-907b-c57c31b6f950
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
		assertEquals("png", ext3);

	}
	
	@Test
	public void splitTest(){
		/***Given***/
		String filename = "test";
		String filename2 = "test.png";

		/***When***/
		String[] splited = filename.split(".");
		String[] splited2 = filename2.split(".");
		
		/***Then***/
		assertEquals("png", splited2[1]);
	}
	
	@Test
	public void substringTest(){
		/***Given***/
		String yyyyMM = "201906";

		/***When***/
		String yyyy = yyyyMM.substring(0, 4);
		String mm = yyyyMM.substring(4, 6);
		
		/***Then***/
		assertEquals("2019", yyyy);
		assertEquals("06", mm);

	}
}
