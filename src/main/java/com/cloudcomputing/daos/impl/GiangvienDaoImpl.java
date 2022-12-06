package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.GiangvienDao;
import com.cloudcomputing.models.GiangvienModel;

public class GiangvienDaoImpl implements GiangvienDao{

	@Override
	public void save(GiangvienModel giangvienModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()){
			String query = "INSERT INTO sinhvien (maSV, hoTen, ngaySinh, maKhoa, accountID) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, giangvienModel.getMaGV());
			statement.setString(2, giangvienModel.getHoTen());
			statement.setDate(3, giangvienModel.getNgaySinh());
			statement.setInt(4, giangvienModel.getMaKhoa());
			statement.setString(5, giangvienModel.getLoaiGV());
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update(GiangvienModel giangvienModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "UPDATE giangvien SET hoTen = ?, ngaySinh = ?, maKhoa = ?, loaiGV = ? WHERE maGV = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, giangvienModel.getHoTen());
			statement.setDate(2, giangvienModel.getNgaySinh());
			statement.setInt(3, giangvienModel.getMaKhoa());
			statement.setString(4, giangvienModel.getLoaiGV());
			statement.setString(5, giangvienModel.getMaGV());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int maGV) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GiangvienModel findBymaGV(String maGV) {
		// TODO Auto-generated method stub
		return null;
	}

}
