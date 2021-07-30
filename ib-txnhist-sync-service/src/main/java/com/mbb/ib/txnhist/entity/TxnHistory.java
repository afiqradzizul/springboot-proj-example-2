package com.mbb.ib.txnhist.entity;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;

import com.mbb.ib.txnhist.constant.TxnHistoryConstant;

@Entity
@Table(name = TxnHistoryConstant.txnHistoryTable)
@DynamicUpdate
public class TxnHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = TxnHistoryConstant.id)
	private int id;

	@Column(name = TxnHistoryConstant.account_Number)
	private BigInteger account_number;

	@Column(name = TxnHistoryConstant.trxAmount)
	private BigDecimal trx_amount;

	@Column(name = TxnHistoryConstant.description)
	private String description;

	@Column(name = TxnHistoryConstant.trxDate)
	private Date trx_date;

	@Column(name = TxnHistoryConstant.trxTime)
	private Date trx_time;

	@Column(name = TxnHistoryConstant.customer_Id)
	private int customer_id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigInteger getAccount_number() {
		return account_number;
	}

	public void setAccount_number(BigInteger account_number) {
		this.account_number = account_number;
	}

	public BigDecimal getTrx_amount() {
		return trx_amount;
	}

	public void setTrx_amount(BigDecimal trx_amount) {
		this.trx_amount = trx_amount;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getTrx_date() {
		return trx_date;
	}

	public void setTrx_date(Date trx_date) {
		this.trx_date = trx_date;
	}

	public Date getTrx_time() {
		return trx_time;
	}

	public void setTrx_time(Date date) {
		this.trx_time = date;
	}

	public int getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(int customer_id) {
		this.customer_id = customer_id;
	}

	public TxnHistory() {
		super();
	}
}
