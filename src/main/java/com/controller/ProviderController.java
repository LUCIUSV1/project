package com.controller;

import com.entity.Provider;
import com.entity.User;
import com.pools.PageSupport;
import com.service.ProviderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2018/12/1.
 */
@Controller
@RequestMapping("pro")
public class ProviderController {
    @Resource(name = "providerService")
    private ProviderService ps;


    //查询供应商列表
    @RequestMapping("provider")
    public String getProviderList(@RequestParam(value = "proCode", required = false) String proCode,
                                  @RequestParam(value = "proName", required = false) String proName,
                                  @RequestParam(name = "pageIndex", required = false) String pageIndex, Model model, HttpSession session) {

        //设置页面容量
        int pageSize = 5;
        int currentPageNo = 1;//页码
        if (pageIndex != null) {
            currentPageNo = Integer.parseInt(pageIndex);
        }
        //
        PageSupport pageSupport = new PageSupport();
        pageSupport.setCurrentPageNo(currentPageNo);
        pageSupport.setPageSize(pageSize);


        //得到总条数
        int totalCount = ps.getProviderCount(proCode, proName);
        pageSupport.setTotalCount(totalCount);
        //计算页数
        int totalPageCount = pageSupport.getTotalPageCount();
        //控制首尾页
        if (currentPageNo < 1) {
            currentPageNo = 1;
        } else if (currentPageNo > totalPageCount) {
            currentPageNo = totalPageCount;
        }
        pageSupport.setTotalCount(totalCount);
        //得到供应商列表信息
        List<Provider> providerList = ps.getProviderList(proCode, proName, currentPageNo, pageSize);
        System.out.println(proCode + "proCode");
        System.out.println(proName + "proName");
        System.out.println(providerList);
        System.out.println(totalCount);
        model.addAttribute("providerList", providerList);
        model.addAttribute("proName", proName);
        model.addAttribute("proCode", proCode);
        model.addAttribute("totalCount", totalCount);
        model.addAttribute("currentPageNo", currentPageNo);
        model.addAttribute("totalPageCount", totalPageCount);

        session.setAttribute("providerList", providerList);
        return "providerlist";
    }

    //进入供应商增加
    @RequestMapping("intoProviderAdd")
    public String intoAdd() {
        return "provideradd";
    }

    //开始增加
    @RequestMapping("/providerAdd")
    public String add(
            @RequestParam(value = "proCode", required = false) String proCode,
            @RequestParam(value = "proName", required = false) String proName,
            @RequestParam(value = "proContact", required = false) String proContact,
            @RequestParam(value = "proPhone", required = false) String proPhone,
            @RequestParam(value = "proAddress", required = false) String proAddress,
            @RequestParam(value = "proFax", required = false) String proFax,
            @RequestParam(value = "proDesc", required = false) String proDesc,
            HttpSession session, Model model) {
        //根据session里的用户拿到用户id
        User u = (User) session.getAttribute("userSession");
        int uId = u.getId();

        Provider p = new Provider();
        p.setProCode(proCode);
        p.setProName(proName);
        p.setProContact(proContact);
        p.setProPhone(proPhone);
        p.setProAddress(proAddress);
        p.setProFax(proFax);
        p.setProDesc(proDesc);
        p.setCreatedBy(uId);
        p.setCreationDate(new Date());

        int count = ps.add(p);
        System.out.println(count);
        if (count > 0) {
            model.addAttribute("proCode", proCode);
            model.addAttribute("proName", proName);
            return "redirect:/pro/provider";
        } else {
            return "providerlist";
        }


    }


    //REST查看供应商
    @RequestMapping("providerView/{id}")
    public String lookPro(@PathVariable String id,Model model ){
        Integer pid = Integer.parseInt(id);
        //通过Id查询供应商
        Provider pro = ps.getPro(pid);
        model.addAttribute("provider",pro);
        return "providerview";
    }
    //进入修改供应商
    @RequestMapping("intoModifyPro/{id}")
    public String intoMp(@PathVariable String id,Model model){
        Integer pid = Integer.parseInt(id);
        //通过Id查询供应商
        Provider pro = ps.getPro(pid);
        model.addAttribute("provider",pro);

        return "providermodify";
    }
    //根据id删除供应商
    @RequestMapping("delProvider")
    @ResponseBody
    public String delP(Integer pid){
        Provider p = ps.getPro(pid);

        if(p==null){
           return  "{\"delResult\":\"notexist\"}";
        }else{
            //根据id查看该供应商下是否有未完成订单
            int count = ps.getCount(pid);
            String c = count+"";
            System.out.println(c);
            if(count>0){
                return  "{\"delResult\":\""+c+"\"}";
            }else{
                //开始删除
                int count1 = ps.delPro(pid);
                if(count1>0){
                    return  "{\"delResult\":\"true\"}";
                }
                else{
                    return  "{\"delResult\":\"false\"}";
                }
            }
        }
    }
}
