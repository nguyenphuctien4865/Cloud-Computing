package com.cloudcomputing.service;

import com.cloudcomputing.models.GiangvienModel;

public interface GiangvienService {
	void save (GiangvienModel giangvienModel);
	void update (GiangvienModel giangvienModel);
	void delete (int maGV);
	GiangvienModel findBymaGV (String maGV);
}
