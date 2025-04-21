package com.myhome.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;
import com.myhome.mapper.NboardMapper;
/* 객체지향 4대 요소 : 상속, 다형성, 캡슐화, 추상화 */

@Service
public class NboardServicImpl implements NboardService{
	
	@Autowired
	NboardMapper mapper;

	@Override
	public int insertNboard(NboardDto dto) throws Exception {
		return  mapper.insertNboard(dto);
	}

	@Override
	public List<?> selectNboardList(DefaultDto defaultDto) throws Exception {
		return mapper.selectNboardList(defaultDto);
	}

	@Override
	public int selectNboardTotal(DefaultDto defaultDto) throws Exception{
		return mapper.selectNboardTotal(defaultDto);
	}

	@Override
	public NboardDto selectNboardDetail(int seqid) {
		return mapper.selectNboardDetail(seqid);
	}

}
