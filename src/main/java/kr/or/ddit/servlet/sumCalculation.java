package kr.or.ddit.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private static final Logger logger = LoggerFactory
			.getLogger(sumCalculation.class);

	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		
		int start = Integer.parseInt(request.getParameter("start"));
		int end = Integer.parseInt(request.getParameter("end"));

		int sum = 0;

		for (int i = start + 1; i < end; i++) {
			sum += i;
		}
	
		logger.debug("sum : {}", sum );
		
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", "start : " + start +"<br> end : " + end + "<br> result : " + sum);
		
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request,
				response);
	}

}
