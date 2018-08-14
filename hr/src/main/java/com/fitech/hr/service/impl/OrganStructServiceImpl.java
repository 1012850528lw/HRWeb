package com.fitech.hr.service.impl;

import com.fitech.hr.dao.OrganStructDAO;
import com.fitech.hr.model.OrganStruct;
import com.fitech.hr.service.OrganStructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganStructServiceImpl implements OrganStructService {

    @Autowired
    private OrganStructDAO organStructDAO;

    @Override
    public List<OrganStruct> selectAllOrgan() {
        return this.organStructDAO.selectAllOrgan();
    }
}
