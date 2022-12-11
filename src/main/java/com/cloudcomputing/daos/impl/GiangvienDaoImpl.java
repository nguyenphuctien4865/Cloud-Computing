package com.cloudcomputing.daos.impl;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.GiangvienDao;
import com.cloudcomputing.models.GiangvienModel;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
		GiangvienModel	giangvienModel = new GiangvienModel();
		try(Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT maGV, hoTen, ngaySinh, maKhoa, loaiGV FROM giangvien where maGV = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, maGV);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				giangvienModel.setMaGV(result.getString(1));
				giangvienModel.setHoTen(result.getString(2));
				giangvienModel.setNgaySinh(result.getDate(3));
				giangvienModel.setMaKhoa(result.getInt(4));
				giangvienModel.setLoaiGV(result.getString(5));
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
		return giangvienModel; 
	}

	@Override
	public List<GiangvienModel> findAll() {
		List <GiangvienModel> giangvien = new ArrayList<>();
		try(Connection conn = DatabaseConnection.initializeDatabase()){
			String query = "SELECT maGV, hoTen, ngaySinh, maKhoa, loaiGV FROM giangvien";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				giangvien.add(new GiangvienModel(rs.getString(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5)));
			}
		}catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return giangvien;
	}

}
