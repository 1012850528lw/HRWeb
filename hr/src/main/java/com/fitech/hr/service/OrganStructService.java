package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.OrganStruct;

import java.util.List;

public interface OrganStructService {

    List<OrganStruct> selectAllOrgan();

    JSONObject selectByRecord(OrganStruct record, int pageSize, int pageNumber);

    OrganStruct selectByOrganId(String organId);

    int updateByOrganId(OrganStruct record);

    int deleteByOrganId(String organId);

    int insertOrgan(OrganStruct record);

    List<OrganStruct> selectTree(String organId);
}
