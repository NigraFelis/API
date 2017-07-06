package com.hanbit.api.controller;

import java.util.Vector;

import javax.swing.JOptionPane;

import com.hanbit.api.domain.AccountBean;
import com.hanbit.api.service.Accountservice;
import com.hanbit.api.serviceImpl.AccountServiceImpl;

public class AccountController {
	public static void main(String[] args) {
		Accountservice service = new AccountServiceImpl();
		AccountBean bean = null;
		
		while(true){
			switch(JOptionPane.showInputDialog("0.exit 1.계좌생성 2.계좌 전체 리스트 3.이름으로 검색 4.계좌로 검색 5.총 계좌 수 6.비번변경 7.입금 8.출금 9.계좌삭제")){
			case"0":
				return;
			case"1":
				bean = new AccountBean(); //새로 생성하는 이유? 만들어놓은 빈에 오버라이딩이 안댐
				String[]info= JOptionPane.showInputDialog("이름/비번/아이디/임금액/SSN").split("/");
				bean.setName(info[0]);
				bean.setPassword(info[1]);
				bean.setId(info[2]);
				bean.setMoney(Integer.parseInt(info[3]));
				bean.setSSN(Integer.parseInt(info[4]));
				service.createAccount(bean);
				JOptionPane.showMessageDialog(null, "계좌생성");
				break;
			case"2":
				Vector<AccountBean>vec=service.accountList();
				String list="";
				for(int i=0; i<service.countAccount(); i++){
					list += vec.get(i).toString();
				}
				JOptionPane.showMessageDialog(null, list);

				break;
			case"3":
				Vector<AccountBean>vec2=service.searchByName(JOptionPane.showInputDialog("이름"));
				String namelist="";
				for(int i=0; i<vec2.size(); i++){
					namelist += vec2.get(i).toString();
				}
				JOptionPane.showMessageDialog(null, namelist);

				break;
			case"4":
				bean= service.findByAccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
				JOptionPane.showMessageDialog(null, bean.toString());

				break;
			case"5":
				int count =service.countAccount();
				JOptionPane.showMessageDialog(null, count);

				break;
			case"6":
				String[] foo = JOptionPane.showInputDialog("계좌번호/비번").split("/");
				bean.setAcountNo(Integer.parseInt(foo[0]));
				bean.setPassword((foo[1]));
				service.updatePassword(bean);
				JOptionPane.showMessageDialog(null, "비번변경완료");

				break;
			case"7":
				String[] foo2 = JOptionPane.showInputDialog("계좌번호/예금금액").split("/");
				bean.setAcountNo(Integer.parseInt(foo2[0]));
				bean.setMoney(Integer.parseInt(foo2[1]));
				service.deposit(bean);
				
				JOptionPane.showMessageDialog(null, "예금완료");

				break;
			case"8":
				String[] foo3 = JOptionPane.showInputDialog("계좌번호/출금금액").split("/");
				bean.setAcountNo(Integer.parseInt(foo3[0]));
				bean.setAcountNo(Integer.parseInt(foo3[1]));
				service.withdraw(bean);
				JOptionPane.showMessageDialog(null, "출금금액");

				break;

			case"9":
				service.deleteAccount(Integer.parseInt(JOptionPane.showInputDialog("계좌번호")));
				JOptionPane.showMessageDialog(null, "해지완료");
				break;

			}
		}
	}
}
