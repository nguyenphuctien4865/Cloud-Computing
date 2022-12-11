package com.cloudcomputing.service.impl;

import com.cloudcomputing.daos.AccountDao;
import com.cloudcomputing.daos.impl.AccountDaoImpl;
import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.service.AccountService;

public class AccountServiceImpl implements AccountService{
	public final AccountDao dao = new AccountDaoImpl();

	@Override
	public void save(AccountModel accounModel) {
		dao.save(accounModel);
	}

	@Override
	public void update(AccountModel accountModel) {
		dao.update(accountModel);
	}

	@Override
	public void delete(int accountID) {
		dao.delete(accountID);
	}

	@Override
	public AccountModel searchByUsername(String username) {
		return dao.searchByUsername(username);
	}

}
