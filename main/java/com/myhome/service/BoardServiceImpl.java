package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.dto.BoardDto;
import com.myhome.mapper.BoardMapper;

@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	BoardMapper mapper;
	
	/**
	 * 오버라이딩 (상속관계에서 부모클래스의 메소드를 재구성한다는 의미)
	 */
	@Override
	public List<?> selectBoardList(BoardDto dto) throws Exception {
		return mapper.selectBoardList(dto);
	}

}
