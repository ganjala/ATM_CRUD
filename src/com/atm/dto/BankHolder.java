package com.atm.dto;

public class BankHolder {
	private int accountPin;
	private String name;
	private double balance;
	private String email;
	private long phNo;
	public int getAccountPin() {
		return accountPin;
	}
	public void setAccountPin(int accountPin) {
		this.accountPin = accountPin;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getPhNo() {
		return phNo;
	}
	public void setPhNo(long phNo) {
		this.phNo = phNo;
	}
	

}
