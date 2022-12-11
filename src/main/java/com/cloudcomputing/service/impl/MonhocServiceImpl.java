package com.cloudcomputing.service.impl;

import java.util.List;

import com.cloudcomputing.daos.MonhocDao;
import com.cloudcomputing.daos.impl.MonhocDaoImpl;
import com.cloudcomputing.models.MonhocModel;
import com.cloudcomputing.service.MonhocService;

public class MonhocServiceImpl implements MonhocService{
	private final MonhocDao dao = new MonhocDaoImpl();
	@Override
	public void save(MonhocModel monhocmodel) {
		// TODO Auto-generated method stub
		dao.save(monhocmodel);
	}

	@Override
	public void update(MonhocModel monhocmodel) {
		// TODO Auto-generated method stub
		dao.update(monhocmodel);
	}

	@Override
	public void delete(String maMH) {
		// TODO Auto-generated method stub
		dao.delete(maMH);
	}

	@Override
	public List<MonhocModel> findAll() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

}
