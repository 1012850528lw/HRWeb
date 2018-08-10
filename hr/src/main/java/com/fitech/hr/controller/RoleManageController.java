package com.fitech.hr.controller;


import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.RoleManage;
import com.fitech.hr.service.RoleManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping("getOne")
    public ModelAndView selectByRoleId(String roleId){
        ModelAndView modelAndView = new ModelAndView();
        RoleManage roleManage = this.roleManageService.selectByRoleId(roleId);
        modelAndView.addObject("role",roleManage);
        modelAndView.setViewName("sys/xtgl/jsgl_edit");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("deleteRole")
    public int deleteByRoleId(String roleId){
        return this.roleManageService.deleteByRoleId(roleId);
    }

    @ResponseBody
    @RequestMapping("updateRole")
    public int updateByRoleId(RoleManage record){
        return this.roleManageService.updateByRoleId(record);
    }

    @ResponseBody
    @RequestMapping("insertRole")
    public int insertRole(RoleManage record){
        return this.roleManageService.insertRole(record);
    }
}
