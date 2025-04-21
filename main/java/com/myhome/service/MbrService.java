package com.myhome.service;

import java.util.List;

import com.myhome.dto.MbrDto;

public interface MbrService {

	// 회원저장처리
	int insertMbr(MbrDto dto) throws Exception;
	
	// 삭제처리
	int mbrDelete(String userid) throws Exception;
	
	// 수정처리
	int updateMbr(MbrDto dto)throws Exception;
	
	// 회원목록 - 검색(확장을 위해 () 비워둬도 리스트는 뜨지만 검색기능 사용을 위해 디티오담기)
	List<?> selectmbrList(MbrDto dto) throws Exception;
	
	// Total 건수
	int selectMbrTotal(MbrDto dto) throws Exception;
	
	// 상세보기
	MbrDto selectMbrDetail(String userid) throws Exception;
	
	
	
}
