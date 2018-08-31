package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.Employee;

/**
 * 员工维护
 */
public interface EmployeeService {

    /**
     *分页查询所有数据
     * @param employee
     * @param pageSize
     * @param pageNumber
     * @return
     */
    public JSONObject selectByRecord(Employee employee,int pageSize, int pageNumber);

    /**
     * 根据组织Id查询数据
     * @param organId
     * @param pageSize
     * @param pageNumber
     * @return
     */
    public JSONObject selectByOrganId(String organId,int pageSize, int pageNumber);
}
