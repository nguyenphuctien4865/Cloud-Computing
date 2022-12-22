package com.cloudcomputing.daos;

import com.cloudcomputing.models.LophocphanModel;

import java.time.LocalDate;
import java.util.List;

public interface LophocphanDao {
	void save(LophocphanModel lophocphanModel);
	void update (LophocphanModel lophocphanModel);
	void delete (int id);
	LophocphanModel findByid (int id);
	LophocphanModel findBymaLop (String maLop);
	LophocphanModel fidnBymaMH (String maMH);
	List <LophocphanModel> findAll ();
	List <LophocphanModel> findbyDate (LocalDate date, String mh);
	List <LophocphanModel> findbymsSV (LocalDate date,  String msSV);


}
