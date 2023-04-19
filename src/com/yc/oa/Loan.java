package com.yc.oa;

import java.util.Date;

public class Loan {
	private int id;
	private Employee employee;
	private String title;
	private double amount;
	private Date applyDate;
	private int status;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getApplyDate() {
		return applyDate;
	}

	public void setApplyDate(Date applyDate) {
		this.applyDate = applyDate;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Loan [id=" + id + ", employee=" + employee + ", title=" + title
				+ ", amount=" + amount + ", applyDate=" + applyDate
				+ ", status=" + status + "]";
	}

	public Loan(int id, Employee employee, String title, double amount,
			Date applyDate, int status) {
		super();
		this.id = id;
		this.employee = employee;
		this.title = title;
		this.amount = amount;
		this.applyDate = applyDate;
		this.status = status;
	}

	public Loan(Employee employee, String title, double amount, Date applyDate,
			int status) {
		super();
		this.employee = employee;
		this.title = title;
		this.amount = amount;
		this.applyDate = applyDate;
		this.status = status;
	}

	public Loan() {
	}

}
