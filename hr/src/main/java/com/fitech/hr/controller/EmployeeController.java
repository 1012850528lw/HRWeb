package com.fitech.hr.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.Employee;
import com.fitech.hr.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("employee/")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @ResponseBody
    @RequestMapping("getList")
    public JSONObject selectByRecord(Employee employee,int pageSize,int pageNumber){
        return this.employeeService.selectByRecord(employee,pageSize,pageNumber);
    }

    @ResponseBody
    @RequestMapping("selectByOrganId")
    public JSONObject selectByOrganId(String organId,int pageSize, int pageNumber){
        return this.employeeService.selectByOrganId(organId,pageSize,pageNumber);
    }
}
