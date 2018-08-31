package com.fitech.hr.service;

import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.OrganStruct;

import java.util.List;

/**
 * 组织机构服务层
 */
public interface OrganStructService {

    /**
     * 查询所有
     * @return
     */
    List<OrganStruct> selectAllOrgan();

    /**
     * 分页查询
     * @param record
     * @param pageSize
     * @param pageNumber
     * @return
     */
    JSONObject selectByRecord(OrganStruct record, int pageSize, int pageNumber);

    /**
     * 根据Id查询
     * @param organId
     * @return
     */
    OrganStruct selectByOrganId(String organId);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByOrganId(OrganStruct record);

    int deleteByOrganId(String organId);

    /**
     * 删除数据
     * @param organName
     * @return
     */
    int deleteByOrganName(String organName);

    /**
     * 增加数据
     * @param record
     * @return
     */
    int insertOrgan(OrganStruct record);

    /**
     * 点击树节点查询
     * @param organId
     * @return
     */
    List<OrganStruct> selectTree(String organId);

    /**
     * 通过节点名称查询Id
     * @param organName
     * @return
     */
    OrganStruct selectIdByOrganName(String organName);
}
