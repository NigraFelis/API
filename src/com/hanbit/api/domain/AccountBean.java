package com.hanbit.api.domain;

public class AccountBean {
	private String name, password, id, txDate;
	int SSN;
	private int accountNo, money;
	public static final String BANK_NAME="KB국민은행";
	
	public void setName(String name){
		this.name=name;
	}
	public String getName(){
		return name;
	}
	
	
	public void setPassword(String password){
		this.password=password;
	}
	public String getPassword(){
		return password;
	}
	
	
	public void setId(String id){
		this.id=id;
	}
	public String getId(){
		return id;
	}
	
	
	public void setAcountNo(int accountNo){
		this.accountNo=accountNo;
	}
	public int getAcountNo(){
		return accountNo;
	}
	
	
	public void settxDate(String txDate){
		this.txDate=txDate;
	}
	public String gettxDate(){
		return txDate;
	}
	
	
	public void setSSN(int SSN){
		this.SSN=SSN;
	}
	public int getSNN(){
		return SSN;
	}
	
	
	public void setMoney(int money){
		this.money=money;
	}
	public int getMoney(){
		return money;
	}
	
	
	public String toString(){
		return String.format("이름: %s 계좌:%d 잔액: %d \n", name,accountNo,money);
	}
}
