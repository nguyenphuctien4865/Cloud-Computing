package com.cloudcomputing.service;

import com.cloudcomputing.models.MonhocModel;

public interface MonhocService {
	void save (MonhocModel monhocmodel);
	void update (MonhocModel monhocmodel);
	void delete (String maMH);
}
