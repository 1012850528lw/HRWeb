package com.fitech.hr.controller;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.UserManage;
import com.fitech.hr.service.UserManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user/")
public class UserManageController {

    @Autowired
    private UserManageService userManageService;

    @ResponseBody
    @RequestMapping("getList")
    public JSONObject selectByRecord(UserManage record,int pageSize,int pageNumber){
        return this.userManageService.selectByRecord(record,pageSize,pageNumber);
    }

    @RequestMapping("getOne")
    public ModelAndView selectByEmployeeId(String employeeId){
        ModelAndView modelAndView = new ModelAndView();
        UserManage userManage = this.userManageService.selectByEmployeeId(employeeId);
        modelAndView.addObject("user",userManage);
        modelAndView.setViewName("sys/xtgl/yhgl_edit");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("updateUser")
    public int updateByUserId(UserManage record){
        return this.userManageService.updateByUserId(record);
    }

    @ResponseBody
    @RequestMapping("updatePaw")
    public int updatePassword(UserManage record){
        return this.userManageService.updatePassword(record);
    }

    @ResponseBody
    @RequestMapping("initPaw")
    public int initPaw(String employeeId){
        return this.userManageService.initPaw(employeeId);
    }

    @ResponseBody
    @RequestMapping("deleteUser")
    public int deleteByUserId(String employeeId){
        return this.userManageService.deleteByUserId(employeeId);
    }
}
