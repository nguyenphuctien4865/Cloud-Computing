package com.cloudcomputing.daos.impl;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.DaymonDao;
import com.cloudcomputing.models.DaymonModel;
import com.cloudcomputing.models.MonhocModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

	@Override
	public List<DaymonModel> findByMaMH(String maMH) {
		List<DaymonModel> daymon = new ArrayList<>();
		try(Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT maMH, maGV FROM daymon WHERE maMH = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, maMH);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				daymon.add(new DaymonModel(rs.getString(1), rs.getString(2)));	
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return daymon;
	}
}
