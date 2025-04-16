package com.myhome.service;

import com.myhome.dto.MbrDto;

public interface MbrService {

	// 회원저장처리
	int insertMbr(MbrDto dto) throws Exception;
	
}
