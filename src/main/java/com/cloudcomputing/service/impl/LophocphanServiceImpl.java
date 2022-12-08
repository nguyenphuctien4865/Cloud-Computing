package com.cloudcomputing.service.impl;

import com.cloudcomputing.daos.LophocphanDao;
import com.cloudcomputing.daos.impl.LophocphanDaoImpl;
import com.cloudcomputing.models.LophocphanModel;
import com.cloudcomputing.service.LophocphanService;

public class LophocphanServiceImpl implements LophocphanService{
	private final LophocphanDao dao = new LophocphanDaoImpl();
	@Override
	public void save(LophocphanModel lophocphanModel) {
		// TODO Auto-generated method stub
		dao.save(lophocphanModel);
	}

	@Override
	public void update(LophocphanModel lophocphanModel) {
		// TODO Auto-generated method stub
		dao.update(lophocphanModel);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		dao.delete(id);
	}

	@Override
	public LophocphanModel findByid(int id) {
		dao.findByid(id);
		return null;
	}

	@Override
	public LophocphanModel findBymaLop(String maLop) {
		dao.findBymaLop(maLop);
		return null;
	}

	@Override
	public LophocphanModel fidnBymaMH(String maMH) {
		dao.fidnBymaMH(maMH);
		return null;
	}

}
