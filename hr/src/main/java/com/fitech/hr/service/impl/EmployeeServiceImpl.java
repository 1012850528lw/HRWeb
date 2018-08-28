package com.fitech.hr.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.dao.EmployeeDAO;
import com.fitech.hr.model.Employee;
import com.fitech.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDAO employeeDAO;

    @Override
    public JSONObject selectByRecord(Employee employee, int pageSize, int pageNumber) {
        JSONObject result = new JSONObject();
        result.put("total", this.employeeDAO.countByRecord(employee));
        result.put("rows", this.employeeDAO.selectByRecord(employee,pageSize,pageNumber));
        return result;
    }

    @Override
    public JSONObject selectByOrganId(String organId, int pageSize, int pageNumber) {
        JSONObject result = new JSONObject();
        result.put("total",this.employeeDAO.countByOrganId(organId));
        result.put("rows", this.employeeDAO.selectByOrganId(organId,pageSize,pageNumber));
        return result;
    }
}
