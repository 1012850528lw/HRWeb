package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.MenuManage;

import java.util.List;

public interface MenuManageService {

    JSONObject selectByRecord(MenuManage record, int pageSize, int pageNumber);

    int insertMenu(MenuManage record);

    int updateByMenuId(MenuManage record);

    MenuManage selectByMenuId(String menuId);

    int deleteByMenuId(String menuId);

    List<MenuManage> selectAllMenu();
}
