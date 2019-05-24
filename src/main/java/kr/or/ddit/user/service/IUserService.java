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
	
	
	/**
	* 
	* Method : getUser
	* 작성자 : PC23
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 사용자 정보 조회
	 */
	UserVO getUser(String userId);
}
