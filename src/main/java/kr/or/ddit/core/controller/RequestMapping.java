package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.controller.MainController;
import kr.or.ddit.controller.UserListController;
import kr.or.ddit.db.model.DbVO;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IDbService;

public class RequestMapping {

	// /main.do -> MainController
	// /userList.do -> UserListController
//	private static Map<String, String> requestMappingClass;
	private static Map<String, Controller> requestMapping;
	
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);

	private static IDbService dbService = new DbService();
	
	
	static{
		List<DbVO> uriClassMappingList = dbService.uriList();
		
		
//		Map<String, String> requestMappingClass = new HashMap<String, String>();
//		requestMappingClass = requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
////		requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
		
		requestMapping = new HashMap<String, Controller>();
		
		for(DbVO dbVo : uriClassMappingList){
			
			// classInfo : "kr.or.ddit.controller.MainController"
			String classInfo = dbVo.getClassName();
			try {
				
				Class clazz = Class.forName(classInfo);		// classInfo에 해당하는 클래스가 없을 때
				Object obj = clazz.newInstance();
				requestMapping.put(dbVo.getUri(), (Controller)obj);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (InstantiationException | IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		
		
		
//		requestMapping.put("/main.do", new MainController());
//		requestMapping.put("/userList.do", new UserListController());
	}
	
	public static Controller getController(String uri) {
		logger.debug("getController : {}", uri);
		return requestMapping.get(uri);
	}

}
