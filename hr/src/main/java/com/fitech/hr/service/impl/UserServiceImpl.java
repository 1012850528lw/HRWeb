package com.fitech.hr.service.impl;

import com.fitech.hr.dao.UserDAO;
import com.fitech.hr.model.User;
import com.fitech.hr.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    public User selectByPrimaryKey(String id) {
        return this.userDAO.selectByPrimaryKey(id);
    }

    public JSONObject selectByRecord(User record, int pageSize, int pageNumber) {
        JSONObject returnJson = new JSONObject();
		returnJson.put("total",this.userDAO.countByRecord(record));
		returnJson.put("rows",this.userDAO.selectByRecord(record,pageSize,pageNumber));
		return returnJson;
    }

    public int deleteByPrimaryKey(String id) {
        return this.userDAO.deleteByPrimaryKey(id);
    }

    public int updateByPrimaryKey(User record) {
        return this.userDAO.updateByPrimaryKey(record);
    }

    public int insert(User record) {
        return this.userDAO.insert(record);
    }
}