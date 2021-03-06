package com.koscom.scrap.service;

import java.util.List;
import java.util.Map;

import com.koscom.scrap.model.FcLinkInfoVO;
import com.koscom.scrap.model.LinkedFcInfoVO;
import com.koscom.scrap.model.ScrBankApiAnInfoVO;
import com.koscom.scrap.model.ScrCardApprovalInfoVO;
import com.koscom.scrap.model.ScrCardInfoVO;
import com.koscom.scrap.model.ScrReqBankVO;
import com.koscom.scrap.model.ScrReqCardVO;
import com.koscom.scrap.model.ScrReqCertificationVO;
import com.koscom.scrap.model.ScrReqHealthVO;
import com.koscom.scrap.model.ScrReqPensionVO;
import com.koscom.scrap.model.ScrRespCashReceiptVO;
import com.koscom.scrap.model.ScrRespHealthPaymentVO;
import com.koscom.scrap.model.ScrRespHealthPaymentdtlVO;
import com.koscom.scrap.model.ScrRespIncomeDtlVO;
import com.koscom.scrap.model.ScrRespPensionPaymentVO;
import com.koscom.scrap.model.ScrRespPensionPaymentdtlVO;
import com.koscom.scrap.model.ScrRsltScrapVO;
import com.koscom.scrap.model.sub.AnAllListHistoryVO;
import com.koscom.scrap.model.sub.DepositAnListHistoryVO;
import com.koscom.util.ReturnClass;

public interface ScrapManager {

	/**
	 * 금융사 스크랩핑 연동 정보 여부 insert
	 * @param String
	 * @return String
	 */
	String createScrapFcList(String data);
	
	/**
	 * 금융사 스크랩핑 연동 정보 여부 update
	 * @param String
	 * @return String
	 */
	String updateScrapFcList(String data);
	
	/**
	 * 스크래핑 연동 금융사 해지
	 * @param String
	 * @return ReturnClass
	 */
	ReturnClass unlinkScrapFc(String no_person, String cd_fc);
	
	/**
	 * 스크래핑 연동 금융사 조회 화면
	 * @param String
	 * @return LinkedFcInfoVO
	 */
	List<LinkedFcInfoVO> frameFcLinkList(String no_person, String cn);
	
	/**
	 * 스크래핑 연동 금융사 수정
	 * @param FcLinkInfoVO
	 * @return ReturnClass
	 */
	ReturnClass updateFcLinkInfoList(FcLinkInfoVO linkedFcInfoList);
	
	/**
	 * 은행 자동 스크래핑 내역 저장 
	 * @param String
	 * @return ReturnClass
	 */
	ReturnClass createAutoBankScrap(String data);
	
	/**
	 * 카드 자동 스크래핑 내역 저장 
	 * @param String
	 * @return ReturnClass
	 */
	ReturnClass createAutoCardScrap(String data);
	
	/**
	 * 국세청 자동 스크래핑 내역 저장 
	 * @param String
	 * @return ReturnClass
	 */
	ReturnClass createAutoNTSScrap(String data);
	
	/**
	 * 건강보험 스크래핑 내역 저장 
	 * @param String
	 * @return ReturnClass
	 */
	ReturnClass createNHISScrap(String data);
	
	/**
	 * 국세청 스크래핑 내역 저장(소득금액증명)
	 * @param String
	 * @return ReturnClass
	 */
	ReturnClass createNTSScrap(String data);
	
	/**
	 * 국민연금 스크래핑 내역 저장 
	 * @param String
	 * @return ReturnClass
	 */
	ReturnClass createNPSScrap(String data);
	
	/**
	 * 금융사 스크랩핑 연동 정보 select(전체 정보)
	 * @param LinkedFcInfoVO
	 * @return LinkedFcInfo
	 */
	List<LinkedFcInfoVO> getLinkFcInfo(LinkedFcInfoVO linkFcInfo);
	
	/**
	 * 금융사 스크랩핑 연동 건수
	 * @param String
	 * @return int
	 */
	int getLinkedFcCount(String no_person);
	
	/**
	 * 자동스크래핑 관련  정보 조회
	 * @param String
	 * @return String
	 */
	String getAutoScrapInfo(String cd_agency, String no_person);
	
	/**
	 * 건강보험 스크래핑 조회 내역 조회
	 * @param ScrReqHealthVO
	 */
	ScrReqHealthVO getScrReqHealth(ScrReqHealthVO scrReqHealthVO);
	
	/**
	 * 건강보험 납부 상세 내역 조회
	 * @param LinkedFcInfoVO
	 * @return LinkedFcInfo
	 */
	List<ScrRespHealthPaymentdtlVO> getScrRespHealthPaymentdtl(ScrRespHealthPaymentdtlVO scrRespHealthPaymentdtlVO);
	
	/**
	 * 국민연금 스크래핑 조회 내역 조회
	 * @param ScrReqPensionVO
	 */
	ScrReqPensionVO getScrReqPension(ScrReqPensionVO scrReqPensionVO);
	
	/**
	 * 국민연금 납부 내역 조회
	 * @param ScrRespHealthPaymentVO
	 * @return 
	 */
	ScrRespPensionPaymentVO getScrRespPensionPayment(ScrRespPensionPaymentVO scrRespPensionPaymentVO);
	
	/**
	 * 국민연금 납부 상세 내역 조회
	 * @param ScrRespHealthPaymentdtlVO
	 * @return 
	 */
	List<ScrRespPensionPaymentdtlVO> getScrRespPensionPaymentdtl(ScrRespPensionPaymentdtlVO scrRespPensionPaymentdtlVO);
	
	/**
	 * 소득증명 상세 내역 조회
	 * @param ScrRespIncomeDtlVO
	 * @return 
	 */
	List<ScrRespIncomeDtlVO> getScrRespIncomeDtl(ScrRespIncomeDtlVO scrRespIncomeDtlVO);
}