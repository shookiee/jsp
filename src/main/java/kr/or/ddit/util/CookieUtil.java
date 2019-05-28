package kr.or.ddit.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CookieUtil {
	
	private static final Logger logger = LoggerFactory
			.getLogger(CookieUtil.class);
	
	public static String cookieString;		// 분석할 쿠키 문자열
	
	/**
	* Method : setCookieString
	* 작성자 : PC23
	* 변경이력 :
	* @param cookieString
	* Method 설명 : 분석할 쿠키 문자열을 받는다
	*/
	public static void setCookieString(String cookieString){
		CookieUtil.cookieString = cookieString;
	}

	
	
	/**
	* Method : getCookie
	* 작성자 : PC23
	* 변경이력 :
	* @param cookie
	* @return
	* Method 설명 : 쿠키 문자열에서 특정 쿠키 값을 가져온다
	*/
	public static String getCookie(String cookie) {
		//"userId=brown; rememberme=true; test=testValue";
		// cookie = "userId"
		String[] cookieArray = CookieUtil.cookieString.split("; ");
		String cookieValue = "";
		//cookieName=cookieValue
		//cookieArray[0] = "userId=brown"
		//cookieArray[1] = "rememberme=true"
		//cookieArray[2] = "test=testValue"
		for(String str : cookieArray) {
			logger.debug("str : {}", str);
						
			//userId=brown
			//userI --> "", "brown"
			
			//"userId=brown".startsWtih("userId=")
			if(str.startsWith(cookie+"=")){
				String[] cookieStr = str.split("=");
				cookieValue = cookieStr[1];
				break;
			}
		}
		return cookieValue;
	}
	
//	public static String getCookie(String cookie) {
//		//"userId=brown; rememberme=true; test=testValue";
//		// cookie = "userId"
//		
//		String[] res = cookieString.split("; ");
//		//userId=brown
//		//rememberme=true
//		//test=testValue
//		String value = "";
//		for(int i = 0; i < res.length; i++) {
//			if(res[i].contains(cookie)){
//				int result = res[i].lastIndexOf("=");
//				value = res[i].substring(result+1);
//			}
//		}
//		
//		return value;
//		
//	}
	
	
}
