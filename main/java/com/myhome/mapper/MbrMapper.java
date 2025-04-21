package com.myhome.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.myhome.dto.MbrDto;

@Mapper
public interface MbrMapper {

	int insertMbr(MbrDto dto);

	List<?> selectmbrList(MbrDto dto);

	int selectMbrTotal(MbrDto dto);

	MbrDto selecMbrDetail(String userid);

	int mbrDelete(String userid);

	int updateMbr(MbrDto dto);
}
