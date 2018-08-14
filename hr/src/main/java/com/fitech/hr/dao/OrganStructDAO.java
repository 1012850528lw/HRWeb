package com.fitech.hr.dao;

import com.fitech.hr.model.OrganStruct;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OrganStructDAO {

    List<OrganStruct> selectAllOrgan();
}
