package com.fitech.hr.dao;

import com.fitech.hr.model.RoleManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface RoleManageDao {

    Long countByRecord(RoleManage record);

    List<RoleManage> selectByRecord(@Param("record") RoleManage record, @Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

}
