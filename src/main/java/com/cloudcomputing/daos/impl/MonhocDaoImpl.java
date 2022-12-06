package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.MonhocDao;
import com.cloudcomputing.models.MonhocModel;

public class MonhocDaoImpl implements MonhocDao{

	@Override
	public void save(MonhocModel monhocmodel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()){
			String query = "INSERT INTO monhoc (maMH, tenMH, loai, soTC, khoaID) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, monhocmodel.getMaMH());
			statement.setString(2, monhocmodel.getTenMH());
			statement.setString(3, monhocmodel.getLoai());
			statement.setInt(4, monhocmodel.getSoTC());
			statement.setInt(5, monhocmodel.getKhoaID());
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(MonhocModel monhocmodel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "UPDATE sinhvien SET tenMH = ?, loai = ?, soTC = ?, khoaID = ? WHERE maMH = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, monhocmodel.getTenMH());
			statement.setString(2, monhocmodel.getLoai());
			statement.setInt(3, monhocmodel.getSoTC());
			statement.setInt(4, monhocmodel.getKhoaID());
			statement.setString(5, monhocmodel.getMaMH());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String maMH) {
		// TODO Auto-generated method stub
		
	}

}
