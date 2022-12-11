package com.cloudcomputing.services;

import com.cloudcomputing.models.LophocphanModel;
import com.cloudcomputing.models.LopthamgiaModel;

import java.util.List;

public interface LophocphanService {
	void save(LophocphanModel lophocphanModel);
	void update (LophocphanModel lophocphanModel);
	void delete (int id);
	LophocphanModel findByid (int id);
	LophocphanModel findBymaLop (String maLop);
	LophocphanModel fidnBymaMH (String maMH);
	List <LophocphanModel> findAll ();
	List <LophocphanModel> findbyDate (String date, String mh);

	List <LophocphanModel> findbymsSV (String date, String msSV);



}
