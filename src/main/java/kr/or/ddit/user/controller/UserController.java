package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;


@WebServlet("/user")
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	IUserService service;
	
	@Override
	public void init() throws ServletException {
		service = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 아이디를 request 객체로부터 파라미터 획득
		String userId = request.getParameter("userId");
		
		// 사용자 아이디로 사용자 정보를 조회
		UserVO userVO = service.getUser(userId);
		if (userVO.getBirth() != null) {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String birthStr = sdf.format(userVO.getBirth());
			request.setAttribute("birthStr", birthStr);
		}
		
		// 조회 결과를 request 객체에 속성으로 저장
//		request.getSession().setAttribute("USER_INFO", userVO);
		request.getSession().setAttribute("userVo", userVO);
		
		// 화면을 담당하는 /user/user.jsp로 forward
		request.getRequestDispatcher("/user/user.jsp").forward(request, response);
		
	}


}
