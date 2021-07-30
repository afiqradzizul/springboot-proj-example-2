package com.mbb.ib.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.mbb.ib.constant.TxnHistoryConstant;
import com.mbb.ib.entity.TxnHistory;

public class TxnHistResponse {

	private String user = TxnHistoryConstant.all;

	private int totalRecord;

	private int pageNumber;

	private int pageSize;

	private int recordStartWith;

	private int recordEndWith;

	@JsonProperty(TxnHistoryConstant.filterByCustomerId)
	private String customerid = TxnHistoryConstant.na;

	@JsonProperty(TxnHistoryConstant.filterByAccountNumber)
	private String accountnumber = TxnHistoryConstant.na;

	@JsonProperty(TxnHistoryConstant.filterByDescription)
	private String description = TxnHistoryConstant.na;

	private List<TxnHistory> txnHist;

	public int getTotalRecord() {
		return totalRecord;
	}

	public void setTotalRecord(int totalrecord) {
		this.totalRecord = totalrecord;
	}

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pagenumber) {
		this.pageNumber = pagenumber;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pagesize) {
		this.pageSize = pagesize;
	}

	public List<TxnHistory> getTxnHist() {
		return txnHist;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getCustomerid() {
		return customerid;
	}

	public void setCustomerid(String customerid) {
		this.customerid = customerid;
	}

	public String getAccountnumber() {
		return accountnumber;
	}

	public void setAccountnumber(String accountnumber) {
		this.accountnumber = accountnumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getRecordStartWith() {
		return recordStartWith;
	}

	public void setRecordStartWith(int recordStartWith) {
		this.recordStartWith = recordStartWith;
	}

	public int getRecordEndWith() {
		return recordEndWith;
	}

	public void setRecordEndWith(int recordEndWith) {
		this.recordEndWith = recordEndWith;
	}

	public void setTxnHist(List<TxnHistory> txnhist) {
		this.txnHist = txnhist;
	}

}
