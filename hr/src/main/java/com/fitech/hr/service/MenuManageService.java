package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.MenuManage;

import java.util.List;

/**
 * 菜单管理服务层
 */
public interface MenuManageService {

    /**
     * 分页查询所有数据
     * @param record
     * @param pageSize
     * @param pageNumber
     * @return
     */
    JSONObject selectByRecord(MenuManage record, int pageSize, int pageNumber);

    /**
     * 点击树节点查询,根据菜单ID
     * @param menuId
     * @return
     */
    List<MenuManage> selectByTree(String menuId);

    /**
     * 增加数据
     * @param record
     * @return
     */
    int insertMenu(MenuManage record);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByMenuId(MenuManage record);

    /**
     * 根据Id查询
     * @param menuId
     * @return
     */
    MenuManage selectByMenuId(String menuId);

    /**
     * 删除数据
     * @param menuId
     * @return
     */
    int deleteByMenuId(String menuId);

    /**
     * 查询所有
     * @return
     */
    List<MenuManage> selectAllMenu();
}
