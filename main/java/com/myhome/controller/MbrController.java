package com.myhome.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
		
		return "redirect:/mbrList";		
	}
	
	@GetMapping("mbrList")
	public String selectmbrList(MbrDto dto, ModelMap model) throws Exception {
		
		int total = mbrservice.selectMbrTotal(dto);
		int pageRownum = total;
		
		List<?> list = mbrservice.selectmbrList(dto);
		model.addAttribute("resultList",list);
		model.addAttribute("total",total);
		model.addAttribute("pageRownum",pageRownum);
		
		// System.out.println(list);
		
		return "member/mbrList";
	}
	
	@GetMapping("mbrDetail/{userid}")
	public String selectMbrDetail(@PathVariable String userid,ModelMap model) throws Exception{
		
		MbrDto dto = mbrservice.selectMbrDetail(userid);
		model.addAttribute("dto",dto);
		
		System.out.println(userid);
		
		return "member/mbrDetail";
	}
	
	@GetMapping("mbrModify/{userid}")
	public String selectMbrModify(@PathVariable String userid, ModelMap model ) throws Exception {
		MbrDto dto = mbrservice.selectMbrDetail(userid);
		model.addAttribute("dto",dto);
		return "member/mbrModify";
	}
	
	@GetMapping("mbrDelete/{userid}")
	public String mbrDelete(@PathVariable String userid) throws Exception{
		
		mbrservice.mbrDelete(userid);		
		
		return "redirect:/mbrList";
	}
	
	@PostMapping("mbrUpdate")
	public String updateMbr(MbrDto dto) throws Exception{
		int cnt = mbrservice.updateMbr(dto);
		
		if(cnt==1) {
			System.out.println("저장완료");
		}else {
			System.out.println("저장실패");
		}
		
		return "redirect:/mbrList";
	}
	

	
	
	
	
	
	
	
}
