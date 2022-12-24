package com.cloudcomputing.daos.impl;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.LopthamgiaDao;
import com.cloudcomputing.models.LopthamgiaModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LopthamgiaDaoImpl implements LopthamgiaDao{

	@Override
	public void save(LopthamgiaModel lopthamgiaModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "INSERT INTO lopthamgia (maSV, lopID, diem) VALUES (?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, lopthamgiaModel.getMaSV());
			statement.setInt(2, lopthamgiaModel.getLopID());
			statement.setFloat(3, lopthamgiaModel.getDiem());
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
	public List<LopthamgiaModel> findBylopID(int lopID) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<LopthamgiaModel> findBymaSV(String msSV) {
		List<LopthamgiaModel> lopthamgia = new ArrayList<>();
		try (Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT * FROM (lopthamgia WHERE msSV=?)";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, msSV);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				lopthamgia.add(new LopthamgiaModel(rs.getString(1),rs.getInt(2),rs.getFloat(3)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lopthamgia;
	}




}
