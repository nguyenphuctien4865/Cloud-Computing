package com.cloudcomputing.daos;

import com.cloudcomputing.models.SinhvienModel;

import java.util.List;

public interface SinhvienDao {
	void save (SinhvienModel sinhvienModel);
	void update (SinhvienModel sinhvienModel);
	void delete (String maSV);
	SinhvienModel findByMaSV (String maSV);
	List <SinhvienModel> findAll ();
}
