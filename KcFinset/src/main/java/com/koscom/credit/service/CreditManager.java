package com.koscom.credit.service;

import java.util.HashMap;
import java.util.List;

import com.koscom.domain.CreditInfo;

public interface CreditManager {

	/**
	 * 신용관리 메인_기본정보
	 * @param no_person
	 * @return CreditInfo
	 */
	CreditInfo getCreditMainBaseInfo(String no_person);

	/**
	 * 신용관리 메인_건수정보
	 * @param no_person
	 * @return CreditInfo
	 */
	CreditInfo getCreditMainCntInfo(String no_person);
	
	/**
	 * Method Desc : kcb전문 송수신 이력조회 
	 * 2018.08.31
	 * @param	HashMap<String, String> searchMap
	 * @return	HashMap<String, String>
	 */
	HashMap<String, String> getKcbInfoCLOB(HashMap<String, String> searchMap);
	
	/**
	 * 신용관리_신용등급상세
	 * @param no_person, creditInfo
	 * @return
	 */
	List<CreditInfo> getCreditDetailGradeChartList(String no_person);
	List<CreditInfo> getCreditDetailGradeInquiryList(String no_person);
	List<CreditInfo> getCreditDetailGradeChangeList(CreditInfo creditInfo);
}