package com.cloudcomputing.daos;

import java.util.List;

import com.cloudcomputing.models.MonhocModel;

public interface MonhocDao {
	void save (MonhocModel monhocmodel);
	void update (MonhocModel monhocmodel);
	void delete (String maMH);
	List <MonhocModel> findAll ();
}
