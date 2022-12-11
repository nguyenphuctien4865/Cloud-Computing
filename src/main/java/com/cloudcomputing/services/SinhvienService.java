package com.cloudcomputing.services;

import com.cloudcomputing.models.SinhvienModel;

import java.util.List;

public interface SinhvienService {
	void save (SinhvienModel sinhvienModel);
	void update (SinhvienModel sinhvienModel);
	void delete (String maSV);
	SinhvienModel findByMaSV (String maSV);
	List <SinhvienModel> findAll ();
}
