package com.cloudcomputing.service.impl;

import com.cloudcomputing.daos.KhoaDao;
import com.cloudcomputing.daos.impl.KhoaDaoImpl;
import com.cloudcomputing.models.KhoaModel;
import com.cloudcomputing.service.KhoaService;

public class KhoaServiceImpl implements KhoaService {
	private KhoaDao dao = new KhoaDaoImpl();

	@Override
	public void save(KhoaModel khoaModel) {
		// TODO Auto-generated method stub
		dao.save(khoaModel);
	}

	@Override
	public void update(KhoaModel khoaModel) {
		// TODO Auto-generated method stub
		dao.update(khoaModel);
	}

	@Override
	public void delete(int khoaID) {
		// TODO Auto-generated method stub
		dao.delete(khoaID);
	}

	@Override
	public KhoaModel findBykhoaID(int khoaID) {
		return dao.findBykhoaID(khoaID);
	}
}
