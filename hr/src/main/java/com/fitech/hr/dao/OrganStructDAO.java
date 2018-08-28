package com.fitech.hr.dao;

import com.fitech.hr.model.OrganStruct;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrganStructDAO {

    /**
     * 查询所有
     * @return
     */
    List<OrganStruct> selectAllOrgan();

    /**
     * 查询总数
     * @param record
     * @return
     */
    Long countByRecord(OrganStruct record);

    /**
     * 更新数据
     * @param record
     * @return
     */
    int updateByOrganId(OrganStruct record);

    /**
     * 删除数据
     * @param organId
     * @return
     */
    int deleteByOrganId(String organId);

    /**
     * 增加数据
     * @param record
     * @return
     */
    int insertOrgan(OrganStruct record);

    /**
     * 根据Id查询
     * @param organId
     * @return
     */
    OrganStruct selectByOrganId(String organId);

    /**
     * 分页查询
     * @param record
     * @param pageSize
     * @param pageNumber
     * @return
     */
    List<OrganStruct> selectByRecord(@Param("record") OrganStruct record,@Param("pageSize") int pageSize,@Param("pageNumber") int pageNumber);
}
