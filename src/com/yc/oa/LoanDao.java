package com.yc.oa;

import java.util.List;

public interface LoanDao {
	boolean apply(Loan l);

	List<Loan> loanList();

	void showResult(List<Loan> ls);
	
	Loan inputApplyInfo();
}
