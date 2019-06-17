package kr.or.ddit.core.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.controller.Controller;
import kr.or.ddit.db.model.DbVo;
import kr.or.ddit.db.service.DbService;
import kr.or.ddit.db.service.IdbService;

public class RequestMapping {
	private static final Logger logger = LoggerFactory
			.getLogger(RequestMapping.class);
	
	// /mian.do --> MainController
	// /userList.do --> UserListController
	
	//private static Map<String, String> requestMappingClass;
	private static Map<String, Controller> requestMapping;
	
	private static IdbService dbService = new DbService();
	
	static{
		List<DbVo> urlClassMappingList = dbService.dbList();
		
		//requestMappingClass = new HashMap<String, String>();
		//requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
		//requestMappingClass.put("/main.do", "kr.or.ddit.controller.MainController");
		
		requestMapping = new HashMap<String, Controller>();
		
//		for (int i = 0; i < urlClassMappingList.size(); i++) {
//			String classInfo = urlClassMappingList.get(i).getClassname();
//			String key = urlClassMappingList.get(i).getUri();
//			try {
//				Class clazz = Class.forName(classInfo);
//				Object obj = clazz.newInstance();
//				requestMapping.put(key, (Controller)obj);
//				
//			} catch (InstantiationException | IllegalAccessException e) {
//					e.printStackTrace();
//			} catch (ClassNotFoundException e) {
//				e.printStackTrace();
//			}
//			
//		}
		
		for( DbVo dbVo : urlClassMappingList){
			// classInfo : "kr.or.ddit.controller.MainController"
			String classInfo = dbVo.getClassname();
			try {
				Class clazz = Class.forName(classInfo);
				Object obj = clazz.newInstance();
				requestMapping.put(dbVo.getUri(), (Controller)obj);
				
			} catch (InstantiationException | IllegalAccessException e) {
					e.printStackTrace();
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		
//		requestMapping.put("/main.do", new MainController());
//		requestMapping.put("/userList.do", new UserListController());
	}
	
	public static Controller getController(String uri) {
		logger.debug("getContrller : {}", uri);
		return requestMapping.get(uri);
	}

}
