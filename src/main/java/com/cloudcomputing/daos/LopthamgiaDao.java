package com.cloudcomputing.daos;

import com.cloudcomputing.models.LopthamgiaModel;

import java.util.List;

public interface LopthamgiaDao {
	void save (LopthamgiaModel lopthamgiaModel);
	void update (LopthamgiaModel lopthamgiaModel);
	void delete (LopthamgiaModel lopthamgiaModel );
	List<LopthamgiaModel> findBylopID (int lopID);
	List<LopthamgiaModel> findBymaSV (String msSV);


}
