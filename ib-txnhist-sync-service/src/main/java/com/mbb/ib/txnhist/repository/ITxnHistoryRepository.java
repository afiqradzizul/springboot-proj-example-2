package com.mbb.ib.txnhist.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mbb.ib.txnhist.entity.TxnHistory;

@Repository
public interface ITxnHistoryRepository extends CrudRepository<TxnHistory, Integer> {

}
