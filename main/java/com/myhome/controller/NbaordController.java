package com.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;
import com.myhome.service.NboardService;

@Controller
public class NbaordController {
	
	@Autowired
	NboardService nboardservice;
	
	@GetMapping("nboardWrite")
	public String boardWrite() {
		
		return "board/nboardWrite";
	}
	
	@PostMapping("nboardInsert")
	// return 값을 일반 jsp 경로가 아닌 일반 텍스트로 인식
	@ResponseBody
	public String insertNboard(NboardDto dto) throws Exception{
		
		String message = "ok";
		// 저장서비스 실행
		int result = nboardservice.insertNboard(dto);
		if(result == 0) message="fail";

		return message;
	}
	
	@GetMapping("nboardList")
	public String selectNboardList(DefaultDto defaultDto,ModelMap model) throws Exception{
		
	
		
		// 총 데이터 개수
		int total = nboardservice.selectNboardTotal(defaultDto);
		// 연산처리를 위해 dto에 값을 세팅(보냄)
		defaultDto.setTotal(total);
	
		// 총 페이지 개수를 계산 시키는 장면
		defaultDto.setTotalPage();
		// 계산후 결과를 얻어옴
		int totalPage = defaultDto.getTotalPage();
		
	
		
		// 1페이지 67 2페이지 57 3페이지 47 3페이지는 토탈에서 20빼기 이런식의 계산
		// 출력 페이지 시작 번호를 계산 시키는 장면
		defaultDto.setPageRownum();
		// 계산 후 결과를 얻어옴
		int pageRownum = defaultDto.getPageRownum();
		
		// SQL에 적용할 시작번호
		// 시작 번호의 계산 후 관련 변수에 값을 넣어준다
		defaultDto.setFirstIndex();
		
		// SQL에 적용할 종료번호
		defaultDto.setLastIndex();
		
		List<?> list = nboardservice.selectNboardList(defaultDto);
		model.addAttribute("resultList",list);
		model.addAttribute("total",total);
		model.addAttribute("pageRownum",pageRownum);
		model.addAttribute("totalPage",totalPage);
		
		return "board/nboardList";
	}
	
	@GetMapping("nboardDetail/{seqid}")
	public String selectNboardDetail(@PathVariable int seqid,ModelMap model) throws Exception{
		
		NboardDto dto = nboardservice.selectNboardDetail(seqid);
		System.out.println("제목 :"+ dto.getTitle());
		
		model.addAttribute("dto",dto);
		
		return "board/nboardDetail";
	}

}
