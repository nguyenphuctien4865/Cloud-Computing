package com.cloudcomputing.daos.impl;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.AccountDao;
import com.cloudcomputing.models.AccountModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

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
	public AccountModel searchByUsername(String username) {
		AccountModel accountModel = new AccountModel();
		try (Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT accountID, username, password, type FROM account WHERE username = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, username);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				accountModel.setAccountID(rs.getInt(1));
				accountModel.setUsername(rs.getString(2));
				accountModel.setPassword(rs.getString(3));
				accountModel.setType(rs.getString(4));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return accountModel;
	}

	@Override
	public List<AccountModel> findAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
