package com.fitech.hr.dao;

import com.fitech.hr.model.MenuManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuManageDAO {
    /**
     * 查询总数
     * @param record
     * @return
     */
    Long countByRecord(MenuManage record);

    /**
     * 增加数据
     * @param record
     * @return
     */
    int insertMenu(MenuManage record);

    /**
     * 更新数据
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
     * 查询所有数据
     * @return
     */
    List<MenuManage> selectAllMenu();

    /**
     * 分页查询
     * @param record
     * @param pageSize
     * @param pageNumber
     * @return
     */
    List<MenuManage> selectByRecord(@Param("record") MenuManage record, @Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);
}
