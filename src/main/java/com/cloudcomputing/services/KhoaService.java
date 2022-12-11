package com.cloudcomputing.services;

import com.cloudcomputing.models.KhoaModel;

import java.util.List;

public interface KhoaService {
	void save(KhoaModel khoaModel);
	void update (KhoaModel khoaModel);
	void delete (int khoaID);
	KhoaModel findBykhoaID (int khoaID);
	List <KhoaModel> findAll ();
}
