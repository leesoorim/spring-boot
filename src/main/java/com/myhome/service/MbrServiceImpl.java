package com.myhome.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.myhome.dto.MbrDto;
import com.myhome.mapper.MbrMapper;

@Service
public class MbrServiceImpl implements MbrService{
	
	@Autowired 
	MbrMapper mapper;

	@Override
	public int insertMbr(MbrDto dto) throws Exception {
		return mapper.insertMbr(dto);
	}

}
