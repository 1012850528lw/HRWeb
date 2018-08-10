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

    @RequestMapping("/main")
    public String user() {
        return "sys/main/welcome";
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
    public String jsgl(){
        return "sys/xtgl/jsgl";
    }

    @RequestMapping("/jsgl_add")
    public String jsglAdd(){
        return "sys/xtgl/jsgl_add";
    }

    @RequestMapping("/yhgl")
    public String yhgl(){
        return "sys/xtgl/yhgl";
    }

    @RequestMapping("/password")
    public String password(){
        return "sys/main/password";
    }

    @RequestMapping("/in")
    @ResponseBody
    public String index2(String aa) {
        System.out.println(aa);
        return "aa";
    }
}
