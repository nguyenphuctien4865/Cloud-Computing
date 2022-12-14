package com.cloudcomputing.services.impl;

import com.cloudcomputing.daos.SinhvienDao;
import com.cloudcomputing.daos.impl.SinhvienDaoImpl;
import com.cloudcomputing.models.SinhvienModel;
import com.cloudcomputing.services.SinhvienService;

import java.util.List;

public class SinhvienServiceImpl implements SinhvienService{
	private final SinhvienDao dao = new SinhvienDaoImpl();
	@Override
	public void save(SinhvienModel sinhvienModel) {
		dao.save(sinhvienModel);
	}

	@Override
	public void update(SinhvienModel sinhvienModel) {
		dao.update(sinhvienModel);
	}

	@Override
	public void delete(String maSV) {
		dao.delete(maSV);
	}

	@Override
	public SinhvienModel findByMaSV(String maSV) {
		return dao.findByMaSV(maSV);
	}

	@Override
	public List<SinhvienModel> findAll() {
		return dao.findAll();
	}

}
