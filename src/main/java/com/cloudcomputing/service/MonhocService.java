package com.cloudcomputing.service;

import java.util.List;

import com.cloudcomputing.models.MonhocModel;

public interface MonhocService {
	void save (MonhocModel monhocmodel);
	void update (MonhocModel monhocmodel);
	void delete (String maMH);
	List <MonhocModel> findAll ();
}
