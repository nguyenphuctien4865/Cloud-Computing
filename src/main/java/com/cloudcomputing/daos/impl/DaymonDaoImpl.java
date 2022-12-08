package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.DaymonDao;
import com.cloudcomputing.models.DaymonModel;

public class DaymonDaoImpl implements DaymonDao {

	@Override
	public void save(DaymonModel daymonModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "INSERT INTO daymon (maMH, maGV) VALUES (?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, daymonModel.getMaMH());
			statement.setString(2, daymonModel.getMaGV());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(DaymonModel daymonModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()){
			String query = "UPDATE daymon SET maGV = ? WHERE maMH = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, daymonModel.getMaGV());
			statement.setString(2, daymonModel.getMaMH());
			statement.executeUpdate();
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}
