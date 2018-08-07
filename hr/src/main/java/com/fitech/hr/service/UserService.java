package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.User;

public interface UserService {
    User selectByPrimaryKey(String id);

    JSONObject selectByRecord(User record, int pageSize, int pageNumber);

    int deleteByPrimaryKey(String id);

    int updateByPrimaryKey(User record);

    int insert(User record);
}