package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cloudcomputing.daos.AccountDao;
import com.cloudcomputing.models.AccountModel;
import com.cloudcomputing.connection.DatabaseConnection;

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

}
