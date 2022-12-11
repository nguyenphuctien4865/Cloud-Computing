package com.cloudcomputing.service.impl;

import java.util.List;

import com.cloudcomputing.daos.LophocphanDao;
import com.cloudcomputing.daos.impl.LophocphanDaoImpl;
import com.cloudcomputing.models.LophocphanModel;
import com.cloudcomputing.service.LophocphanService;

public class LophocphanServiceImpl implements LophocphanService{
	private final LophocphanDao dao = new LophocphanDaoImpl();
	@Override
	public void save(LophocphanModel lophocphanModel) {
		dao.save(lophocphanModel);
	}

	@Override
	public void update(LophocphanModel lophocphanModel) {
		dao.update(lophocphanModel);
	}

	@Override
	public void delete(int id) {
		dao.delete(id);
	}

	@Override
	public LophocphanModel findByid(int id) {
		return dao.findByid(id);
	}

	@Override
	public LophocphanModel findBymaLop(String maLop) {
		return dao.findBymaLop(maLop);
	}

	@Override
	public LophocphanModel fidnBymaMH(String maMH) {
		return dao.fidnBymaMH(maMH);
	}

	@Override
	public List<LophocphanModel> findAll() {
		return dao.findAll();
	}

}
