package com.cloudcomputing.service;

import com.cloudcomputing.models.SinhvienModel;

public interface SinhvienService {
	void save (SinhvienModel sinhvienModel);
	void update (SinhvienModel sinhvienModel);
	void delete (String maSV);
	SinhvienModel findByMaSV (String maSV);
}
