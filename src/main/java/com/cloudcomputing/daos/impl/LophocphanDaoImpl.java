package com.cloudcomputing.daos.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.LophocphanDao;
import com.cloudcomputing.models.LophocphanModel;

public class LophocphanDaoImpl implements LophocphanDao{

	@Override
	public void save(LophocphanModel lophocphanModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()){
			String query = "INSERT INTO lophocphan (maLop, loai, maMH, maGV, phong, soSV, ngayBD, namHoc, thu, tiet) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, lophocphanModel.getMaLop());
			statement.setString(2, lophocphanModel.getLoai());
			statement.setString(3, lophocphanModel.getMaMH());
			statement.setString(4, lophocphanModel.getMaGV());
			statement.setString(5, lophocphanModel.getPhong());
			statement.setInt(6, lophocphanModel.getSoSV());
			statement.setDate(7, lophocphanModel.getNgayBD());
			statement.setInt(8, lophocphanModel.getNamHoc());
			statement.setInt(9, lophocphanModel.getThu());
			statement.setString(10, lophocphanModel.getTiet());
			statement.executeUpdate();
		}
		catch (Exception e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void update(LophocphanModel lophocphanModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
			String query = "UPDATE lophocphan SET maLop = ?, loai = ?, maMH = ?, maGV = ?, phong = ?, soSV = ?, ngayBD = ?, namHoc = ?, thu = ?, tiet = ? WHERE id = ?";
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, lophocphanModel.getMaLop());
			statement.setString(2, lophocphanModel.getLoai());
			statement.setString(3, lophocphanModel.getMaMH());
			statement.setString(4, lophocphanModel.getMaGV());
			statement.setString(5, lophocphanModel.getPhong());
			statement.setInt(6, lophocphanModel.getSoSV());
			statement.setDate(7, lophocphanModel.getNgayBD());
			statement.setInt(8, lophocphanModel.getNamHoc());
			statement.setInt(9, lophocphanModel.getThu());
			statement.setString(10, lophocphanModel.getTiet());
			statement.setInt (11, lophocphanModel.getId());
			statement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public LophocphanModel findByid(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LophocphanModel findBymaLop(String maLop) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public LophocphanModel fidnBymaMH(String maMH) {
		// TODO Auto-generated method stub
		return null;
	}

}
