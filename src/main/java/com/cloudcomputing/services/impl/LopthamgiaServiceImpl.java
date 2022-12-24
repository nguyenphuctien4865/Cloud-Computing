package com.cloudcomputing.services.impl;

import com.cloudcomputing.daos.LopthamgiaDao;
import com.cloudcomputing.daos.impl.LopthamgiaDaoImpl;
import com.cloudcomputing.models.LopthamgiaModel;
import com.cloudcomputing.services.LopthamgiaService;

import java.util.List;

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

	@Override
	public List<LopthamgiaModel> findbyDate(String date, String msSV) {
		return null;
	}

	@Override
	public List<LopthamgiaModel> findbymsSV(String msSV) {
		return dao.findBymaSV(msSV);
	}

}
