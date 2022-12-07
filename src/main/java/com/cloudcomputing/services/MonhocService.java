package com.cloudcomputing.services;

import com.cloudcomputing.daos.MonhocDao;
import com.cloudcomputing.daos.impl.MonhocDaoImpl;
import com.cloudcomputing.models.MonhocModel;

import java.util.List;

public class MonhocService {
    private MonhocDaoImpl dao = new MonhocDaoImpl();
    public List<MonhocModel> findAll() {
        return dao.findAll();
    }
}
