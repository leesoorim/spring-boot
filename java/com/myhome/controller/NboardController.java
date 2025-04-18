package com.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;
import com.myhome.service.NboardService;

@Controller
public class NboardController {

	@Autowired
	NboardService nboardService;

	@GetMapping("nboardWrite")
	public String boardWrite() {
		return "board/nboardWrite";
	}
	
	@PostMapping("nboardInsert") 
	// @ResponseBody :: return 값을 일반 jsp 경로가 아닌 일반 텍스트로 인식
	@ResponseBody
	public String insertNboard(NboardDto dto) throws Exception {
		
		String message = "ok";
		// 저장서비스 실행
		int result = nboardService.insertNboard(dto);
		if( result == 0 ) message = "fail";
	
		return message;
	}
	
	@GetMapping("nboardList")
	public String selectNboardList(  DefaultDto defaultDto
									,ModelMap model) 
												throws Exception {
		
		int total = nboardService.selectNboardTotal(defaultDto);
		defaultDto.setTotal(total);

		defaultDto.setTotalPage();
		int totalPage  = defaultDto.getTotalPage();

		// 출력 페이지 시작 행번호
		defaultDto.setPageRownum();
		int pageRownum = defaultDto.getPageRownum();

		// SQL에 적용할 시작번호
		defaultDto.setFirstIndex();
		
		// SQL에 적용할 종료번호
		defaultDto.setLastIndex();

		List<?> list = nboardService.selectNboardList(defaultDto);
		model.addAttribute("resultList", list);
		model.addAttribute("total", total);
		
		model.addAttribute("totalPage", totalPage);
		model.addAttribute("pageRownum", pageRownum);

		return "board/nboardList";
	}

}

