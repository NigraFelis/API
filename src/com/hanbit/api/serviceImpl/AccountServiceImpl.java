package com.hanbit.api.serviceImpl;

import java.util.Calendar;
import java.util.Vector;

import com.hanbit.api.domain.AccountBean;
import com.hanbit.api.service.Accountservice;

public class AccountServiceImpl implements Accountservice{
	
	Vector<AccountBean> vec;
	public AccountServiceImpl(){
		vec=new Vector<AccountBean>(10, 10);
		
	}

	@Override
	public void createAccount(AccountBean bean) {
		int randomNo = (int)(Math.random()*99+10);
		Calendar now = Calendar.getInstance();
		
		int mm = now.get(now.MONTH);
		int dd = now.get(now.DAY_OF_MONTH)+1;
		int hh = now.get(now.HOUR);
		
		bean.setAcountNo(randomNo);
		bean.settxDate(String.valueOf(mm+"월"+dd+"일"+hh+"시"));
		vec.add(bean);
	}
	
	@Override
	public Vector<AccountBean> accountList() {
		return vec;
	}

	@Override
	public Vector<AccountBean> searchByName(String name) {
		Vector<AccountBean> temp = new Vector<AccountBean>(10, 10);
		
		for(int i=0; i<vec.size(); i++){
			if(name.equals(vec.get(i).getName())){
				temp.add(vec.get(i));
			}
		}
		return temp;
	}

	@Override
	public AccountBean findByAccount(int accountNo) {
		AccountBean temp = new AccountBean();
		
		for(int i=0; i<vec.size(); i++){
			if(accountNo == vec.get(i).getAcountNo()){
				temp=vec.get(i);
			}
		}
		return temp;
	}

	@Override
	public int countAccount() {
		return vec.size();
	}

	@Override
	public void updatePassword(AccountBean bean) {
		findByAccount(bean.getAcountNo()).setPassword(bean.getPassword()); 
	}

	@Override
	public void deposit(AccountBean bean) {
		for (int i=0;i<vec.size();i++){
			if(bean.getAcountNo() == vec.get(i).getAcountNo()){
				vec.get(i).setMoney(bean.getMoney() + vec.get(i).getMoney());
			}
		}
	}

	@Override
	public void withdraw(AccountBean bean) {
		for (int i=0;i<vec.size();i++){
			if(bean.getAcountNo() == vec.get(i).getAcountNo()){
				vec.get(i).setMoney(bean.getMoney() - vec.get(i).getMoney());
			}
		}
		
	}

	@Override
	public void deleteAccount(int accountNo) {
		vec.remove(findByAccount(accountNo));
		
	}

}
