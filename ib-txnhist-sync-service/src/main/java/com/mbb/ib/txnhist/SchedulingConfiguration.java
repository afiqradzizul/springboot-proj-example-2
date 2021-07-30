package com.mbb.ib.txnhist;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.mbb.ib.txnhist.constant.TxnHistoryConstant;

@Configuration
@EnableScheduling
@ConditionalOnProperty(name = TxnHistoryConstant.schedulingEnabled, matchIfMissing = TxnHistoryConstant.matchFlag)
public class SchedulingConfiguration {
}
