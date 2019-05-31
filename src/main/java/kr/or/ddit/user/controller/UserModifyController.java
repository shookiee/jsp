package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/userModify")
public class UserModifyController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static final Logger logger = LoggerFactory
			.getLogger(UserModifyController.class);

	private IUserService service;
	
	@Override
	public void init() throws ServletException {
		service = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userModify doGet()");
		request.getRequestDispatcher("/user/userModify.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userModify doPost()");
		request.setCharacterEncoding("UTF-8");
		String userId = ((UserVO)request.getSession().getAttribute("userVo")).getUserId();
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String zipcd = request.getParameter("zipcd");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String birth = request.getParameter("birth");
		
		
		logger.debug("userId : {}", userId);
		logger.debug("name : {}", name);
		logger.debug("birth : {}", birth);
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		
		UserVO userVo = service.getUser(userId);
		logger.debug("userVo.birth : {}", userVo.getBirth());
		if (userVo.getBirth() != null) {
			String birthStr = sdf.format(userVo.getBirth());
			request.setAttribute("birthStr", birthStr);
			logger.debug("birthstr : {}", birthStr);
		}
		
		UserVO userVO = null;
		
		try {
			userVO = new UserVO(name, userId, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		int updateCnt = service.updateUser(userVO);
		logger.debug("updateCnt : {}", updateCnt);
		// 정상 등록 된 경우
		if(updateCnt == 1) {
			response.sendRedirect(request.getContextPath() + "/userPagingList");
		}
		
		
	}

}
