package com.cloudcomputing.service.impl;

import com.cloudcomputing.daos.LopthamgiaDao;
import com.cloudcomputing.daos.impl.LopthamgiaDaoImpl;
import com.cloudcomputing.models.LopthamgiaModel;
import com.cloudcomputing.service.LopthamgiaService;

public class LopthamgiaServiceImpl implements LopthamgiaService{
	private final LopthamgiaDao dao = new LopthamgiaDaoImpl();
	@Override
	public void save(LopthamgiaModel lopthamgiaModel) {
		// TODO Auto-generated method stub
		dao.save(lopthamgiaModel);
	}

	@Override
	public void update(LopthamgiaModel lopthamgiaModel) {
		// TODO Auto-generated method stub
		dao.update(lopthamgiaModel);
	}

	@Override
	public void delete(LopthamgiaModel lopthamgiaModel) {
		// TODO Auto-generated method stub
		dao.delete(lopthamgiaModel);
	}

	@Override
	public LopthamgiaModel findBylopID(int lopID) {
		// TODO Auto-generated method stub
		dao.findBylopID(lopID);
		return null;
	}

}
