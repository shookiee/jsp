package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@WebServlet("/jsp/mulCalculation")
public class MulCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private static final Logger logger = LoggerFactory
			.getLogger(MulCalculation.class);
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int param1 = Integer.parseInt(request.getParameter("param1"));
		int param2 = Integer.parseInt(request.getParameter("param2"));
		
		int result = param1 * param2;
		
		logger.debug("result : {}", result);

		HttpSession session = request.getSession();
		session.setAttribute("mulResult", param1 + " * " + param2 + " = " + result);
		
		request.getRequestDispatcher("/jsp/mulResult.jsp").forward(request, response);
		
	}

}
