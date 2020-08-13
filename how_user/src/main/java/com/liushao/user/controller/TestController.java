package com.liushao.user.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("test")
@CrossOrigin
public class TestController {
    /**
     * test
     */
    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "demo.html";
    }
}
