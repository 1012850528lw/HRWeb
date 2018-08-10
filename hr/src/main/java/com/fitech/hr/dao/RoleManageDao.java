package com.fitech.hr.dao;

import com.fitech.hr.model.RoleManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleManageDao {

    Long countByRecord(RoleManage record);

    int insertRole(RoleManage record);

    RoleManage selectByRoleId(String roleId);

    int updateByRoleId(RoleManage record);

    int deleteByRoleId(String roleId);

    List<RoleManage> selectByRecord(@Param("record") RoleManage record, @Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

}
