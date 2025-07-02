package com.substring.smartresult.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/results")
public class ResultController {

    @RequestMapping("/input")
    public String viewResult(){
        System.out.println("Result page");
        return "view_result";
    }
    @RequestMapping("/view")
    public String getResult(){

        return "result_data";
    }
    @RequestMapping("/add")
    public String addResult(){

        return "add_result";
    }
}
