package com.yc.oa;

public class Menu {
	private static final String[] ms = { "�鿴�����б�(S)", "����������(A)", "��������(E)",
			"���µ�¼(R)" };

	public static void showMenu() {
		System.out.println("---------------------------------------");
		System.out.println("��ǰ�û�Ϊ��"+Session.currentEmployee.getName());
		System.out.println("������˵��������е���ĸ��ѡ����Ӧ����");
		for (String s : ms) {
			if (s.equals("��������(E)")
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
