package com.controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HelloController extends AbstractController {
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        //向Model中放数据
        mv.addObject("hello","zhangsan");
        //返回页面
        mv.setViewName("/hello.jsp");
        return mv;
    }

    @RequestMapping("/test.html")
    public String save (String userCode,Model model){
        logger.info("hello,SpringMVC!userCode:"+userCode);
        model.addAttribute("userCode",userCode);
        return "success";
    }
}