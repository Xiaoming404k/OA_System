package com.yc.oa;

public class Menu {
	private static final String[] ms = { "查看申请列表(S)", "发起申请借款(A)", "审批申请(E)",
			"重新登录(R)" };

	public static void showMenu() {
		System.out.println("---------------------------------------");
		System.out.println("当前用户为："+Session.currentEmployee.getName());
		System.out.println("请输入菜单后括号中的字母，选择相应操作");
		for (String s : ms) {
			if (s.equals("审批申请(E)")
					&& Session.currentEmployee.getGroupId() == 2) {
				continue;
			}
			System.out.println(s);
		}
		System.out.println("---------------------------------------");
	}

	public static void main(String[] args) {
		showMenu();
	}
}
