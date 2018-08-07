/* BaoZhu */
package com.fitech.hr.dao;

import com.fitech.hr.model.User;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserDAO {
    long countByRecord(User record);

    int deleteByPrimaryKey(String id);

    int insert(User record);

    List<User> selectByRecord(@Param("record") User record, @Param("pageSize") int pageSize, @Param("pageNumber") int pageNumber);

    User selectByPrimaryKey(String id);

    int updateByPrimaryKey(User record);
}