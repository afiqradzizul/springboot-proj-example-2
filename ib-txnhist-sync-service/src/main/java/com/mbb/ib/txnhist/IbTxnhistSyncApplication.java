package com.mbb.ib.txnhist;

import java.text.ParseException;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.Scheduled;

import com.mbb.ib.txnhist.constant.TxnHistoryConstant;
import com.mbb.ib.txnhist.service.TxnHistoryService;

@SpringBootApplication
public class IbTxnhistSyncApplication {

	@Autowired
	private TxnHistoryService txnHistService;

	public static void main(String[] args) {
		SpringApplication.run(IbTxnhistSyncApplication.class, args);
	}

	@Scheduled(cron = TxnHistoryConstant.cronExpression)
	public void Job() throws ParseException {
		System.out.println(new Date());
		txnHistService.processBatchFile();
	}

}