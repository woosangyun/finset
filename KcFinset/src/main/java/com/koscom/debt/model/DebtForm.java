package com.koscom.debt.model;

import java.util.List;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

import com.koscom.comm.model.SearchForm;

public class DebtForm extends SearchForm {
	private static final long serialVersionUID = 1397943544218783237L;

    private String no_person      	;
    private String seq            	;
    private String seq_credit_info	;
    private String no_manage_info 	;/* 부채 정보관리번호 */
    private String req_yyyymm		;
    private String display_yn		;/*부채 삭제 처리용*/
    private List<DebtForm> list		;/*부채 삭제 관리용*/
    private String req_yyyymmdd		;/*캘린더 list 조회*/
    private String st_yyyymm		;/*그래프 시작 기간*/
    private String ed_yyyymm		;/*그래프 종료 기간*/
    
	public String getNo_person() {
		return no_person;
	}
	public void setNo_person(String no_person) {
		this.no_person = no_person;
	}
	public String getSeq() {
		return seq;
	}
	public String getSeq_credit_info() {
		return seq_credit_info;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public void setSeq_credit_info(String seq_credit_info) {
		this.seq_credit_info = seq_credit_info;
	}
    public String getNo_manage_info() {
        return no_manage_info;
    }
    public void setNo_manage_info(String no_manage_info) {
        this.no_manage_info = no_manage_info;
    }
    public String getReq_yyyymm() {
		return req_yyyymm;
	}
	public void setReq_yyyymm(String req_yyyymm) {
		this.req_yyyymm = req_yyyymm;
	}
	public String getDisplay_yn() {
		return display_yn;
	}
	public void setDisplay_yn(String display_yn) {
		this.display_yn = display_yn;
	}
	public List<DebtForm> getList() {
		return list;
	}
	public void setList(List<DebtForm> list) {
		this.list = list;
	}
	public String getReq_yyyymmdd() {
		return req_yyyymmdd;
	}
	public void setReq_yyyymmdd(String req_yyyymmdd) {
		this.req_yyyymmdd = req_yyyymmdd;
	}
	public String getSt_yyyymm() {
		return st_yyyymm;
	}
	public void setSt_yyyymm(String st_yyyymm) {
		this.st_yyyymm = st_yyyymm;
	}
	public String getEd_yyyymm() {
		return ed_yyyymm;
	}
	public void setEd_yyyymm(String ed_yyyymm) {
		this.ed_yyyymm = ed_yyyymm;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
	}
}