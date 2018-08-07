package com.fitech.hr.controller;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.User;
import com.fitech.hr.service.UserService;
import com.fitech.hr.util.IDGenerator;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("user/")
public class UserController {
    @Autowired
    private UserService userService;

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @RequestMapping("getone")
    public ModelAndView selectByPrimaryKey(String id) {
        ModelAndView mav = new ModelAndView();
        User user = this.userService.selectByPrimaryKey(id);
        mav.addObject("user", user);
        mav.setViewName("sys/user/user_edit");
        return mav;
    }

    @ResponseBody
    @RequestMapping("removeone")
    public int deleteByPrimaryKey(String id) {
        return this.userService.deleteByPrimaryKey(id);
    }

    @ResponseBody
    @RequestMapping("updateone")
    public int updateByPrimaryKey(User record) {
        return this.userService.updateByPrimaryKey(record);
    }

    @ResponseBody
    @RequestMapping("saveone")
    public int insert(User record) {
        record.setId(IDGenerator.getUid());
        return this.userService.insert(record);
    }

    @ResponseBody
    @RequestMapping("getlist")
    public JSONObject selectByRecord(User record, int pageSize, int pageNumber) {
        return this.userService.selectByRecord(record, pageSize, pageNumber);
    }

    @RequestMapping("saveonepage")
    public String saveonepage() {
        return "sys/user/user_add";
    }


}