package com.fitech.hr.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.dao.UserManageDAO;
import com.fitech.hr.model.UserManage;
import com.fitech.hr.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserManageServiceImpl implements UserManageService {

    @Autowired
    private UserManageDAO userManageDAO;

    @Override
    public JSONObject selectByRecord(UserManage record, int pageSize, int pageNumber) {
        JSONObject result = new JSONObject();
        result.put("total", this.userManageDAO.countByRecord(record));
        result.put("rows", this.userManageDAO.selectByRecord(record,pageSize,pageNumber));
        return result;
    }

    @Override
    public UserManage selectByEmployeeId(String employeeId) {
        return this.userManageDAO.selectByEmployeeId(employeeId);
    }

    @Override
    public int updateByUserId(UserManage record) {
        return this.userManageDAO.updateByUserId(record);
    }

    @Override
    public int deleteByUserId(String employeeId) {
        return this.userManageDAO.deleteByUserId(employeeId);
    }

    @Override
    public int initPaw(String employeeId) {
        return this.userManageDAO.initPaw(employeeId);
    }

    @Override
    public int updatePassword(UserManage record) {
        return this.userManageDAO.updatePassword(record);
    }
}
