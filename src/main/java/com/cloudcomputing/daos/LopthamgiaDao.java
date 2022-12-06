package com.cloudcomputing.daos;

import com.cloudcomputing.models.LopthamgiaModel;

public interface LopthamgiaDao {
	void save (LopthamgiaModel lopthamgiaModel);
	void update (LopthamgiaModel lopthamgiaModel);
	void delete (LopthamgiaModel lopthamgiaModel );
	LopthamgiaModel findBylopID (int lopID);
}
