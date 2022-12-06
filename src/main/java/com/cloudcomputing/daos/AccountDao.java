package com.cloudcomputing.daos;

import com.cloudcomputing.models.AccountModel;

public interface AccountDao {
	void save (AccountModel accountModel);
	void update (AccountModel accountModel);
	void delete (int accountID);
}
