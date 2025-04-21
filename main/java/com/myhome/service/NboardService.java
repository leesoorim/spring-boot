package com.myhome.service;

import java.util.List;

import com.myhome.dto.DefaultDto;
import com.myhome.dto.NboardDto;

public interface NboardService {

	/**
	 * (게시판)저장처리
	 * insert ,update,delete => 저장건수 리턴해줌
	 */
	int insertNboard(NboardDto dto) throws Exception;
	
	/**
	 * (게시판) 목록
	 */
	List<?> selectNboardList(DefaultDto defaultDto) throws Exception;

	/**
	 * (게시판) 총 데이터 개수
	 */
	int selectNboardTotal(DefaultDto defaultDto) throws Exception;
	
	/**
	 * (게시판) 상세보기
	 */
	
	NboardDto selectNboardDetail(int seqid) throws Exception;
}
