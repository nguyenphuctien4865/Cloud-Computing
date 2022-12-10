package com.cloudcomputing.services;

import com.cloudcomputing.daos.AccountDao;
import com.cloudcomputing.daos.impl.AccountDaoImpl;
import com.cloudcomputing.models.AccountModel;

public class AccountService {

    private AccountDao dao = new AccountDaoImpl();

    public AccountModel findbyUsername(String username){
        return dao.findbyUsername(username);
    }
}
