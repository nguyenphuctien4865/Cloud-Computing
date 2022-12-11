package com.cloudcomputing.services;

import com.cloudcomputing.models.LopthamgiaModel;

public interface LopthamgiaService {
	void save (LopthamgiaModel lopthamgiaModel);
	void update (LopthamgiaModel lopthamgiaModel);
	void delete (LopthamgiaModel lopthamgiaModel );
	LopthamgiaModel findBylopID (int lopID);
}
