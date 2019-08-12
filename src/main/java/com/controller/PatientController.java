package com.controller;

import com.entity.Bill;
import com.entity.Patient;
import com.pools.PageSupport;
import com.service.PatientService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("pat")
public class PatientController {
    @Resource(name = "patientService")
    private PatientService patientService;

    @RequestMapping("getPat")
    public String getPat(@RequestParam(value = "patientId",required = false)String patientId ,
                         @RequestParam(value = "pageIndex",required = false)String pageIndex,
                         Model model, HttpSession session){
        //设置页面容量
        int pageSize = 5;
        int currentPageNo = 1;//页码
        if(pageIndex!=null){
            currentPageNo=Integer.parseInt(pageIndex);
        }

        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);

        //得到总条数
        int totalCount = patientService.getPatientCount(patientId);
        pageSupport.setTotalCount(totalCount);
        //计算页数
        int totalPageCount = pageSupport.getTotalPageCount();
        //控制首尾页
        if(currentPageNo<1){
            currentPageNo=1;
        }else if (currentPageNo>totalPageCount){
            currentPageNo=totalPageCount;
        }
        pageSupport.setTotalCount(totalCount);
        //得到订单列表
        List<Patient> patients = patientService.getPatList(patientId,currentPageNo,pageSize);
//        System.out.println(patients);
        model.addAttribute("patients",patients);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("totalPageCount",totalPageCount);


        session.setAttribute("patients",patients);
        return "billlist";
    }
}
