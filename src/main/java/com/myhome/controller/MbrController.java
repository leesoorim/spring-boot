package com.myhome.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.myhome.dto.MbrDto;
import com.myhome.service.MbrService;

@Controller
public class MbrController {
	
	@Autowired
	MbrService mbrservice;

	@GetMapping("mbrWrite")
	public String mbrWrite() {
		return "member/mbrWrite";
	}
	
	@PostMapping("mbrInsert")
	public String insertMbr(MbrDto dto) throws Exception{
		
		System.out.println("userid : "+ dto.getUserid());
		System.out.println("pass : "+ dto.getPass());
		// 서비스 실행
		int cnt = mbrservice.insertMbr(dto);
		
		if(cnt==1) {
			System.out.println("저장완료");
		}else {
			System.out.println("저장실패");
		}
		
		return "";
		
	}
	
}
