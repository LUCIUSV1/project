package com.controller;

import com.alibaba.fastjson.JSONObject;
import com.entity.Doctor;
import com.entity.Role;
import com.entity.User;
import com.pools.PageSupport;
import com.service.DoctorService;
import com.service.RoleService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("user")
public class UserController {

    @Resource(name = "roleService")
    private RoleService roleService;
    @Resource(name = "doctorService")
    private DoctorService doctorService;


    //登陆
    @RequestMapping("/login.do")
    public String login(String userCode, String userPassword, HttpSession session, HttpServletRequest request) {
        Doctor u = doctorService.login(userCode, userPassword);
        if (u != null) {
            session.setAttribute("userSession", u);
            return "redirect:/user/login";
        } else {
            //失败
//            model.addAttribute("error","用户名密码错误");
            request.setAttribute("error", "用户名密码错误");
            return "forward:/login.jsp";
        }
    }

    @RequestMapping("/login")
    public String main(HttpSession session) {
        if (session.getAttribute("userSession") == null) {
            return "redirect:/login.jsp";
        }
        return "frame";
    }

    //注销
    @RequestMapping("/logout.do")
    public String logout(HttpSession session, HttpServletResponse response) {
        session.removeAttribute("userSession");
        session.invalidate();

        return "redirect:/login.jsp";
    }

}
