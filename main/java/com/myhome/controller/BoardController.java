package com.myhome.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import com.myhome.dto.BoardDto;
import com.myhome.service.BoardService;

import jakarta.annotation.Resource;

/**
 * Controller 어노테이션
 *  웹주소와의 맵핑의 역할을 하게끔 하는 세팅
 */
					
@Controller
public class BoardController {
	
	@Resource
	BoardService boardService;

	/**
	 * 웹 주소를 매핑해주는 역할 (Get방식으로 접근) 
	 */
	@GetMapping("b/write")
	public ModelAndView boardWrite(ModelAndView mav) {
		
		mav.setViewName("board/boardWrite");
		return mav;
	}
	
	@GetMapping("b/list")
	public String boardList(BoardDto dto) throws Exception {
		
		List<?> list = boardService.selectBoardList(dto);
		
		System.out.println("list : "+ list);
		
		return "board/boardList";
	}
	
	
}
	