package com.cloudcomputing.services;

import com.cloudcomputing.models.LophocphanModel;
import com.cloudcomputing.models.LopthamgiaModel;

import java.util.List;

public interface LopthamgiaService {
	void save (LopthamgiaModel lopthamgiaModel);
	void update (LopthamgiaModel lopthamgiaModel);
	void delete (LopthamgiaModel lopthamgiaModel );
	LopthamgiaModel findBylopID (int lopID);
	List<LopthamgiaModel> findbyDate (String date, String msSV);
	List<LopthamgiaModel> findbymsSV ( String msSV);


}
