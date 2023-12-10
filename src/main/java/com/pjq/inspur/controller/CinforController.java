package com.pjq.inspur.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pjq.inspur.pojo.GzcrmCinfo;
import com.pjq.inspur.service.CinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
@RequestMapping("/cinfo")
public class CinforController {
    @Autowired
    private CinfoService cinfoService;
    @RequestMapping("/deleteCinfo")
    public String deleteCinfo(int cId, Model model){
        int nums = cinfoService.deleteLearnById(cId);
        if (nums==1) {
            System.out.println("删除客户信息成功！");
            model.addAttribute("msg","<script>alert('删除客户信息成功！');</script>");
        }else {
            System.out.println("删除客户信息失败！！");
            model.addAttribute("msg","<script>alert('删除客户信息失败！');</script>");
        }
        return "redirect:/cinfo/queryCinfoList";
    }
    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum,Model model){
        boolean flag = cinfoService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除客户信息成功！");
            model.addAttribute("msg","<script>alert('批量删除客户信息成功');</script>");
        }else {
            System.out.println("批量删除客户信息失败！");
            model.addAttribute("msg","<script>alert('批量删除客户信息失败');</script>");
        }
        return "redirect:/cinfo/queryCinfoList";
    }
    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int cId,Model model){
        GzcrmCinfo cinfo = cinfoService.queryCinfoById(cId);
        model.addAttribute("cinfo",cinfo);
        return "manager/clientinfoUpdate";
    }
    @RequestMapping("/updateCinfo")
    public String updateCinfo(GzcrmCinfo cinfo,Model model){
        int nums = cinfoService.updateCinfo(cinfo);
        if (nums==1) {
            System.out.println("更新客户信息成功！");
            model.addAttribute("msg","<script>alert('更新客户信息成功！');</script>");
        }else {
            System.out.println("更新客户信息失败！！");
            model.addAttribute("msg","<script>alert('更新客户信息失败！');</script>");
        }
        return "redirect:/cinfo/queryCinfoList";
    }
    @RequestMapping("/insertCinfo")
    public String insertCinfo(GzcrmCinfo cinfo,Model model){
        int nums = cinfoService.insertCinfo(cinfo);
        if (nums==1) {
            System.out.println("插入客户信息成功！");
            model.addAttribute("msg","<script>alert('插入客户信息成功！');</script>");
        }else {
            System.out.println("插入客户信息失败！！");
            model.addAttribute("msg","<script>alert('插入客户信息失败！');</script>");
        }
        return "redirect:/cinfo/queryCinfoList";
    }
    @RequestMapping("/queryCinfoList")
    public String queryCinfoList(@RequestParam(required = false) String cId,
                                 @RequestParam(required = false) String cName,
                                 @RequestParam(required = false) String cSsn,
                                 @RequestParam(required = false) String msg,
                                 @RequestParam(defaultValue = "1") int pageNum,
                                 Model model){
        PageHelper.startPage(pageNum,5);
        List<GzcrmCinfo> list = cinfoService.queryCinfoList(cId,cName,cSsn);
        PageInfo<GzcrmCinfo> info = new PageInfo<>(list);
        model.addAttribute("cId",cId);
        model.addAttribute("cName",cName);
        model.addAttribute("cSsn",cSsn);
        model.addAttribute("msg",msg);
        model.addAttribute("info",info);
        model.addAttribute("pageNum",pageNum);
        return "manager/clientinfo";
    }
}