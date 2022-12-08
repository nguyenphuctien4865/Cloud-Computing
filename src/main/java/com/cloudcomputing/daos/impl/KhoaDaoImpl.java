package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
		KhoaModel khoaModel = new KhoaModel();
		try(Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT khoaID, tenKhoa FROM khoa where khoaID = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, khoaID);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				khoaModel.setKhoaID(result.getInt(1));
				khoaModel.setTenKhoa(result.getString(2));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return khoaModel;
	}
	
}
