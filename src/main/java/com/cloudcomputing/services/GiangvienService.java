package com.cloudcomputing.services;

import com.cloudcomputing.models.GiangvienModel;

import java.util.List;

public interface GiangvienService {
	void save (GiangvienModel giangvienModel);
	void update (GiangvienModel giangvienModel);
	void delete (int maGV);
	GiangvienModel findBymaGV (String maGV);
	List <GiangvienModel> findAll ();
}
