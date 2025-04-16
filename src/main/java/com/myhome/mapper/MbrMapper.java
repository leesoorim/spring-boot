package com.myhome.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.dto.MbrDto;

@Mapper
public interface MbrMapper {

	int insertMbr(MbrDto dto);

}
