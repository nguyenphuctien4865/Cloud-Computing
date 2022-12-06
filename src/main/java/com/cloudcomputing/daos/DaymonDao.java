package com.cloudcomputing.daos;

import com.cloudcomputing.models.DaymonModel;

public interface DaymonDao {
	void save (DaymonModel daymonModel);
	void update(DaymonModel daymonModel);
}
