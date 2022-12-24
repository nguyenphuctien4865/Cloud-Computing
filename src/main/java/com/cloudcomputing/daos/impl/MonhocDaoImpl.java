package com.cloudcomputing.daos.impl;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.MonhocDao;
import com.cloudcomputing.models.MonhocModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
			String query = "UPDATE monhoc SET tenMH = ?, loai = ?, soTC = ?, khoaID = ? WHERE maMH = ?";
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

	@Override
	public List<MonhocModel> findAll() {
		List <MonhocModel> monhoc = new ArrayList<>();
		try(Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT maMH, tenMH, loai, soTC, khoaID FROM monhoc";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				monhoc.add(new MonhocModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4), rs.getInt(5)));
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return monhoc;
	}

	@Override
	public List<MonhocModel> findbyCurrentUser( int khoa) {
		List<MonhocModel> monhocModels = new ArrayList<>();
		try (Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT maMH, tenMH, loai,soTC,khoaID FROM monhoc WHERE khoaID=?;";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, khoa);

			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				monhocModels.add(new MonhocModel(rs.getString(1), rs.getString(2), rs.getString(3), rs.getInt(4),rs.getInt(5)));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return monhocModels;
	}

	@Override
	public MonhocModel findByMaMH(String maMH) {
		MonhocModel monhocModel = new MonhocModel();
		try(Connection conn = DatabaseConnection.initializeDatabase()){
			String query ="SELECT maMH, tenMH, loai, soTC, khoaID FROM monhoc where maMH = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, maMH);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				monhocModel.setMaMH(result.getString(1));
				monhocModel.setTenMH(result.getString(2));
				monhocModel.setLoai(result.getString(3));
				monhocModel.setSoTC(result.getInt(4));
				monhocModel.setKhoaID(result.getInt(5));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return monhocModel;
	}

}
