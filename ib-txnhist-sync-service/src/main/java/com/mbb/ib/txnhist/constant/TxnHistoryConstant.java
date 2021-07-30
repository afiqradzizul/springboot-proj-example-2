package com.mbb.ib.txnhist.constant;

public final class TxnHistoryConstant {

	private TxnHistoryConstant() {
	}

	// Other
	public static final String cronExpression = "${txn.hist.sync.cron.exp}";
	public static final String schedulingEnabled = "scheduling.enabled";
	public static final boolean matchFlag = true;
	public static final String sourcePath = "${txn.hist.sync.path.source}";
	public static final String archivePath = "${txn.hist.sync.path.archive}";
	public static final String errorPath = "${txn.hist.sync.path.error}";
	public static final String dateFormat = "yyyy-mm-dd";
	public static final String timeFormat = "hh:mm:ss";

	// Entity
	public static final String txnHistoryTable = "ib_txn_hist";
	public static final String id = "id";
	public static final String account_Number = "account_number";
	public static final String trxAmount = "trx_amount";
	public static final String description = "description";
	public static final String trxDate = "trx_date";
	public static final String trxTime = "trx_time";
	public static final String customer_Id = "customer_id";
}
