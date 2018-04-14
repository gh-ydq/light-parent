package com.light.web.controller;

import com.light.core.impl.UserServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WebController {
    private Logger logger = LoggerFactory.getLogger(WebController.class);
    @Autowired
    private UserServiceImpl userService;
	
    @RequestMapping(value="/",method = RequestMethod.GET)
    public String home(){

        return "jqgrid";
    }


    @ResponseBody
    @RequestMapping(value="/greeting",method = RequestMethod.GET)
    public String Greeting(){
        return "Message From SpringBoot Service - Hello World!";
    }
}