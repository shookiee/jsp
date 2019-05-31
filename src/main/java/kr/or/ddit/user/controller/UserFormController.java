package kr.or.ddit.user.controller;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

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


@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory
			.getLogger(UserFormController.class);
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
	
	
	// 사용자 등록 화면 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 등록 화면 요청
		request.getRequestDispatcher("user/userForm.jsp").forward(request, response);
	}

	
	
	// 사용자 등록 요청 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("userForm doPost()");
		request.setCharacterEncoding("UTF-8");
		
		// 사용자가 보낸 파라미터를 사용해서 UserVO 인스턴스를 만들어서
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String name = request.getParameter("name");
		String alias = request.getParameter("alias");
		String zipcd = request.getParameter("zipcd");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String birth = request.getParameter("birth");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//		sdf.parse(source);	// 문자를 날짜로 반환
//		sdf.format(date); 날짜를 문자열로 반환

		UserVO userVO = null;
		try {
			userVO = new UserVO(userId, name, alias, pass, addr1, addr2, zipcd, sdf.parse(birth));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		
		// 사용자가 입력한 userId가 이미 존재하는 userId인지 체크
		UserVO dbUser = userService.getUser(userId);
		// 등록된 사용자가 아닌 경우 --> 정상 입력이 가능한 상황
		if(dbUser == null) {
			int insertCnt = userService.insertUser(userVO);
			// 정상 등록 된 경우
			if(insertCnt == 1) {
				response.sendRedirect(request.getContextPath() + "/userPagingList");
			} else {
				
				
			}
			
		} else {	// 아이디가 중복 된 경우
			// redirect, foward
//			request.getRequestDispatcher("").forward(request, response);
			request.setAttribute("msg", "이미 존재하는 ID 입니다 :-(");
			doGet(request, response);
			
		}
		
		// 존재하지 않을 경우
		// 		userService 객체를 통해 insertUser(userVO);
		// 		정상적으로 입력이 된 경우
		//		사용자 페이징 리스트 1페이지로 이동
		// 		정상적으로 입력이 되지 않은 경우
		//		사용자 등록 페이지로 이동, 사용자가 입력한 값을 input에 넣어준다
		
		
		
		// 존재 할 경우
		//		사용자 등록 페이지로 이동, 사용자가 입력한 값을 input에 넣어준다
		//		이미 존재하는 userId 입니다(alert 또는 text로 표시)
	}

}
