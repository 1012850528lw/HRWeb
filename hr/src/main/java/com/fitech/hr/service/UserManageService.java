package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.UserManage;


public interface UserManageService {

    JSONObject selectByRecord(UserManage record,int pageSize, int pageNumber);

    UserManage selectByEmployeeId(String employeeId);

    int updateByUserId(UserManage record);

    int deleteByUserId(String employeeId);

    int initPaw(String employeeId);

    int updatePassword(UserManage record);
}
