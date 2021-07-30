package com.mbb.ib.txnhist.service;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.mbb.ib.txnhist.util.FileUtil;
import com.mbb.ib.txnhist.constant.TxnHistoryConstant;
import com.mbb.ib.txnhist.entity.TxnHistory;
import com.mbb.ib.txnhist.repository.ITxnHistoryRepository;

@Service
public class TxnHistoryService {

	@Value(TxnHistoryConstant.sourcePath)
	private String sourcePath;

	@Value(TxnHistoryConstant.archivePath)
	private String archivePath;

	@Value(TxnHistoryConstant.errorPath)
	private String errorPath;

	@Autowired
	private ITxnHistoryRepository txnHistRepo;

	public void processBatchFile() throws ParseException {

		FileUtil File = new FileUtil();

		FileUtil TempFile = new FileUtil();

		File[] listOfFiles = File.getAllFile(sourcePath);

		for (File file : listOfFiles) {

			if (File.isTextFile(file)) {

				File.renameToTempFile(file, sourcePath);

				File tempFile = File.getTempFile(file);

				try {
					Scanner text = new Scanner(tempFile);
					TempFile.skipFirstRow(text);
					while (TempFile.hasNextRowOfData(text)) {
						TxnHistory txnHist = new TxnHistory();
						String rowOfData = TempFile.getRowOfData(text);
						String[] data = TempFile.getArrayOfData(rowOfData);
						txnHist.setAccount_number(new BigInteger(data[0]));
						txnHist.setTrx_amount(new BigDecimal(data[1]));
						txnHist.setDescription(data[2]);
						txnHist.setTrx_date(this.stringToDate(data[3], TxnHistoryConstant.dateFormat));
						txnHist.setTrx_time(this.stringToDate(data[4], TxnHistoryConstant.timeFormat));
						txnHist.setCustomer_id(Integer.parseInt(data[5]));
						txnHistRepo.save(txnHist);
					}
					text.close();
				} catch (FileNotFoundException e) {
					File.moveToError(file, errorPath);
				}

				TempFile.moveToArchive(tempFile, archivePath);
			} else {
				File.moveToError(file, errorPath);
			}
		}
	}

	private Date stringToDate(String data, String Format) throws ParseException {
		DateFormat format = new SimpleDateFormat(Format);
		Date newDate = format.parse(data);
		return newDate;
	}
}