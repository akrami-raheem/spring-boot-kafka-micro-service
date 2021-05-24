package com.network.international.entity.dto;

import java.util.Date;

public class PosTransactionsDto {

	private Long id;

	private long posId;

	private String accountNo;

	private double amount;

	private Date createdTime;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public long getPosId() {
		return posId;
	}

	public void setPosId(long posId) {
		this.posId = posId;
	}

	public String getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getCreatedTime() {
		return createdTime;
	}

	public void setCreatedTime(Date createdTime) {
		this.createdTime = createdTime;
	}

}