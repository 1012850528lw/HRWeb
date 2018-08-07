package com.fitech.hr.controller;


import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.MenuManager;
import com.fitech.hr.service.MenuManegerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("menu/")
public class MenuManagerController {

    @Autowired
    private MenuManegerService menuManegerService;

    @ResponseBody
    @RequestMapping("getList")
    public JSONObject selectByRecord(MenuManager record, int pageSize, int pageNumber){
        return this.menuManegerService.selectByRecord(record, pageSize, pageNumber);
    }

    @ResponseBody
    @RequestMapping("getAll")
    public List<MenuManager> selectAllMenu(){
        return this.menuManegerService.selectAllMenu();
    }

    @ResponseBody
    @RequestMapping("updateMenu")
    public int updateByMenuId(MenuManager record){
        return this.menuManegerService.updateByMenuId(record);
    }

    @RequestMapping("getOne")
    public ModelAndView selectByMenuId(String menuId){
        ModelAndView modelAndView = new ModelAndView();
        MenuManager menuManager = this.menuManegerService.selectByMenuId(menuId);
        modelAndView.addObject("menu",menuManager);
        modelAndView.setViewName("sys/xtgl/cdgl_edit");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("deleteMenu")
    public int deleteByMenuId(String menuId){
        return this.menuManegerService.deleteByMenuId(menuId);
    }

    @ResponseBody
    @RequestMapping("insertMenu")
    public int insertMenu(MenuManager record){
        return this.menuManegerService.insertMenu(record);
    }
}
