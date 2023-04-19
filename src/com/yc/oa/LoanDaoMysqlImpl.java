package com.yc.oa;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class LoanDaoMysqlImpl implements LoanDao {

	@Override
	public boolean apply(Loan l) {
		String sql = "insert into loan(employeeId,title,amount,applyDate,status)values("
				+ Session.currentEmployee.getId()
				+ ",'"
				+ l.getTitle()
				+ "',"
				+ l.getAmount()
				+ ",'"
				+ new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
						.format(new Date()) + "',0)";
		return DbUtils.executeCUD(sql) == 1;
	}

	@Override
	public List<Loan> loanList() {
		String sql = "select * from loan where employeeId="
				+ Session.currentEmployee.getId() + " order by applyDate desc";
		return DbUtils.executeR(sql, Loan.class);
	}

	public static void main(String[] args) {
		// new LoanDaoMysqlImpl().showResult(new LoanDaoMysqlImpl().loanList());
		new LoanDaoMysqlImpl().inputApplyInfo();
	}

	@Override
	public void showResult(List<Loan> ls) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
		System.out.println("\t\t申请列表");
		System.out.println("标题\t借款金额\t\t贷款日期\t\t状态");
		for (Loan lt : ls) {
			System.out.println(lt.getTitle()
					+ "\t"
					+ lt.getAmount()
					+ "\t"
					+ sdf.format(lt.getApplyDate())
					+ "\t"
					+ (lt.getStatus() == 0 ? "未审批"
							: (lt.getStatus() == 1 ? "审批通过" : "审批驳回")));
		}

	}

	@Override
	public Loan inputApplyInfo() {
		Scanner s = new Scanner(System.in);
		System.out.println("申请借款");
		Loan l = new Loan();
		String title;
		double amount;
		System.out.print("标题：");
		title = s.next();
		l.setTitle(title);
		System.out.print("金额：");
		amount = s.nextDouble();
		l.setAmount(amount);
		return l;
	}

}
