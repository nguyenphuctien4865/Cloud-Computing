package com.cloudcomputing.daos;

import java.util.List;

import com.cloudcomputing.models.AccountModel;

import java.util.List;

public interface AccountDao {
	void save (AccountModel accountModel);
	void update (AccountModel accountModel);
	void delete (int accountID);
	AccountModel searchByUsername(String username);
	List <AccountModel> findAll();
}
