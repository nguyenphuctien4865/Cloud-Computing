package com.cloudcomputing.daos;

import com.cloudcomputing.models.LophocphanModel;

import java.util.List;

public interface LophocphanDao {
	void save(LophocphanModel lophocphanModel);
	void update (LophocphanModel lophocphanModel);
	void delete (int id);
	LophocphanModel findByid (int id);
	LophocphanModel findBymaLop (String maLop);
	LophocphanModel fidnBymaMH (String maMH);
	List <LophocphanModel> findAll ();
	List <LophocphanModel> findbyDate (String date, String mh);

}
