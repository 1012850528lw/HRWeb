package com.fitech.hr.controller;


import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.MenuManage;
import com.fitech.hr.service.MenuManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("menu/")
public class MenuManageController {

    @Autowired
    private MenuManageService menuManagerService;

    @ResponseBody
    @RequestMapping("getList")
    public JSONObject selectByRecord(MenuManage record, int pageSize, int pageNumber){
        return this.menuManagerService.selectByRecord(record, pageSize, pageNumber);
    }

    @ResponseBody
    @RequestMapping("getAll")
    public List<MenuManage> selectAllMenu(){
        return this.menuManagerService.selectAllMenu();
    }

    @ResponseBody
    @RequestMapping("updateMenu")
    public int updateByMenuId(MenuManage record){
        return this.menuManagerService.updateByMenuId(record);
    }

    @RequestMapping("getOne")
    public ModelAndView selectByMenuId(String menuId){
        ModelAndView modelAndView = new ModelAndView();
        MenuManage menuManager = this.menuManagerService.selectByMenuId(menuId);
        modelAndView.addObject("menu",menuManager);
        modelAndView.setViewName("sys/xtgl/cdgl_edit");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("deleteMenu")
    public int deleteByMenuId(String menuId){
        return this.menuManagerService.deleteByMenuId(menuId);
    }

    @ResponseBody
    @RequestMapping("insertMenu")
    public int insertMenu(MenuManage record){
        return this.menuManagerService.insertMenu(record);
    }
}
