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
		System.out.println("\t\t�����б�");
		System.out.println("����\t�����\t\t��������\t\t״̬");
		for (Loan lt : ls) {
			System.out.println(lt.getTitle()
					+ "\t"
					+ lt.getAmount()
					+ "\t"
					+ sdf.format(lt.getApplyDate())
					+ "\t"
					+ (lt.getStatus() == 0 ? "δ����"
							: (lt.getStatus() == 1 ? "����ͨ��" : "��������")));
		}

	}

	@Override
	public Loan inputApplyInfo() {
		Scanner s = new Scanner(System.in);
		System.out.println("������");
		Loan l = new Loan();
		String title;
		double amount;
		System.out.print("���⣺");
		title = s.next();
		l.setTitle(title);
		System.out.print("��");
		amount = s.nextDouble();
		l.setAmount(amount);
		return l;
	}

}
