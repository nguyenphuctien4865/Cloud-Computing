package com.cloudcomputing.daos.impl;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.cloudcomputing.connection.DatabaseConnection;
import com.cloudcomputing.daos.LophocphanDao;
import com.cloudcomputing.models.KhoaModel;
import com.cloudcomputing.models.LophocphanModel;
import com.mysql.cj.protocol.Resultset;

public class LophocphanDaoImpl implements LophocphanDao {

	@Override
	public void save(LophocphanModel lophocphanModel) {
		try (Connection connection = DatabaseConnection.initializeDatabase()) {
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
		} catch (Exception e) {
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
			statement.setInt(11, lophocphanModel.getId());
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
		LophocphanModel lophocphanModel = new LophocphanModel();
		try (Connection conn = DatabaseConnection.initializeDatabase()) {
			String query = "SELECT id, maLop, loai, maMH, maGV, phong, soSV, ngayBD, namHoc, thu, tiet FROM lophocphan WHERE id = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setInt(1, id);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				lophocphanModel.setId(result.getInt(1));
				lophocphanModel.setMaLop(result.getString(2));
				lophocphanModel.setLoai(result.getString(3));
				lophocphanModel.setMaMH(result.getString(4));
				lophocphanModel.setMaGV(result.getString(5));
				lophocphanModel.setPhong(result.getString(6));
				lophocphanModel.setSoSV(result.getInt(7));
				lophocphanModel.setNgayBD(result.getDate(8));
				lophocphanModel.setNamHoc(result.getInt(9));
				lophocphanModel.setThu(result.getInt(10));
				lophocphanModel.setTiet(result.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lophocphanModel;
	}

	@Override
	public LophocphanModel findBymaLop(String maLop) {
		LophocphanModel lophocphanModel = new LophocphanModel();
		try (Connection conn = DatabaseConnection.initializeDatabase()) {
			String query = "SELECT id, maLop, loai, maMH, maGV, phong, soSV, ngayBD, namHoc, thu, tiet FROM lophocphan WHERE maLop = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, maLop);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				lophocphanModel.setId(result.getInt(1));
				lophocphanModel.setMaLop(result.getString(2));
				lophocphanModel.setLoai(result.getString(3));
				lophocphanModel.setMaMH(result.getString(4));
				lophocphanModel.setMaGV(result.getString(5));
				lophocphanModel.setPhong(result.getString(6));
				lophocphanModel.setSoSV(result.getInt(7));
				lophocphanModel.setNgayBD(result.getDate(8));
				lophocphanModel.setNamHoc(result.getInt(9));
				lophocphanModel.setThu(result.getInt(10));
				lophocphanModel.setTiet(result.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lophocphanModel;
	}

	@Override
	public LophocphanModel fidnBymaMH(String maMH) {
		LophocphanModel lophocphanModel = new LophocphanModel();
		try (Connection conn = DatabaseConnection.initializeDatabase()) {
			String query = "SELECT id, maLop, loai, maMH, maGV, phong, soSV, ngayBD, namHoc, thu, tiet FROM lophocphan WHERE maMH = ?";
			PreparedStatement statement = conn.prepareStatement(query);
			statement.setString(1, maMH);
			ResultSet result = statement.executeQuery();
			while (result.next()) {
				lophocphanModel.setId(result.getInt(1));
				lophocphanModel.setMaLop(result.getString(2));
				lophocphanModel.setLoai(result.getString(3));
				lophocphanModel.setMaMH(result.getString(4));
				lophocphanModel.setMaGV(result.getString(5));
				lophocphanModel.setPhong(result.getString(6));
				lophocphanModel.setSoSV(result.getInt(7));
				lophocphanModel.setNgayBD(result.getDate(8));
				lophocphanModel.setNamHoc(result.getInt(9));
				lophocphanModel.setThu(result.getInt(10));
				lophocphanModel.setTiet(result.getString(11));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return lophocphanModel;
	}

	@Override
	public List<LophocphanModel> findAll() {
		List<LophocphanModel> lop = new ArrayList<>();
		try (Connection conn = DatabaseConnection.initializeDatabase()) {
			String query = "SELECT id, maLop, loai, maMH, maGV, phong, soSV, ngayBD, namHoc, thu, tiet FROM lophocphan";
			PreparedStatement statement = conn.prepareStatement(query);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				lop.add(new LophocphanModel(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4),
						rs.getString(5), rs.getString(6), rs.getInt(7), rs.getDate(8), rs.getInt(9), rs.getInt(10),
						rs.getString(11)));
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return lop;
	}

}
