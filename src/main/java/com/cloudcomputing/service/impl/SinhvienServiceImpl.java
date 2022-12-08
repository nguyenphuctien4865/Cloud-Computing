package com.cloudcomputing.service.impl;

import com.cloudcomputing.daos.SinhvienDao;
import com.cloudcomputing.daos.impl.SinhvienDaoImpl;
import com.cloudcomputing.models.SinhvienModel;
import com.cloudcomputing.service.SinhvienService;

public class SinhvienServiceImpl implements SinhvienService{
	private final SinhvienDao dao = new SinhvienDaoImpl();
	@Override
	public void save(SinhvienModel sinhvienModel) {
		// TODO Auto-generated method stub
		dao.save(sinhvienModel);
	}

	@Override
	public void update(SinhvienModel sinhvienModel) {
		// TODO Auto-generated method stub
		dao.update(sinhvienModel);
	}

	@Override
	public void delete(String maSV) {
		// TODO Auto-generated method stub
		dao.delete(maSV);
	}

	@Override
	public SinhvienModel findByMaSV(String maSV) {
		// TODO Auto-generated method stub
		dao.findByMaSV(maSV);
		return null;
	}

}
