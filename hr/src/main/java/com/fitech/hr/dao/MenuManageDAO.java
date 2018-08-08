package com.fitech.hr.dao;

import com.fitech.hr.model.MenuManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuManageDAO {
    Long countByRecord(MenuManage record);

    int insertMenu(MenuManage record);

    int updateByMenuId(MenuManage record);

    MenuManage selectByMenuId(String menuId);

    int deleteByMenuId(String menuId);

    List<MenuManage> selectAllMenu();

    List<MenuManage> selectByRecord(@Param("record") MenuManage record, @Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);
}
