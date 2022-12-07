package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.KhoaDao;
import com.cloudcomputing.models.KhoaModel;

public class KhoaDaoImpl implements KhoaDao{

	@Override
	public void save(KhoaModel khoaModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()){
			String query = "INSERT INTO khoa (tenKhoa) VALUES (?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, khoaModel.getTenKhoa());
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(KhoaModel khoaModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "UPDATE khoa SET tenKhoa = ? WHERE khoaID = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, khoaModel.getTenKhoa());
			statement.setInt(2, khoaModel.getKhoaID());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void delete(int khoaID) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public KhoaModel findBykhoaID(int khoaID) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
