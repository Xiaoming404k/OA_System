package com.yc.oa;

public class Employee {
	private int id;
	private String name;
	private String loginName;
	private String password;
	private int groupId;// Ա����ɫ��1Ϊ����2ΪԱ��

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getGroupId() {
		return groupId;
	}

	public void setGroupId(int groupId) {
		this.groupId = groupId;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", loginName="
				+ loginName + ", password=" + password + ", groupId=" + groupId
				+ "]";
	}

	public Employee(int id, String name, String loginName, String password,
			int groupId) {
		super();
		this.id = id;
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.groupId = groupId;
	}

	public Employee() {
	}

	public Employee(String name, String loginName, String password, int groupId) {
		super();
		this.name = name;
		this.loginName = loginName;
		this.password = password;
		this.groupId = groupId;
	}

}
