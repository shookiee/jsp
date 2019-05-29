package kr.or.ddit.user.dao;

import java.util.List;

import kr.or.ddit.paging.model.PageVO;
import kr.or.ddit.user.model.UserVO;

public interface IUserDao {
	
	/** 
	* Method : userList
	* 작성자 : PC23
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 조회
	 */
	List<UserVO> userList();
	
	
	/**
	* 
	* Method : getUser
	* 작성자 : PC23
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 특정 사용자 조회
	 */
	UserVO getUser(String userId);
	
	
	/**
	 * 
	* Method : userPagingList
	* 작성자 : PC23
	* 변경이력 :
	* @param pageVO
	* @return
	* Method 설명 :사용자 페이징 리스트 조회
	 */
	List<UserVO> userPagingList(PageVO pageVO);


	
	/**
	 * 
	* Method : usersCnt
	* 작성자 : PC23
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 수 조회
	 */
	int usersCnt();
}
