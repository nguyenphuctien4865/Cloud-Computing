package com.cloudcomputing.service;

import java.util.List;

import com.cloudcomputing.models.LophocphanModel;

public interface LophocphanService {
	void save(LophocphanModel lophocphanModel);
	void update (LophocphanModel lophocphanModel);
	void delete (int id);
	LophocphanModel findByid (int id);
	LophocphanModel findBymaLop (String maLop);
	LophocphanModel fidnBymaMH (String maMH);
	List <LophocphanModel> findAll ();
}
