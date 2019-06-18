package kr.or.ddit.user.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.user.model.UserVO;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;


@WebServlet("/profile")
public class ProfileController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private IUserService service;
	
	@Override
	public void init() throws ServletException {
		service = new UserService();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 사용자 아이디를 파라미터로부터 확인
		String userId = request.getParameter("userId");
		
		// 사용자 정보(path)를 조회
		UserVO userVO = service.getUser(userId);
		
		// path정보로 file을 읽어들여서 
		ServletOutputStream sos = response.getOutputStream();
		FileInputStream fis = null;
		String filePath = null;		
		
		// 사용자가 업로드한 파일이 존재할 경우 : path
		if(userVO.getPath() != null) {
			filePath = userVO.getPath();
		} else { // 사용자가 업로드한 파일이 존재하지 않을 경우 : no_image.gif
			// webapp/img/no_image.gif
			filePath = getServletContext().getRealPath("/img/no_image.gif");
			
		}
		
		File file = new File(filePath);
		fis = new FileInputStream(file);
		
		int len = 0;
		byte[] buffer = new byte[512];
		
		// response 객체에 스트림으로 써준다
		while((len=fis.read(buffer, 0, 512)) != -1){
			sos.write(buffer);
		}
		
		fis.close();
		sos.close();
		
		
	}

}