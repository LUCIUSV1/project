package com.controller;

import com.entity.Bill;
import com.pools.PageSupport;
import com.service.BillService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Administrator on 2018/12/3.
 */
@Controller
@RequestMapping("bill")
public class BillController {
    @Resource(name = "billService")
    private BillService billService;

    @RequestMapping("getBill")
    public String getBill(@RequestParam(value = "productName",required = false)String productName,
                          @RequestParam(value = "providerId",required = false)Integer providerId,
                          @RequestParam(value = "isPayment",required = false)Integer isPayment,
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
        int totalCount = billService.getBillListCount(productName,providerId,isPayment);
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
        List<Bill> billList = billService.getBillList(productName,providerId,isPayment,currentPageNo,pageSize);
        System.out.println(billList);
        model.addAttribute("billList",billList);
        model.addAttribute("totalCount",totalCount);
        model.addAttribute("currentPageNo",currentPageNo);
        model.addAttribute("totalPageCount",totalPageCount);


        session.setAttribute("billList",billList);
        return "billlist";
    }
}
