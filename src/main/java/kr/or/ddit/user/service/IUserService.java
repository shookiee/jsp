package kr.or.ddit.user.service;

import java.util.List;

import kr.or.ddit.user.model.UserVO;

public interface IUserService {
	
	/**
	 * 
	* Method : userList
	* 작성자 : PC23
	* 변경이력 :
	* @return
	* Method 설명 :
	 */
	List<UserVO> userList();
}
