package com.myhome.service;

import java.util.List;

import com.myhome.dto.BoardDto;
/**
 * 명세처리 (만들어야 되는 프로그램(메소드)의 목록)
 */
public interface BoardService {
	
	/**
	 * 게시판 목록
	 * @param dto
	 * @return List<?>
	 * @throws Exception
	 */
	public List<?> selectBoardList(BoardDto dto)throws Exception;	
	
	/**
	 * 게시판 입력처리
	 */
	public int insertBoard(BoardDto dto) throws Exception; 
	/**
	 * 게시판 수정처리
	 */
	public int updateBoard(BoardDto dto) throws Exception;
	
	/**
	 * 게시판 삭제처리 ( 암호도 보내고 여러가지 확인해야되면 BoardDto로 )
	 */
	public int deleteBoard(int seqid) throws Exception;
	
	/**
	 * 게시판 상세출력
	 */
	// 상세보기 (한 건 출력)
	public BoardDto selectBoardDetail(int seqid) throws Exception;
	
	/**
	 * 게시판 조회수 증가 ( update nboard set hits=hits+1 where seqid=12)
	 */
	public void updateBoardHits(int seqid) throws Exception; // 따로 결과값 1이런 거 굳이 안받아도 돼서 void
	
	

}
