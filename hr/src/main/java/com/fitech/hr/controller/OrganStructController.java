package com.fitech.hr.controller;
import com.alibaba.fastjson.JSONObject;
import com.fitech.hr.model.OrganStruct;
import com.fitech.hr.service.OrganStructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("organ/")
public class OrganStructController {

    @Autowired
    private OrganStructService organStructService;

    @ResponseBody
    @RequestMapping("getAll")
    public List<OrganStruct> selectAllOrgan(){
        return this.organStructService.selectAllOrgan();
    }

    @ResponseBody
    @RequestMapping("getList")
    public JSONObject selectByRecord(OrganStruct record,int pageSize, int pageNumber){
        return this.organStructService.selectByRecord(record,pageSize,pageNumber);
    }

    @ResponseBody
    @RequestMapping("getIds")
    public OrganStruct selectIdByOrganName(String organName){
        return this.organStructService.selectIdByOrganName(organName);
    }

    @ResponseBody
    @RequestMapping("getOne")
    public OrganStruct selectByOrganId(String organId){
        return this.organStructService.selectByOrganId(organId);
    }


    @ResponseBody
    @RequestMapping("updateOrgan")
    public int updateByOrganId(OrganStruct record){
        return this.organStructService.updateByOrganId(record);
    }

    @ResponseBody
    @RequestMapping("deleteOrgan")
    public int deleteByOrganName(String organName){
        return this.organStructService.deleteByOrganName(organName);
    }

    @ResponseBody
    @RequestMapping("insertOrgan")
    public int insertOrgan(OrganStruct record){
        return this.organStructService.insertOrgan(record);
    }

    @ResponseBody
    @RequestMapping("selectTree")
    public List<OrganStruct> selectTree(String organId){
        return this.organStructService.selectTree(organId);
    }
}
