package com.mbb.ib.repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mbb.ib.constant.CommonConstant;
import com.mbb.ib.constant.TxnHistoryConstant;
import com.mbb.ib.entity.TxnHistory;

@Repository
public interface ITxnHistoryRepository extends CrudRepository<TxnHistory, Integer> {

	@Query(value = TxnHistoryConstant.sqlQuery1, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public List<TxnHistory> findByCurrentUser(@Param(TxnHistoryConstant.getFromRow) int getFromRow,
			@Param(TxnHistoryConstant.size) int size, @Param(CommonConstant.username) String username);

	@Query(value = TxnHistoryConstant.sqlQuery2, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public List<TxnHistory> findAll(@Param(TxnHistoryConstant.getFromRow) int getFromRow,
			@Param(TxnHistoryConstant.size) int size);

	@Query(value = TxnHistoryConstant.sqlQuery3, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public List<TxnHistory> findAllFilterByCustomerId(@Param(TxnHistoryConstant.getFromRow) int getFromRow,
			@Param(TxnHistoryConstant.size) int size, @Param(CommonConstant.customerId) int customerid);

	@Query(value = TxnHistoryConstant.sqlQuery4, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public List<TxnHistory> findAllFilterByAccountNumber(@Param(TxnHistoryConstant.getFromRow) int getFromRow,
			@Param(TxnHistoryConstant.size) int size,
			@Param(TxnHistoryConstant.accountNumber) BigInteger accountnumber);

	@Query(value = TxnHistoryConstant.sqlQuery5, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public List<TxnHistory> findAllFilterByDescription(@Param(TxnHistoryConstant.getFromRow) int getFromRow,
			@Param(TxnHistoryConstant.size) int size, @Param(TxnHistoryConstant.description) String description);

	@Query(value = TxnHistoryConstant.sqlQuery6, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public int countByCurrentUser(@Param(CommonConstant.username) String username);

	@Query(value = TxnHistoryConstant.sqlQuery7, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public int countAll();

	@Query(value = TxnHistoryConstant.sqlQuery8, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public int countByCustomerId(@Param(CommonConstant.customerId) int customerid);

	@Query(value = TxnHistoryConstant.sqlQuery9, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public int countByAcountNumber(@Param(TxnHistoryConstant.accountNumber) BigInteger accountnumber);

	@Query(value = TxnHistoryConstant.sqlQuery10, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public int countByDescription(@Param(TxnHistoryConstant.description) String description);

	@Query(value = TxnHistoryConstant.sqlQuery11, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public List<TxnHistory> findAllFilterByCustomerIdAndAccountNumber(@Param(TxnHistoryConstant.getFromRow) int getFromRow,
			@Param(TxnHistoryConstant.size) int size, @Param(CommonConstant.customerId) int customerid,
			@Param(TxnHistoryConstant.accountNumber) BigInteger accountnumber);

	@Query(value = TxnHistoryConstant.sqlQuery12, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public int countByCustomerIdAndAccountNumber(@Param(CommonConstant.customerId) int customerid,
			@Param(TxnHistoryConstant.accountNumber) BigInteger accountnumber);

	@Query(value = TxnHistoryConstant.sqlQuery13, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public List<TxnHistory> findAllFilterByCustomerIdAndAccountNumberAndDescription(
			@Param(TxnHistoryConstant.getFromRow) int getFromRow, @Param(TxnHistoryConstant.size) int size,
			@Param(CommonConstant.customerId) int customerid,
			@Param(TxnHistoryConstant.accountNumber) BigInteger accountnumber,
			@Param(TxnHistoryConstant.description) String description);

	@Query(value = TxnHistoryConstant.sqlQuery14, nativeQuery = TxnHistoryConstant.nativeQuertFlag)
	public int countByCustomerIdAndAccountNumberAndDescription(@Param(CommonConstant.customerId) int customerid,
			@Param(TxnHistoryConstant.accountNumber) BigInteger accountnumber,
			@Param(TxnHistoryConstant.description) String description);

}
