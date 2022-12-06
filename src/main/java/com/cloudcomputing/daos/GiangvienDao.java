package com.cloudcomputing.daos;

import com.cloudcomputing.models.GiangvienModel;

public interface GiangvienDao {
	void save (GiangvienModel giangvienModel);
	void update (GiangvienModel giangvienModel);
	void delete (int maGV);
	GiangvienModel findBymaGV (String maGV);
}
