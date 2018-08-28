package com.fitech.hr.dao;

import com.fitech.hr.model.Employee;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface EmployeeDAO {
    /**
     * 查询总数
     * @param employee
     *
     * @return
     */
    Long countByRecord(Employee employee);

    List<Employee> selectByRecord(@Param("employee") Employee employee, @Param("pageSize") int pageSize,@Param("pageNumber") int pageNumber);

    /**
     * 点击树节点查询对应数据
     * @param organId
     * @return
     */
    Long countByOrganId(String organId);

    List<Employee> selectByOrganId(@Param("organId") String organId,@Param("pageSize") int pageSize,@Param("pageNumber") int pageNumber);

}
