package com.fitech.hr.controller;


import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.RoleManage;
import com.fitech.hr.service.RoleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/role")
public class RoleManageController {

    @Autowired
    private RoleManageService roleManageService;

    @ResponseBody
    @RequestMapping("getList")
    public JSONObject selectByRecord(RoleManage record, int pageSize, int pageNumber){
        return this.roleManageService.selectByRecord(record,pageSize,pageNumber);
    }
}
