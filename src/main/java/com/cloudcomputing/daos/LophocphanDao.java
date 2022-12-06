package com.cloudcomputing.daos;

import com.cloudcomputing.models.LophocphanModel;

public interface LophocphanDao {
	void save(LophocphanModel lophocphanmodel);
	void update (LophocphanModel lophocphanModel);
	void delete (int id);
	LophocphanModel findByid (int id);
	LophocphanModel findBymaLop (String maLop);
	LophocphanModel fidnBymaMH (String maMH);
}
