package com.yc.oa;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		EmployeeDao empDao = new EmployeeDaoMysqlImpl();
		LoanDao loanDao = new LoanDaoMysqlImpl();
		Employee inputEmp = empDao.inputLoginInfo();
		Employee currEmp = empDao.login(inputEmp);
		Menu.showMenu();
		Scanner s = new Scanner(System.in);
		String op = null;
		while (true) {
			op = s.next();
			op = op.toUpperCase();// ��Сд�޹�
			switch (op) {// "�鿴�����б�(S)", "����������(A)", "��������(E)","���µ�¼(R)"
			case "S":
				loanDao.showResult(loanDao.loanList());
				Menu.showMenu();
				break;
			case "A":
				Loan l = loanDao.inputApplyInfo();
				loanDao.apply(l);
				Menu.showMenu();
				break;
			case "E":
				System.out.println("���������У������ڴ���");
				Menu.showMenu();
				break;
			case "R":
				Session.currentEmployee = null;
				inputEmp = empDao.inputLoginInfo();
				currEmp = empDao.login(inputEmp);
				Menu.showMenu();
				break;
			case "X":
				System.exit(0);
			}
		}
	}
}