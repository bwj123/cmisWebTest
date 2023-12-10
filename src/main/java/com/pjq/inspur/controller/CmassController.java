package com.pjq.inspur.controller;

import com.pjq.inspur.pojo.GzcrmCmass;
import com.pjq.inspur.pojo.GzcrmCminfo;
import com.pjq.inspur.service.CmassService;
import com.pjq.inspur.service.CminfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping("/cmass")
public class CmassController {
    @Autowired
    private CmassService cmassService;
    @Autowired
    private CminfoService cminfoService;

    @RequestMapping("/queryList")
    public String queryList(@RequestParam(required = false) String cmId4,
                            @RequestParam(required = false) String cmassDate,
                            @RequestParam(required = false) String msg,
                            Model model) {
        List<GzcrmCmass> list = cmassService.queryList(cmId4, cmassDate);
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        model.addAttribute("cmId4", cmId4);
        model.addAttribute("cmassDate", cmassDate);
        model.addAttribute("cmasses", list);
        //定位页面
        model.addAttribute("hash", "tab4");
        model.addAttribute("msg", msg);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/deleteCmass")
    public String deleteCmass(int cmassId, Model model) {
        int nums = cmassService.deleteCmassById(cmassId);
        if (nums == 1) {
            System.out.println("删除考核记录成功！");
            model.addAttribute("msg", "<script>alert('删除考核记录成功！');</script>");
        } else {
            System.out.println("删除考核记录失败！！");
            model.addAttribute("msg", "<script>alert('删除考核记录失败！');</script>");
        }
        return "redirect:/cmass/queryList";
    }

    @RequestMapping("/deleteMany")
    public String deleteMany(String checkTnum, Model model) {
        boolean flag = cmassService.deleteMany(checkTnum);
        if (flag) {
            System.out.println("批量删除考核记录成功！");
            model.addAttribute("msg", "<script>alert('批量删除考核记录成功！');</script>");
        } else {
            System.out.println("批量删除考核记录失败！！");
            model.addAttribute("msg", "<script>alert('批量删除考核记录失败！');</script>");
        }
        return "redirect:/cmass/queryList";
    }

    @RequestMapping("/beforeUpdate")
    public String beforeUpdate(int cmassId, Model model) {
        GzcrmCmass cmass = cmassService.queryCerById(cmassId);
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        List<GzcrmCmass> list = cmassService.queryList(null, null);
        model.addAttribute("upCmass", cmass);
        model.addAttribute("light", "light8");
        model.addAttribute("hash", "tab4");
        model.addAttribute("cmasses", list);
        model.addAttribute("cminfo", cminfos);
        return "manager/clientMgrInfoOther";
    }

    @RequestMapping("/update")
    public String update(GzcrmCmass cmass, Model model) {
        int nums = cmassService.update(cmass);
        if (nums == 1) {
            System.out.println("更新考核记录成功！");
            model.addAttribute("msg", "<script>alert('更新考核记录成功！');</script>");
        } else {
            System.out.println("更新考核记录失败！！");
            model.addAttribute("msg", "<script>alert('更新考核记录失败！');</script>");
        }
        return "redirect:/cmass/queryList";
    }

    @RequestMapping("/insert")
    public String insert(GzcrmCmass cmass, Model model, HttpSession session) {
        int flag = 0;
        List<GzcrmCminfo> cminfos = cminfoService.queryAll();
        for (int i = 0; i < cminfos.size(); i++) {
            if (cminfos.get(i).getCmId() == cmass.getCmId()) {
                flag = 1;
            }
        }
        if (flag == 1) {
            cmass.setCmModificationPerson((String) session.getAttribute("uname"));
            int nums = cmassService.insert(cmass);
            if (nums == 1) {
                System.out.println("添加考核记录成功！");
                model.addAttribute("msg", "<script>alert('添加考核记录成功！');</script>");
            } else {
                System.out.println("添加考核记录失败！！");
                model.addAttribute("msg", "<script>alert('添加考核记录失败！');</script>");
            }
        } else {
            model.addAttribute("msg", "<script>alert('添加考核记录失败！用户经理ID不存在');</script>");
        }
        return "redirect:/cmass/queryList";
    }
}