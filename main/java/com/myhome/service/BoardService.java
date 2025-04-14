package com.myhome.service;

import java.util.List;

import com.myhome.dto.BoardDto;
/**
 * 명세처리 (만들어야 되는 프로그램(메소드)의 목록)
 */
public interface BoardService {
	
	public List<?> selectBoardList(BoardDto dto)throws Exception;

}
