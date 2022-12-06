package com.cloudcomputing.daos;

import com.cloudcomputing.models.KhoaModel;

public interface KhoaDao {
	void save(KhoaModel khoaModel);
	void update (KhoaModel khoaModel);
	void delete (int khoaID);
	KhoaModel findBykhoaID (int khoaID);
}
