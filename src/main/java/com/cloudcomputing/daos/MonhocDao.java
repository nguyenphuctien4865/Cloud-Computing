package com.cloudcomputing.daos;

import com.cloudcomputing.models.MonhocModel;

import java.util.List;

public interface MonhocDao {
	void save (MonhocModel monhocmodel);
	void update (MonhocModel monhocmodel);
	void delete (String maMH);
	List<MonhocModel> findAll();
}
