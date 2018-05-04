package query;

public class Queries {
	 private final String getCustDetails = "SELECT * "
			+ "FROM CDW_SAPP_CUSTOMER "
			+ "WHERE SSN = ?";
	
	private final String modifyCustDetails = "UPDATE CDW_SAPP_CUSTOMER " +
			"SET FIRST_NAME=? , MIDDLE_NAME=?, LAST_NAME =?, CREDIT_CARD_NO=? ," +
			"APT_NO= ? , STREET_NAME= ? , CUST_CITY= ? , CUST_STATE= ? , CUST_COUNTRY=? , CUST_ZIP=? , " +
			"CUST_PHONE= ? , CUST_EMAIL = ? " +
			"WHERE SSN = ?;";
	private final String modifyCustDetailsPrefix = "UPDATE CDW_SAPP_CUSTOMER " +
			"SET ";
	private final String modifyCustDetailsSuffix = "=? where SSN = ?;";

	private final String genMonthlyBill ="SELECT SUM(TRANSACTION_VALUE) as BILL "
			+ "FROM CDW_SAPP_CREDITCARD "
			+ "WHERE CREDIT_CARD_NO = ? AND "
			+ "MONTH = ? AND "
			+ "YEAR = ? ;";
	
	private final String displayCustTransactionsByDate ="SELECT * "
			+ "FROM CDW_SAPP_CREDITCARD "
			+ "WHERE CUST_SSN =? AND "
			+ "YEAR BETWEEN ? AND ? AND "
			+ "MONTH BETWEEN ? AND ? AND "
			+ "DAY BETWEEN ? AND ? "
			+ "ORDER BY YEAR,MONTH,DAY;"
			;

	private final String displayCustTransByZip="SELECT * "
			+ "FROM CDW_SAPP_CREDITCARD AS card JOIN CDW_SAPP_CUSTOMER AS cust ON " +
			" card.CUST_SSN = cust.SSN " +
			"where CUST_ZIP = ? AND " +
			"MONTH = ? AND YEAR = ? " +
			"ORDER BY DAY DESC;";

	
	private final String displayNumAndTotalByType ="SELECT COUNT(*) as Number, SUM(TRANSACTION_VALUE) as Total "
			+ "FROM CDW_SAPP_CREDITCARD "
			+ "WHERE TRANSACTION_TYPE =? "
			+ "GROUP BY TRANSACTION_TYPE";
	
	private final String displayNumAndTotalByState = "SELECT count(*) as Number, sum(TRANSACTION_VALUE) AS Total " +
											"FROM CDW_SAPP_CREDITCARD as card JOIN CDW_SAPP_BRANCH as branch ON "+
											"card.BRANCH_CODE= branch.BRANCH_CODE "+
											"WHERE branch.BRANCH_STATE = ? "+
											"GROUP BY card.BRANCH_CODE";


	public String getCustDetails() {
		return getCustDetails;
	}

	public String getModifyCustDetails() {
		return modifyCustDetails;
	}

	public String getGenMonthlyBill() {
		return genMonthlyBill;
	}

	public String getDisplayCustTransactionsByDate() {
		return displayCustTransactionsByDate;
	}

	public String getDisplayCustTransByZip() {
		return displayCustTransByZip;
	}

	public String getDisplayNumAndTotalByType() {
		return displayNumAndTotalByType;
	}

	public String getDisplayNumAndTotalByState() {
		return displayNumAndTotalByState;
	}
	public String getModifyCustDetailsPrefix() {
		return modifyCustDetailsPrefix;
	}

	public String getModifyCustDetailsSuffix() {
		return modifyCustDetailsSuffix;
	}
}
