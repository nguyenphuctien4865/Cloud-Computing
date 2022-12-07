package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.LopthamgiaDao;
import com.cloudcomputing.models.LopthamgiaModel;

public class LopthamgiaDaoImpl implements LopthamgiaDao{

	@Override
	public void save(LopthamgiaModel lopthamgiaModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "INSERT INTO lopthamgia (maSV, lopID, diem) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, lopthamgiaModel.getMaSV());
			statement.setInt(2, lopthamgiaModel.getLopID());
			statement.setFloat(2, lopthamgiaModel.getDiem());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(LopthamgiaModel lopthamgiaModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(LopthamgiaModel lopthamgiaModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LopthamgiaModel findBylopID(int lopID) {
		// TODO Auto-generated method stub
		return null;
	}

}
