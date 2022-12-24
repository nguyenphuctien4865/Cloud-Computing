package com.cloudcomputing.services;

import java.util.List;

import com.cloudcomputing.models.DaymonModel;

public interface DaymonService {
	void save (DaymonModel daymonModel);
	void update(DaymonModel daymonModel);
	List<DaymonModel> findByMaMH(String maMH);
}
