package com.cloudcomputing.daos;

import java.util.List;

import com.cloudcomputing.models.DaymonModel;

public interface DaymonDao {
	void save (DaymonModel daymonModel);
	void update(DaymonModel daymonModel);
	List<DaymonModel> findByMaMH(String maMH);
}
