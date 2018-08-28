package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.Employee;

public interface EmployeeService {

    public JSONObject selectByRecord(Employee employee,int pageSize, int pageNumber);

    public JSONObject selectByOrganId(String organId,int pageSize, int pageNumber);
}
