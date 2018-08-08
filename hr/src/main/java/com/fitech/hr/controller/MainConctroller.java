package com.fitech.hr.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainConctroller {

    @RequestMapping("/index")
    public String index() {
        return "layerui/index";
    }

    @RequestMapping("/user")
    public String user() {
        return "sys/user/user_main";
    }

    @RequestMapping("/cdgl")
    public  String cdgl(){
        return "sys/xtgl/cdgl";
    }

    @RequestMapping("/cdgl_add")
    public  String cdglAdd(){
        return "sys/xtgl/cdgl_add";
    }

    @RequestMapping("/jsgl")
    public String lsgl(){
        return "sys/xtgl/jsgl";
    }

    @RequestMapping("/in")
    @ResponseBody
    public String index2(String aa) {
        System.out.println(aa);
        return "aa";
    }
}
