package com.fitech.hr.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.dao.RoleManageDao;
import com.fitech.hr.model.RoleManage;
import com.fitech.hr.service.RoleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleManageServiceImpl implements RoleManageService {

    @Autowired
    private RoleManageDao roleManageDao;

    @Override
    public JSONObject selectByRecord(RoleManage record, int pageSize, int pageNumber) {
        JSONObject str = new JSONObject();
        str.put("total", this.roleManageDao.countByRecord(record));
        str.put("rows", this.roleManageDao.selectByRecord(record,pageSize,pageNumber));
        return str;
    }

    @Override
    public int insertRole(RoleManage record) {
        return this.roleManageDao.insertRole(record);
    }

    @Override
    public RoleManage selectByRoleId(String roleId) {
        return this.roleManageDao.selectByRoleId(roleId);
    }

    @Override
    public int updateByRoleId(RoleManage record) {
        return this.roleManageDao.updateByRoleId(record);
    }

    @Override
    public int deleteByRoleId(String roleId) {
        return this.roleManageDao.deleteByRoleId(roleId);
    }
}
