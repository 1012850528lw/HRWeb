package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.MenuManager;

import java.util.List;

public interface MenuManegerService {

    JSONObject selectByRecord(MenuManager record, int pageSize, int pageNumber);

    int insertMenu(MenuManager record);

    int updateByMenuId(MenuManager record);

    MenuManager selectByMenuId(String menuId);

    int deleteByMenuId(String menuId);

    List<MenuManager> selectAllMenu();
}
