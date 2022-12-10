package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import com.cloudcomputing.daos.AccountDao;
import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.models.MonhocModel;

public class AccountDaoImpl implements AccountDao {

	@Override
	public void save(AccountModel accountModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "INSERT INTO account(username, password, type) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, accountModel.getUsername());
			statement.setString(2, accountModel.getPassword());
			statement.setString(3, accountModel.getType());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(AccountModel accountModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "UPDATE account SET username = ?, password = ?, type = ? WHERE accountID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, accountModel.getUsername());
			statement.setString(2, accountModel.getPassword());
			statement.setString(3, accountModel.getType());
			statement.setInt(4, accountModel.getAccountID());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int accountID) {
		// TODO Auto-generated method stub

	}

	@Override
	public AccountModel findbyUsername(String username) {
		AccountModel account = new AccountModel();
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "SELECT * FROM account WHERE username = ?";
			var statement = connection.prepareStatement(query);
			statement.setString(1, username);
			var result = statement.executeQuery();
			while (result.next()){
				account.setAccountID(result.getInt(1));
				account.setUsername(result.getString(2));
				account.setPassword(result.getString(3));
				account.setType(result.getString(4));
			}


		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return account;
	}

}
