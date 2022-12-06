package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.SinhvienDao;
import com.cloudcomputing.models.SinhvienModel;

public class SinhvienDaoImpl implements SinhvienDao{

	@Override
	public void save(SinhvienModel sinhvienModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()){
			String query = "INSERT INTO sinhvien (maSV, hoTen, ngaySinh, maKhoa, accountID) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, sinhvienModel.getMaSV());
			statement.setString(2, sinhvienModel.getHoTen());
			statement.setDate(3, sinhvienModel.getNgaySinh());
			statement.setInt(4, sinhvienModel.getMaKhoa());
			statement.setInt(5, sinhvienModel.getAccountID());
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void update(SinhvienModel sinhvienModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "UPDATE sinhvien SET hoTen = ?, ngaySinh = ?, maKhoa = ?, accountID = ? WHERE maSV = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, sinhvienModel.getHoTen());
			statement.setDate(2, sinhvienModel.getNgaySinh());
			statement.setInt(3, sinhvienModel.getMaKhoa());
			statement.setInt(4, sinhvienModel.getAccountID());
			statement.setString(5, sinhvienModel.getMaSV());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String maSV) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public SinhvienModel findByMaSV(String maSV) {
		// TODO Auto-generated method stub
		return null;
	}

}
