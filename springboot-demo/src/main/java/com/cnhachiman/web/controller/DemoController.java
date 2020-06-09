package com.cnhachiman.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("demo")
public class DemoController {

    @RequestMapping("/get")
    public @ResponseBody String test(){
        return "just test!";
    }
}
