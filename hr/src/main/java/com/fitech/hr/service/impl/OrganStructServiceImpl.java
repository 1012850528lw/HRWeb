package com.fitech.hr.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.dao.OrganStructDAO;
import com.fitech.hr.model.OrganStruct;
import com.fitech.hr.service.OrganStructService;
import com.google.gson.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OrganStructServiceImpl implements OrganStructService {

    @Autowired
    private OrganStructDAO organStructDAO;

    @Override
    public List<OrganStruct> selectAllOrgan() {
        return this.organStructDAO.selectAllOrgan();
    }

    @Override
    public JSONObject selectByRecord(OrganStruct record, int pageSize, int pageNumber) {
        JSONObject str = new JSONObject();
        str.put("total", this.organStructDAO.countByRecord(record));
        str.put("rows", this.organStructDAO.selectByRecord(record,pageSize,pageNumber));
        return str;
    }

    @Override
    public OrganStruct selectByOrganId(String organId) {
        return this.organStructDAO.selectByOrganId(organId);
    }

    @Override
    public int updateByOrganId(OrganStruct record) {
        return this.organStructDAO.updateByOrganId(record);
    }

    @Override
    public int deleteByOrganId(String organId) {
        return this.organStructDAO.deleteByOrganId(organId);
    }

    @Override
    public int insertOrgan(OrganStruct record) {
        return this.organStructDAO.insertOrgan(record);
    }

    @Override
    public List<OrganStruct> selectTree(String organId) {
        List<OrganStruct> list = new ArrayList<>();
        list.add(this.organStructDAO.selectByOrganId(organId));
        return list;
    }

}
