package com.yc.oa;

import java.util.List;
import java.util.Scanner;

public class EmployeeDaoMysqlImpl implements EmployeeDao {

	@Override
	public Employee login(Employee emp)/*(String loginName,String password)*/ {
		String sql = "select *from employee where loginName='"
				+ emp.getLoginName() + "' and password='" + emp.getPassword()
				+ "'";
		List<Employee> es = DbUtils.executeR(sql, Employee.class);
		if (es != null && es.size() == 1) {
			Session.currentEmployee = es.get(0);
			return Session.currentEmployee;
		} else {
			throw new OaException("�û������������");
		}
	}

	public Employee inputLoginInfo() {
		Scanner s = new Scanner(System.in);
		String loginName, password;
		Employee emp = new Employee();
		System.out.println("ϵͳ��¼");
		System.out.print("��¼����");
		loginName = s.next();
		System.out.print("���룺");
		password = s.next();
		emp.setLoginName(loginName);
		emp.setPassword(password);
		return emp;
	}

	public static void main(String[] args) {
		EmployeeDaoMysqlImpl ed = new EmployeeDaoMysqlImpl();
		System.out.println(ed.inputLoginInfo());
	}

}
