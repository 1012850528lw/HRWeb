package com.fitech.hr.dao;

import com.fitech.hr.model.UserManage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户管理DAO
 */
@Mapper
public interface UserManageDAO {

    Long countByRecord(UserManage record);

    UserManage selectByEmployeeId(String employeeId);

    int updateByUserId(UserManage record);

    int deleteByUserId(String employeeId);

    int initPaw(String employeeId);

    int updatePassword(UserManage record);

    List<UserManage> selectByRecord(@Param("record") UserManage record, @Param("pageSize") int pageSize,@Param("pageNumber") int pageNumber);
}
