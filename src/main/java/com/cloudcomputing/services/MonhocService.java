package com.cloudcomputing.services;

import com.cloudcomputing.models.MonhocModel;

import java.util.List;

public interface MonhocService {
	void save (MonhocModel monhocmodel);
	void update (MonhocModel monhocmodel);
	void delete (String maMH);
	List <MonhocModel> findAll ();
	List <MonhocModel> findbyCurrentUser (int khoa);

}
