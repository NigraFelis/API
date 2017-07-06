package com.hanbit.api.service;

import java.util.Vector;

import com.hanbit.api.domain.AccountBean;

public interface Accountservice {
	public void createAccount(AccountBean bean);
	public Vector <AccountBean> accountList();
	public Vector <AccountBean> searchByName(String name);
	public AccountBean findByAccount(int accountNo);
	public int countAccount();
	public void updatePassword(AccountBean bean);
	public void deposit(AccountBean bean);
	public void withdraw(AccountBean bean);
	public void deleteAccount(int accountNo);
	
}
