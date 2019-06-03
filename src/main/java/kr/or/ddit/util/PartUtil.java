package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PartUtil {

	/**
	* Method : getFileName
	* 작성자 : PC23
	* 변경이력 :
	* @param contentDisposition
	* @return
	* Method 설명 : contentDisposition에서 파일명을 반환한당
	*/
	
	private static final Logger logger = LoggerFactory
			.getLogger(PartUtil.class);
	public static String getFileName(String contentDisposition) {
//		form-data; name="profile"; filename="sally.png"
		String[] splited = contentDisposition.split("; ");
		for(String split : splited) {
			if(split.startsWith("filename=")){
//				logger.debug("split.indexOf : {}", split.indexOf("\""));
				int startIndex = split.indexOf("\"") +1;
				int lastIndex = split.lastIndexOf("\"");
				
				return split.substring(startIndex, lastIndex);
			}
		}

		return "";
	}
	
	
	/**
	* Method : getExt
	* 작성자 : PC23
	* 변경이력 :
	* @param fileName
	* @return
	* Method 설명 : 파일명으로부터 파일 확장자를 반환
	*/
	public static String getExt(String fileName) {
		String[] splited = fileName.split("\\.");
		
		if(splited.length == 1) {
			return "";
		} else {
			return splited[splited.length-1];
		}
		
		
	}

}
