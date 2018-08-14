package com.fitech.hr.controller;

import com.fitech.hr.model.OrganStruct;
import com.fitech.hr.service.OrganStructService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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
}
