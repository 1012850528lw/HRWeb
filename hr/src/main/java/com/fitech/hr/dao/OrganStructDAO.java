package com.fitech.hr.dao;

import com.fitech.hr.model.OrganStruct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrganStructDAO {

    List<OrganStruct> selectAllOrgan();

    Long countByRecord(OrganStruct record);

    //int updateByOrganId(OrganStruct record);

    OrganStruct selectByOrganId(String organId);

    List<OrganStruct> selectByRecord(@Param("record") OrganStruct record,@Param("pageSize") int pageSize,@Param("pageNumber") int pageNumber);
}
