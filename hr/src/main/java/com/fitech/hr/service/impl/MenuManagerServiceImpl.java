package com.fitech.hr.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.dao.MenuManagerDAO;
import com.fitech.hr.model.MenuManager;
import com.fitech.hr.service.MenuManegerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuManagerServiceImpl implements MenuManegerService {
    @Autowired
    private MenuManagerDAO menuManagerDAO;

    @Override
    public JSONObject selectByRecord(MenuManager record, int pageSize, int pageNumber) {

        JSONObject returnJson = new JSONObject();
        returnJson.put("total",this.menuManagerDAO.countByRecord(record));
        returnJson.put("rows", this.menuManagerDAO.selectByRecord(record, pageSize, pageNumber));
        return returnJson;
    }

    @Override
    public int insertMenu(MenuManager record) {
        return this.menuManagerDAO.insertMenu(record);
    }

    @Override
    public int updateByMenuId(MenuManager record) {
        return this.menuManagerDAO.updateByMenuId(record);
    }

    @Override
    public MenuManager selectByMenuId(String menuId) {
        return this.menuManagerDAO.selectByMenuId(menuId);
    }

    @Override
    public int deleteByMenuId(String menuId) {
        return this.menuManagerDAO.deleteByMenuId(menuId);
    }

    @Override
    public List<MenuManager> selectAllMenu() {
        return this.menuManagerDAO.selectAllMenu();
    }

}
