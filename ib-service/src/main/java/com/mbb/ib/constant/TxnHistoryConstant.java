package com.mbb.ib.constant;

public final class TxnHistoryConstant {

	private TxnHistoryConstant() {
	}

	// Rest
	public static final String authorization = "Authorization";
	public static final String bearer = "Bearer ";
	public static final String apiPath_1 = "/api/auth";
	public static final String apiPath_2 = "/api";
	public static final String apiPath_3 = "/auth";
	public static final String apiPath_4 = "/txnhistory/page/{page}/size/{size}";
	public static final String apiPath_5 = "/txnhistory/all/page/{page}/size/{size}";
	public static final String apiPath_6 = "/txnhistory/all/page/{page}/size/{size}/customerid/{id}";
	public static final String apiPath_7 = "/txnhistory/all/page/{page}/size/{size}/accountnumber/{accountnumber}";
	public static final String apiPath_8 = "/txnhistory/all/page/{page}/size/{size}/description/{description}";
	public static final String apiPath_9 = "/txnhistory/all/page/{page}/size/{size}/customerid/{id}/accountnumber/{accountnumber}";
	public static final String apiPath_10 = "/txnhistory/all/page/{page}/size/{size}/customerid/{id}/accountnumber/{accountnumber}/description/{description}";
	public static final String page = "page";
	public static final String size = "size";
	public static final String id = "id";
	public static final String accountNumber = "accountnumber";
	public static final String description = "description";
	public static final String getFromRow = "getfromrow";
	public static final String all = "All";
	public static final String na = "NA";
	public static final String filterByCustomerId = "filterbycustomerid";
	public static final String filterByAccountNumber = "filterbyaccountnumber";
	public static final String filterByDescription = "filterbydescription";
	public static final String datePattern = "yyyy-MM-dd";
	public static final String timePattern = "HH:mm:ss";

	// Repository
	public static final String sqlQuery1 = "SELECT * FROM (SELECT * FROM (SELECT\r\n"
			+ "ROW_NUMBER() OVER(ORDER BY id ASC) AS RECORD, ID, ACCOUNT_NUMBER, TRX_AMOUNT, DESCRIPTION, TRX_DATE, TRX_TIME, CUSTOMER_ID\r\n"
			+ "FROM IB_TXN_HIST WHERE CUSTOMER_ID = (SELECT CUSTOMER_ID FROM IB_USER WHERE USERNAME = :username)) AS FOO\r\n"
			+ "WHERE RECORD >= :getfromrow) AS FOO LIMIT :size";

	public static final String sqlQuery2 = "SELECT * FROM (SELECT * FROM (SELECT \r\n"
			+ "ROW_NUMBER() OVER(ORDER BY id ASC) AS RECORD, ID, ACCOUNT_NUMBER, TRX_AMOUNT, DESCRIPTION, TRX_DATE, TRX_TIME, CUSTOMER_ID\r\n"
			+ "FROM IB_TXN_HIST) AS FOO\r\n" + "WHERE RECORD >= :getfromrow) AS FOO LIMIT :size";

	public static final String sqlQuery3 = "SELECT * FROM (SELECT * FROM (SELECT \r\n"
			+ "ROW_NUMBER() OVER(ORDER BY id ASC) AS RECORD, ID, ACCOUNT_NUMBER, TRX_AMOUNT, DESCRIPTION, TRX_DATE, TRX_TIME, CUSTOMER_ID\r\n"
			+ "FROM IB_TXN_HIST WHERE CUSTOMER_ID = :customerid) AS FOO\r\n"
			+ "WHERE RECORD >= :getfromrow) AS FOO LIMIT :size";

	public static final String sqlQuery4 = "SELECT * FROM (SELECT * FROM (SELECT\r\n"
			+ "ROW_NUMBER() OVER(ORDER BY id ASC) AS RECORD, ID, ACCOUNT_NUMBER, TRX_AMOUNT, DESCRIPTION, TRX_DATE, TRX_TIME, CUSTOMER_ID\r\n"
			+ "FROM IB_TXN_HIST WHERE ACCOUNT_NUMBER = :accountnumber) AS FOO\r\n"
			+ "WHERE RECORD >= :getfromrow) AS FOO LIMIT :size";

	public static final String sqlQuery5 = "SELECT * FROM (SELECT * FROM (SELECT\r\n"
			+ "ROW_NUMBER() OVER(ORDER BY id ASC) AS RECORD, ID, ACCOUNT_NUMBER, TRX_AMOUNT, DESCRIPTION, TRX_DATE, TRX_TIME, CUSTOMER_ID\r\n"
			+ "FROM IB_TXN_HIST WHERE DESCRIPTION LIKE %:description%) AS FOO\r\n"
			+ "WHERE RECORD >= :getfromrow) AS FOO LIMIT :size";

	public static final String sqlQuery6 = "SELECT COUNT(*) FROM IB_TXN_HIST WHERE CUSTOMER_ID = (SELECT CUSTOMER_ID FROM IB_USER WHERE USERNAME = :username)";

	public static final String sqlQuery7 = "SELECT COUNT(*) FROM IB_TXN_HIST";

	public static final String sqlQuery8 = "SELECT COUNT(*) FROM IB_TXN_HIST WHERE CUSTOMER_ID = :customerid";

	public static final String sqlQuery9 = "SELECT COUNT(*) FROM IB_TXN_HIST WHERE ACCOUNT_NUMBER = :accountnumber";

	public static final String sqlQuery10 = "SELECT COUNT(*) FROM IB_TXN_HIST WHERE DESCRIPTION LIKE %:description%";

	public static final String sqlQuery11 = "SELECT * FROM (SELECT * FROM (SELECT \r\n"
			+ "ROW_NUMBER() OVER(ORDER BY id ASC) AS RECORD, ID, ACCOUNT_NUMBER, TRX_AMOUNT, DESCRIPTION, TRX_DATE, TRX_TIME, CUSTOMER_ID\r\n"
			+ "FROM IB_TXN_HIST WHERE CUSTOMER_ID = :customerid AND ACCOUNT_NUMBER = :accountnumber) AS FOO\r\n"
			+ "WHERE RECORD >= :getfromrow) AS FOO LIMIT :size";

	public static final String sqlQuery12 = "SELECT COUNT(*) FROM IB_TXN_HIST WHERE CUSTOMER_ID = :customerid AND ACCOUNT_NUMBER = :accountnumber";

	public static final String sqlQuery13 = "SELECT * FROM (SELECT * FROM (SELECT \r\n"
			+ "ROW_NUMBER() OVER(ORDER BY id ASC) AS RECORD, ID, ACCOUNT_NUMBER, TRX_AMOUNT, DESCRIPTION, TRX_DATE, TRX_TIME, CUSTOMER_ID\r\n"
			+ "FROM IB_TXN_HIST WHERE CUSTOMER_ID = :customerid AND ACCOUNT_NUMBER = :accountnumber AND DESCRIPTION LIKE %:description%) AS FOO\r\n"
			+ "WHERE RECORD >= :getfromrow) AS FOO LIMIT :size";

	public static final String sqlQuery14 = "SELECT COUNT(*) FROM IB_TXN_HIST WHERE CUSTOMER_ID = :customerid AND ACCOUNT_NUMBER = :accountnumber AND DESCRIPTION LIKE %:description%";

	public static final boolean nativeQuertFlag = true;

	// Entity
	public static final String txnHistoryTable = "ib_txn_hist";
	public static final String account_Number = "account_number";
	public static final String trxAmount = "trx_amount";
	public static final String trxDate = "trx_date";
	public static final String trxTime = "trx_time";
}
