package com.cloudcomputing.services;

import com.cloudcomputing.models.AccountModel;

public interface AccountService {
	void save (AccountModel accounModel);
	void update (AccountModel accountModel);
	void delete (int accountID);
	AccountModel searchByUsername(String username);
}
