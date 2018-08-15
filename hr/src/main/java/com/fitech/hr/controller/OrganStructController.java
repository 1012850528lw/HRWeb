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
    @RequestMapping("getOne")
    public ModelAndView selectByOrganId(String organId){
        ModelAndView modelAndView = new ModelAndView();
        OrganStruct organStruct = this.organStructService.selectByOrganId(organId);
        modelAndView.addObject("organ",organStruct);
        modelAndView.setViewName("sys/zzjggl/zzjgwh_edit");
        return modelAndView;
    }

//    @ResponseBody
//    @RequestMapping("updateOrgan")
//    public int updateByOrganId(OrganStruct record){
//        return this.organStructService.updateByOrganId(record);
//    }
}
