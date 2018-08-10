package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.RoleManage;

public interface RoleManageService {

    JSONObject selectByRecord(RoleManage record, int pageSize, int pageNumber);

    int insertRole(RoleManage record);

    RoleManage selectByRoleId(String roleId);

    int updateByRoleId(RoleManage record);

    int deleteByRoleId(String roleId);
}
