package com.cloudcomputing.daos;

import java.util.List;

import com.cloudcomputing.models.SinhvienModel;

public interface SinhvienDao {
	void save (SinhvienModel sinhvienModel);
	void update (SinhvienModel sinhvienModel);
	void delete (String maSV);
	SinhvienModel findByMaSV (String maSV);
	List <SinhvienModel> findAll ();
}
