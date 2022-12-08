package com.cloudcomputing.service;

import com.cloudcomputing.models.KhoaModel;

public interface KhoaService {
	void save(KhoaModel khoaModel);
	void update (KhoaModel khoaModel);
	void delete (int khoaID);
	KhoaModel findBykhoaID (int khoaID);
}
