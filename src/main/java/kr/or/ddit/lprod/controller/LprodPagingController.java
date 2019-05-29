package kr.or.ddit.lprod.controller;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodServiceImpl;
import kr.or.ddit.paging.model.PageVO;

/**
 * Servlet implementation class LprodPagingList
 */
@WebServlet("/lprodPagingList")
public class LprodPagingController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	private ILprodService lprodService;

	@Override
	public void init(ServletConfig config) throws ServletException{
		lprodService = new LprodServiceImpl();
	}
	
		
	private static final Logger logger = LoggerFactory
			.getLogger(LprodPagingController.class);
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String pageString = request.getParameter("page");
		String pageSizeString = request.getParameter("pageSize");
		
		logger.debug("pageString : {}", pageString);
		logger.debug("pageSizeString : {}", pageSizeString);
		
		int page = pageString == null ? 1 : Integer.parseInt(pageString);
		int pageSize = pageSizeString == null ? 5 : Integer.parseInt(pageSizeString);

		logger.debug("page : {}", page);
		logger.debug("pageSize : {}", pageSize);
		
		
		PageVO pageVO = new PageVO(page, pageSize);
		logger.debug("pageVo : {}", pageVO);
		
		Map<String, Object> resultMap = lprodService.lprodPagingList(pageVO);
		
		List<LprodVO> lprodList = (List<LprodVO>)resultMap.get("lprodList");
		int paginationSize = (Integer)resultMap.get("paginationSize");
		
		request.setAttribute("lprodList", lprodList);
		request.setAttribute("paginationSize", paginationSize);
		request.setAttribute("pageVO", pageVO);
		
		request.getRequestDispatcher("/lprod/lprodPagingList.jsp").forward(request, response);
		
	}

}
