package com.cloudcomputing.service.impl;

import com.cloudcomputing.daos.GiangvienDao;
import com.cloudcomputing.daos.impl.GiangvienDaoImpl;
import com.cloudcomputing.models.GiangvienModel;
import com.cloudcomputing.service.GiangvienService;

public class GiangvienServiceImpl implements GiangvienService{

	private final GiangvienDao dao = new GiangvienDaoImpl();
	@Override
	public void save(GiangvienModel giangvienModel) {
		
		dao.save(giangvienModel);
	}

	@Override
	public void update(GiangvienModel giangvienModel) {
		dao.update(giangvienModel);
	}

	@Override
	public void delete(int maGV) {
		dao.delete(maGV);
	}

	@Override
	public GiangvienModel findBymaGV(String maGV) {
		return dao.findBymaGV(maGV);
	}

}
