package com.mbb.ib.controller;

import java.math.BigInteger;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mbb.ib.constant.CommonConstant;
import com.mbb.ib.constant.TxnHistoryConstant;
import com.mbb.ib.model.TxnHistResponse;
import com.mbb.ib.service.TxnHistoryService;

@RestController
@RequestMapping(TxnHistoryConstant.apiPath_2)
public class TxnHistoryController {

	@Autowired
	private TxnHistoryService txnHistoryService;

	@GetMapping(value = TxnHistoryConstant.apiPath_4)
	public ResponseEntity<?> findByCurrentUser(HttpServletRequest httpServletRequest,
			@PathVariable(name = TxnHistoryConstant.page) Integer page,
			@PathVariable(name = TxnHistoryConstant.size) Integer size) {

		TxnHistResponse txnHistory = new TxnHistResponse();

		txnHistory.setPageNumber(page);
		txnHistory.setPageSize(size);
		txnHistory.setUser((String) httpServletRequest.getAttribute(CommonConstant.username));

		return new ResponseEntity<>(txnHistoryService.findByCurrentUser(txnHistory), HttpStatus.OK);
	}

	@GetMapping(value = TxnHistoryConstant.apiPath_5)
	public ResponseEntity<?> findAll(@PathVariable(name = TxnHistoryConstant.page) Integer page,
			@PathVariable(name = TxnHistoryConstant.size) Integer size) {

		TxnHistResponse txnHistory = new TxnHistResponse();

		txnHistory.setPageNumber(page);
		txnHistory.setPageSize(size);

		return new ResponseEntity<>(txnHistoryService.findAll(txnHistory), HttpStatus.OK);
	}

	@GetMapping(value = TxnHistoryConstant.apiPath_6)
	public ResponseEntity<?> filterAllByCustomerId(@PathVariable(name = TxnHistoryConstant.page) Integer page,
			@PathVariable(name = TxnHistoryConstant.size) Integer size,
			@PathVariable(name = TxnHistoryConstant.id) Integer id) {

		TxnHistResponse txnHistory = new TxnHistResponse();

		txnHistory.setPageNumber(page);
		txnHistory.setPageSize(size);
		txnHistory.setCustomerid(Integer.toString(id));

		return new ResponseEntity<>(txnHistoryService.findAllFilterByCustomerId(txnHistory), HttpStatus.OK);
	}

	@GetMapping(value = TxnHistoryConstant.apiPath_7)
	public ResponseEntity<?> filterAllByAccountNumber(@PathVariable(name = TxnHistoryConstant.page) Integer page,
			@PathVariable(name = TxnHistoryConstant.size) Integer size,
			@PathVariable(name = TxnHistoryConstant.accountNumber) BigInteger accountnumber) {

		TxnHistResponse txnHistory = new TxnHistResponse();

		txnHistory.setPageNumber(page);
		txnHistory.setPageSize(size);
		txnHistory.setAccountnumber(accountnumber.toString());

		return new ResponseEntity<>(txnHistoryService.findAllFilterByAccountNumber(txnHistory), HttpStatus.OK);
	}

	@GetMapping(value = TxnHistoryConstant.apiPath_8)
	public ResponseEntity<?> filterAllByDescription(@PathVariable(name = TxnHistoryConstant.page) Integer page,
			@PathVariable(name = TxnHistoryConstant.size) Integer size,
			@PathVariable(name = TxnHistoryConstant.description) String description) {

		TxnHistResponse txnHistory = new TxnHistResponse();

		txnHistory.setPageNumber(page);
		txnHistory.setPageSize(size);
		txnHistory.setDescription(description);

		return new ResponseEntity<>(txnHistoryService.findAllFilterByDescription(txnHistory), HttpStatus.OK);
	}

	@GetMapping(value = TxnHistoryConstant.apiPath_9)
	public ResponseEntity<?> filterAllByCustomerIdAndAccountNumber(
			@PathVariable(name = TxnHistoryConstant.page) Integer page,
			@PathVariable(name = TxnHistoryConstant.size) Integer size,
			@PathVariable(name = TxnHistoryConstant.id) Integer id,
			@PathVariable(name = TxnHistoryConstant.accountNumber) BigInteger accountnumber) {

		TxnHistResponse txnHistory = new TxnHistResponse();

		txnHistory.setPageNumber(page);
		txnHistory.setPageSize(size);
		txnHistory.setCustomerid(Integer.toString(id));
		txnHistory.setAccountnumber(accountnumber.toString());

		return new ResponseEntity<>(txnHistoryService.findAllFilterByCustomerIdAndAccountNumber(txnHistory),
				HttpStatus.OK);
	}

	@GetMapping(value = TxnHistoryConstant.apiPath_10)
	public ResponseEntity<?> filterAllByCustomerIdAndAccountNumberAndDescription(
			@PathVariable(name = TxnHistoryConstant.page) Integer page,
			@PathVariable(name = TxnHistoryConstant.size) Integer size,
			@PathVariable(name = TxnHistoryConstant.id) Integer id,
			@PathVariable(name = TxnHistoryConstant.accountNumber) BigInteger accountnumber,
			@PathVariable(name = TxnHistoryConstant.description) String description) {

		TxnHistResponse txnHistory = new TxnHistResponse();

		txnHistory.setPageNumber(page);
		txnHistory.setPageSize(size);
		txnHistory.setCustomerid(Integer.toString(id));
		txnHistory.setAccountnumber(accountnumber.toString());
		txnHistory.setDescription(description);

		return new ResponseEntity<>(
				txnHistoryService.findAllFilterByCustomerIdAndAccountNumberAndDescription(txnHistory), HttpStatus.OK);
	}
}
