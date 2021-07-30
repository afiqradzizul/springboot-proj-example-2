package com.mbb.ib.service;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mbb.ib.entity.TxnHistory;
import com.mbb.ib.model.TxnHistResponse;
import com.mbb.ib.repository.ITxnHistoryRepository;

@Service
public class TxnHistoryService {

	@Autowired
	private ITxnHistoryRepository txnHistRepo;

	public TxnHistResponse findByCurrentUser(TxnHistResponse txnHist) {
		txnHist.setRecordStartWith(this.getFromRow(txnHist));
		txnHist.setTotalRecord(txnHistRepo.countByCurrentUser(txnHist.getUser()));
		txnHist.setTxnHist((txnHistRepo.findByCurrentUser(txnHist.getRecordStartWith(), txnHist.getPageSize(),
				txnHist.getUser())));
		txnHist.setRecordStartWith(this.updateFromRow(txnHist));
		txnHist.setRecordEndWith(this.getEndRow(txnHist));
		txnHist = this.amountConvertToBigInteger(txnHist);
		return txnHist;
	}

	public TxnHistResponse findAll(TxnHistResponse txnHist) {
		txnHist.setRecordStartWith(this.getFromRow(txnHist));
		txnHist.setTotalRecord(txnHistRepo.countAll());
		txnHist.setTxnHist(txnHistRepo.findAll(txnHist.getRecordStartWith(), txnHist.getPageSize()));
		txnHist.setRecordStartWith(this.updateFromRow(txnHist));
		txnHist.setRecordEndWith(this.getEndRow(txnHist));
		txnHist = this.amountConvertToBigInteger(txnHist);
		return txnHist;
	}

	public TxnHistResponse findAllFilterByCustomerId(TxnHistResponse txnHist) {
		txnHist.setRecordStartWith(this.getFromRow(txnHist));
		txnHist.setTotalRecord(txnHistRepo.countByCustomerId(Integer.parseInt(txnHist.getCustomerid())));
		txnHist.setTxnHist(txnHistRepo.findAllFilterByCustomerId(txnHist.getRecordStartWith(), txnHist.getPageSize(),
				Integer.parseInt(txnHist.getCustomerid())));
		txnHist.setRecordStartWith(this.updateFromRow(txnHist));
		txnHist.setRecordEndWith(this.getEndRow(txnHist));
		txnHist = this.amountConvertToBigInteger(txnHist);
		return txnHist;
	}

	public TxnHistResponse findAllFilterByAccountNumber(TxnHistResponse txnHist) {
		txnHist.setRecordStartWith(this.getFromRow(txnHist));
		txnHist.setTotalRecord(txnHistRepo.countByAcountNumber(new BigInteger(txnHist.getAccountnumber())));
		txnHist.setTxnHist(txnHistRepo.findAllFilterByAccountNumber(txnHist.getRecordStartWith(), txnHist.getPageSize(),
				new BigInteger(txnHist.getAccountnumber())));
		txnHist.setRecordStartWith(this.updateFromRow(txnHist));
		txnHist.setRecordEndWith(this.getEndRow(txnHist));
		txnHist = this.amountConvertToBigInteger(txnHist);
		return txnHist;
	}

	public TxnHistResponse findAllFilterByDescription(TxnHistResponse txnHist) {
		txnHist.setRecordStartWith(this.getFromRow(txnHist));
		txnHist.setTotalRecord(txnHistRepo.countByDescription(txnHist.getDescription()));
		txnHist.setTxnHist(txnHistRepo.findAllFilterByDescription(txnHist.getRecordStartWith(), txnHist.getPageSize(),
				txnHist.getDescription()));
		txnHist.setRecordStartWith(this.updateFromRow(txnHist));
		txnHist.setRecordEndWith(this.getEndRow(txnHist));
		txnHist = this.amountConvertToBigInteger(txnHist);
		return txnHist;
	}

	public TxnHistResponse findAllFilterByCustomerIdAndAccountNumber(TxnHistResponse txnHist) {
		txnHist.setRecordStartWith(this.getFromRow(txnHist));
		txnHist.setTotalRecord(txnHistRepo.countByCustomerIdAndAccountNumber(Integer.parseInt(txnHist.getCustomerid()),
				new BigInteger(txnHist.getAccountnumber())));
		txnHist.setTxnHist(txnHistRepo.findAllFilterByCustomerIdAndAccountNumber(txnHist.getRecordStartWith(),
				txnHist.getPageSize(), Integer.parseInt(txnHist.getCustomerid()),
				new BigInteger(txnHist.getAccountnumber())));
		txnHist.setRecordStartWith(this.updateFromRow(txnHist));
		txnHist.setRecordEndWith(this.getEndRow(txnHist));
		txnHist = this.amountConvertToBigInteger(txnHist);
		return txnHist;
	}

	public TxnHistResponse findAllFilterByCustomerIdAndAccountNumberAndDescription(TxnHistResponse txnHist) {
		txnHist.setRecordStartWith(this.getFromRow(txnHist));
		txnHist.setTotalRecord(
				txnHistRepo.countByCustomerIdAndAccountNumberAndDescription(Integer.parseInt(txnHist.getCustomerid()),
						new BigInteger(txnHist.getAccountnumber()), txnHist.getDescription()));
		txnHist.setTxnHist(txnHistRepo.findAllFilterByCustomerIdAndAccountNumberAndDescription(
				txnHist.getRecordStartWith(), txnHist.getPageSize(), Integer.parseInt(txnHist.getCustomerid()),
				new BigInteger(txnHist.getAccountnumber()), txnHist.getDescription()));
		txnHist.setRecordStartWith(this.updateFromRow(txnHist));
		txnHist.setRecordEndWith(this.getEndRow(txnHist));
		txnHist = this.amountConvertToBigInteger(txnHist);
		return txnHist;
	}

	private int getFromRow(TxnHistResponse txnHist) {
		return (txnHist.getPageNumber() * txnHist.getPageSize()) - txnHist.getPageSize() + 1;
	}

	private int getEndRow(TxnHistResponse txnHist) {

		int endRow = txnHist.getRecordStartWith() + txnHist.getPageSize() - 1;

		return (endRow != txnHist.getTxnHist().size() ? txnHist.getTxnHist().size() != 0
				? txnHist.getTxnHist().get(txnHist.getTxnHist().size() - 1).getRecord()
				: 0 : txnHist.getRecordStartWith() + txnHist.getPageSize() - 1);
	}

	private int updateFromRow(TxnHistResponse txnHist) {
		return ((txnHist.getTxnHist().size() > 0) ? txnHist.getRecordStartWith() : 0);
	}

	private TxnHistResponse amountConvertToBigInteger(TxnHistResponse txnHist) {
		for (TxnHistory txnhist : txnHist.getTxnHist()) {
			txnhist.setTrx_amount(
					new BigDecimal(txnhist.getTrx_amount().toBigInteger()).setScale(2, RoundingMode.FLOOR));
		}
		return txnHist;
	}

}
