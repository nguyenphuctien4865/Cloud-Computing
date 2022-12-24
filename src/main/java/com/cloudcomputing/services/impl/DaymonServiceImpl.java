package com.cloudcomputing.services.impl;

import java.util.List;

import com.cloudcomputing.daos.DaymonDao;
import com.cloudcomputing.daos.impl.DaymonDaoImpl;
import com.cloudcomputing.models.DaymonModel;
import com.cloudcomputing.services.DaymonService;

public class DaymonServiceImpl implements DaymonService{
	private final DaymonDao dao = new DaymonDaoImpl();
	@Override
	public void save(DaymonModel daymonModel) {
		// TODO Auto-generated method stub
		dao.save(daymonModel);
	}

	@Override
	public void update(DaymonModel daymonModel) {
		// TODO Auto-generated method stub
		dao.update(daymonModel);
	}

	@Override
	public List<DaymonModel> findByMaMH(String maMH) {
		return dao.findByMaMH(maMH);
	}
	
}
