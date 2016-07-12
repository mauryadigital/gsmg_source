package com.pts.ats.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pts.ats.DAO.Account;
import com.pts.ats.DAO.AccountDao;

@Service("accountService")
public class AccountService {

	private AccountDao accountDao;
	/**
	 * @param userDao the userDao to set
	 */
	@Autowired
	public void setAccountDao(AccountDao accountDao) {
		this.accountDao = accountDao;
	}
	public void createAccount(Account account) {
		// TODO Auto-generated method stub
		accountDao.createAccount(account);
	}
	public boolean exists(String userName) {
		// TODO Auto-generated method stub
		return accountDao.exists(userName);
	}


}
