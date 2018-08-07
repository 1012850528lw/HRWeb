package com.fitech.hr.dao;

import com.fitech.hr.model.MenuManager;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuManagerDAO {
    Long countByRecord(MenuManager record);

    int insertMenu(MenuManager record);

    int updateByMenuId(MenuManager record);

    MenuManager selectByMenuId(String menuId);

    int deleteByMenuId(String menuId);

    List<MenuManager> selectAllMenu();

    List<MenuManager> selectByRecord(@Param("record") MenuManager record,@Param("pageSize") int pageSize,@Param("pageNumber") int pageNumber);
}
