package kr.or.ddit.core.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.controller.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

// localhost/userList.do --> init -> 
@WebServlet("*.do")
public class FrontController extends HttpServlet{
	
	private static final Logger logger = LoggerFactory
			.getLogger(FrontController.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		logger.debug("service : {}", req.getRequestURI());
		String uri = req.getRequestURI();
		
		Controller controller = RequestMapping.getController(uri);
		String viewName = controller.execute(req, resp);

		ViewResolver.viewResolve(viewName, req, resp);
		
		
//		if(uri.equals("/userList.do"))
//			new UserListController().execute(req, resp);
//		else if(uri.equals("/userCreate.do"))
//			new UserCreateController().execute(req, resp);
//		else if(uri.equals("/userModify.do"))
//			new UserModifyController().execute(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

	}
	
}
