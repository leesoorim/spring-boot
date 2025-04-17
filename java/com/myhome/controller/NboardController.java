package com.myhome.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class NboardController {

	@GetMapping("boardWrite")
	public String boardWrite() {
		
		return "board/nboardWrite";
	}
	@PostMapping("boardInsert") 
	public String insertNboard() throws Exception {
		
		return "";
	}
	
}






