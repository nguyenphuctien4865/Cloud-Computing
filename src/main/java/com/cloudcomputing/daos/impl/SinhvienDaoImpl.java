package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		SinhvienModel sinhvienModel = new SinhvienModel();
		try (Connection conn =  DatabaseConnection.initializeDatabase()){
			String query = "SELECT maSV, hoTen, ngaySinh, maKhoa, accountID FROM sinhvien WHERE maSV = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, maSV);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				sinhvienModel.setMaSV(rs.getString(1));
				sinhvienModel.setHoTen(rs.getString(2));
				sinhvienModel.setNgaySinh(rs.getDate(3));
				sinhvienModel.setMaKhoa(rs.getInt(4));
				sinhvienModel.setAccountID(rs.getInt(5));
			}
		}catch (Exception e) {
			e.printStackTrace();
		}
		return sinhvienModel;
	}

	@Override
	public List<SinhvienModel> findAll() {
		List <SinhvienModel> sinhvien = new ArrayList<>();
		try(Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT maSV, hoTen, ngaySinh, maKhoa, accountID FROM sinhvien";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				sinhvien.add(new SinhvienModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getInt(5)));
				
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return sinhvien;
	}

}
